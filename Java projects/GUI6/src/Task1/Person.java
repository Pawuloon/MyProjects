package Task1;

import java.util.Collection;
import java.util.Objects;

public class Person implements Comparable<Person>
{
    private final String name;
    private final int birthYear;

    public Person(String name, int birthYear)
    {
        this.name = name;
        this.birthYear = birthYear;
    }

    public static boolean isInColl(Collection<Person> collection, String name, int year)
    {
        return collection.contains(new Person(name,year));
    }

    @Override
    public boolean equals(Object obj)
    {
       if (obj == this)
           return true;
       if (!(obj instanceof Person person))
           return false;
       return this.name.equals(person.name) && this.birthYear == person.birthYear;
    }

    @Override
    public int hashCode()
    {
       return Objects.hash(this.name,this.birthYear);
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public int compareTo(Person o)
    {
        if (o.equals(new Person(name,birthYear)))
            return 0;
        return -1;
    }
}
