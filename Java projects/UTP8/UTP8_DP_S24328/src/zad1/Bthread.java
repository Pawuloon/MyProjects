package zad1;
import java.util.List;

public class Bthread extends Thread
{
    private final List<Good>list;
    private int previous = 0;
    private int all = 0;

    public Bthread(List<Good> list)
    {
        this.list = list;
    }

    @Override
    public void run()
    {
        int size;
        try
        {
            Thread.sleep(200);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        while (this.previous != (size = list.size()))
        {
            for (int i = this.previous; i < size; i++)
            {
                if ((i + 1) % 100 == 0)
                    System.out.println("counted the weight of " + (i + 1) + " goods");
                synchronized (this.list)
                {
                    all += this.list.get(i).getWeight();
                }
            }
            this.previous = size;
        }
        System.out.println(this.all);
    }
}
