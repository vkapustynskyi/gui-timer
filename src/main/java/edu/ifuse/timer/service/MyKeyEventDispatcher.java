package edu.ifuse.timer.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class MyKeyEventDispatcher implements KeyEventDispatcher {
    private final JFrame frame;

    public MyKeyEventDispatcher(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED && e.isAltDown() && e.getKeyChar() == 'U') {
            LOGGER.info("Alt + U pressed.");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        return false;
    }
}