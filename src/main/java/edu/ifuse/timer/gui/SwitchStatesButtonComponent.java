package edu.ifuse.timer.gui;

import edu.ifuse.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;

public class SwitchStatesButtonComponent {

    public static JToggleButton createToggleButton() {
        JToggleButton button = new JToggleButton("Start");
        button.setFont(new Font("Digital", Font.PLAIN, 20));
        button.addActionListener((e -> toggleAction(button)));
        return button;
    }

    private static void toggleAction(JToggleButton toggleButton) {
        if (toggleButton.isSelected()) {
            toggleButton.setText("Stop");
            TimerService.start();
        } else {
            toggleButton.setText("Start");
            TimerService.stop();
        }
    }

}
