import java.util.Iterator;

/**
 * Stack (LIFO: last-in, first-out) API for resizing array implementation
 * @author Rob Smith
 * @version 1.0
 * @param <E> class / data type of the items in the Stack
 */
public class ResizingArrayStack<E> implements Stack<E> {
    private E[] buffer;
    private int size;

    /**
     * Constructor for the ResizingArrayStack class.
     */
    public ResizingArrayStack() {
        this.size = 0;
        buffer = (E[]) new Object[10];
    }

    private void resize(int max) {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Add an item to the stack.
     * This method is a O(1) operation if a resize is not triggered because it doesn't loop through the array.
     * If resize is triggered it becomes O(n) because resize loops through the entire array to size it up.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * Runtime for this method is O(1) if a resize is not triggered because it doesn't loop through the array.
     * If resize is triggered it becomes O(n) because resize loops through the entire array.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        E value = buffer[size - 1];
        buffer[size - 1] = null;
        if (size > 0 && size == buffer.length / 4) {
            resize(buffer.length / 2);
        }
        size--;
        return value;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * The runtime for this method is O(1) because there is no looping, it simply retrieves an item.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        E value = buffer[size - 1];
        return value;
    }

    /**
     * Checks to see if the stack is empty.
     * Runtime of O(1), single check of variable with no looping.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * Runtime of O(1), single check of variable with no looping.
     *
     * @return the number of items in the stack
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
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        private int iterSize = size;

        public boolean hasNext() {
            return iterSize > 0;
        }

        public E next() {
            E value = buffer[iterSize - 1];
            iterSize--;
            return value;
        }

        /**
         * Unused method in this implementation.
         */
        public void remove() {
        }
    }
}
