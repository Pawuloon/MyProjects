package Task4;

import java.util.Comparator;

public class MyComp implements Comparator<Integer>
{
    public static final int BY_VAL=0, BY_VAL_REV=1,BY_NUM_OF_DIVS=2, BY_SUM_OF_DIGS=3;

    private final int a ;
    public MyComp(int a)
    {
        this.a = a;
    }

    @Override
    public int compare(Integer o1, Integer o2)
    {
       if (a == BY_VAL)
           return Integer.compare(o1,o2);
       if (a == BY_VAL_REV)
           return Integer.compare(o2,o1);
       if(a == BY_NUM_OF_DIVS)
       {
           var b = countDivisors(o1);
           var c = countDivisors(o2);

           return Integer.compare(b,c);
       }
       if (a == BY_SUM_OF_DIGS)
           return Integer.compare(sumOfDigits(o1),sumOfDigits(o2));

       return  0;
    }
    private int countDivisors(int num)
    {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }


    private int sumOfDigits(int n)
    {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
