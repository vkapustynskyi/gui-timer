package edu.ifuse.timer.gui;

import javax.swing.*;
import java.awt.*;

import static edu.ifuse.timer.TimerApp.LOGGER;

public class TimerButtonLabel extends JLabel {

    private static final TimerButtonLabel INSTANCE = new TimerButtonLabel();

    private TimerButtonLabel() {
        super("");
        LOGGER.info("Creating buttons");
        this.setLayout(new GridLayout(1, 2));
        this.add(SwitchStatesButtonComponent.createToggleButton());
        this.add(ClearButtonComponent.createClearButton());
    }

    public static TimerButtonLabel getInstance() {
        return INSTANCE;
    }
}
