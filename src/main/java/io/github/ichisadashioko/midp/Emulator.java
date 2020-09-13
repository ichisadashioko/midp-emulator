package io.github.ichisadashioko.midp;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FilenameFilter;
import java.awt.FileDialog;

class TermColor {
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String FG_BRIGHT_RED = "\u001B[91m";
    public static final String FG_BRIGHT_BLUE = "\u001B[94m";
}

class Logger {
    public static void debug(Object o) {
        long ts = System.currentTimeMillis();
        System.out.print(TermColor.FG_BRIGHT_BLUE);
        System.out.print("[");
        System.out.print(ts);
        System.out.print("] ");
        System.out.print(TermColor.RESET_COLOR);
        System.out.println(o);
    }
}

class MainWindow extends Frame implements WindowListener {

    @Override
    public void windowActivated(WindowEvent arg0) {
        Logger.debug(arg0);
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        Logger.debug(arg0);
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        Logger.debug(arg0);
        dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        Logger.debug(arg0);
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        Logger.debug(arg0);
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        Logger.debug(arg0);
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        Logger.debug(arg0);
    }
}

class MidpJarFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        Logger.debug("[MidpJarFilenameFilter] dir: " + dir);
        Logger.debug("[MidpJarFilenameFilter] filename: " + name);

        if (name.length() == 0) {
            return false;
        }

        int startIdx = name.lastIndexOf(".");
        if (startIdx < 0) {
            return false;
        }

        String ext = name.substring(startIdx);
        Logger.debug("[MidpJarFilenameFilter] ext: " + ext);
        return true;
    }
}

public class Emulator {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        window.addWindowListener(window);

        window.setTitle("emulator");
        window.setSize(640, 480);
        window.setVisible(true);

        FileDialog fd = new FileDialog(window);
        MidpJarFilenameFilter filter = new MidpJarFilenameFilter();
        fd.setFilenameFilter(filter);
        // setVisible will block the thread here
        fd.setVisible(true);

        String selectedFileDir = fd.getDirectory();
        String selectedFilename = fd.getFile();

        Logger.debug(selectedFileDir);
        Logger.debug(selectedFilename);

        // TODO the main thread should have terminated after executing the following
        // print command but it is not
        Logger.debug("after setVisible");
    }
}
