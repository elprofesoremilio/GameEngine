package Engine;

import java.awt.*;

/**
 * Representa la base para cualquier objeto del juego.
 * Define las propiedades físicas básicas y los métodos que toda entidad debe tener.
 * @author elProfesorEmilio
 */
public abstract class GameObject {

    // Usamos protected para que las clases hijas puedan acceder directamente
    protected float x, y;
    protected int width, height;
    protected float speedX, speedY;
    protected Scene scene;

    /**
     * Constructor base para un objeto de juego.
     * @param x Posición inicial en el eje X.
     * @param y Posición inicial en el eje Y.
     * @param width Ancho del objeto.
     * @param height Alto del objeto.
     */
    public GameObject(float x, float y, int width, int height, Scene scene) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = 0;
        this.speedY = 0;
        this.scene = scene;
    }

    /**
     * Actualiza la lógica del objeto.
     * @param delta El factor de tiempo para normalizar el movimiento.
     */
    public abstract void update(float delta);

    /**
     * Define cómo se dibuja el objeto en pantalla.
     * @param g El contexto gráfico (el pincel).
     */
    public abstract void render(Graphics2D g);

    // --- Getters y Setters (Encapsulamiento) ---

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setVelocity(float velX, float velY) {
        this.speedX = velX;
        this.speedY = velY;
    }

    public void setVelocityX(float velX) {
        this.speedX = velX;
    }

    public void setVelocityY(float velY) {
        this.speedY = velY;
    }

    /**
     * Obtiene el rectángulo que representa los límites del objeto.
     * @return Un objeto Rectangle con la posición y dimensiones del objeto.
     */
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    /**
     * Verifica si este objeto colisiona con otro objeto.
     * @param other El otro objeto de juego a verificar.
     * @return true si hay colisión, false en caso contrario.
     */
    public boolean intersects(GameObject other) {
        return this.getBounds().intersects(other.getBounds());
    }
}