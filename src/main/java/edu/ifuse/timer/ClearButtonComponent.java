package edu.ifuse.timer;

import javax.swing.*;
import java.awt.*;

public class ClearButtonComponent {

    public static JButton createClearButton(TimerApp timer) {
        JButton button = new JButton("Clear");
        button.setFont(new Font("Digital", Font.PLAIN, 20));
        button.addActionListener((e) -> timer.reset());
        return button;
    }

}
