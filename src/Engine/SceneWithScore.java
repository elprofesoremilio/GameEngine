package Engine;

import java.awt.*;

public class SceneWithScore extends Scene {
    protected int score;
    protected String scoreText;

    public SceneWithScore(Game game, int score) {
        super(game);
        this.score = score;
        scoreText = "Score: ";
    }

    public SceneWithScore(Game game) {
        this(game,0);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        String scoreString = String.format("%s%02d", scoreText, score);
        TextRenderer.draw(g, scoreString, 10, 30, new Font("Arial", Font.BOLD, 20), Color.BLUE);
    }

    public void addPoint() {
        this.score++;
    }

    public int getScore() {
        return score;
    }
}
