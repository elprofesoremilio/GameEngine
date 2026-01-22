package Engine;

import Engine.GameObject;

public interface Collidable {
    /**
     * Se llama cuando este objeto colisiona con otro objeto.
     * @param other El otro objeto con el que se ha colisionado.
     */
    void onCollision(GameObject other);
}