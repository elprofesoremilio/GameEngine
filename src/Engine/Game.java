package Engine;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Clase principal que gestiona el hilo de ejecución y el bucle de juego.
 * @author elProfesorEmilio
 */
public class Game implements Runnable {

    private final Window window;
    private boolean running = false;

    // Configuración del tiempo (60 actualizaciones por segundo)
    private static final int UPS = 60;
    private static final double NS_PER_TICK = 1000000000.0 / UPS;

    // Referencia a la escena actual
    private Scene currentScene;

    // Manejador de la entrada
    private final InputHandler input = new InputHandler();

    private int width, height;
    private final GameState gameState;

    /**
     * Optimización específica para Linux/Unix al iniciar la clase.
     */
    static {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Sistema: " + os);
        if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            // Estamos en Linux/Unix
            System.out.println("[Motor] Detectado Linux: Activando optimizaciones de OpenGL...");
            System.setProperty("sun.java2d.opengl", "true");

            // Desactiva el parpadeo provocado por el gestor de ventanas
            System.setProperty("sun.java2d.pmoffscreen", "false");

            // Mejora el rendimiento del cursor y eventos en X11
            System.setProperty("sun.java2d.xrender", "true");
        }
    }

    public Game(int width, int height, String title) {
        this.window = new Window(width, height, title);
        this.window.getCanvas().addKeyListener(input); // Conectamos teclado al canvas
        this.width = width;
        this.height = height;
        this.gameState = new GameState();
    }

    /**
     * Permite cambiar la escena actual del motor.
     * @param nextScene La nueva instancia de Engine.Scene a ejecutar.
     */
    public void setScene(Scene nextScene) {
        this.currentScene = nextScene;
    }

    /**
     * Inicia el hilo del juego.
     */
    public synchronized void start() {
        if (running) return;
        running = true;
        Thread thread = new Thread(this, "GameThread");
        thread.start();
    }

    /**
     * Método principal del juego con GameLoop basado en Delta Time.
     * Se encarga de actualizar la lógica y renderizar los frames.
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double accumulator = 0; // Renombramos delta a accumulator para mayor claridad

        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;

        // Calculamos cuánto dura un tick en SEGUNDOS (1 / 60.0 = 0.0166s)
        final float secondsPerTick = (float)(NS_PER_TICK / 1000000000.0);

        while (running) {
            long now = System.nanoTime();
            accumulator += (now - lastTime) / NS_PER_TICK;
            lastTime = now;

            while (accumulator >= 1) {
                // PASAMOS EL TIEMPO REAL: secondsPerTick (aprox 0.016)
                // Esto hace que el movimiento sea consistente
                update(secondsPerTick);

                input.update();
                ticks++;
                accumulator--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("UPS: " + ticks + " FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
    }

    /**
     * Actualiza la lógica de todos los objetos.
     * @param delta Factor de tiempo para que el movimiento sea independiente de los frames.
     */
    private void update(float delta) {
        if (currentScene != null) {
            currentScene.update(delta);
        }
    }

    /**
     * Se encarga de dibujar el frame actual usando BufferStrategy.
     */
    private void render() {
        BufferStrategy bs = window.getCanvas().getBufferStrategy();

        if (bs == null) {
            // Creamos 3 buffers para evitar cualquier parpadeo
            window.getCanvas().createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D)bs.getDrawGraphics();

        // 1. Limpiar pantalla
        g.clearRect(0, 0, window.getWidth(), window.getHeight());

        // 2. Dibujar escena
        if (currentScene != null) {
            currentScene.render(g);
        }

        // 3. Mostrar y liberar recursos
        g.dispose();
        bs.show();
    }

    public InputHandler getInput() {
        return input;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameState getGameState() { return gameState; }

    /**
     * Resetea el estado del juego a su configuración inicial.
     */
    public void resetState() {
        gameState.reset();
    }

}