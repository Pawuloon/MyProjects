/**
 *
 *  @author Dembicki Paweł S24328
 *
 */


package zad2;

import java.io.*;
import java.util.*;


public class Anagrams
{
    String fileName;
    List<String>list;
    List<List<String>>lists;
    public Anagrams(String string) throws FileNotFoundException
    {
        this.fileName = string;
        this.list = new ArrayList<>();
        this.lists = new ArrayList<>();
        Scanner scanner = new Scanner(new File(string));
        while (scanner.hasNext())
            list.add(scanner.next());
        scanner.close();
    }
    public boolean isAnagram(String string, String string2)
    {
        boolean anagram = false;
        char[] chars;
        char[] chars1;
        chars = string.toCharArray();
        chars1 = string2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        if (Arrays.equals(chars,chars1))
            anagram = true;
        return anagram;
    }

    public List<List<String>>getSortedByAnQty()
    {
        List<List<String>> lists = new ArrayList<>();
        List<String> listT = new ArrayList<>();
        List<String> copy = new ArrayList<>(this.list);

        for (String str : this.list)
        {
            if (copy.contains(str))
            {
                listT.add(str);
                for (int i = this.list.indexOf(str) + 1; i < this.list.size(); i++)
                {
                    if ((str.length() == this.list.get(i).length()) && isAnagram(this.list.get(i),str))
                    {
                        listT.add(this.list.get(i));
                        copy.remove(this.list.get(i));
                    }
                }
                lists.add(new ArrayList<>(listT));
                listT.clear();
            }
        }
        for ( List<String>list1 :lists )
        {
            Collections.sort(list1);
        }
        this.lists = lists;
        return lists;
    }
    public String getAnagramsFor(String next)
    {
        StringBuilder word = new StringBuilder(next).append(": ");
        for (List<String> strings : this.lists)
        {
            for (int i = 0; i < strings.size(); i++)
            {
                if (strings.get(i).equals(next))
                {
                    strings.remove(next);
                    word.append(strings);
                }
            }
        }
        if (word.toString().equals(next))
         return null;
       return word.toString();
    }

}
