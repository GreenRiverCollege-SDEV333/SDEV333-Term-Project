import java.util.Iterator;

public class LinkedStack<E> implements Stack<E>
{
    private Node first; // top of stack (most recently added node)
    private int size;

    private class Node
    {   // nested class to define nodes
        E item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return size;
    }

    public void push (E item)
    {   // add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public E pop()
    {   // remove item from top of stack
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public E peek()
    {
        return null;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E>
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
