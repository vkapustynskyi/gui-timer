package edu.ifuse.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TimerApp {
    public static Logger LOGGER;
    private static String TIME = "00:00:00";
    private static Timer TIMER;
    private static Timer DEFAULT_LOGGING_TIMER;
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel timerDisplayLabel;
    private final JLabel buttonsLabel;
    private final FileOutputStream journalFile = new FileOutputStream("log.txt");

    public TimerApp() throws FileNotFoundException {
        configureLogger();
        LOGGER.info("Setting up GUI timer");
        frame = new JFrame("GUI Timer");
        frame.addWindowListener(new MyWindowAdapter(frame));
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyEventDispatcher());

        LOGGER.info("Creating timer display");
        timerDisplayLabel = new JLabel("00:00:00");
        timerDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerDisplayLabel.setFont(new Font("Digital", Font.PLAIN, 100));

        LOGGER.info("Creating buttons");
        buttonsLabel = new JLabel();
        buttonsLabel.setLayout(new GridLayout(1, 2));
        buttonsLabel.add(SwitchStatesButtonComponent.createToggleButton());
        buttonsLabel.add(ClearButtonComponent.createClearButton(this));

        panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(timerDisplayLabel);
        panel.add(buttonsLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);

        LOGGER.info("Configuring timer");
        TIMER = new Timer(1000, this::iterateTimer);
        DEFAULT_LOGGING_TIMER = new Timer(10000, this::defaultLogging);
        DEFAULT_LOGGING_TIMER.start();
        JOptionPane.showMessageDialog(null, "Welcome! Use the timer!", "GUI timer", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new TimerApp();
    }

    public static void start() {
        LOGGER.info("Starting the timer");
        TIMER.start();
    }

    public static void stop() {
        LOGGER.info("Stopping the timer");
        TIMER.stop();
    }

    private static void configureLogger() {
        try {
            LOGGER = Logger.getLogger("myLogger");
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        LOGGER.info("Resetting the timer");
        TIME = "00:00:00";
        timerDisplayLabel.setText("00:00:00");
    }

    private void iterateTimer(ActionEvent e) {
        TIME = LocalTime.parse(TIME).plus(1000, ChronoUnit.MILLIS).toString();
        timerDisplayLabel.setText(TIME);
    }

    private void defaultLogging(ActionEvent e) {
        LOGGER.info("Timer display is: " + timerDisplayLabel.getText());
    }

    private class MyKeyEventDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED && e.isAltDown() && e.getKeyChar() == 'U') {
                LOGGER.info("Alt + U pressed.");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            return false;
        }
    }
}
