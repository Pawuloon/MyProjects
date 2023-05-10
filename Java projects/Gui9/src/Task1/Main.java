package Task1;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void examp1()
    {
        JFrame frame = new JFrame("Examp1");


        JPanel panel1 = new JPanel(new GridLayout(4,1));
        JPanel panel2 = new JPanel(new GridLayout(3,3));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));



        panel2.add(new JButton("B1"));
        panel2.add(new JButton("B2"));
        panel2.add(new JButton("B3"));
        panel2.add(new JButton("B4"));
        panel2.add(new JButton("B5"));
        panel2.add(new JButton("B6"));
        panel2.add(new JButton("B7"));
        panel2.add(new JButton("B8"));
        panel2.add(new JButton("B9"));


        panel1.add(new JTextField("Field 1"));
        panel1.add(new JTextField("Field 2"));
        panel1.add(new JTextField("Field 3"));
        panel1.add(new JTextField("Field 4"));
        panel1.add(new JScrollPane(new JTextArea("Text Area")));
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.NORTH);
        mainPanel.add(panel2, BorderLayout.EAST);


        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void examp2()
    {
        JFrame frame = new JFrame("Examp2");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new GridLayout(3,4));
        JPanel panel3 = new JPanel();

        panel2.add(new JButton("01"));
        panel2.add(new JButton("02"));
        panel2.add(new JButton("03"));
        panel2.add(new JButton("04"));
        panel2.add(new JButton("05"));
        panel2.add(new JButton("06"));
        panel2.add(new JButton("07"));
        panel2.add(new JButton("08"));
        panel2.add(new JButton("09"));
        panel2.add(new JButton("10"));
        panel2.add(new JButton("11"));
        panel2.add(new JButton("12"));



        panel1.add(new JTextArea("Text Area 1"));

        panel3.add(new JTextArea("Text Area 2"));



        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.WEST);
        mainPanel.add(panel2, BorderLayout.CENTER);
        mainPanel.add(panel3, BorderLayout.EAST);
        mainPanel.add(new JTextArea("Text Area 4"),BorderLayout.SOUTH);


        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void examp3()
    {
        JFrame frame = new JFrame("Examp3");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new GridLayout(2,2));
        JPanel panel3 = new JPanel(new GridLayout(2,3));
        JPanel panel4 = new JPanel();

        panel1.add(new JTextArea("Text Area 1"));

        panel4.add(new JTextField("TextField1"));
        panel4.add(new JTextField("TextField2"));
        panel4.add(new JTextField("TextField3"));


        panel2.add(new JButton("B01"));
        panel2.add(new JButton("B02"));
        panel2.add(new JButton("B03"));
        panel2.add(new JButton("B04"));

        panel3.add(panel4);
        panel3.add(new JButton("B05"));
        panel3.add(new JButton("B06"));
        panel3.add(new JTextField("TextField3"));
        panel3.add(new JButton("B07"));
        panel3.add(new JButton("B08"));






        panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.NORTH);
        mainPanel.add(panel2, BorderLayout.WEST);
        mainPanel.add(panel3, BorderLayout.EAST);





        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Main::examp1);
    }
}
