package javax.microedition.lcdui;

public class TextField extends Item {
    public static final int ANY = 0;
    public static final int EMAILADDR = 1;
    public static final int NUMERIC = 2;
    public static final int PHONENUMBER = 3;
    public static final int URL = 4;
    public static final int DECIMAL = 5;
    public static final int PASSWORD = 0x10000;
    public static final int UNEDITABLE = 0x20000;
    public static final int SENSITIVE = 0x40000;
    public static final int NON_PREDICTIVE = 0x80000;
    public static final int INITIAL_CAPS_WORD = 0x10000;
    public static final int INITIAL_CAPS_SENTANCE = 0x200000;
    public static final int CONSTRAINT_MASK = 0xFFFF;

    public TextField(String label, String text, int maxSize, int constraints) {
        throw new UnsupportedOperationException();
    }

    public void delete(int offset, int length) {
        throw new UnsupportedOperationException();
    }

    public int getCaretPosition() {
        throw new UnsupportedOperationException();
    }

    public int getChars(char[] data) {
        throw new UnsupportedOperationException();
    }

    public int getConstraints() {
        throw new UnsupportedOperationException();
    }

    public int getMaxSize() {
        throw new UnsupportedOperationException();
    }

    public String getString() {
        throw new UnsupportedOperationException();
    }

    public void insert(char[] data, int offset, int length, int position) {
        throw new UnsupportedOperationException();
    }

    public void insert(String src, int position) {
        throw new UnsupportedOperationException();
    }

    public void setChars(char[] data, int offset, int length) {
        throw new UnsupportedOperationException();
    }

    public void setConstraints(int constraints) {
        throw new UnsupportedOperationException();
    }

    public void setInitialInputMode(String characterSubset) {
        throw new UnsupportedOperationException();
    }

    public int setMaxSize(int maxSize) {
        throw new UnsupportedOperationException();
    }

    public void setString(String text) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        throw new UnsupportedOperationException();
    }
}