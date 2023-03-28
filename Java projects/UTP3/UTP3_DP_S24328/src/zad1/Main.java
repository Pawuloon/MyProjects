package zad1;


import java.util.*;

public class Main
{
    static List<String> getPricesInPLN(List<String> destinations, double xrate)
    {
        return ListCreator.collectFrom(destinations)
                .when((a)->
                        {
                            for (String b : destinations)
                            {
                                if (b.startsWith("WAW"))
                                {
                                    return b;
                                }
                            }
                            return "";
                        }


                        /*<-- lambda expression
                 *  selecting flights from Warsaw (starting with WAW)
                 */
                )
                .mapEvery((a)->
                        {
                            List<String>list = new ArrayList<>();
                            String separate;
                            String name, value;
                            StringBuilder builder = new StringBuilder();
                            int number = 0;
                            for (String b : destinations)
                            {


                                if (b.startsWith("WAW"))
                                {
                                    number = Integer.parseInt(b.replaceAll("[A-Za-z]","").trim());
                                    separate = String.valueOf((int)(number * xrate));
                                    value = b.replaceAll("-?\\d+",separate).replaceAll("[^0-9]","");
                                    name = b.substring(3).trim().replaceAll("-?\\d+","");
                                    b = String.valueOf(builder.replace(0,27,"to " + name + "-price in PLN:  " + value));
                                    list.add(b);
                                }
                            }
                            return list;
                        } /*<-- lambda expression
                 *  calculating flight price in PLN
                 *  and creating the result string
                 */
                );
    }

    public static void main(String[] args)
    {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
        List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
        for (String r : result) System.out.println(r);
    }
}

