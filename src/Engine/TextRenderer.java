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
     */
    public static void drawCentered(Graphics2D g, String text, int screenWidth, int screenHeight, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);
        // Activamos suavizado de texto para que se vea profesional
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        FontMetrics metrics = g.getFontMetrics(font);
        int x = (screenWidth - metrics.stringWidth(text)) / 2;
        int y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(text, x, y);
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
}
