import java.util.Iterator;

public class Backpack implements Iterable<Backpack.Node>
{


    public static class Node
   {
       private final Stuff stuff;
       private Node next;

       public Node(Stuff stuff)
       {
           this.stuff = stuff;
           this.next = null;
       }

       public Stuff getStuff()
       {
           return stuff;
       }
   }
   private Node head;

    public Backpack()
    {}

    public void add(Node node)
    {
        if (head == null)
            head = node;
        else
        {
            Node last = head;

            while(last.next != null)
                last = last.next;

            last.next = node;
        }
    }

    public void remove(Stuff data)
    {
        if (head == null)
            return;
        if (head.stuff == data)
        {
            head = head.next;
            return;
        }
        Node removal = head;
        while (removal.next != null && removal.next.stuff != data)
            removal = removal.next;
        if (removal.next != null)
        {
            removal.next = removal.next.next;
        }
    }

    public boolean contains(Stuff data)
    {
        Node contain = head;
        while (contain != null)
        {
            if (contain.stuff == data)
                return true;

            contain = contain.next;
        }
        return false;
    }


    public int size()
    {
        int counter = 0;
        Node count = head;
        while (count != null)
        {
            counter++;
            count = count.next;
        }
        return counter;
    }
    private static class BagIterator implements Iterator<Node>
    {

        Node curr;

        public BagIterator(Node curr)
        {
            this.curr = curr;
        }

        @Override
        public boolean hasNext()
        {
            return curr != null;
        }

        @Override
        public Node next()
        {
            Node node = curr;
            curr = curr.next;
            return node;
        }
    }
    @Override
    public Iterator<Node> iterator()
    {
       return new BagIterator(head);
    }

    public void print()
    {
        for (var a : this)
        {
            System.out.println(a.stuff + "\t");
        }
    }


}
