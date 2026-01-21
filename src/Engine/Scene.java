package Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona todos los GameObjects que coexisten en un momento dado.
 * Se encarga de propagar las llamadas de update y render a cada objeto.
 * @author elProfesorEmilio
 */
public class Scene {

    /**
     * Lista de objetos presentes en la escena.
     * Usamos List (interfaz) para instanciar un ArrayList (polimorfismo de colecciones).
     */
    private List<GameObject> objects;
    private List<GameObject> toRemove;
    protected Game game; // Referencia al motor para poder pedir cambios de escena
    protected InputHandler input;

    public Scene(Game game) {
        this.objects = new ArrayList<>();
        this.toRemove = new ArrayList<>();
        this.game = game;
        this.input = game.getInput();
    }

    /**
     * Añade un nuevo objeto a la escena.
     * @param obj Cualquier instancia que herede de Engine.GameObject.
     */
    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    /**
     * Elimina un objeto de la escena.
     * En lugar de borrar directamente, lo añadimos a una lista de espera.
     * @param obj El objeto a eliminar.
     */
    public void removeObject(GameObject obj) {
        toRemove.add(obj);
    }
    /**
     * Actualiza todos los objetos de la escena.
     * Aquí se aplica el Polimorfismo: llamamos a update() sin saber 
     * si el objeto es un Jugador, Enemigo o Bala.
     * Además, se comprueban colisiones entre todos los objetos que implementen Collidable.
     * @param delta Factor de tiempo.
     */
    public void update(float delta) {
        // 1. Limpiar objetos pendientes del frame anterior
        if (!toRemove.isEmpty()) {
            objects.removeAll(toRemove);
            toRemove.clear();
        }

        // 2. Actualizar posiciones primero
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(delta);
        }

        // 3. Comprobar colisiones (Algoritmo de fuerza bruta O(n²))
        for (int i = 0; i < objects.size(); i++) {
            GameObject a = objects.get(i);

            for (int j = i + 1; j < objects.size(); j++) {
                GameObject b = objects.get(j);

                if (a instanceof Collidable && b instanceof Collidable && a.intersects(b)) {
                    ((Collidable)a).onCollision(b);
                    ((Collidable)b).onCollision(a);
                }
            }
        }
    }

    /**
     * Dibuja todos los objetos de la escena.
     * @param g Contexto gráfico proporcionado por el motor (Engine.Game).
     */
    public void render(Graphics2D g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    /**
     * Cuenta cuántos objetos de un tipo específico hay en la escena.
     * @param type Clase del objeto a contar.
     * @return Número de objetos de ese tipo.
     */
    public int getCountOf(Class<?> type) {
        int count = 0;
        for (GameObject obj : objects) {
            // Comprobamos si el objeto es de la clase que buscamos o una hija
            if (type.isInstance(obj)) {
                count++;
            }
        }
        return count;
    }

    public InputHandler getInput() { return input; }

    public Game getGame() { return game; }
}