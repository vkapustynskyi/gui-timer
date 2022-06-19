package edu.ifuse.timer;

import javax.swing.*;

public class SwitchStatesButtonComponent {

    public static JToggleButton createToggleButton() {
        JToggleButton toggleButton = new JToggleButton("Start");
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
