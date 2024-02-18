import java.util.Iterator;

public class LinkedBag<E> implements Bag<E> {
    private Node first;
    private int size;

    private class Node
    {
        E data;
        Node next;
    }

    /**
     * add an item to the bag
     * O(5) a few constants
     * @param item the item that will be added
     */
    @Override
    public void add(E item) {
        Node oldfirst = first;
        first = new Node();
        first.data = item;
        first.next = oldfirst;
        size++;
    }

    /**
     * check if the bag is empty
     * O(1) return statement only
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    /**
     * check the size of the bag
     * O(1) return statement only
     * @return the size as an int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>
    {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {}
        public E next() {
            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
