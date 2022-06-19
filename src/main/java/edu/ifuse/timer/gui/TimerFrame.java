package edu.ifuse.timer.gui;

import edu.ifuse.timer.service.MyKeyEventDispatcher;
import edu.ifuse.timer.service.MyLoggerFactory;
import edu.ifuse.timer.service.MyWindowAdapter;
import edu.ifuse.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class TimerFrame extends JFrame {

    public TimerFrame(String title) throws HeadlessException {
        super(title);
        LOGGER.info("Setting up GUI timer");
        this.addWindowListener(new MyWindowAdapter(this));
        this.setIconImage(new ImageIcon("src/main/resources/timer-ico.png").getImage());
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyEventDispatcher(this));

        this.add(new TimerPanel(new GridLayout(0, 1)), BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(600, 400));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        JOptionPane.showMessageDialog(null, "Welcome! Use the timer!", "GUI timer", JOptionPane.INFORMATION_MESSAGE);
    }
}
