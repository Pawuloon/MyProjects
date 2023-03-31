public class Stuff
{
    private final String name;
    private final int weight;

    public Stuff(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }


    @Override
    public String toString()
    {
        return this.name + " " + this.weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
