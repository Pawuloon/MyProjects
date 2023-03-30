package Task3;

public enum Country
{
    PL("Polska"),
    NL("Nederland"),
    DE("Deustchland");
    private String label;

    Country(String label)
    {
        this.label = label;
    }

    @Override
    public String toString()
    {
        return label;
    }


}
