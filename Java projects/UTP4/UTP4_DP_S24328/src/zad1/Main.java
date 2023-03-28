/**
 *
 *  @author Dembicki Paweł S24328
 *
 */



package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {

        Function<String,List<String>> flines = n->
        {
            List<String>list = new ArrayList<>();
            try (BufferedReader buffer = new BufferedReader(
                    new FileReader(n))) {

                String str;
                while ((str = buffer.readLine()) != null)
                {
                    list.add(str);
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            return list;
        };
        Function<List<String>, String> join = (n)->
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (String a : n)
            {
                stringBuilder.append(a);
            }
            return String.valueOf(stringBuilder);
        };

        Function<String,List<Integer>> collectInts = (n)->
        {
            List<Integer> list = new ArrayList<>();
            int num;
            Pattern digit = Pattern.compile("-?\\d+");
            Matcher matcher = digit.matcher(n);
            while (matcher.find())
            {
                num = Integer.parseInt(matcher.group());
                list.add(num);
            }
            return list;
        };
        Function<List<Integer>,Integer> sum = (n)->
        {
            int suming = 0;
            for (int a  : n)
            {
                suming += a;
            }
            return suming;
        };/*<--
         *  definition of operations in the form of lambda expressions:
         *  - flines - returns a list of lines from a text file
         *  - join - combines a string list (returns a string of interconnected elements of the list)
         *  - collectInts - returns a list of integers contained in the string
         *  - sum - returns the sum of elements of a list of integers
         */

        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList(args);
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

    }
}
