package Engine;

/**
 * Clase que representa el estado del juego.
 * Incluye atributos como puntuación, vidas y nivel actual.
 */
public class GameState {
    private int score;
    private int lives;
    private int level;

    public GameState() {
        reset(); // Inicializa con valores por defecto
    }

    /**
     * Resetea el estado del juego a los valores iniciales.
     */
    public void reset() {
        this.score = 0;
        this.lives = 3;
        this.level = 1;
    }

    // Métodos de utilidad

    /**
     * Añade puntos a la puntuación actual.
     * @param points Puntos a añadir
     */
    public void addScore(int points) { this.score += points; }
    /**
     * Resta una vida al juego.
     */
    public void loseLife() { this.lives--; }
    /**
     * Añade una vida al juego.
     */
    public void addLife() { this.lives++; }

    // Getters y Setters
    public int getScore() { return score; }
    public int getLives() { return lives; }
    public int getLevel() { return level; }
    /**
     * Establece el nivel actual del juego.
     * @param level Nuevo nivel
     */
    public void setLevel(int level) { this.level = level; }
}
