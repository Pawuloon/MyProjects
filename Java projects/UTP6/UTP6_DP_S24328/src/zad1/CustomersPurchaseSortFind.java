package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CustomersPurchaseSortFind
{
    List<String>list;
    List<Purchase>purchaseList;
    String fname;
    public void readFile(String fname)
    {
        purchaseList = new ArrayList<>();
        this.fname = fname;
        File file = new File(fname);
        try
        {
            Scanner scanner = new Scanner(file);
            list = new ArrayList<>();
            while (scanner.hasNext())
                list.add(scanner.nextLine());
            scanner.close();
        }catch (FileNotFoundException exception)
        {
            System.out.println("Error");
        }

        List<List<String>>separate = new ArrayList<>();
        int i = 0;
        for (String a : list)
        {
            separate.add(Arrays.asList(a.split(";")));
            purchaseList.add(new Purchase(separate.get(i).get(0),separate.get(i).get(1)
                    ,separate.get(i).get(2),separate.get(i).get(3),separate.get(i).get(4)));
            i++;
        }
        purchaseList.forEach(System.out::println);


    }

    public void showSortedBy(String names)
    {
        switch (names)
        {
            case "names":
            {
                System.out.println("names");
                Comparator<Purchase>comparator = new Comparator<Purchase>()
                {
                    @Override
                    public int compare(Purchase o1, Purchase o2)
                    {
                        return o1.name.compareTo(o2.name);
                    }
                };
                purchaseList.sort(comparator);
                for (Purchase p : purchaseList)
                {
                    System.out.println(p);
                }
                break;
            }
            case "costs":
            {
                System.out.println("costs");
                Comparator<Purchase>comparator = new Comparator<Purchase>()
                {
                    @Override
                    public int compare(Purchase o1, Purchase o2)
                    {
                       double price = Double.parseDouble(o1.price) * Double.parseDouble(o1.purchased_quantity);
                       double price2 = Double.parseDouble(o2.price) * Double.parseDouble(o2.purchased_quantity);
                       return Double.compare(price2,price);
                    }
                };
                purchaseList.sort(comparator);
                for (Purchase p : purchaseList)
                {
                    System.out.println(p + " (cost: " +
                            (Double.parseDouble(p.price) * Double.parseDouble(p.purchased_quantity)) + ")");
                }
                break;
            }
        }

    }

    public void showPurchaseFor(String string)
    {
        System.out.println("Customer"+string);
        for (Purchase p : purchaseList)
        {
            if (p.customer_id.equals(string))
                System.out.println(p);
        }
    }
}
