package Task2;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer>, Iterator<Integer>
{
    private int current;


    public Hailstone(int start)
    {
        this.current = 2 * start;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return this;
    }

    @Override
    public boolean hasNext()
    {
        return current != 1;
    }

    @Override
    public Integer next()
    {
        if (current % 2 == 0)
           return current /= 2;
        else
           return current =  3 * current + 1;

    }
}
