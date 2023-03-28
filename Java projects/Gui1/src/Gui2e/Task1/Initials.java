package Gui2e.Task1;

public class Initials implements TwoStringOper
{
    public Initials() {
    }

    @Override
    public String apply(String one, String two)
    {
        return "" + one.charAt(0) + two.charAt(0);
    }
}
