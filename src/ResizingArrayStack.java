import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Daniel Knoll
 * Resizing Stack Array that accepts any data type.
 */
public class ResizingArrayStack<E> implements Stack<E> {
    private E[] buffer;
    private int size;

    public ResizingArrayStack()
    {
        buffer = (E[]) new Object[10];
    }

    /**
     * Add an item to the stack.
     * slowest would be O(n*2) from having to resize
     * average should only be about O(2) from setting buffer at index + increment size
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if (size == buffer.length) {
            resize();
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Resize array to be twice as long as it currently is.
     * O(n) is slowest and also average from copying over the array
     */
    public void resize() {
        E[] newBuffer = (E[]) new Object[buffer.length * 2];
        for (int i = 0;i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }

    /**
     * Removes the most recently added item from the stack.
     * O(4) is slowest from affecting each variable
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(0);
        }
        E toReturn = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        return toReturn;


    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *  O(1) checking one variable
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return buffer[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     * O(1) returning 1 variable
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    /**
     * Returns a count of the number of items in the stack.
     *  O(1) returning 1 variable
     * @return the number of items in the stack
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
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<E> {
        private int i;

        public ResizingArrayIterator() {
            i = size;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            i--;
            return buffer[i];
        }
    }
}
