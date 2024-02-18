package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a Stack using an array and a Stack interface for generics
 * @param <E> Class may store various types of values
 * @author Zalman I.
 */
public class ResizingArrayStack<E> implements Stack<E> {
    /**
     * An array used to store items placed within the stack
     */
    private E[] buffer;

    /**
     * The number of items stored within buffer
     */
    private int size;

    /**
     * Constructs a ResizingArrayStack with an empty buffer,
     * and a default max capacity of 10 items
     *
     * Runtime: O(1) as it always takes the same runtime to conduct this operation
     */
    public ResizingArrayStack() {
        // setup buffer with default max capacity of 10
        buffer = (E[]) new Object[10];

        // buffer starts off empty
        size = 0;
    }

    /**
     * Resize the buffer by updating its max capacity by given number
     *
     * Runtime: O(n) as it has to run through the buffer to copy over all items into a new array,
     * therefore the runtime depends on the prior buffer's length
     *
     * @param maxCapacity the new max capacity of buffer
     */
    private void resizeBuffer(int maxCapacity) {
        // create a new buffer, with the given max capacity
        E[] newBuffer = (E[]) new Object[maxCapacity];

        // run through current buffer and copy over all items
        for(int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }

        // override existing buffer with the newly created one,
        // now with the requested max capacity
        buffer = newBuffer;
    }

    /**
     * Add an item to the stack.
     *
     * Runtime: O(1) if buffer is empty/not full, as we are only accessing the final index to add an item.
     * If the array is full O(n) as we need to run through buffer to copy over all items during resize.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        // if the buffer is full, double its max capacity
        if(size == buffer.length) {
            resizeBuffer(buffer.length * 2);
        }

        // add given item to "end/top" of buffer
        buffer[size] = item;

        // account for new item being added
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * Runtime: O(1) if buffer is not too large, as we are only accessing the final index to "pop off" an item.
     * Otherwise, O(n) as we need to run through buffer to copy over all items during resize.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        // if buffer contains no items, one cannot be retrieved
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve item from empty Stack");
        }

        // get the end/top item from stack, account for index
        E requestedItem = buffer[size - 1];

        // clear that slot in buffer
        buffer[size - 1] = null;

        // account for item being removed
        size--;

        // if the buffer is not empty, and too large
        if(size > 0 && size == buffer.length / 4) {
            // reduce its current max capacity by half
            resizeBuffer(buffer.length / 2);
        }

        return requestedItem;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * Runtime: O(1) as we can instantly access the final index to retrieve item.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        // if buffer contains no items, one cannot be retrieved
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve item from empty Stack");
        }

        // get and return end/top item in buffer
        return buffer[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * Runtime: O(1) as we are instantly accessing a variable and checking a condition.
     * This operation would always take the same runtime to conduct.
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
     * Runtime: O(1) as we are instantly retrieving a variable.
     * This operation would always take the same runtime to conduct.
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
        return new ReverseArrayStackIterator();
    }

    /**
     * Implementation of an Iterator for the ReverseArrayStack class
     */
    private class ReverseArrayStackIterator implements Iterator<E>
    {
        /**
         * The current number of items being tracked by iterator
         */
        private int trackedSize;

        /**
         * Constructs an ReverseArrayStackIterator iterator, with a tracker for buffer size
         */
        ReverseArrayStackIterator() {
            trackedSize = size;
        }

        /**
         * Checks if buffer has another element, and returns true/false accordingly
         * @return true if buffer has another element; otherwise false
         */
        public boolean hasNext() {
            return trackedSize > 0;
        }

        /**
         * Gets and returns the next/top item in the buffer
         * @return the next/top item in the buffer
         */
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get item at end/top of buffer
            E currItem = buffer[trackedSize];

            // move down to the next item
            trackedSize--;

            return currItem;
        }
    }
}
