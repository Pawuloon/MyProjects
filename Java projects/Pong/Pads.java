package Pong;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Pads extends Rectangle
{
    int ID;
    int Speed = 15;
    int paddleSpeedDir;


    Pads(int x, int y, int paddleWidth, int paddleHeight,int ID)
    {
        super(x,y,paddleWidth,paddleHeight);
        this.ID = ID;
    }

    public void keyPressed(KeyEvent event)
    {
        switch (ID)
        {
            case 1:
                if (event.getKeyCode()==KeyEvent.VK_W)
                {
                    setDirection(-Speed);
                    move();
                }
                if (event.getKeyCode()==KeyEvent.VK_S)
                {
                    setDirection(Speed);
                    move();
                }
                break;

            case 2:
                if (event.getKeyCode()==KeyEvent.VK_UP)
                {
                    setDirection(-Speed);
                    move();
                }
                if (event.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    setDirection(Speed);
                    move();
                }

        }
    }

    public void keyReleased(KeyEvent event)
    {
        switch (ID)
        {
            case 1:
                if (event.getKeyCode()==KeyEvent.VK_W)
                {
                    setDirection(0);
                    move();
                }
                if (event.getKeyCode()==KeyEvent.VK_S)
                {
                    setDirection(0);
                    move();
                }
                break;

            case 2:
                if (event.getKeyCode()==KeyEvent.VK_UP)
                {
                    setDirection(0);
                    move();
                }
                if (event.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    setDirection(0);
                    move();
                }
                break;
        }
    }

    public void setDirection(int direction)
    {
        paddleSpeedDir = direction;
    }

    public void move()
    {
        y = y + paddleSpeedDir;
    }

    public void draw(Graphics graphics)
    {
        if (ID==1)
            graphics.setColor(Color.MAGENTA);
        else
            graphics.setColor(Color.YELLOW);

        graphics.fillRect(x,y,width,height);
    }



}