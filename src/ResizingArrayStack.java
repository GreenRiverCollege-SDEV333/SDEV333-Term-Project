/*
 * SDEV333 Best class :D
 * Ming Li
 */

import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E> {
    private int size;
    private E[] buffer;

    public ResizingArrayStack() {
        // initialize my fieldss
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        // Add item to top of stack.
        if (size == buffer.length) resize(2*buffer.length);
        buffer[size++] = item;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        // Remove item from top of stack.
        E item = buffer[--size];
        buffer[size] = null; // Avoid loitering (see text).
        if (size > 0 && size == buffer.length/4) resize(buffer.length/2);
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return buffer[0];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
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

    private void resize(int max)
    { // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++)
            temp[i] = buffer[i];
        buffer = temp;
    }

    private class ReverseArrayIterator implements Iterator<E>
    { // Support LIFO iteration.
        private int i = size;
        public boolean hasNext() { return i > 0; }
        public E next() { return buffer[--i]; }
        public void remove() { }
    }
}
