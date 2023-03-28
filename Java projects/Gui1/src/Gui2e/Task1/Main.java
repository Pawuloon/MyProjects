package Gui2e.Task1;

public class Main
{
    public static void main(String[] args)
    {
        TwoStringOper[] a = {new Concat(), new ConcatRev(), new Initials() , new Separ(" loves ")};
        for (var b : a)
        {
            System.out.println(b.apply("Mary", "John"));
        }
    }
}
