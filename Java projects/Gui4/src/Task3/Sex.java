package Task3;

public enum Sex
{
    F(0),
    M(1);

    private int val;
    Sex(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }
}
