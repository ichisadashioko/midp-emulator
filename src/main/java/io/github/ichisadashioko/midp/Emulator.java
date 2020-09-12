package io.github.ichisadashioko.midp;

import java.awt.Frame;

class MainWindow extends Frame {
}

public class Emulator {
    public static void main(String[] args) {
        System.out.println("Hello");

        MainWindow window = new MainWindow();
        window.setSize(640, 480);
        window.setVisible(true);
    }
}
