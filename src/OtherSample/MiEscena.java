package OtherSample;

import Engine.Game;
import Engine.Scene;

import java.awt.*;

public class MiEscena extends Scene {
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 300;

    public MiEscena(Game game) {
        super(game);
        this.addObject(new Sun(400, 100, 50, 50));
        this.addObject(new DeadLine(0,GAME_HEIGHT-5,GAME_WIDTH,5));
    }

    @Override
    public void render(Graphics2D g) {
        g.setBackground(Color.BLACK);
        g.clearRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        super.render(g);
    }
}
