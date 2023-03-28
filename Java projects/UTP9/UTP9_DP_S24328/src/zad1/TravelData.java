package zad1;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TravelData
{
    private final File file;
    private final List<String>countryDeparture = new ArrayList<>();
    private final List<String>dateRet = new ArrayList<>();
    private final List<String>dateP = new ArrayList<>();
    private final List<String>place = new ArrayList<>();
    private final List<String>price = new ArrayList<>();
    private final List<String>priceCurrency = new ArrayList<>();
    private final List<List<String>> content = new ArrayList<>();

    public TravelData(File file)
    {
        this.file = file;

        List<String> location = new ArrayList<>();
        try
        {
            Scanner scanner;
            List<Path> pathList = Files.walk(this.file.toPath()).filter(Files::isRegularFile).collect(Collectors.toList());
            for (Path path : pathList)
            {
                List<String>list = new ArrayList<>();
                File file1 = new File(path.toUri());
                scanner = new Scanner(file1);
                while (scanner.hasNext())
                {
                    list.add(scanner.next());
                }
                content.add(list);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        for (List<String>list : content)
        {
            location.add(list.get(0));
            countryDeparture.add(list.get(1));
            dateRet.add(list.get(2));
            dateP.add(list.get(3));
            place.add(list.get(4));
            price.add(list.get(5));
            priceCurrency.add(list.get(6));
        }
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat)
    {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < dateP.size(); i++)
        {
            result.add(countryDeparture.get(i) + " " + dateRet.get(i) + " " + dateP.get(i) + " "
                    + place.get(i) + " " + price.get(i) + " " + priceCurrency.get(i));
        }
        Locale locale1 = new Locale(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("messages",locale1);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        dateFormat1.applyPattern(dateFormat);
        List<String>last = new ArrayList<>();
        for (int i = 0; i < result.size(); i++)
        {
            StringBuilder add = new StringBuilder(("label"));
                if (countryDeparture.get(i).startsWith("W") || countryDeparture.get(i).startsWith("I"))
                    add.append(1);
                if (countryDeparture.get(i).startsWith("U") || countryDeparture.get(i).startsWith("S"))
                    add.append(2);
                if (countryDeparture.get(i).startsWith("N"))
                    add.append(3);
                last.add(bundle.getString(String.valueOf(add)));
        }
        return last;
    }

    public List<String> getDateRet() {
        return dateRet;
    }

    public List<String> getDateP() {
        return dateP;
    }

    public List<String> getPlace() {
        return place;
    }

    public List<String> getPrice() {
        return price;
    }

    public List<String> getPriceCurrency() {
        return priceCurrency;
    }

    public List<List<String>> getContent()
    {
        return content;
    }

    public List<String> getCountryDeparture()
    {
        return countryDeparture;
    }
}
