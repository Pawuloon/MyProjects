package Gui2e.Task1;

public class Concat implements TwoStringOper
{
    public Concat() {}

    @Override
    public String apply(String one, String two)
    {
        return one + two;
    }
}
