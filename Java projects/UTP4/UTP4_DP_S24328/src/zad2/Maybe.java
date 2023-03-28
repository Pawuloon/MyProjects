package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T>
{
    T t;
    public Maybe(T t)
    {
        this.t = t;
    }

    public static <T>Maybe<T> of(T t)
    {

        return new <T>Maybe<T>(t);
    }
    @Override
    public String toString()
    {
        if (t != null)
            return "Maybe has value " + t;
        else
            return "Maybe is empty";
    }

    public T get()
    {
       if (t == null)
       {
            throw new NoSuchElementException(" maybe is empty");
       }
       else
           return t;
    }

    public <S>Maybe<S> map(Function<T,S> func)
    {
      try
      {
          return new Maybe<>(func.apply(get()));
      }catch (NoSuchElementException e)
      {
        return new Maybe<>(null);
      }
    }

    public void ifPresent(Consumer<T> cons)
    {
        if(t != null)
        {
            cons.accept(t);
        }
    }

    public Maybe<T>filter(Predicate<T> pred)
    {
       if (pred.test(t))
           return this;
       else
           return new Maybe<>(null);

    }

    public T orElse(T defVal)
    {
       if (Maybe.of(t).isPresent())
           return Maybe.of(t).get();
       else
           return defVal;
    }

    public boolean isPresent()
    {
        return t != null;
    }
}
