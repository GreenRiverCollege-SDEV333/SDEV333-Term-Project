import java.util.Iterator;
/**
 *
 * implement all the methods in the Queue <E> interface
 *
 * (LIFO) Queue - Linked-list implementation
 * @author Kayley Young
 */
public class LinkedQueue<E> implements Queue<E> {
    /**
     * Add an item to the queue.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {

    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        return null;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
