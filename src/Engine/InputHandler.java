package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Gestiona la entrada de teclado.
 * @author elProfesorEmilio
 */
public class InputHandler implements KeyListener {
    private boolean[] keys = new boolean[256];
    public boolean up, down, left, right, space;
    private boolean[] keysLast = new boolean[256]; // Estado en el frame anterior

    /**
     * Actualiza el estado de las teclas.
     * Debe llamarse una vez por frame, se hace automáticamente en la clase Game.
     */
    public void update() {
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        System.arraycopy(keys, 0, keysLast, 0, keys.length);
    }

    /**
     * Devuelve true si la tecla está siendo mantenida pulsada.
     * Útil para movimiento: if(input.isKeyHeld(KeyEvent.VK_W)) ...
     */
    public boolean isKeyHeld(int keyCode) {
        return keys[keyCode];
    }

    /**
     * Devuelve true solo en el instante en que se presiona la tecla.
     * Útil para acciones únicas: cambiar escena, disparar, saltar.
     */
    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode] && !keysLast[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < keys.length) keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < keys.length) keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}