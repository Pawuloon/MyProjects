package Task2;

public class ReversibleString implements Reversible
{

    private String reverse;

    public ReversibleString(String reverse)
    {
        this.reverse = reverse;
    }

    @Override
    public String reversing()
    {
        var build = new StringBuilder(reverse);
        reverse = (build.reverse().toString());
        return reverse;
    }

    @Override
    public String toString()
    {
        return reverse;
    }
}
