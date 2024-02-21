import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E>
{
    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int size;   // number of items on the queue

    private class Node
    {   // nested class to define nodes
        E item;
        Node next;
    }

    @Override
    public void enqueue(E item)
    {
    }

    @Override
    public E dequeue()
    {   // remove item from the beginning of the list
        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty())
        {
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty()
    {
        return first == null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E>
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
