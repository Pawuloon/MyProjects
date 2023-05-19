package Pong;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle
{

    Random random = new Random();
    int xBallSpeed;
    int yBallSpeed;
    int movementSpeed = 8;

    Ball(int x, int y, int width , int height)
    {
        super(x,y,width,height);

        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        xDirectionSpeed(randomXDirection * movementSpeed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        yDirectionSpeed(randomYDirection * movementSpeed);

    }

    public void xDirectionSpeed(int x)
    {
        xBallSpeed = x;
    }

    public void yDirectionSpeed(int y)
    {
        yBallSpeed = y;
    }

    public void move()
    {
        x += xBallSpeed;
        y += yBallSpeed;
    }

    public void draw(Graphics graphics)
    {

        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        graphics.setColor(new Color(r,g,b));
        graphics.fillOval(x,y,height,width);
    }
}