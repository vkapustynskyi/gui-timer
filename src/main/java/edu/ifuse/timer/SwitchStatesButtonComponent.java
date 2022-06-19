package edu.ifuse.timer;

import javax.swing.*;
import java.awt.*;

public class SwitchStatesButtonComponent {

    public static JToggleButton createToggleButton() {
        JToggleButton toggleButton = new JToggleButton("Start");
        toggleButton.setFont(new Font("Digital", Font.PLAIN, 20));
        toggleButton.addActionListener((e -> toggleAction(toggleButton)));
        return toggleButton;
    }

    private static void toggleAction(JToggleButton toggleButton) {
        if (toggleButton.isSelected()) {
            toggleButton.setText("Stop");
            TimerApp.start();
        } else {
            toggleButton.setText("Start");
            TimerApp.stop();
        }
    }

}
