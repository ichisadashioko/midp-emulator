package javax.microedition.lcdui;

public final class Font {
    public static final int STYPE_PLAIN = 0;
    public static final int STYPE_BOLD = 1;
    public static final int STYPE_ITALIC = 2;
    public static final int STYPE_UNDERLINED = 4;
    public static final int SIZE_SMALL = 8;
    public static final int SIZE_MEDIUM = 0;
    public static final int SIZE_LARGE = 16;
    public static final int FACE_SYSTEM = 0;
    public static final int FACE_MONO_SPACE = 32;
    public static final int FACE_PROPORTIONAL = 64;
    public static final int FONT_STATIC_TEXT = 0;
    public static final int FONT_INPUT_TEXT = 1;

    public int charsWidth(char[] ch, int offset, int length) {
        throw new UnsupportedOperationException();
    }

    public int charWidth(char ch) {
        throw new UnsupportedOperationException();
    }

    public int getBaselinePosition() {
        throw new UnsupportedOperationException();
    }

    public static Font getDefaultFont() {
        throw new UnsupportedOperationException();
    }

    public int getFace() {
        throw new UnsupportedOperationException();
    }

    public static Font getFont(int fontSpecifier) {
        throw new UnsupportedOperationException();
    }

    public static Font getFont(int face, int style, int size) {
        throw new UnsupportedOperationException();
    }

    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    public int getSize() {
        throw new UnsupportedOperationException();
    }

    public int getStyle() {
        throw new UnsupportedOperationException();
    }

    public boolean isBold() {
        throw new UnsupportedOperationException();
    }

    public boolean isItalic() {
        throw new UnsupportedOperationException();
    }

    public boolean isPlain() {
        throw new UnsupportedOperationException();
    }

    public boolean isUnderlined() {
        throw new UnsupportedOperationException();
    }

    public int stringWidth(String str) {
        throw new UnsupportedOperationException();
    }

    public int substringWidth(String str, int offset, int len) {
        throw new UnsupportedOperationException();
    }
}