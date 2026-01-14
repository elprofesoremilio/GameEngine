package OtherSample;

import Engine.Game;
import Engine.GameObject;
import Engine.InputHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Sun extends GameObject {
    /**
     * Constructor base para un objeto de juego.
     *
     * @param x      Posición inicial en el eje X.
     * @param y      Posición inicial en el eje Y.
     * @param width  Ancho del objeto.
     * @param height Alto del objeto.
     */
    private int radius;
    private final InputHandler input = Game.getInput();

    public Sun(float x, float y, int width, int height) {
        super(x, y, width, height);
        radius = width/2;
    }

    @Override
    public void update(float delta) {
        if (input.down) {
            radius--;
        }
        if (input.up) {
            radius++;
        }
        if (input.isKeyPressed(KeyEvent.VK_P)) {
            radius*=2;
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int)x,(int)y,radius,radius);
    }
}
