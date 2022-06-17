package edu.ifuse.timer;

import javax.swing.*;

public class ClearButtonComponent {

    public static JButton createClearButton(TimerApp timer) {
        JButton button = new JButton("Clear");
        button.addActionListener((e) -> timer.reset());
        return button;
    }

}
