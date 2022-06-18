package edu.ifuse.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimerApp implements ActionListener {

    private static String TIME = "00:00:00";
    private static Timer TIMER;
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel timerDisplayLabel;
    private final JLabel buttonsLabel;

    public TimerApp() {
        frame = new JFrame("GUI Timer");
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

        timerDisplayLabel = new JLabel("00:00:00");
        timerDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerDisplayLabel.setFont(new Font("Digital", Font.PLAIN, 100));

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
        frame.pack();
        frame.setSize(700, 500);

        TIMER = new Timer(1000, this);
    }

    public static void main(String[] args) {
        new TimerApp();
    }

    public static void start() {
        TIMER.start();
    }

    public static void stop() {
        TIMER.stop();
    }

    public void reset() {
        TIME = "00:00:00";
        timerDisplayLabel.setText("00:00:00");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TIME = LocalTime.parse(TIME).plus(1000, ChronoUnit.MILLIS).toString();
        timerDisplayLabel.setText(TIME);
    }

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED && e.isAltDown() && e.getKeyChar() == 'u') {
                System.out.println("Pressed " + e.getKeyChar());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            return false;
        }
    }
}
