import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList <E> implements List<E>{

    public int size;
    public E[] buffer;

    public ArrayList() {
        size = 0;
        buffer = (E[]) new Object[10];
    }

    private void resize(int size) {
        E[] re = (E[]) new Object[size];
        System.arraycopy(buffer, 0, re, 0, buffer.length);
        buffer = re;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if (buffer.length == size) {
            resize(size * 2);
        }
        for (int i = size; i > 0; i--) {
            buffer[i] = buffer[i -1];
        }

        buffer[0] = item;
        size++;

    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if (buffer.length == size) {
            resize(size * 2);
        }

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
    public void add(int index, E item) {
        if (buffer.length == size) {
            resize(size * 2);
        }

        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];

        }

        buffer[index] = item;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     * @throws IndexOutOfBoundsException if out of range
     */
    @Override
    public E get(int i) {
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        buffer[i] = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (!isEmpty()) {
            E front = null;
            for (int i = 0; i <= size - 2; i++) {
                front = buffer[i];
                buffer[i] = buffer[i + 1];
            }
            size--;
            return front;
        }
        return null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (!isEmpty()) {
            E back = buffer[size - 1];
            buffer[size - 1] = null;
            size--;
            return back;
        }
        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (buffer[i] == item) {
                    buffer[i] = null;

                    for (int j = i; j < size; j++) {
                        buffer[i] = buffer[i + 1];
                    }
                    size--;
                }
            }
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        E copyOfRemovedValue = buffer[index];

        //shift values to left
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[size - 1] = null;

        size--;

        return copyOfRemovedValue;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == item) {
                return true;
            }
        }
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
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<E> {

        private int i;

        private IntListIterator() {
            i = 0;
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
            return i < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (i >= size) {
                throw new NoSuchElementException("i is now out of bounds");
            }
            E currentValue = buffer[i];
            i++;
            return currentValue;
        }

    }
}
