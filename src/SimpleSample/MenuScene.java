package SimpleSample;

import Engine.Game;
import Engine.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScene extends Scene {

    public MenuScene(Game game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        // Si pulsamos espacio, el menú le dice al motor que cambie al Nivel 1
        if (input.isKeyPressed(KeyEvent.VK_SPACE)) {
            game.setScene(new Level1(game));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("MENU PRINCIPAL - Pulsa ESPACIO para jugar", 250, 300);
        super.render(g);
    }
}