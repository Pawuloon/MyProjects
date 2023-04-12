package Task3;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main
{
    public static void Task()
    {
        Map<String, List<Person>> map;
        try
        {
            // Files.lines(Path.get(file) // Stream of strings
            List<String> lines = Files.readAllLines(new File("f.txt").toPath());
            map = lines.stream().map(line -> line.split(" ")).map(stud -> new Person(stud[0],stud[1],stud[2])).collect(Collectors.groupingBy(Task3.Person::getGroup));
            map.forEach((group, stud) -> System.out.println("Group " + group + ": " + stud));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        Task();
    }
}
