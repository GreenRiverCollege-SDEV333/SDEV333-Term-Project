import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a stack using a resizing array.
 *
 * @param <E> the type of elements stored in the stack
 * @author Noah Lanctot
 * @version 1.0
 */
public class ResizingArrayStack<E> implements Stack<E> {
    private E[] array;
    private int size;

    /**
     * Initializes an empty stack with an initial capacity of 10.
     */
    public ResizingArrayStack() {
        array = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Resizes the array to the given capacity.
     *
     * @param capacity the new capacity of the array
     */
    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Adds an item to the top of the stack.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = item;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the item most recently added
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        E item = array[--size];
        array[size] = null;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    /**
     * Returns the item most recently added to this stack without removing it.
     * Time complexity: O(1)
     *
     * @return the item most recently added
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return array[size - 1];
    }

    /**
     * Checks whether the stack is empty.
     * Time complexity: O(1)
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the stack.
     * Time complexity: O(1)
     *
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to traverse the items in the stack.
     *
     * @return an iterator to traverse the items in the stack
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[index--];
        }
    }
}