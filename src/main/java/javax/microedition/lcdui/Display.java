package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display {
    public static final int LIST_ELEMENT = 1;
    public static final int CHOICE_GROUP_ELEMENT = 2;
    public static final int ALERT = 3;
    public static final int COLOR_FOREGROUND = 1;
    public static final int COLOR_HIGHLIGHTED_BACKGROUND = 2;
    public static final int COLOR_HIGHTLIGHTED_FOREGROUND = 3;
    public static final int COLOR_BORDER = 4;
    public static final int COLOR_HIGHLIGHTED_BORDER = 5;

    public void callSerially(Runnable r) {
        throw new UnsupportedOperationException();
    }

    public boolean flashBacklight(int duration) {
        throw new UnsupportedOperationException();
    }

    public int getBestImageHeight(int imageType) {
        throw new UnsupportedOperationException();
    }

    public int getBestImageWidth(int imageType) {
        throw new UnsupportedOperationException();
    }

    public int getBorderStyle(boolean highlighted) {
        throw new UnsupportedOperationException();
    }

    public int getColor(int colorSpecifier) {
        throw new UnsupportedOperationException();
    }

    public Displayable getCurrent() {
        throw new UnsupportedOperationException();
    }

    public static Display getDisplay(MIDlet m) {
        throw new UnsupportedOperationException();
    }

    public boolean isColor() {
        throw new UnsupportedOperationException();
    }

    public int numAlphaLevels() {
        throw new UnsupportedOperationException();
    }

    public int numColors() {
        throw new UnsupportedOperationException();
    }

    public void setCurrent(Alert alert, Displayable nextDisplayable) {
        throw new UnsupportedOperationException();
    }

    public void setCurrentItem(Item item) {
        throw new UnsupportedOperationException();
    }

    public boolean vibrate(int duration) {
        throw new UnsupportedOperationException();
    }
}