package Task2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class fileDoxer
{
    public static void dox ()
    {
        JFrame frame = new JFrame("DOXER");

        JPanel textPanel = new JPanel();



        // Text file content
        JTextArea textArea = new JTextArea("Content.......");
        textArea.setPreferredSize(new Dimension(300,400));
        textPanel.add(textArea, BorderLayout.CENTER);



        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        var button1 = new JButton("EXIT");
        var button2 = new JButton("Select File");


        buttonPanel.add(button1);
        buttonPanel.add(button2);
        button1.addActionListener(e -> System.exit(0));

        button2.addActionListener(e ->
        {
            var filer = new JFileChooser(System.getProperty("user.home"));
            filer.setFileFilter(new FileNameExtensionFilter("CustomFilter","txt","java"));
            filer.showOpenDialog(null);
            var file = filer.getSelectedFile();
            frame.setTitle(file.getName());
            BufferedReader br;
            try
            {
                String st;
                StringBuilder builder = new StringBuilder();
                br = new BufferedReader(new FileReader(file));
                while ((st = br.readLine()) != null)
                    builder.append(st).append("\n");
                textArea.setText(String.valueOf(builder));
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        });
        frame.setVisible(true);

        frame.add(textPanel,BorderLayout.CENTER);
        frame.add(buttonPanel,BorderLayout.PAGE_END);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
