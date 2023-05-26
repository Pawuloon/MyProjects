package Task1;

import javax.swing.*;
import java.awt.*;

public class SnowMan extends JFrame
{
    public SnowMan()
    {
        setTitle("SnowMan");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(new Dimension(400,400));

        setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {

       super.paint(g);
        getContentPane().setBackground(Color.BLUE);
       var ballOneD = getHeight()/6;
       var ballTwoD = getHeight()/3;
       var ballThreeD = getHeight()/2;

       var x = getWidth() / 2 - ballThreeD / 2;
       var y = getWidth() - ballThreeD;

       // Ball three
       g.setColor(Color.WHITE);
       g.fillOval(x,y,ballThreeD,ballThreeD);
       // Ball two
       g.setColor(Color.WHITE);
       g.fillOval(x - (ballTwoD - ballThreeD) / 2, y - ballTwoD, ballTwoD, ballTwoD);

        // Ball three
       g.setColor(Color.WHITE);
       g.fillOval(x-(ballOneD - ballThreeD)/2, y - ballTwoD - ballOneD, ballOneD,ballOneD);


    }
}
