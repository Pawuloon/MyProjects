package zad1;

import java.util.*;



public class Main
{
    public Main()
    {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12); /*<-- here you should initialize elements of the first list */
        System.out.println(test1(src1));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");/*<-- here you should initialize elements of the second list */
        System.out.println(test2(src2));
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = new Selector<Integer>()
        {
            @Override
            public boolean select(Integer integer)
            {
                boolean isBigger = false;
                for (int a : src)
                {
                    if (a < 10)
                    {
                        isBigger = true;
                        break;
                    }
                }
                return isBigger;
            }
        };
        /*<-- definition of selector; lambda-expressions are not allowed; variable name sel */
        Mapper<Integer,Integer> map = new Mapper<Integer,Integer>()
        {
            @Override
            public List<Integer> map(Integer integer)
            {
                List<Integer>list1 = new ArrayList<>();
                    for (int a : src)
                    {
                        if (a < 10)
                            list1.add(a + 10);
                    }
                    return list1;
            }
        };
        /*<-- definition of mapper; lambda-expressions are not allowed; variable name map */

        return ListCreator.collectFrom(src).when(sel).mapEvery(map);

        /*<-- return of the result
      which is obtained by invocation of static method of ListCreator class:
     */
    }

    public List<Integer> test2(List<String> src) {
        Selector<Integer> sel = new Selector<Integer>()
        {
            @Override
            public boolean select(Integer integer)
            {
                boolean isBigger = false;
                for ( String a : src)
                {
                    if (a.length() > 3)
                    {
                        isBigger = true;
                        break;
                    }
                }
                return isBigger;
            }
        }; /*<-- definition of selector; lambda-expressions are not allowed; variable name sel */
        Mapper<Integer,String> map = new Mapper<Integer,String>()
        {
            @Override
            public List<Integer> map(String s)
            {
                List<Integer>list1 = new ArrayList<>();
                    for (String a : src)
                    {
                        if (a.length() > 3)
                             list1.add(a.length() + 10);

                    }
                    return list1;
            }
        }; /*<-- definition of mapper; lambda-expressions are not allowed; variable name map */



        return ListCreator.collectFrom(src).when(sel).mapEvery(map); /*<-- return of the result
      which is obtained by invocation of static method of ListCreator class:
     */
    }

    public static void main(String[] args)
    {
        new Main();
    }

}
