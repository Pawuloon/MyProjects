package zad2;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        // List of destination: departure_airport destination_airport price_EUR
        // See if you have to erase "" this from list
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
        List<String> result = dest.stream().filter(a->a.startsWith("WAW")).map(a->
        {
            String separate;
            String name, value;
            StringBuilder builder = new StringBuilder();
            int number;
            number = Integer.parseInt(a.replaceAll("[A-Za-z]","").trim());
            separate = String.valueOf((int)(number * ratePLNvsEUR));
            value = a.replaceAll("-?\\d+",separate).replaceAll("[^0-9]","");
            name = a.substring(3).trim().replaceAll("-?\\d+","");
            a = String.valueOf(builder.replace(0,27,"to " + name + "-price in PLN:  " + value));
            return a;
        }).collect(Collectors.toList());

        /*<-- you should add a code fragment here
         * you should not use any your own classes like eg. ListCreator
         * or either any your own interfaces
         */

        for (String r : result) System.out.println(r);
    }
}


