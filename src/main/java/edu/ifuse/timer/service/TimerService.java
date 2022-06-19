package edu.ifuse.timer.service;

import edu.ifuse.timer.gui.TimerButtonLabel;
import edu.ifuse.timer.gui.TimerDisplay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class TimerService {

    private static String DEFAULT_TIME = "00:00:00";
    private static final Timer TIMER = new Timer(1000, TimerService::iterateTimer);
    private static final TimerDisplay TIMER_DISPLAY = TimerDisplay.getInstance();

    public static void start() {
        LOGGER.info("Starting the timer");
        TIMER.start();
    }

    public static void stop() {
        LOGGER.info("Stopping the timer");
        TIMER.stop();
    }

    public static void reset() {
        LOGGER.info("Resetting the timer");
        DEFAULT_TIME = "00:00:00";
        TIMER_DISPLAY.setText("00:00:00");
    }

    private static void iterateTimer(ActionEvent e) {
        DEFAULT_TIME = LocalTime.parse(DEFAULT_TIME).plus(1000, ChronoUnit.MILLIS).toString();
        TIMER_DISPLAY.setText(DEFAULT_TIME);
    }
}
