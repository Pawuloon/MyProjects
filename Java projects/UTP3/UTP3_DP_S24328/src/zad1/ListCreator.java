package zad1;

import java.util.List;
import java.util.function.UnaryOperator;


public class ListCreator<L,K>
{


    UnaryOperator<L> operator;
    List<L>list;
    public static <L,K>ListCreator<L,K> collectFrom(List<L> list)
    {
        ListCreator<L,K> creator = new ListCreator<>();
        creator.list = list;
        return creator;
    }
    public ListCreator<L,K> when(UnaryOperator<L> operator)
    {
        this.operator = operator;
        return this;
    }
    public List<L> mapEvery(UnaryOperator<List<L>> operator)
    {
        return operator.apply(list);
    }

}
