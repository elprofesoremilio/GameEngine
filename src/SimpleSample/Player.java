package SimpleSample;

import Engine.GameObject;
import Engine.InputHandler;
import Engine.Scene;

import java.awt.*;

public class Player extends GameObject {
    private InputHandler input;
    private float speed = 5.0f;

    public Player(float x, float y, Scene scene) {
        super(x, y, 32, 32, scene);
        this.input = scene.getInput();
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
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }
}