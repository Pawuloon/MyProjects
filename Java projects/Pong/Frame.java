package Pong;

import javax.swing.*;
import java.awt.*;

class GFrame extends JFrame
{
    private final Panel panel;

    GFrame()
    {
        panel = new Panel();
        this.add(panel);
        this.setTitle("Ping-Pong");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
