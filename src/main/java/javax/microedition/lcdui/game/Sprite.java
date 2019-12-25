package javax.microedition.lcdui.game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Sprite extends Layer {
    public static final int TRANS_NONE = 0;
    public static final int TRANS_ROT90 = 5;
    public static final int TRANS_ROT180 = 3;
    public static final int TRANS_ROT270 = 6;
    public static final int TRANS_MIRROR = 2;
    public static final int TRANS_MIRROR_ROT90 = 7;
    public static final int TRANS_MIRROR_ROT180 = 1;
    public static final int TRANS_MIRROR_ROT270 = 4;

    public Sprite(Image image) {
        throw new UnsupportedOperationException();
    }

    public Sprite(Image image, int frameWidth, int frameHeight) {
        throw new UnsupportedOperationException();
    }

    public Sprite(Sprite s) {
        throw new UnsupportedOperationException();
    }

    public boolean collidesWith(Image image, int x, int y, boolean pixelLevel) {
        throw new UnsupportedOperationException();
    }

    public boolean collidesWith(Sprite s, boolean pixelLevel) {
        throw new UnsupportedOperationException();
    }

    public boolean collidesWith(TiledLayer t, boolean pixelLevel) {
        throw new UnsupportedOperationException();
    }

    public void defineCollisionRectangle(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    public void defineReferencePixel(int x, int y) {
        throw new UnsupportedOperationException();
    }

    public int getFrame() {
        throw new UnsupportedOperationException();
    }

    public int getFrameSequenceLength() {
        throw new UnsupportedOperationException();
    }

    public int getRawFrameCount() {
        throw new UnsupportedOperationException();
    }

    public int getRefPixelX() {
        throw new UnsupportedOperationException();
    }

    public int getRefPixelY() {
        throw new UnsupportedOperationException();
    }

    public void nextFrame() {
        throw new UnsupportedOperationException();
    }

    public void paint(Graphics g) {
        throw new UnsupportedOperationException();
    }

    public void prevFrame() {
        throw new UnsupportedOperationException();
    }

    public void setFrame(int sequenceIndex) {
        throw new UnsupportedOperationException();
    }

    public void setFrameSequence(int[] sequence) {
        throw new UnsupportedOperationException();
    }

    public void setImage(Image img, int frameWidth, int frameHeight) {
        throw new UnsupportedOperationException();
    }

    public void setRefPixelPosition(int x, int y) {
        throw new UnsupportedOperationException();
    }

    public void setTransform(int transform) {
        throw new UnsupportedOperationException();
    }
}