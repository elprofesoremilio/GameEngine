package Engine;

public abstract class Spawner {
    private float timer;
    private float interval;
    protected Scene scene;
    private boolean active = true;

    public Spawner(Scene scene, float intervalSeconds) {
        this.scene = scene;
        this.interval = intervalSeconds;
    }

    public void update(float delta) {
        if (!active) return;

        // Si tu delta viene en milisegundos (ej. 16.6), divídelo por 1000 aquí
        // o asegúrate de que el 'interval' esté en la misma unidad.
        timer += delta;

        if (timer >= interval) {
            spawn();
            // IMPORTANTE: No resetear a 0, sino restar el intervalo.
            // Esto evita que el tiempo sobrante se pierda y mantiene el ritmo perfecto.
            timer -= interval;
        }
    }

    // Cada juego definirá qué se "spawnea" aquí
    public abstract void spawn();

    public void stop() { active = false; }
    public void start() { active = true; }
}