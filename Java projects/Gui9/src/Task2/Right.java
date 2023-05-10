package Task2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Right implements ActionListener
{

    private final JTextField text;
    private final JFrame frame;

    public Right(JTextField text, JFrame frame)
    {
        this.text = text;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            frame.setTitle(text.getText());
    }
}
