package edu.ifuse.timer;

import edu.ifuse.timer.gui.TimerFrame;
import edu.ifuse.timer.service.MyLoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Logger;

public class TimerApp {
    public static Logger LOGGER = MyLoggerFactory.getLogger();

    public static void main(String[] args) {
        new TimerFrame("GUI timer");
    }
}
