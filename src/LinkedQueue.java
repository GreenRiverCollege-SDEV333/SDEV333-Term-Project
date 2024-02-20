import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedQueue represents a queue data structure implemented using a linked list.
 *
 * @param <E> the type of elements stored in the stack
 * @author Noah Lanctot
 * @version 1.0
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    /**
     * Adds an item to the end of the queue.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @param item the item to enqueue
     */
    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    /**
     * Removes and returns the item least recently added to this queue.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the item least recently added
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * Checks whether the queue is empty.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the queue.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to traverse the items in the queue.
     *
     * @return an iterator to traverse the items in the queue
     */
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}