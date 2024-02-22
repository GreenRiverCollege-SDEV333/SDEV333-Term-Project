package interfaces;

/**
 * interfaces.Stack (LIFO: last-in, first-out) API
 * @param <E> class / data type of the items in the stack
 */
public interface Stack<E> extends Iterable<E> {
    /**
     * Add an item to the stack.
     * @param item the item to be added
     */
    void push(E item);

    /**
     * Removes the most recently added item from the stack.
     * @return the item that was removed
     */
    E pop();

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * @return item at the top of the stack.
     */
    E peek();

    /**
     * Checks to see if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the stack.
     * @return the number of items in the stack
     */
    int size();
}