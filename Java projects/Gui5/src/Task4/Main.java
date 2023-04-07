package Task4;

import java.util.HashSet;

public class Main
{
    public static boolean isHappy(int num)
    {
       var set = new HashSet<Integer>();
       while(num != 1 && !set.contains(num))
       {
           set.add(num);
           var sum = 0;
           while (num > 0)
           {
                var digit = num % 10;
                sum += digit * digit;
                num /= 10;
           }
           num = sum;
       }
       return num == 1;
    }
    public static void main(String[] args)
    {
        int[] numbers = {    331,    238,    556549,15999,  85449,    999998,999997, 521133, 123456789 };
        for (int n : numbers)
            System.out.println(n + " is " +(isHappy(n) ? "happy" : "sad"));
    }
}
