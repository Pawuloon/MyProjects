package Pong;

import java.util.Scanner;

public class Pong
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1 to start the game");
        int num = scanner.nextInt();
        if (num == 1)
        {
            new GFrame();
        }

    }
}
