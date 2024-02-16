import java.util.Iterator;

public class LinkedBag<E> implements Bag<E> {
    private Node first; // first node in list
    private int size; // track Nodes in bag

    public LinkedBag() {
        first = null;
        size = 0;
    }

    private class Node
    {
        E item;
        Node next;
    }

    @Override
    public void add(E item) {
        Node oldFirst = first; // same as push() in Stack
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++; // increment size by 1
    }

    @Override
    public boolean isEmpty() {
        return first == null; // Or: N == 0.
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator()
    { return new ListIterator(); }
    private class ListIterator implements Iterator<E>
    {
        private Node current = first;
        public boolean hasNext() {
            return current != null; }
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
