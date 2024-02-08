import java.util.Iterator;
/**
 *  * Implementation of the LinkedBag<E> using the Bag<E> interface. This is my term assignment 2 Bag.
 * @author Rob Smith
 * @version 1.0
 * @param <E> class / data type of the items in the LinkedBag
 */
public class LinkedBag<E> implements Bag<E>{
    private Node head;
    private int size;

    private class Node{
        E data;
        Node next;
    }

    /**
     * Constructor for the linkedBay class.
     */
    public LinkedBag(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds the specified object to the front of the bag.
     * Runtime of this is O(1). It always takes the same amount of time to add a node to the front of a linked list
     * because there is no looping to shift like in an array.
     * @param item the item to be added
     */
    public void add(E item){
        Node newNode = new Node();
        newNode.data = item;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        this.size++;
    }

    /**
     * Checks if the bag is empty.
     * Runtime of this is O(1). It's simply returning a single boolean with no loops.
     * @return true if the LinkedBag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks the size of the bag.
     * Runtime of this is O(1). It's simply returning a single int with no loops.
     * @return the size of the LinkedBag
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
    public Iterator<E> iterator() {
        return new LinkedBagIterator();
    }

    private class LinkedBagIterator implements Iterator<E>{
        Node current = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * Runtime is O(1) because there is no looping involved it is just checking where in the bag the
         * iterator is currently located.
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        /**
         * Returns the next element in the iteration.
         * Runtime for this is O(1) because it's only accessing a single point of data not looping through the
         * bag in its entirety.
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E value = current.data;
            current = current.next;
            return value;
        }
    }
}
