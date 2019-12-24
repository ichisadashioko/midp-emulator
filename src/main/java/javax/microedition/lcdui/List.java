package javax.microedition.lcdui;

public class List extends Screen implements Choice {
    public static final Command SELECT_COMMAND = new Command("", Command.SCREEN, 0);

    public List(String title, int listType) {
        throw new UnsupportedOperationException();
    }

    public List(String title, int listType, String[] stringElements, Image[] imageElements) {
        throw new UnsupportedOperationException();
    }

    public int append(String stringPart, Image imagePart) {
        throw new UnsupportedOperationException();
    }

    public void delete(int elementNum) {
        throw new UnsupportedOperationException();
    }

    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    public int getFitPolicy() {
        throw new UnsupportedOperationException();
    }

    public Font getFont(int elementNum) {
        throw new UnsupportedOperationException();
    }

    public Image getImage(int elementNum) {
        throw new UnsupportedOperationException();
    }

    public int getSelectedFlags(boolean[] selectedArray_return) {
        throw new UnsupportedOperationException();
    }

    public int getSelectedIndex() {
        throw new UnsupportedOperationException();
    }

    public String getString(int elementNum) {
        throw new UnsupportedOperationException();
    }

    public void insert(int elementNum, String stringPart, Image imagePart) {
        throw new UnsupportedOperationException();
    }

    public boolean isSelected(int elementNum) {
        throw new UnsupportedOperationException();
    }

    public void removeCommand(Command cmd) {
        throw new UnsupportedOperationException();
    }

    public void set(int elementNum, String stringPart, Image imagePart) {
        throw new UnsupportedOperationException();
    }

    public void setFitPolicy(int fitPolicy) {
        throw new UnsupportedOperationException();
    }

    public void setFont(int elementNum, Font font) {
        throw new UnsupportedOperationException();
    }

    public void setSelectedFlags(boolean[] selectedArray) {
        throw new UnsupportedOperationException();
    }

    public void setSelectedIndex(int elementNum, boolean selected) {
        throw new UnsupportedOperationException();
    }

    public void setTicker(Ticker ticker) {
        throw new UnsupportedOperationException();
    }

    public void setTitle(String s) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        throw new UnsupportedOperationException();
    }

}