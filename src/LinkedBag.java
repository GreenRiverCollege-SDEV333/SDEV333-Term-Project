import java.util.Iterator;

public class LinkedBag<E> implements Bag<E>
{
    private Node first; // first node in list
    private int size;   // just to remove the error for isEmpty and size methods

    public LinkedBag()
    {
        size = 0;
    }

    private class Node
    {
        E item;
        Node next;
    }

    public void add(E item)
    {   // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    public Iterator<E> iterator()
    {
        return new LinkedBagIterator();
    }
    private class LinkedBagIterator implements Iterator<E>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {

        }

        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
