package io.github.ichisadashioko.midp;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MainWindow extends Frame implements WindowListener {

    @Override
    public void windowActivated(WindowEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        System.out.println(arg0);
        dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        System.out.println(arg0);

    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        System.out.println(arg0);
    }

}

public class Emulator {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        window.addWindowListener(window);

        window.setSize(640, 480);
        window.setVisible(true);

        // TODO the main thread should have terminated after executing the following
        // print command but it is not
        System.out.println("after setVisible");
    }
}
