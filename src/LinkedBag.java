import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * implement all the methods in the Queue <E> interface
 *
 *  Bag- Linked-list implementation
 * @author Kayley Young
 */
public class LinkedBag<E> implements Bag<E> {
    private Node head; //first node in list
    private int size; //number of items in bag
    private class Node{
        E data;
        Node next;
        public Node(E data ){
            this.data = data;
        }
    }
    /**
     * constructor for LinkedBag initializes fields
     *
     *  O(1) because initializing fields  take constant time.
     *
     */
    public LinkedBag(){
        head = null;
        size = 0;

    }
    /**
     * Add an item to the bag
     *
     *  O(1) because regardless of the size of the linkedBag,
     * all actions take constant time.
     *
     * @param item (the item to be added)
     */
    @Override
    public void add(E item) {
      Node theNewOne = new Node(item);

        if (head == null) {
            //the list is currently empty
            head = theNewOne;
            size++;
        } else {
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
            size++;
        }
    }

    /**
     * Checks if the bag is empty or not
     *  O(1) because it's only a single comparison
     * to check if the size variable is equal to 0.
     *
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the bag
     * O(1) because it's only a single comparison
     * to check the size
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
     *  this method would be O(1) this is constant time complexity.
     * it creates a new instance of the LinkedBagIterator class and returns it.
     * this involves simple operations that do not depend on the size of the linkedBag.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedBagIterator();
    }

    private class LinkedBagIterator implements Iterator<E> {
        private Node current = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("there is no next one to go to");
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
