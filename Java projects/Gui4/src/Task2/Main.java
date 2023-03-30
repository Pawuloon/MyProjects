package Task2;

import java.util.Arrays;

public class Main
{
    public static <T,R> void transform(T[] in, R[] out, Transform<T, R> transform)
    {
        for (int i = 0; i < in.length; i++)
        {
            out[i] = transform.apply(in[i]);
        }
    }

    public static void main(String[] args)
    {
        String[]  sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) +'\n');
        Integer[] iout = new Integer[sin.length];
        Transform<String,Integer> parser = new Transform<String, Integer>() {
            @Override
            public Integer apply(String s)
            {
                return s.length();
            }
        };
        transform(sin, iout, parser);
        System.out.println(Arrays.toString(iout));
        Character[] cout = new Character[sin.length];
        transform(sin, cout, new Transform<String, Character>() {
            @Override
            public Character apply(String s)
            {
                return s.charAt(0);
            }
        });
        System.out.println(Arrays.toString(cout));
        String[] sout = new String[sin.length];
        transform(sin, sout, s -> s.toUpperCase());
        System.out.println(Arrays.toString(sout));

    }
}
