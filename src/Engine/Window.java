package Engine;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * Gestiona la ventana del juego y el área de dibujo (Canvas).
 * @author elProfesorEmilio
 */
public class Window extends JFrame {

    private final Canvas canvas;

    /**
     * Crea una ventana con dimensiones fijas.
     * @param width Ancho en píxeles.
     * @param height Alto en píxeles.
     * @param title Título de la ventana.
     */
    public Window(int width, int height, String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Creamos el lienzo de dibujo
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(true); // Permite que el canvas capture el teclado

        this.add(canvas);
        this.pack(); // Ajusta el JFrame al tamaño del Canvas
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}