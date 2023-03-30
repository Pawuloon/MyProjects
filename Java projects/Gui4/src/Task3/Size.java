package Task3;

public enum Size
{
    XS(0),
    S(1),
    M(2),
    L(3),
    XL(4);

    private int val;
    Size(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }
}
