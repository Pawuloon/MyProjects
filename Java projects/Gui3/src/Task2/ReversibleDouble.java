package Task2;

public class ReversibleDouble implements Reversible
{
    private double reverse;

    public ReversibleDouble(double reverse)
    {
        this.reverse = reverse;
    }

    @Override
    public String reversing()
    {
        reverse = Double.parseDouble(new StringBuilder(String.valueOf(reverse)).reverse().toString());
        return String.valueOf(reverse);
    }

    @Override
    public String toString()
    {
        return "" + reverse;
    }
}
