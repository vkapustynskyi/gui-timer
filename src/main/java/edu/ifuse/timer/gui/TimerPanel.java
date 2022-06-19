package edu.ifuse.timer.gui;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {

    public TimerPanel(LayoutManager layout) {
        super(layout);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.add(TimerDisplay.getInstance());
        this.add(TimerButtonLabel.getInstance());
    }
}
