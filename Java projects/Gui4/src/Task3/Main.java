package Task3;

import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    public static<T> void printArray(String string, T[] person)
    {
        System.out.println(string + "\n" + Arrays.toString(person).replaceAll("\\),",")\n"));
    }
    public static void main(String[] args)
    {
        Person[] persons = {
                new Person("Max",  Sex.M, Size.XL, Country.NL),
                new Person("Jan",  Sex.M, Size.S,  Country.PL),
                new Person("Eva",  Sex.F, Size.XS, Country.NL),
                new Person("Lina", Sex.F, Size.L,  Country.DE),
                new Person("Mila", Sex.F, Size.S,  Country.DE),
                new Person("Ola",  Sex.F, Size.M,  Country.PL),};
        Comparator<Person> sexThenSize = (o1, o2) ->
        {
            int a = o1.getSex().compareTo(o2.getSex());
            int b = o1.getSize().compareTo(o2.getSize());
            return Math.min(a, b);
        };
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);
        Arrays.sort(persons,((o1, o2) ->
        {
            int a = o1.getSize().compareTo(o2.getSize());
            int b = o1.getName().compareTo(o2.getName());
            return a - b;
        }));
        printArray("Persons by size and then name", persons);
        Country[] countries = Country.values();
        Arrays.sort(countries,((o1, o2) ->
        {
           return o2.ordinal() - o1.ordinal();
        }));
        printArray("Countries by name", countries);
    }
}
