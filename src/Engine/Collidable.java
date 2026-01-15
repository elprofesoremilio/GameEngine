package Engine;

import Engine.GameObject;

public interface Collidable {
    void onCollision(GameObject other);
}