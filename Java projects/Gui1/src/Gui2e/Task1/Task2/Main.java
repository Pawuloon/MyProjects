package Gui2e.Task1.Task2;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {


        var arr = new String[]{"Alice", "Sue", "Janet", "Bea"};
        var len = new LenFilter(4);



        class Anon implements SFilter
        {
            public Anon() {}

            @Override
            public boolean test(String one)
            {
                var letter = one.charAt(0);
                return letter >= 'A' && letter < 'D';
            }
        }
        var anos = new Anon();

        SFilter filter = one ->
        {
            var first = one.charAt(0);
            return first > 'H' && first <= 'Z';
        };


        // Prints
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(SFilter.filter(arr, len)));
        System.out.println(Arrays.toString(SFilter.filter(arr, anos)));
        System.out.println(Arrays.toString(SFilter.filter(arr, filter)));
    }
}
