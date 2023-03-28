package Gui2e.Task1.Task2;

public class LenFilter implements SFilter
{
    private int minLen;

    public LenFilter(int minLen)
    {
        this.minLen = minLen;
    }

    @Override
    public boolean test(String one)
    {
        return one.length() >= minLen;
    }
}
