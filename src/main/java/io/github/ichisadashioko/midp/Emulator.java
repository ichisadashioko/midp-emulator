package io.github.ichisadashioko.midp;

import java.awt.Frame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class MainWindow extends Frame implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
    }

    public void mousePressed(MouseEvent e) {
        System.out.println(e);
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(e);
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println(e);
    }

    public void mouseExited(MouseEvent e) {
        System.out.println(e);
    }
}

public class Emulator {
    public static void main(String[] args) {
        System.out.println("Hello");

        MainWindow window = new MainWindow();
        window.addMouseListener(window);
        window.setSize(640, 480);
        window.setVisible(true);
    }
}
