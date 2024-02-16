import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E> {

    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int size; // number of items on the queue

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
     * Add an item to the queue.
     *
     * @param item the item to be added
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
     * Remove an item from the queue.
     *
     * @return the item that was removed
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
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null; // Or: N == 0.
    }

    /**
     * Returns a count of the number of items in the queue.
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
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
