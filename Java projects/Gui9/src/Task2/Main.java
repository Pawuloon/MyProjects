package Task2;

import javax.swing.*;
import java.awt.*;


public class Main
{
    public static void display()
    {
            var frame = new JFrame("Paris");
            // General
            JPanel panel = new JPanel(new GridLayout());
            var button1 = new Button("Warsaw");
            var button2 = new Button("Change Title...");
            var button3 = new Button("Paris");
            var text = new JTextField("Paris");
            panel.add(button3);
            panel.add(button1);
            panel.add(button2);
            panel.add(text);
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(panel, BorderLayout.NORTH);


            // Actions
            button1.addActionListener(e -> text.setText(button1.getLabel()));
            text.addActionListener(e -> button1.setLabel(text.getText()));

            button2.addActionListener(new Right(text,frame));
            button3.addActionListener(e -> text.setText(button3.getLabel()));
            // Main panel
            frame.getContentPane().add(mainPanel);
            frame.pack();
            frame.setVisible(true);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Main::display);
    }
}
