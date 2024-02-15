package APIs;

import java.util.Iterator;

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
     * If all slots in buffer are full, increase its max capacity by given number
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
        // now with more max capacity
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
        // get the end/top item from stack
        E requestedItem = buffer[size];

        // clear that slot in buffer
        buffer[size] = null;

        // account for item being removed
        size--;

        // if the buffer is not empty, and running low on space
        if(size > 0 && size == buffer.length / 4) {
            // increase its size by half the current max
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
        return null;
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
