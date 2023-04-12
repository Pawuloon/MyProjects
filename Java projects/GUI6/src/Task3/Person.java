package Task3;

public class Person
{
    private final String name;
    private final String group;
    private final String score;

    public Person(String name, String group, String score)
    {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return name + "(" + group + ")" + "-" + score;
    }
}
