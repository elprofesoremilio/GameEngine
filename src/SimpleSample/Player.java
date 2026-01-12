package SimpleSample;

import Engine.GameObject;
import Engine.InputHandler;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
    private InputHandler input;
    private float speed = 5.0f;

    public Player(float x, float y, InputHandler input) {
        super(x, y, 32, 32);
        this.input = input;
    }

    @Override
    public void update(float delta) {
        // Importante: Multiplicamos por delta para que el movimiento
        // sea fluido e independiente de los FPS
        if (input.up) y -= speed * delta;
        if (input.down) y += speed * delta;
        if (input.left) x -= speed * delta;
        if (input.right) x += speed * delta;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }
}