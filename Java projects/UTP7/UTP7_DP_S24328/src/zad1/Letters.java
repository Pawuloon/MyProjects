package zad1;

import java.util.List;
import java.util.Vector;

public class Letters
{
    List<Thread>threadList;
    public Letters(String letters)
    {
        threadList = new Vector<>();
        int i = 0;
        while (i < letters.length())
        {
            String string = String.valueOf(letters.charAt(i));
            Thread myThread = new Thread(()->
            {
                while (!Thread.interrupted())
                {
                    System.out.print(string);
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception exception)
                    {
                        break;
                    }
                }

            });
            myThread.setName("Thread " + string);
            threadList.add(myThread);
            i++;
        }
    }

    public List<Thread>getThreads()
    {
        return this.threadList;
    }
}
