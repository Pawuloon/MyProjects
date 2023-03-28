package zad1;

public class Good
{
    private final int id;
    private final int weight;

    public Good(int id, int weight)
    {
        this.id = id;
        this.weight = weight;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return id + " " + weight;
    }
}
