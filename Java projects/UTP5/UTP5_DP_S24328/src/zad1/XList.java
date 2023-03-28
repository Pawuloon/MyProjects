package zad1;



import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;



public class XList<T> extends ArrayList<T>
{
    public XList(T...ts)
    {
        Collections.addAll(this,ts);
    }

    public XList(Collection<T>collection)
    {
        super(collection);
    }

    public static <L>XList<L> of(L...ls)
    {
        return new XList<L>(ls);
    }
    public static <K>XList<K> of(Collection<K>collection)
    {
        return new XList<>(collection);
    }

    public static XList<String> charsOf(String string)
    {
        return new XList<>(string.split(""));
    }

    public static XList<String> tokensOf(String...string)
    {
        String word = "";
        String separator = "";
        try
        {
            for (int i = 0; i < string.length; i++)
            {
                word = string[0];
                separator = string[1];
            }
        }catch (Exception exception)
        {}
        if (separator.equals(""))
            return XList.of(word.split(" "));
        else
         return XList.of(word.split(separator));
    }

    @SafeVarargs
    public final XList<T> union(T... t)
    {
        return this.union(XList.of(t));
    }

    public XList<T>union(Collection<T>collection)
    {
        XList<T>xList = new XList<>(this);
        xList.addAll(collection);
        return xList;
    }

    public XList<T> diff(Collection<T>collection)
    {
        XList<T>xList = new XList<>();
        for (T t  : this)
        {
            if (!collection.contains(t))
                xList.add(t);
        }
        return xList;
    }


    public XList<T> unique()
    {
        Set<T>set = new LinkedHashSet<>(this);
        return new XList<>(set);
    }


    public XList<XList<String>> combine()
    {
        XList<XList<String>> lists = new XList<>();
        for (T t : this)
        {
            Iterator<String>iterator = ((Collection)t).iterator();
            if (lists.isEmpty())
            {
                while (iterator.hasNext())
                {
                    lists.add(new XList<>(iterator.next()));
                }
            }
            else
            {
                XList<XList<String>> temporal = new XList<>();
                while (iterator.hasNext())
                {
                    String newItem = iterator.next();

                    for (Object ob : lists)
                    {
                        XList<T> item = new XList<>();
                        item.addAll((XList)ob);
                        item.add((T)newItem);

                        temporal.add((XList<String>)item);
                    }
                }
                lists = temporal;
            }
        }
        return lists;
    }

    public <K>XList<K> collect(Function<T,K> function)
    {
        XList<K>xList = new XList<>();
        for (T t : this)
        {
            xList.add(function.apply(t));
        }
        return xList;

    }

    public String join(String string)
    {
        return this.stream().map(Object::toString).collect(Collectors.joining(string));
    }
    public String join()
    {
        StringBuilder builder = new StringBuilder();
        this.stream().map(builder::append).collect(Collectors.toList());
        return (builder).toString();
    }

    public void forEachWithIndex(BiConsumer<T,Integer> consumer)
    {
        for (int i = 0; i < this.size(); i++)
        {
            consumer.accept(this.get(i),i);
        }
    }
}
