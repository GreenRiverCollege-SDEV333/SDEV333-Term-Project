package APIs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {
    /**
     * An array used to store items placed within the ResizingArrayStack
     */
    private E[] buffer;

    /**
     * The number of items stored within buffer
     */
    private int size;

    /**
     * Constructs a ResizingArrayStack with an empty buffer,
     * and a default max capacity of 10 items
     */
    public ResizingArrayStack() {
        // setup buffer with default max capacity of 10
        buffer = (E[]) new Object[10];

        // buffer starts off empty
        size = 0;
    }

    /**
     * Resize the buffer by updating its max capacity by given number
     * @param maxCapacity the new max capacity of buffer
     */
    private void resizeBuffer(int maxCapacity) {
        // create a new buffer, with the given max capacity
        E[] newBuffer = (E[]) new Object[maxCapacity];

        // run through current buffer and copy over all items
        for(int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        // override existing buffer with the newly created one,
        // now with the requested max capacity
        buffer = newBuffer;
    }

    /**
     * Add an item to the stack.
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
     * @return the item that was removed
     */
    @Override
    public E pop() {
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
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        // if buffer contains no items, one cannot be retrieved
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve item from empty ResizingArrayStack");
        }

        // get and return end/top item in buffer
        return buffer[size - 1];
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
        return null;
    }
}
