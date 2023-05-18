package Task1;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class Main
{

    public static void words()
    {
        JFrame frame = new JFrame("WORDS");


        // Text
        var panel = new JPanel();

        var text = new JTextArea("jdsgkxvhc xj");
        text.setPreferredSize(new Dimension(300, 400));
        AtomicReference<String> og = new AtomicReference<>(text.getText());

        panel.add(text);

        // Buttons
        var buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        var button1 = new JButton("Back");
        var button2 = new JButton("Show words");

        button1.setEnabled(false);
        button2.setEnabled(true);
        // Actions
        button2.addActionListener(e ->
        {
            og.set(text.getText());
            var field = text.getText().split("\\P{L}+");
            var set = new LinkedHashSet<>(Arrays.asList(field));
            var builder = new StringBuilder();
            set.forEach(a-> builder.append(a.toLowerCase()).append("\n"));
            text.setText(String.valueOf(builder));
            button2.setEnabled(false);
            button1.setEnabled(true);
        });


        button1.addActionListener(e ->
        {
            text.setText(og.get());
            button1.setEnabled(false);
            button2.setEnabled(true);
        });

        buttons.add(button1);
        buttons.add(button2);

        // Final build
        frame.add(panel,BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.PAGE_END);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Main::words);
    }
}
