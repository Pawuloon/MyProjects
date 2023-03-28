package Task3;

import java.util.Comparator;

public class MyComp implements Comparator<Integer>
{
    public static final int
            BY_VAL = 0,
            BY_VAL_REV = 1,
            BY_NUM_OF_DIVS = 2,
            BY_SUM_OF_DIGS = 3;

    private int num;

    public MyComp(int num)
    {
        this.num = num;
    }


    @Override
    public int compare(Integer o1, Integer o2)
    {
        switch (num)
        {
            case BY_VAL:
                return o1.compareTo(o2);
            case BY_VAL_REV:
                return o2.compareTo(o1);
            case BY_NUM_OF_DIVS:
                if (getDivisorsCount(o1) != getDivisorsCount(o2))
                    return getDivisorsCount(o1) - getDivisorsCount(o2);
                return o1.compareTo(o2);
            case BY_SUM_OF_DIGS:
                if ( getDigitSum(o1) != getDigitSum(o2))
                {
                    return getDigitSum(o1) - getDigitSum(o2);
                }
                return o1.compareTo(o2);

        }
        return -1;
    }

    private int getDivisorsCount(int n)
    {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }


    private int getDigitSum(int n)
    {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
