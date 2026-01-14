package OtherSample;

import Engine.GameObject;

import java.awt.*;

public class DeadLine extends GameObject {
    /**
     * Constructor base para un objeto de juego.
     *
     * @param x      Posición inicial en el eje X.
     * @param y      Posición inicial en el eje Y.
     * @param width  Ancho del objeto.
     * @param height Alto del objeto.
     */
    public DeadLine(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y,width,height);
    }
}
