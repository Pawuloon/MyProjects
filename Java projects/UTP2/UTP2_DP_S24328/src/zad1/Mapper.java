package zad1;

import java.util.List;

public interface Mapper<L,K>
{
    List<L> map(K k);
}
