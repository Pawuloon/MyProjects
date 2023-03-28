package Gui2e.Task1;

public class ConcatRev implements TwoStringOper
{
    public ConcatRev() {
    }

    @Override
    public String apply(String one, String two)
    {
        return two  + one;
    }
}
