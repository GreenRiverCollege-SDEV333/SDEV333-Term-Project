import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack (LIFO: last-in, first-out) API
 *
 * @author Braedon Billingsley
 * @param <E> the class / data type of the items in the stack
 */
public class ResizingArrayStack<E> implements Stack<E> {

    private E[] buffer;
    private int size;

    /**
     * A stack implementation using a resizing array.
     * This stack follows the LIFO (last-in, first-out) principle.
     */
    public ResizingArrayStack() {
        buffer = (E[]) new Object[1];
        size = 0;
    }

    private void resize(int max)
    { // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Adds an item to the top of the stack.
     * The worst case time complexity of this method is O(n) when resizing is needed,
     * but the average case time complexity is O(1) due to array doubling.
     *
     * @param item  item to be added to the stack.
     */
    @Override
    public void push(E item) { // Add item to top of stack.
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Pop an item from the top of the stack.
     * The worst case time complexity of this method is O(n) when resizing is needed,
     * but the average case time complexity is O(1) due to array halving.
     *
     * @return the popped item from the stack.
     */
    @Override
    public E pop() { // Remove item from top of stack.
        size--;
        E item = buffer[size];
        buffer[size] = null; // Avoid loitering (see text).
        if (size > 0 && size == buffer.length / 4) {
            resize(buffer.length / 2);
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * The worst case time complexity of this method is O(1).
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (isEmpty()) { // check if empty
            throw new NoSuchElementException("Stack is empty");
        }
        return buffer[size - 1]; // return top item in stack
    }

    /**
     * Checks if the stack is empty.
     * The worst case time complexity of this method is O(1).
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the stack.
     * The worst case time complexity of this method is O(1).
     *
     * @return the size of the stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the stack.
     * The worst case time complexity of this method is O(1).
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E>
    { // Support LIFO iteration.
        private int i = size;

        /**
         * Check if there are more items in the stack to iterate over.
         * The worst case time complexity of this method is O(1).
         *
         * @return true if there are more items, false otherwise.
         */
        public boolean hasNext() { 
            return i > 0; 
        }

        /**
         * Returns the next item in the stack iteration.
         * The worst case time complexity of this method is O(1).
         *
         * @return the next item in the stack iteration.
         */
        public E next() {
            i--;
            return buffer[i];
        }
    }
}
