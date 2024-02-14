import java.util.Iterator;

public class LinkedBag<E> implements Bag<E> {
    private Node first; // first node in list
    private int size; // size
    private class Node
    {
        E item;
        Node next;
    }
    /**
     * Add an item
     *
     * @param item the item to be added
     */
    @Override
    public void add(E item) {
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    /**
     * Checks to see if the bad is empty
     *
     * @return true of the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the bag.
     *
     * @return the number of items in the bag
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    { return new ListIterator(); }
    private class ListIterator implements Iterator<E>
    {
        private Node current = first;
        public boolean hasNext()
        { return current != null; }
        public void remove() { }
        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

}
