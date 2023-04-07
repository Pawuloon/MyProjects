package Task3;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main
{
    public static Map<String, List<Purchase>> read()
    {
        var map = new HashMap<String,List<Purchase>>();
        try
        {
            var file = new File("file.txt");
            var scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
               String[] strings = scanner.nextLine().split(" ");
               var purch = new Purchase(strings[0],strings[1], Integer.parseInt(strings[2]));
               if (map.containsKey(strings[0]))
               {
                   var list = map.get(strings[0]);
                   list.add(purch);
               }
               else
               {
                   var list = new ArrayList<Purchase>();
                   list.add(purch);
                   map.put(strings[0], list);
               }

            }
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return map;
    }

    public static void writeToFile(Map<String,List<Purchase>> map)
    {
        File file = new File("summary.txt");
        try
        {
            var writer = new FileWriter(file);
            for (var record : map.entrySet())
            {
                var customName = record.getKey();
                var products = new HashSet<String>();
                var purchases = record.getValue();
                var numberOfPurchase = 0;
                var total = 0;
                for (var purchase : purchases)
                {
                    products.add(purchase.getProductName());
                    total += purchase.getPrice();
                }
                var numOfUnique = products.size();
                writer.write(customName + " " + numberOfPurchase + " " + numOfUnique + " " + total +  '\n');
            }
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
       writeToFile(read());
    }
}

