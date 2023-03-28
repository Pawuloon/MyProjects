package Gui2e.Task1.Task2;

import java.util.ArrayList;

public interface SFilter
{
    boolean test(String one);

    static String[] filter(String[] arr, SFilter filter)
    {
        var list = new ArrayList<String>();
        for (var a: arr)
        {
            if(filter.test(a))
                list.add(a);
        }
        var retArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            retArr[i] = list.get(i);
        }
        return retArr;
    }

}
