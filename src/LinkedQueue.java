import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * implement all the methods in the Queue <E> interface
 *
 * (LIFO) Queue - Linked-list implementation
 * @author Kayley Young
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node head; //link to least recently added node
    private Node tail; //link to last node added in the queue
    private int size; //number of items on the queue
    private int numModifications; //the number of modifications made to the queue

    private class Node {
        E item;
        Node next;

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    /**
     * constructor for LinkedQueue, initializes fields
     *
     *  O(1) because initializing fields  take constant time.
     *
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
        numModifications = 0;
    }
    /**
     * Add an item to the queue.
     *
     * this method runs in O(1) because with single operations the complexity class is constant.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }

        Node oldTail = tail;
        tail = new Node(item, null);

        if (isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }

        size++;
        numModifications++;

    }

    /**
     * Remove an item from the queue.
     *
     * This method runs in O(1) because with single operations the complexity class is constant.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E item = head.item;
        head = head.next;

        if (isEmpty()) {
            tail = null;
        }

        size--;
        numModifications++;

        return item;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * This method runs in O(1) because with single comparison operation the complexity class is constant.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * This method runs in O(1) because with single operations the complexity class is constant.
     *
     * @return the number of items in the queue
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
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current;
        private final int numModificationsAtCreation = numModifications;

        /**
         * Initializes the iterator by setting the current
         * position to be the same as the head (front) of
         * the list.
         */
        public LinkedListIterator() {
            current = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         * @throws ConcurrentModificationException if queue has been modified since this iterator was created
         */
        @Override
        public boolean hasNext() {
            if (numModifications != numModificationsAtCreation) {
                throw new ConcurrentModificationException("queue has changed!");
            }

            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         * @throws ConcurrentModificationException if the queue has been modified since this iterator was created
         */
        @Override
        public E next() {
            if (numModifications != numModificationsAtCreation) {
                throw new ConcurrentModificationException("queue has changed!");
            }

            if (current == null) {
                throw new NoSuchElementException("current is null!");
            }
            // save current.item so we can return it
            E item = current.item;
            // advance current to next node in list
            current = current.next;
            return item;
        }
    }
}
