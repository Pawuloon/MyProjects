package Task1;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("List:");
        List<Person> list = Arrays.asList(new Person("Alice", 2000),
                new Person("Brenda", 2001),
                new Person("Cecilia", 2002));
        System.out.println(Person.isInColl(list, "Brenda", 2001));
        System.out.println(Person.isInColl(list, "Debby", 2001));


        Set<Person> tSet = new TreeSet<>(list);
        System.out.println("\nTreeSet:");
        System.out.println(Person.isInColl(tSet, "Brenda", 2001));
        System.out.println(Person.isInColl(tSet, "Debby", 2001));

        Set<Person> hSet = new HashSet<>(list);
        System.out.println("\nHashSet:");
        System.out.println(Person.isInColl(hSet, "Brenda", 2001));
        System.out.println(Person.isInColl(hSet, "Debby", 2001));
    }
}
