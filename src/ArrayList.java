import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    /**
     * An array used to store items placed within the ArrayList
     */
    private E[] buffer;

    /**
     * The number of items stored within buffer
     */
    private int size;

    /**
     * Constructs an ArrayList with an empty buffer, and a default max capacity of 10 items
     */
    public ArrayList() {
        // setup buffer with default max capacity of 10
        buffer = (E[]) new Object[10];

        // no items are stored in buffer
        size = 0;
    }

    /**
     * If all slots in buffer are full, double its max capacity
     */
    private void doubleMaxCapacity() {
        // if all buffer slots are filled
        if(size == buffer.length) {
            // create a new buffer, with double the capacity of the existing buffer
            E[] newBuffer = (E[]) new Object[size * 2];

            // run through previous buffer and copy over all items
            for(int i = 0; i < buffer.length; i++) {
                newBuffer[i] = buffer[i];
            }

            // replace buffer with newBuffer, now with double the length
            buffer = newBuffer;
        }
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        // if the buffer already contains items
        if(!isEmpty()) {
            // if the buffer is full, increase max capacity
            doubleMaxCapacity();

            // run through buffer backwards
            for (int i = size; i > 0; i--) {
                // get item at previous index and place in current index,
                // thereby shifting all items to the left
                buffer[i] = buffer[i - 1];
            }
        }

        // add the given item at the now cleared index 0
        buffer[0] = item;

        // a new item has been added to buffer
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        // if the buffer is full, increase max capacity
        doubleMaxCapacity();

        // add the given item at final index
        buffer[size] = item;

        // a new item has been added to buffer
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if the buffer is full, increase max capacity
        doubleMaxCapacity();

        // run through buffer backwards, up to given index
        for (int i = size; i > index; i--) {
            // get item at previous index and place in current index,
            // thereby shifting all items to the right
            buffer[i] = buffer[i - 1];
        }

        // add the given item at current index
        buffer[index] = item;

        // a new item has been added to buffer
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if buffer contains no items, one cannot be retrieved
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve item from empty ArrayList");
        }

        return buffer[index];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // place the given item at the requested index
        buffer[index] = item;

        // if the buffer is regarded as empty, account for new item placed at index 0
        if(isEmpty()) {
            size++;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        // if buffer contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty ArrayList");
        }

        // get requested item prior to removal
        E requestedItem = buffer[0];

        // run through buffer
        for(int i = 0; i < size; i++) {
            // replace item at current index with item at next index
            buffer[i] = buffer[i + 1];
        }

        // account for removal of item
        size--;

        return requestedItem;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        // if buffer contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty ArrayList");
        }

        // get requested item prior to removal, accounting for index
        E requestedItem = buffer[size - 1];

        // clear the final item in buffer
        buffer[size - 1] = null;

        // account for removal of item
        size--;

        return requestedItem;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        // if buffer contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty ArrayList");
        }

        // find item in buffer and get its index
        int index = indexOf(item);

        // if item is not in buffer
        if(index == -1) {
            throw new NoSuchElementException("Given item is not located in ArrayList");
        }

        // otherwise, run through buffer, starting at given index
        // and accounting for removal of requested item
        for(int i = index; i <= size - 1; i++) {
            // replace item at current index with item at next index
            buffer[i] = buffer[i + 1];
        }

        // account for removal of item
        size--;
    }

    /**
     * Gets and returns the index of the given item in buffer, if exists
     * @param item the item being searched for in buffer
     * @return the index of given item in buffer if exists; otherwise -1
     */
    private int indexOf(E item) {
        // run through buffer
        for(int i = 0; i < buffer.length; i++) {
            // check if item stored at current index is the specified item
            if(item.equals(buffer[i])) {
                // return the current index, as that is where the specified item is located
                return i;
            }
        }

        // if the item does not exist in buffer
        return -1;
    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if buffer contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty ArrayList");
        }

        // get requested item prior to removal
        E requestedItem = buffer[index];

        // run through buffer, starting at given index
        // and accounting for removal of requested item
        for(int i = index; i <= size - 1; i++) {
            // replace item at current index with item at next index
            buffer[i] = buffer[i + 1];
        }

        // account for removal of item
        size--;

        return requestedItem;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        // run through buffer
        for (int i = 0; i < size; i++) {
            // check if item at current index of buffer is given item
            if(item.equals(buffer[i])) {
                // item was located
                return true;
            }
        }

        // item could not be found
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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

    /**
     * Implementation of an Iterator for the ArrayIntList class
     */
    private class ArrayListIterator implements Iterator<E> {
        /**
         * The current index being tracked by the Iterator
         */
        private int index;

        /**
         * Constructs an ArrayIntList iterator with the index initialized to 0
         */
        ArrayListIterator() {
            index = 0;
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
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get the item at current index of buffer
            E currItem = buffer[index];

            // move on to next element
            index++;

            return currItem;
        }
    }
}