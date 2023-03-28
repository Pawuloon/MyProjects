package zad1;

public class Purchase
{
    final String customer_id;
    final String name;
    final String commodity_name;
    final String price;
    final String purchased_quantity;

    public Purchase(String customerId, String name, String commodityName,
                    String price, String purchasedQuantity)
    {
        this.customer_id = customerId;
        this.name = name;
        this.commodity_name = commodityName;
        this.price = price;
        this.purchased_quantity = purchasedQuantity;
    }

    @Override
    public String toString()
    {
        return customer_id + ";" + name + ";" + commodity_name + ";" + price + ";" + purchased_quantity;
    }
}
