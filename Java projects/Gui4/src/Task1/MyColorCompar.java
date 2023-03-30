package Task1;

import java.util.Comparator;

public class MyColorCompar implements Comparator<MyColor>
{
    private ColComponent colComponent;
    public MyColorCompar(ColComponent colComponent)
    {
        this.colComponent = colComponent;
    }

    @Override
    public int compare(MyColor o1, MyColor o2)
    {
        if (colComponent == ColComponent.RED)
            return o1.getR() - o2.getR();
        if (colComponent == ColComponent.GREEN)
            return o1.getG() - o2.getG();
        else
            return o1.getB() - o2.getB();
    }
}
