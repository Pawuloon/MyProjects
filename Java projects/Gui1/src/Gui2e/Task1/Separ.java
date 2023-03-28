package Gui2e.Task1;

public class Separ implements TwoStringOper
{
    private final String separ;

    public Separ(String separ)
    {
        this.separ = separ;
    }

    @Override
    public String apply(String one, String two)
    {
        return one + this.separ + two;
    }
}
