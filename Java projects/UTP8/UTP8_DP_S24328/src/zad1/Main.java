/**
 *
 *  @author Dembicki Paweł S24328
 *
 */



package zad1;

import java.nio.file.Paths;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        List<Good> list = Collections.synchronizedList(new ArrayList<>());

        Athread read = new Athread(list);
        Bthread countAll = new Bthread(list);

        read.setName("A");
        countAll.setName("B");
        read.start();
        countAll.start();
    }

}
