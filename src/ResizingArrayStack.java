/**
 * Resizing Array Stack
 *
 * This stack uses a built in array to store its data.
 *
 * @author R.J. Trenchard
 * @date 2/15/2024
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_BUFFER = 10;
    private static final double MAX_CAPACITY = 0.75;

    private static final double MIN_CAPACITY = 0.5;

    private E[] stack;
    private int size;

    public ResizingArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_BUFFER];
        this.size = 0;
    }

    // for testing
    protected int getArraySize() {
        return stack.length;
    }

    // resizes the array when capacity is overfull or underfull
    private void autoResize() {
        double capacity = this.size() / (double)stack.length;

        // grow when we reach max capacity
        if (capacity > MAX_CAPACITY) {
            grow();
        }

        // shrink if we're below the min capacity, but the default buffer must have a size.
        else if (capacity < MIN_CAPACITY && stack.length > DEFAULT_BUFFER) {
            shrink();
        }
    }

    private void grow() {
        // hold old data
        E[] buf = stack;
        int newLength = stack.length + DEFAULT_BUFFER;

        // create new array of a larger size
        stack = (E[]) new Object[newLength];

        this.copy(buf, stack);
    }

    private void shrink() {
        // hold old data
        E[] buf = stack;
        int newLength = stack.length - DEFAULT_BUFFER;

        // don't try if the new length is too small
        if (newLength < DEFAULT_BUFFER) {
            return;
        }

        // create new array of a smaller size
        stack = (E[]) new Object[newLength];

        this.copy(buf, stack);
    }

    // O(n), linear copy.
    private void copy(E[] from, E[] to) {
        // copy old data to new array
        int shortest = (to.length < from.length) ? to.length : from.length;
        for (int i = 0; i < shortest; i++) {
            to[i] = from[i];
        }
    }

    /**
     * Add an item to the stack.
     *
     * O(n) - if the buffer is full, we need to copy the whole stack
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        autoResize();
        
        // add item, grow size
        stack[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * O(n) - if the buffer is too large, need to copy array
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        autoResize();
        
        // grab data and lower size
        E data = stack[size-1];
        size--;
        return data;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * O(1) - access to peek is instant
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack[size-1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * O(1) - instant access
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
     * O(1) - access to size is instant
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
     * O(n) - always n elements unless you break early.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int it = 0;

            E[] readonly = stack.clone();

            int readonly_size = size();


            @Override
            public boolean hasNext() {
                return it < readonly_size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = readonly[it];
                it++;
                return data;
            }
        };
    }
}
