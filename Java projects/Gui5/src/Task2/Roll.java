package Task2;


import java.util.Iterator;



public class Roll implements Iterable<Integer>, Iterator<Integer>
{
    private boolean cont = true;
    private int a = 20, b = 20;
    private int myRand;

    @Override
    public Iterator<Integer> iterator()
    {
        return this;
    }


    @Override
    public boolean hasNext()
    {
        return cont;
    }

    @Override
    public Integer next()
    {
        myRand = (int)((Math.random() * 6) + 1);
        if (a + b + myRand != 11)
        {
            b = a;
            a = myRand;
        }
        else
            cont = false;
        return myRand;
    }

    @Override
    public String toString()
    {
        return myRand + "";
    }
}
