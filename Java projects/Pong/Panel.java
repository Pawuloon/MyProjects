package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements Runnable
{
    static final int gameWidth = 1000;
    static final int gameHeight = 1000;
    static final Dimension screenSize = new Dimension(gameWidth, gameHeight);
    static final int ballDiameter = 40;
    static final int paddleWidth = 40;
    static final int paddleHeight = 200;


    Thread gameThread;
    Image image;
    Graphics Graphical;
//  Player one
    Pads pad1;
//  Player two
    Pads pad2;
    Ball ball;
    Score score;

    Panel()
    {
        newPaddles();
        newBall();
        score = new Score(gameWidth, gameHeight);
        this.setFocusable(true);
        this.addKeyListener(new Listener());
        this.setPreferredSize(screenSize);


        gameThread = new Thread(this);

        gameThread.start();
    }

    public void newBall()
    {
        ball = new Ball((gameWidth / 2) - (ballDiameter / 2), (gameHeight / 2) - (ballDiameter / 2), ballDiameter, ballDiameter);
    }

    public void newPaddles()
    {
        pad1 = new Pads(0, (gameHeight / 2) - (paddleHeight / 2), paddleWidth, paddleHeight, 1);
        pad2 = new Pads(gameWidth - paddleWidth, (gameHeight / 2) - (paddleHeight / 2), paddleWidth, paddleHeight, 2);
    }

    @Override
    public void paint(Graphics graphics)
    {
        image = createImage(gameWidth, gameHeight);
        Graphical = image.getGraphics();
        draw(Graphical);

        graphics.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics graphics)
    {
        pad1.draw(graphics);
        pad2.draw(graphics);
        ball.draw(graphics);
        score.draw(graphics);
    }

    public void move()
    {
            pad1.move();
            pad2.move();
            ball.move();
    }

    public void collision()
    {
//          Paddle 1 stop at edge
        if (pad1.y <= 0)
            pad1.y = 0;
        if (pad1.y >= (gameHeight - paddleHeight))
            pad1.y = (gameHeight - paddleHeight);

//          Paddle 2 stop at edge
        if (pad2.y <= 0)
            pad2.y = 0;
        if (pad2.y >= (gameHeight - paddleHeight))
            pad2.y = (gameHeight - paddleHeight);
//          Ball bounce of the edge
        if (ball.y <= 0)
        {
            ball.yDirectionSpeed(-ball.yBallSpeed);
        }

        if (ball.y >= gameHeight - ballDiameter)
        {
            ball.yDirectionSpeed(-ball.yBallSpeed);
        }

//          Ball bounce of  paddle 1
        if (ball.intersects(pad1))
        {
            ball.xBallSpeed = Math.abs(ball.xBallSpeed);
            ball.xBallSpeed++;

            if (ball.yBallSpeed > 0)
                ball.yBallSpeed++;
            else
                ball.yBallSpeed--;
            ball.xDirectionSpeed(ball.xBallSpeed);
            ball.yDirectionSpeed(ball.yBallSpeed);
        }

//          Ball bounces of paddle 2
        if (ball.intersects(pad2))
        {
            ball.xBallSpeed = Math.abs(ball.xBallSpeed);
            ball.xBallSpeed++;

            if (ball.yBallSpeed > 0)
                ball.yBallSpeed++;
            else
                ball.yBallSpeed--;
            ball.xDirectionSpeed(-ball.xBallSpeed);
            ball.yDirectionSpeed(ball.yBallSpeed);
        }

//          Player gets one point and new ball is created
        if (ball.x <= 0)
        {
            score.player2Score++;
            newPaddles();
            newBall();
        }

        if (ball.x >= gameHeight - ballDiameter)
        {
            score.player1Score++;
            newPaddles();
            newBall();
        }
    }

    public void run()
    {
        long time = System.nanoTime();
        double frames = 30.0;
        double nanoSec = 1000000000 / frames;
        double delta = 1;

        while (true)
        {
            long now = System.nanoTime();
            delta += (now - time) / nanoSec;
            time = now;

            if (delta >= 1)
            {
                move();
                collision();
                repaint();
                delta--;
            }
        }

    }

    public class Listener extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)
        {

                pad1.keyPressed(event);
                pad2.keyPressed(event);
        }

        public void keyReleased(KeyEvent event)
        {
            pad1.keyReleased(event);
            pad2.keyReleased(event);
        }
    }
}