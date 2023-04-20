package Task4;

import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        String file = System.getProperty("user.home") +"/CountWords.txt";
        System.out.println(file);
        for (Map.Entry<String, Integer> e : new Words(file))
            System.out.println(e.getKey() + " -> " + e.getValue());
    }
}
