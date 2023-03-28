package Gui2ea.Task1;

import Gui2e.Task1.Initials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Singer
{
    private final String name;
    private static int number = 0;

    public Singer(String name)
    {
        this.name = name;
        number += 1;
    }

    public abstract String sing();



     public static Singer loudest(Singer[] object)
     {
         var len = new ArrayList<Integer>();
         for (Singer singer : object)
         {
             len.add(singer.sing().length());
         }
         Collections.sort(len);
         int ind = len.indexOf(len.get(len.size() - 1));

         for (var a : object)
         {
             if (a.sing().length() == len.get(ind)) {
                 return a;
             }
         }
         return null;
     }



    @Override
    public String toString()
    {
        return  name + ": " + sing();
    }

}
