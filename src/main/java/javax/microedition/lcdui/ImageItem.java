package javax.microedition.lcdui;

public class ImageItem extends Item {
    public static final int LAYOUT_DEFAULT = 0;
    public static final int LAYOUT_LEFT = 1;
    public static final int LAYOUT_RIGHT = 2;
    public static final int LAYOUT_CENTER = 3;
    public static final int LAYOUT_NEWLINE_BEFORE = 0x100;
    public static final int LAYOUT_NEWLINE_AFTER = 0x200;

    public ImageItem(String label, Image img, int layout, String altText) {
        throw new UnsupportedOperationException();
    }

    public ImageItem(String label, Image image, int layout, String altText, int appearanceMode) {
        throw new UnsupportedOperationException();
    }

    public String getAltText() {
        throw new UnsupportedOperationException();
    }

    public int getAppearanceMode() {
        throw new UnsupportedOperationException();
    }

    public Image getImage() {
        throw new UnsupportedOperationException();
    }

    public int getLayout() {
        throw new UnsupportedOperationException();
    }

    public void setAltText(String text) {
        throw new UnsupportedOperationException();
    }

    public void setImage(Image img) {
        throw new UnsupportedOperationException();
    }

    public void setLayout(int layout) {
        throw new UnsupportedOperationException();
    }
}
