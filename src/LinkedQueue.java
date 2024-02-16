import java.util.Iterator;

/**
 * LinkedQueue is an implementation of the Queue interface that
 * uses a linked list to store the elements.
 *
 * @author Braedon Billingsley
 * @param <E> the class / data type of the items in the queue
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int size; // number of items on the queue

    /**
     * Constructs an empty LinkedQueue.
     */
    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }
    private class Node { // nested class to define nodes
        E item;
        Node next;
    }

    /**
     * Add an item into the LinkedQueue.
     * The worst case time complexity of this method is O(1).
     *
     * @param item  item to add into the queue.
     */
    @Override
    public void enqueue(E item) {
        Node oldLast = last; // Add item to the end of the list.

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    /**
     * Removes an item from the LinkedQueue.
     * The worst case time complexity of this method is O(1).
     *
     * @return the item that was removed.
     */
    @Override
    public E dequeue() {
        E item = first.item; // Remove item from the beginning of the list.
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    /**
     * Checks if the LinkedQueue is empty.
     * The worst case time complexity of this method is O(1).
     *
     * @return true if LinkedQueue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null; // Or: N == 0.
    }

    /**
     * Returns the size of the LinkedQueue.
     * The worst case time complexity of this method is O(1).
     *
     * @return size of the LinkedQueue.
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
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E> {
        private Node current = first;

        /**
         * Checks if there are more elements in the LinkedQueue.
         * The worst case time complexity of this method is O(1).
         *
         * @return true if there are more elements, false otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the LinkedQueue.
         * The worst case time complexity of this method is O(1).
         *
         * @return the next element in the LinkedQueue.
         */
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
