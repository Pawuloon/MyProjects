package Task1;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String[] arr = {
                "salon A", "Mercedes","130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"};


        var set = new HashSet<String>();
        var map = new HashMap<String, List<Car>>();
        for (int i = 1, j = 2, k = 0; i < arr.length && j < arr.length && k < arr.length; i+=3, j+=3, k+=3)
        {
           var car = new Car(arr[i],Integer.parseInt(arr[j]));
           if(map.containsKey(arr[k]))
           {
               var list = map.get(arr[k]);
               list.add(car);
           }
           else
           {
                var list = new ArrayList<Car>();
                list.add(car);
                map.put(arr[k], list);
           }

        }
        System.out.println(map);

        Car leastExpensiveCar = null;
        String leastExpensiveSalon = null;
        int leastExpensivePrice = 0;

        for (List<Car> carList : map.values())
        {
            for (Car car : carList) {
                if (leastExpensiveCar == null  || car.getPrice() < leastExpensivePrice) {
                    leastExpensivePrice = car.getPrice();
                    leastExpensiveCar = car;
                    leastExpensiveSalon = car.getName();
                }
            }
        }

        assert leastExpensiveCar != null;
        System.out.println(leastExpensiveCar.getName() + " in salon " + leastExpensiveSalon + " for " + leastExpensivePrice );
    }
}
