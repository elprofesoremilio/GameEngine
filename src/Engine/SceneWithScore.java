package Engine;

import java.awt.*;

public class SceneWithScore extends Scene {
    protected int score;

    public SceneWithScore(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        String scoreString = String.format("%02d", score);
        g.setColor(Color.BLUE);
        g.drawString(scoreString,10,20);
    }

    public void addPoint() {
        this.score++;
    }
}
