package Task3;

public class  Purchase
{
    private String name;
    private String productName;
    private int price;


    public Purchase(String name, String productName, int price) {
        this.name = name;
        this.productName = productName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString()
    {
        return name + " " + productName + " " + price;
    }
}
