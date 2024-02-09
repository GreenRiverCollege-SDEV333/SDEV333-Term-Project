package interfaces;

/**
 * interfaces.Deque: double-ended queue API
 * Supports adding and removing items at both ends.
 *
 * @param <E>
 */
public interface Deque<E> extends Iterable<E> {
    /**
     * Checks if the deque is empty.
     * @return true if the deque is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the deque.
     * @return number of items in the deque
     */
    int size();

    /**
     * Add an item to the left end of the deque.
     * @param item item to be added
     */
    void pushLeft(E item);

    /**
     * Add an item to the right end of the deque.
     * @param item
     */
    void pushRight(E item);

    /**
     * Remove an item from the left end of the deque.
     * @return
     */
    E popLeft();

    /**
     * Remove an item from the right end of the deque.
     * @return
     */
    E popRight();
}