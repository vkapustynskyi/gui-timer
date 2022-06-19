package edu.ifuse.timer.gui;

import edu.ifuse.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;

public class ClearButtonComponent {

    public static JButton createClearButton() {
        JButton button = new JButton("Clear");
        button.setFont(new Font("Digital", Font.PLAIN, 20));
        button.addActionListener((e) -> TimerService.reset());
        return button;
    }

}
