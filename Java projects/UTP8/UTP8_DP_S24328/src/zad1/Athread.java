package zad1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Athread extends Thread
{
    private final List<Good>list;
    public Athread(List<Good> list)
    {
        this.list = list;
    }

    @Override
    public void run()
    {

        try
        {
            File file = new File("../Goods.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int num = 0;
            String split;
            while((split = bufferedReader.readLine()) != null)
            {
                String[] data = split.split(" ");
                synchronized (this.list)
                {
                        this.list.add(new Good(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
                }
                num+=1;
                if (num%200==0)
                    System.out.println("created " + num + " objects");
            }
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }
}
