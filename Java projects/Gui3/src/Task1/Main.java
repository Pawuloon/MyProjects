package Task1;

public class Main
{
    public static void main(String[] args)
    {
        // Example 1
        System.out.println(FunDD.xminim(new Parabola(1,-1,5/4d),0,1));
        // Example 2
        var anon = new FunDD() {
            @Override
            public double fun(double x)
            {
                return Math.sqrt(Math.pow(x - 0.75,2) + 1);
            }
        };

        System.out.println("Second");
        System.out.println(FunDD.xminim(anon,0,2));
        // Example 3
        FunDD funDD = x -> Math.pow(x,2) * (x - 2);
        System.out.println(FunDD.xminim(funDD,0,2));
    }
}
