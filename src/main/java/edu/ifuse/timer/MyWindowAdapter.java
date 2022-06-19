package edu.ifuse.timer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class MyWindowAdapter extends WindowAdapter {
    private final JFrame frame;

    public MyWindowAdapter(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        LOGGER.info("Program exit confirmation");
        int result = JOptionPane.showConfirmDialog(frame, "Do you want to close the application?",
                "Exit confirmation: ", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            LOGGER.info("Program exit confirmed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (result == JOptionPane.NO_OPTION) {
            LOGGER.info("Program exit canceled");
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
