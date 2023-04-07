package Task2;

public class Main
{
    public static void main(String[] args)
    {

        for (int turn = 0; turn < 10; ++turn)
        {
            for (var i : new Roll())
                System.out.print(i + " ");
           System.out.println();
        }
    }
}
