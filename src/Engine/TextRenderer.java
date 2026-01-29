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

    // Centralizamos la configuración para no repetir código
    private static FontMetrics setup(Graphics2D g, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        return g.getFontMetrics(font);
    }

    /**
     * Dibuja un texto permitiendo configurar fuente y color.
     */
    public static void draw(Graphics2D g, String text, int x, int y, Font font, Color color) {
        draw(g, text, x, y, font, color, null);
    }

    /**
     * Dibuja un texto permitiendo configurar fuente, color y color de fondo.
     */
    public static void draw(Graphics2D g, String text, int x, int y, Font font, Color color, Color bgColor) {
        FontMetrics metrics = setup(g, font, color);
        drawWithOptionalBackground(g, text, x, y, metrics, color, bgColor);
    }

    /**
     * Dibuja un texto centrado totalmente en un área (por ejemplo, la pantalla).
     * Permite especificar un color de fondo opcional.
     */
    public static void drawCentered(Graphics2D g, String text, int screenWidth, int screenHeight, Font font, Color textColor, Color bgColor) {
        FontMetrics metrics = setup(g, font, textColor);
        int x = (screenWidth - metrics.stringWidth(text)) / 2;
        int y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();
        drawWithOptionalBackground(g, text, x, y, metrics, textColor, bgColor);
    }

    /**
     * Dibuja un texto centrado solo horizontalmente en la Y que se le especifique
     */
    public static void drawHorizontallyCentered(Graphics2D g, String text, int screenWidth, int y, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);

        FontMetrics metrics = g.getFontMetrics(font);
        int x = (screenWidth - metrics.stringWidth(text)) / 2;

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
    public static void drawRightAligned(Graphics2D g, String text, int rightX, int y, Font font, Color color, Color bgColor) {
        FontMetrics metrics = setup(g, font, color);
        // Calculamos la posición X restando el ancho del texto al tope derecho
        int drawX = rightX - metrics.stringWidth(text);
        drawWithOptionalBackground(g, text, drawX, y, metrics, color, bgColor);
    }

    /**
     * Método interno para evitar repetir la lógica del fondo.
     * Si bgColor es null, no dibuja fondo.
     */
    private static void drawWithOptionalBackground(Graphics2D g, String text, int x, int y, FontMetrics metrics, Color textColor, Color bgColor) {
        if (bgColor != null) {
            g.setColor(bgColor);
            int padding = 4;
            // Usamos metrics.getAscent() para que el fondo cubra exactamente las letras
            g.fillRect(x - padding,
                    y - metrics.getAscent() - padding,
                    metrics.stringWidth(text) + (padding * 2),
                    metrics.getHeight() + (padding * 2));
        }
        g.setColor(textColor);
        g.drawString(text, x, y);
    }

    /**
     * Dibuja un texto con sombra para mejorar la legibilidad.
     */
    public static void drawWithShadow(Graphics2D g, String text, int x, int y, Font font, Color color) {
        draw(g, text, x + 2, y + 2, font, Color.BLACK); // Sombra
        draw(g, text, x, y, font, color); // Texto principal
    }

    /**
     * Dibuja texto con un borde (outline) de 1px para máxima legibilidad.
     */
    public static void drawWithOutline(Graphics2D g, String text, int x, int y, Font font, Color textColor, Color outlineColor) {
        setup(g, font, outlineColor);
        // Dibujamos el mismo texto desplazado en las 4 diagonales
        g.drawString(text, x - 1, y - 1);
        g.drawString(text, x + 1, y - 1);
        g.drawString(text, x - 1, y + 1);
        g.drawString(text, x + 1, y + 1);

        g.setColor(textColor);
        g.drawString(text, x, y);
    }

    /**
     * Permite dibujar textos largos con saltos de línea (\n)
     */
    public static void drawMultiLine(Graphics2D g, String text, int x, int y, Font font, Color color) {
        FontMetrics metrics = setup(g, font, color);
        String[] lines = text.split("\n");
        int currentY = y;
        for (String line : lines) {
            g.drawString(line, x, currentY);
            currentY += metrics.getHeight();
        }
    }
}
