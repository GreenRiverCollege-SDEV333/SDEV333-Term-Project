import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  * Implementation of the LinkedQueue<E> using the Queue<E> interface. This is my term assignment 2 FIFO Queue.
 * @author Rob Smith
 * @version 1.0
 * @param <E> class / data type of the items in the LinkedQueue
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node oldest;
    private Node newest;
    private int size;

    /**
     * Constructor for LinkedQueue class.
     */
    public LinkedQueue() {
        this.oldest = null;
        this.newest = null;
        this.size = 0;
    }

    private class Node {
        E data;
        Node next;
    }
    /**
     * Checks if the queue is empty.
     * Runtime of this is O(1). It's simply returning a single boolean with no loops.
     * @return true if the LinkedQueue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Checks the size of the list.
     * Runtime of this is O(1). It's simply returning a single int with no loops.
     * @return the size of the LinkedQueue
     */
    public int size() {
        return size;
    }

    /**
     * Adds the specified object to the front of the list.
     * Runtime of this is O(1). It always takes the same amount of time to add a node to the end of a linked list when
     * using a second pointer because we don't need to traverse the linked list to locate the end node.
     *
     * @param item the item to be added
     */
    public void enqueue(E item) {
        Node newNode = new Node();
        if (size == 0) {
            newest = newNode;
            oldest = newest;
        } else {
            newest.next = newNode;
            newest = newNode;
        }
        newNode.data = item;
        newest.next = null;
        size++;

    }

    /**
     * Dequeue removes the last element in the linked list and returns the value of the data inside it.
     * Runtime for this operation is O(1), removing the last element is a constant time operation regardless of the
     * size of the list since we're tracking it with a tail pointer.
     *
     * @return the data from the node removed from the list.
     */
    public E dequeue() {
        if (oldest == null) {
            throw new NoSuchElementException("The list is empty");
        } else {
            E result = oldest.data;
            oldest = oldest.next;
            size--;
            if (isEmpty()) {
                newest = null;
            }
            return result;
        }
    }
    /**
     * returns an object to iterate through the LinkedQueue.
     * Runtime is O(1) because it is merely instantiating an object with no looping.
     * @return an object to iterate through the LinkedQueue
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E> {

        private Node current = oldest;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * Runtime is O(1) because there is no looping involved it is just checking where int he LinkedQueue the
         * iterator is currently located.
         *
         * @return {@code true} if the current position is not the end of the list, aka, null.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * Runtime for this is O(1) because it's only accessing a single point of data not looping through the
         * LinkedQueue in its entirety.
         *
         * @return the next element in the iteration
         */
        public E next() {
            E value = current.data;
            current = current.next;
            return value;
        }
    }
}
