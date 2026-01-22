package Engine;

public class GameState {
    private int score;
    private int lives;
    private int level;

    public GameState() {
        reset(); // Inicializa con valores por defecto
    }

    public void reset() {
        this.score = 0;
        this.lives = 3;
        this.level = 1;
    }

    // Métodos de utilidad
    public void addScore(int points) { this.score += points; }
    public void loseLife() { this.lives--; }
    public void addLife() { this.lives++; }

    // Getters y Setters
    public int getScore() { return score; }
    public int getLives() { return lives; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
