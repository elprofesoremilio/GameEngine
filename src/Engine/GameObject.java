package Engine;

import java.awt.Graphics;

/**
 * Representa la base para cualquier objeto del juego.
 * Define las propiedades físicas básicas y los métodos que toda entidad debe tener.
 * @author elProfesorEmilio
 */
public abstract class GameObject {

    // Usamos protected para que las clases hijas puedan acceder directamente
    protected float x, y;
    protected int width, height;
    protected float velX, velY;

    /**
     * Constructor base para un objeto de juego.
     * @param x Posición inicial en el eje X.
     * @param y Posición inicial en el eje Y.
     * @param width Ancho del objeto.
     * @param height Alto del objeto.
     */
    public GameObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velX = 0;
        this.velY = 0;
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
    public abstract void render(Graphics g);

    // --- Getters y Setters (Encapsulamiento) ---

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setVelocity(float velX, float velY) {
        this.velX = velX;
        this.velY = velY;
    }
}