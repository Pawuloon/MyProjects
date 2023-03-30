package Task3;

public class Person
{
    private String name;
    private Sex sex;
    private Size size;
    private Country country;

    public Person(String name, Sex sex, Size size, Country country)
    {
        this.name = name;
        this.sex = sex;
        this.size = size;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Size getSize() {
        return size;
    }

    public Country getCountry() {
        return country;
    }


    @Override
    public String toString()
    {
        return name + " " + "(" + sex + " " + size + " " + country + ")";
    }
}
