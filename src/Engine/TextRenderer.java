package Engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Clase de utilidad para facilitar el dibujado de texto con formato y alineación.
 */
public class TextRenderer {

    /**
     * Dibuja un texto permitiendo configurar fuente, color y alineación.
     */
    public static void draw(Graphics2D g, String text, int x, int y, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);
        // Activamos suavizado de texto para que se vea profesional
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.drawString(text, x, y);
    }

    /**
     * Dibuja un texto centrado totalmente en un área (por ejemplo, la pantalla).
     * Permite especificar un color de fondo opcional.
     */
    public static void drawCentered(Graphics2D g, String text, int screenWidth, int screenHeight, Font font, Color textColor, Color bgColor) {
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (screenWidth - metrics.stringWidth(text)) / 2;
        int y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();

        drawWithOptionalBackground(g, text, x, y, metrics, textColor, bgColor);
    }

    /**
     * Dibuja un texto centrado solo horizontalmente en la Y que se le especifique
     */
    public static void drawHorizontalCentered(Graphics2D g, String text, int screenWidth, int y, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);

        FontMetrics metrics = g.getFontMetrics(font);
        int x = (screenWidth - metrics.stringWidth(text)) / 2;

        g.drawString(text, x, y);
    }

    /**
     * Dibuja un texto alineado a la derecha con respecto a una coordenada X que actúa como "tope".
     * @param g Contexto gráfico.
     * @param text Texto a dibujar.
     * @param rightX La coordenada X donde debe terminar el texto.
     * @param y Coordenada Y (línea base).
     * @param font Fuente a utilizar.
     * @param color Color del texto.
     */
    public static void drawRightAligned(Graphics2D g, String text, int rightX, int y, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        FontMetrics metrics = g.getFontMetrics(font);
        // Calculamos la X restando el ancho del texto al tope derecho
        int drawX = rightX - metrics.stringWidth(text);

        g.drawString(text, drawX, y);
    }

    /**
     * Método interno para evitar repetir la lógica del fondo.
     * Si bgColor es null, no dibuja fondo.
     */
    private static void drawWithOptionalBackground(Graphics2D g, String text, int x, int y, FontMetrics metrics, Color textColor, Color bgColor) {
        if (bgColor != null) {
            g.setColor(bgColor);
            // Calculamos el área del fondo con un pequeño margen (padding)
            int padding = 4;
            g.fillRect(x - padding,
                    y - metrics.getAscent() - padding,
                    metrics.stringWidth(text) + (padding * 2),
                    metrics.getHeight() + (padding * 2));
        }

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(textColor);
        g.drawString(text, x, y);
    }
}
