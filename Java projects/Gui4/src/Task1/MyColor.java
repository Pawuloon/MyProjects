package Task1;

import java.awt.*;

public class MyColor extends Color implements Comparable<MyColor>
{

    private final int r,g,b;
    public MyColor(int r, int g, int b)
    {
        super(r, g, b);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString()
    {
        return "(" + r + "," + g + "," + b + ")";
    }

    @Override
    public int compareTo(MyColor o)
    {
        return (this.r + this.g + this.b) - (o.r + o.g + o.b);
    }
}
