import java.util.Iterator;


/**
 * LinkedBag represents a bag data structure implemented using a linked list.
 *
 * @author Braedon Billingsley
 * @param <E> the type of elements in the bag.
 */
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

    /**
     * Add an item into the LinkedBag.
     * The worst case time complexity of this method is O(1).
     *
     * @param item  item to add.
     */
    @Override
    public void add(E item) {
        Node oldFirst = first; // same as push() in Stack
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++; // increment size by 1
    }

    /**
     * Checks if the LinkedBag is empty.
     * The worst case time complexity of this method is O(1).
     *
     * @return true if LinkedBag is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null; // Or: N == 0.
    }

    /**
     * Returns the size of the LinkedBag.
     * The worst case time complexity of this method is O(1).
     *
     * @return size of the LinkedBag.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over a set of elements of type {@code E}.
     * The worst case time complexity of this method is O(1).
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
