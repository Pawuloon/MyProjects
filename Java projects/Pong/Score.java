package Pong;

import java.awt.*;

public class Score extends Rectangle
{
    static int width;
    static int height;
    int player1Score;
    int player2Score;

    Score(int width, int height)
    {
        Score.width = width;
        Score.height = height;
    }

    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Serif Plain",Font.PLAIN, 70));

        graphics.drawLine(width/2,0,width/2,height);

        graphics.setColor(Color.MAGENTA);
        graphics.drawString(String.valueOf(player1Score), (width/2 - 90), 55);

        graphics.setColor(Color.YELLOW);
        graphics.drawString(String.valueOf(player2Score), (width/2 + 15), 55);
    }
}
