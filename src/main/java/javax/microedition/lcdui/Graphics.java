package javax.microedition.lcdui;

public class Graphics {
    public static final int HCENTER = 1;
    public static final int VCENTER = 2;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int TOP = 16;
    public static final int BOTTOM = 32;
    public static final int BASELINE = 64;
    public static final int SOLID = 0;
    public static final int DOTTED = 1;

    public void clipRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException();
    }

    public void drawChar(char character, int x, int y, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawImage(Image img, int x, int y, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        throw new UnsupportedOperationException();
    }

    public void drawRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest,
            int y_dest, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height,
            boolean processAlpha) {
        throw new UnsupportedOperationException();
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new UnsupportedOperationException();
    }

    public void drawString(String str, int x, int y, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
        throw new UnsupportedOperationException();
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException();
    }

    public void fillRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new UnsupportedOperationException();
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        throw new UnsupportedOperationException();
    }

    public int getBlueComponent() {
        throw new UnsupportedOperationException();
    }

    public int getClipHeight() {
        throw new UnsupportedOperationException();
    }

    public int getClipWidth() {
        throw new UnsupportedOperationException();
    }

    public int getClipX() {
        throw new UnsupportedOperationException();
    }

    public int getClipY() {
        throw new UnsupportedOperationException();
    }

    public int getColor() {
        throw new UnsupportedOperationException();
    }

    public int getDisplayColor(int color) {
        throw new UnsupportedOperationException();
    }

    public Font getFont() {
        throw new UnsupportedOperationException();
    }

    public int getGrayScale() {
        throw new UnsupportedOperationException();
    }

    public int getGreenComponent() {
        throw new UnsupportedOperationException();
    }

    public int getRedComponent() {
        throw new UnsupportedOperationException();
    }

    public int getStrokeStyle() {
        throw new UnsupportedOperationException();
    }

    public int getTranslateX() {
        throw new UnsupportedOperationException();
    }

    public int getTranslateY() {
        throw new UnsupportedOperationException();
    }

    public void setClip(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void setColor(int RGB) {
        throw new UnsupportedOperationException();
    }

    public void setColor(int red, int green, int blue) {
        throw new UnsupportedOperationException();
    }

    public void setFont(Font font) {
        throw new UnsupportedOperationException();
    }

    public void setGrayScale(int value) {
        throw new UnsupportedOperationException();
    }

    public void setStrokeStyle(int style) {
        throw new UnsupportedOperationException();
    }

    public void translate(int x, int y) {
        throw new UnsupportedOperationException();
    }
}