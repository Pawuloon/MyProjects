package Task1;

public class Parabola implements FunDD
{

    private final double a;
    private final double b;
    private final double c;

    public Parabola(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double fun(double x)
    {
        return a * Math.pow(x,2) + b * x + c;
    }
}
