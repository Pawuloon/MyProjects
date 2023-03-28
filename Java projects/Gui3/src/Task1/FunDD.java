package Task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@FunctionalInterface
public interface FunDD
{
    double fun(double x);
    static double xminim(FunDD funDD, double a , double b)
    {
        var list = new ArrayList<Double>();
        for (double x = a; x <= b ; x+= 1e-5)
        {
            list.add(funDD.fun(x));

        }
        return list.indexOf(Collections.min(list));
    }
}
