package Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Words implements Iterable<Map.Entry<String, Integer>> {

    private final String fileName;

    public Words(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Iterator<Map.Entry<String, Integer>> iterator() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8);
            Map<String, Integer> wordCounts = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\W+")))
                    .filter(word -> word.length() > 0)
                    .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                    .collect(Collectors.groupingBy(word -> word, HashMap::new, Collectors.summingInt(e -> 1)));
            return wordCounts.entrySet().iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
