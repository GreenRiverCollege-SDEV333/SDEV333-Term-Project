import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    private int size;
    private E[] buffer;

    // constructor
    public ArrayList() {
        // initialize my fieldss
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        // If the buffer is already full, we increase the size by 2 times
        if (buffer.length == size) {
            increaseSize(size * 2);
        }

        for (int i = size; i > 0; i--) {
            buffer[i] = buffer[i - 1];
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
        // If the buffer is already full, we increase the size by 2 times
        if (buffer.length == size) {
            increaseSize(size * 2);
        }

        size++;
        buffer[size] = item;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        // If the buffer is already full, we increase the size by 2 times
        if (buffer.length == size) {
            increaseSize(size * 2);
        }

        size++;

        for (int i = size; i >= index; i--) {
            buffer[i] = buffer[i - 1];
        }

        buffer[index] = item;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        // If the i is greater than the current size or less than 0 than we know that it's not possible
        if (i > size || i < 0) {
            return null;
        }
        else {
            return buffer[i];
        }
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
        // If i is greater than 0 but equal or less than the size, we will know it's within size
        if (i >= 0 && i <= size) {
            buffer[i] = item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        // If the size is 0, that means that it's empty so there's no need
        if (size == 0) {
            return null;
        }

        E removed = buffer[0];

        buffer[0] = null;

        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i + 1];
        }

        buffer[size] = null; // Changes the back to null since we would move everything to the left so the index should be nothing now
        size--;

        return removed;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        // If the size is 0, that means that it's empty so there's no need
        if (size == 0) {
            return null;
        }

        E removed = buffer[size];
        buffer[size] = null;
        size--;
        return removed;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        // If the size is not 0, run it
        if (size != 0) {
            // for each item in the array
            for (int i = 0; i < size; i++) {
                // if the item is the same remove it
                if (buffer[i] == item) {
                    buffer[i] = null;

                    // for each of the remaining index we will shift it to the left
                    for (int j = i; j < size; j++) {
                        buffer[i] = buffer[i + 1];
                    }

                    // Lower size by 1
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
        // If the size is 0, that means that it's empty so there's no need
        if (size == 0) {
            return null;
        }
        else {
            E removedInt = buffer[index];

            for (int i = index; i <= size; i++) {
                buffer[i] = buffer[i + 1];
            }

            size--;
            return removedInt;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        boolean doseItContains = false;

        for (int i = 0; i <= size; i++) {
            if (buffer[i] == item) {
                doseItContains = true;
            }
        }

        return doseItContains;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
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
        //private fields
        private int i;

        private ArrayListIterator() {
            i = 0;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
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

    // resizing
    private void increaseSize(int size) {
        E[] placeholder = (E[]) new Object[size];
        System.arraycopy(buffer, 0, placeholder, 0, buffer.length);
        buffer = placeholder;
    }
}
