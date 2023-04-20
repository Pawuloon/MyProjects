package Task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static List<Person> getPersons(List<String> list)
    {
        return list.stream().filter(word -> word.length() > 3).map(word -> new Person(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase()))
                .sorted(Comparator.comparing(Person::getName)).limit(3).collect(Collectors.toList());
    }
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("john", "al", "KENNY", "jenny","noemi");
        System.out.println(getPersons(list));
    }
}
