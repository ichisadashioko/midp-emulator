package javax.microedition.media;

import java.io.InputStream;

public final class Manager {
    public static final String TONE_DEVICE_LOCATOR = "device://tone";

    public static Player createPlayer(InputStream stream, String type) {
        throw new UnsupportedOperationException();
    };

    public static Player createPlayer(String locator) {
        throw new UnsupportedOperationException();
    }

    public static String[] getSupportedContentTypes(String protocol) {
        throw new UnsupportedOperationException();
    }

    public static String[] getSupportedProtocols(String content_type) {
        throw new UnsupportedOperationException();
    }

    public static void playTone(int note, int duration, int volume) {
        throw new UnsupportedOperationException();
    }
}