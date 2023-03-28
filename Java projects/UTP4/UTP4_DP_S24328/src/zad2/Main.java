/**
 *
 *  @author Dembicki Paweł S24328
 *
 */

package zad2;

public class Main
{
    public static void test() {
        // A method of(...)
        String s = "aaa";
        Maybe<String> m1 = Maybe.of(s);
        System.out.println(m1);
        s = null;
        Maybe<String> m2 = Maybe.of(s);
        System.out.println(m2);

        // A method ifPresent(...)
        Integer num = null;
        Maybe<Integer> m4 = Maybe.of(num);
        // INSTEAD OF
        if (num != null) System.out.println(num);
        // WE SHOULD WRITE
        m4.ifPresent(n -> System.out.println(n));
        // AND EVEN
        m4.ifPresent(System.out::println);

        Maybe<Integer> m5 = Maybe.of(10);
        m5.ifPresent(System.out::println);

        // A method map()
        Maybe<Integer> m6 = m5.map( n -> n +10 );
        System.out.println(m6);

        // A method get()
        System.out.println(m6.get());
        try {
            System.out.println(m4.get());
        } catch(Exception exc) {
            System.out.println(exc);
        }

        // A method orElse()
        // INSTEAD OF
        String snum = null;
        if (num != null) snum = "The value is: " + num;
        if (snum != null) System.out.println(snum);
        else System.out.println("The value is not available");

        //YOU CAN WRITE
        String res = Maybe.of(num).map(n -> "The value is: "+n)
                .orElse("The value is not available");
        System.out.println(res);

        // And filter(...)

        String txt = "Dog";
        String msg = "";

        //INSTEAD OF
        if (txt != null && txt.length() > 0) {
            msg = txt;
        } else {
            msg = "Txt is null or empty";
        }

        //YOU CAN WRITE
        msg = Maybe.of(txt)
                .filter(t -> t.length() > 0)
                .orElse("Txt is null or empty");
        System.out.println(msg);
    }

    public static void main(String[] args) {
        test();
    }
}

