package SimpleSample;

import Engine.Game;
import Engine.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Ejemplo de un nivel concreto del juego.
 */
public class Level1 extends Scene {

    /**
     * Constructor del nivel. Aquí se "monta" la escena.
     */
    public Level1(Game game) {
        super(game); // Pasamos la referencia del motor a la clase padre Engine.Scene

        // Añadimos los objetos iniciales del nivel
        // Usamos el polimorfismo: addObject recibe Engine.GameObject, le pasamos un SimpleSample.Player
        this.addObject(new Player(400, 300, input));

        // Podríamos añadir enemigos o obstáculos aquí
        // this.addObject(new Obstacle(200, 200));
    }

    @Override
    public void update(float delta) {
        // 1. Ejecutamos la lógica de todos los GameObjects de la lista
        super.update(delta);

        // 2. Lógica específica de este nivel
        // Ejemplo: Si pulsa ESC, volvemos a una hipotética escena de Menú
        if (input.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            game.setScene(new MenuScene(game));
            System.out.println("Cambiando a Menú...");
        }
    }

    @Override
    public void render(Graphics2D g) {
        // Dibujamos un fondo específico para este nivel
        g.setColor(new Color(30, 30, 30)); // Gris oscuro
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.WHITE);
        g.drawString("NIVEL 1 - Usa WASD para moverte | ESC para salir", 20, 30);

        // Dibujamos todos los GameObjects
        super.render(g);
    }
}