package javax.microedition.media;

public interface Controllable {
    public Control getControl(String controlType);

    public Control[] getControls();
}