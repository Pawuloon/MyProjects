package Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        String book = "schultz_sklepy_cynamonowe_UTF8.txt"; // or "melville_moby_dick.txt"
        int minLen = 5;

        try(Stream<String> lines = Files.lines(Paths.get(book)))
        {
            Map<Integer, List<String>> map = lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(word -> word.replaceAll("\\P{L}+", ""))
                    .filter(word -> word.length() >= minLen)
                    .filter(word -> word.chars().distinct().count() == word.length())
                    .collect(Collectors.groupingBy(String::length, Collectors.toList()));

            List<Integer> lastTwo = map.keySet().stream()
                    .sorted()
                    .toList();

            System.out.println("Two lists of the longest words with all letters different:");
            int len = lastTwo.get(lastTwo.size() - 2);
            System.out.println("length " + len + ": " + map.get(len));
            len = lastTwo.get(lastTwo.size() - 1);
            System.out.println("length " + len + ": " + map.get(len));

        } catch (IOException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
            System.exit(1);
        }

    }
}
