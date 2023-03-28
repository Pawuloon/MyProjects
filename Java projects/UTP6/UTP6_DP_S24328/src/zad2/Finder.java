package zad2;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;


public class Finder
{
    String fname;
    List<String>list;
    public Finder(String fname) throws IOException
    {
        this.fname = fname;
        list = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get(fname), StandardCharsets.UTF_8.name());
        while (scanner.hasNext())
        {
            String a = scanner.next();
            list.add(a);
        }
        scanner.close();
    }

    public int getIfCount()
    {

        int count = 0;
        String word = "if";
        String first = word.substring(1);
        List<List<String>> separate = new ArrayList<>();
        List<String> remove = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(Paths.get(fname),StandardCharsets.UTF_8.name());
            while (scanner.hasNext())
            {
                String a = scanner.nextLine();
                remove.add(a);
            }
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        for (String a : remove)
        {
            if (!a.startsWith("//"))
            {
                if (a.length() > word.length() || a.length() == word.length())
                    if (a.contains(word))
                    {
                        separate.add(Arrays.asList(a.split(String.valueOf(word.charAt(0)))));
                    }
            }
        }
        separate.forEach(System.out::println);
        String erase = String.valueOf((char)34);
        for (List<String> a : separate)
        {
            for (String b : a)
            {
                if (b.startsWith(first))
                    if ((b.contains("(") ))
                       count++;
            }
        }
        return count;
    }

    public int getStringCount(String variant)
    {
        int count = 0;
        List<List<String>>list1 = new ArrayList<>();
        String word = variant.replaceFirst(String.valueOf(variant.charAt(0)),"");
        for (String a : list)
        {
            if (a.length() > variant.length() || a.length() == variant.length())
                if (a.contains(variant))
                {
                    list1.add(Arrays.asList((a.split(String.valueOf(variant.charAt(0))))));
                }
        }
        for (List<String> strings : list1)
        {
            for (String string : strings)
            {
                if (string.contains(word))
                    count++;
            }
        }
        return count;
    }
}
