import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    public class Node {
        Node next;
        E data;
    }

    private Node head;
    private int size;

    /**
     * Add an item to the queue.
     * O(5) from a few constants
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        if (size == 0) {
            head = new Node();
            head.data = item;
            head.next = null;
        } else {
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    /**
     * Remove an item from the queue.
     * O(2n+c) a few iterations through the linked list (n) and a few constants (c)
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        Node finder = head;
        while (finder.next != null) {
            finder = finder.next;
        }
        Node finder2 = head;
        while (finder2.next != finder) {
            finder2 = finder.next;
        }
        finder2.next = null;
        size--;
        return finder.data;
    }

    /**
     * Checks to see if the queue is empty.
     * O(1) returning 1 variable
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    /**
     * Returns a count of the number of items in the queue.
     * O(1) returning 1 variable
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new LinkedQueueIterator();
    }
    private class LinkedQueueIterator implements Iterator<E> {

        private Node current;

        public LinkedQueueIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (current == null || current.next == null) {
                return false;
            }
            else {
                return true;
            }
        }
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!");
            }
            E dataValue = (E) current.data;
            current = current.next;
            return dataValue;
        }
    }
}
