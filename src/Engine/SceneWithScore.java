package Engine;

import java.awt.*;

public class SceneWithScore extends Scene {
    protected int score;

    public SceneWithScore(Game game) {
        super(game);
        int score = 0;
    }

    public SceneWithScore(Game game, int score) {
        super(game);
        this.score = score;
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        String scoreString = String.format("Puntuación: %02d", score);
        TextRenderer.draw(g, scoreString, 10, 30, new Font("Arial", Font.BOLD, 20), Color.BLUE);
    }

    public void addPoint() {
        this.score++;
    }

    public int getScore() {
        return score;
    }
}
