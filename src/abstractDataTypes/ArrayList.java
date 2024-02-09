package abstractDataTypes;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tobygoetz
 * @version 1.0
 * Generic ArrayList, to be used with any data type
 * @param <E> specifies data type to be used in ArrayList
 */
public class ArrayList<E> implements List<E> {

    private static final int CAPACITY = 10;

    // fields
    private E[] buffer;
    private int size;

    /**
     * Constructor for ArrayList
     */
    public ArrayList()
    {
        size = 0;
        buffer = (E[]) new Object[CAPACITY];
    }


    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(Object item)
    {
        //loop while index is greater than zero
        for (int i = size; i > 0; i--) {
            //if buffer is at capacity increase buffer by one index
            if (size == buffer.length) {
                this.resize();
            }
            //index at highest buffer gets shifted right
            buffer[i] = buffer[i - 1];
        }
        buffer[0] = (E) item;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        //if buffer is at capacity increase buffer by one index
        if ( size == buffer.length) {
            resize();
        }
        //add value to size which is one index greater than last value
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item)
    {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Specified Index Must Be " +
                    "In the Range of 0-" + size);
        } else {
            //loop while index is greater than index value specified
            for (int i = size; i >= index; i--) {
                //if buffer is at capacity increase buffer by one index
                if (size == buffer.length) {
                    this.resize();
                }
                //index at highest buffer gets shifted right
                if (i != 0) {
                    buffer[i] = buffer[i - 1];
                }
            }
        }
        buffer[index] = item;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index)
    {
        if (index < 0 ) {
            throw new IndexOutOfBoundsException(
                    "Index must be greater than 0");
        } else if (index >= size ) {
            if (size == 0) {
                throw new IndexOutOfBoundsException(
                        "This list is empty");
            } else {
                throw new IndexOutOfBoundsException(
                        "Specified Index Must Be " +
                                "In the Range of 0-" + (size - 1));
            }
        } return buffer[index];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Specified Index Must Be " +
                    "In the Range of 0-" + (size - 1));
        } else {
            buffer[index] = item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        if (!isEmpty()) {
            E removed = buffer[0];
            for (int i = 0; i <= size - 1; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
            return removed;
        } else {
            return null;
        }
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(Object item) {

    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(Object item) {
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && buffer[0] == null;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
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
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int index;

        private ArrayListIterator() { index = 0;}

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (index >= size) {
                throw new NoSuchElementException("Index is out of range");
            }

            E currentValue = buffer[index];
            index++;
            return currentValue;
        }
    }

    /**
     * Helper method to resize ArrayIntlist to support
     * more data
     */
    private void resize() {
        //create new space, separate from the old space (buffer)
        int newSize = size + CAPACITY;
        E[] newBuffer = (E[]) new Object[newSize];

        // copy everything over from buffer into newBuffer
        if (newSize > buffer.length) {
            for (int i = 0; i < buffer.length; i++) {
                newBuffer[i] = buffer[i];
            }
        } else {
            for (int i = 0; i < newBuffer.length; i++) {
                newBuffer[i] = buffer[i];
            }
        }

        // set the new space into buffer
        buffer = newBuffer;

        // the old space is no longer "pointed to" and will eventually
        // be cleaned up by the garbage collector
    }


    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", indices=" + Arrays.toString(buffer) +

                '}';
    }
}
