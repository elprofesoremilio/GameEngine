package Engine;

import java.awt.Graphics;
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
    protected Game game; // Referencia al motor para poder pedir cambios de escena
    protected InputHandler input;

    public Scene(Game game) {
        this.objects = new ArrayList<>();
        this.game = game;
        this.input = Game.getInput();
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
     * @param obj El objeto a eliminar.
     */
    public void removeObject(GameObject obj) {
        objects.remove(obj);
    }

    /**
     * Actualiza todos los objetos de la escena.
     * Aquí se aplica el Polimorfismo: llamamos a update() sin saber 
     * si el objeto es un Jugador, Enemigo o Bala.
     * @param delta Factor de tiempo.
     */
    public void update(float delta) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(delta);
        }
    }

    /**
     * Dibuja todos los objetos de la escena.
     * @param g Contexto gráfico proporcionado por el motor (Engine.Game).
     */
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }
}