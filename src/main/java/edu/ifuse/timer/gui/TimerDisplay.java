package edu.ifuse.timer.gui;

import edu.ifuse.timer.service.MyLoggerFactory;

import javax.swing.*;
import java.awt.*;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class TimerDisplay extends JLabel {
    private static final TimerDisplay INSTANCE = new TimerDisplay();

    private TimerDisplay() {
        super("00:00:00");
        LOGGER.info("Creating timer display");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Digital", Font.PLAIN, 100));
        Timer timer = new Timer(10000, (e) -> MyLoggerFactory.defaultLogging(this));
        timer.start();
    }

    public static TimerDisplay getInstance() {
        return INSTANCE;
    }
}
