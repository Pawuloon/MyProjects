package zad1;


import java.util.function.Function;

public class InputConverter<T>
{
    T t;

    public InputConverter(T t)
    {
        this.t = t;
    }

    // Only one method


    public <K>K convertBy(Function...functions)
    {
        Object object = functions[0].apply(t);
        for (int i = 1; i < functions.length; i++)
        {
            object = functions[i].apply(object);
        }

        return (K)object;
    }


}
