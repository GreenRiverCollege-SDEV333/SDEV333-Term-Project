import java.util.Iterator;

public class LinkedBag<E> implements Bag<E> {
    private Node head;
    private int size;

    public LinkedBag()
    {
        head = null;
        size = 0;
    }
    private class Node
    {
        E item;
        Node next;
    }
    @Override
    public void add(E item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>
    {
        private Node current = head;
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
