package edu.ifuse.timer.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class MyLoggerFactory {

    public static Logger getLogger() {
        Logger logger;
        try {
            new FileOutputStream("log.txt");
            System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
            logger = Logger.getLogger("myLogger");
            FileHandler fileHandler = new FileHandler("log.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            return logger;
        } catch (SecurityException | IOException e) {
            throw new RuntimeException();
        }
    }

    public static void defaultLogging(JLabel label) {
        LOGGER.info("Timer display is: " + label.getText());
    }
}
