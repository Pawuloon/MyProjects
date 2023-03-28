package zad1;

import java.util.List;

public class ListCreator<L,K>
{
    K usage;
    Selector<L> selector;

    public ListCreator(List<L> list)
    {
    }

    public static <L>ListCreator collectFrom(List<L> list)
    {
        return new ListCreator(list);
    }
    public ListCreator<L,K> when(Selector<L> selector)
    {
        this.selector = selector;
        return this;
    }
    public List<L> mapEvery(Mapper<L,K> mapper)
    {
        return mapper.map(usage);
    }

}
