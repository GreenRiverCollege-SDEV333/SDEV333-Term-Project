import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
Need to finish methods and runtime analysis
@ Ryder Dettloff
@ version 1.0
@ 02-13-2024
 */
public class ArrayList<E> implements List<E> {
    private int size;
    private E[] buffer;

    public ArrayList() {
        buffer = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     * Runtime Analysis: This method will run in O(n) worst case because it has to traverse through the whole list
     */
    @Override
    public void addFront(E item) {
        if(size == buffer.length)
        {
            increaseBuffer(size);
        }
        for (int i = size - 1; i >= 0; i--) { // shift elements
            buffer[i + 1] = buffer[i];
        }
        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     * Worse case the buffer needs to beresized and will run in O(n) but for empty arrays it will log O(1) for best case
     * @param item the item to be added
     */
    @Override

    public void addBack(E item) {
            increaseBuffer(size + 1);
            buffer[size++] = item;
        }

        /**
         * Add an item at specified index (position).
         * Runtime Analysis O(n) has to shift all elements in the list
         * @param i    the index where the item should be added
         * @param item the item to be added
         */
        @Override
        public void add(int i, E item) {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Index is out of bounds!");
            }

            if (size == buffer.length) {
                increaseBuffer(size + 1);
            }
                for (int j = size; j > i; j--) {
                buffer[j] = buffer[j - 1];
            }

            buffer[i] = item;
            size++;
        }

        /**
         * Get the item at a specified index.
         * Runtime Analysis: runs in O(1) since it grabs it from the specific index
         * @param i the index where the item should be retrieved
         * @return the item located at that index
         */
        @Override
        public E get(int i) {
            if (i < 0 || i >= size) {
                throw new IndexOutOfBoundsException("index is out of bounds!");
            }
            return buffer[i];
        }

        /**
         * Set (save) an item at a specified index. Previous
         * item at that index is overwritten.
         * Runtime Analysis: Also invloves indexing so O(1)
         * @param i    the index where the item should be saved
         * @param item the item to be saved
         */
        @Override
        public void set(int i, E item) {
            if (i < 0 || i >= size) {
                throw new IndexOutOfBoundsException("index is out of bounds!");
            }
            buffer[i] = item;
        }

        /**
         * Remove item at the front of the list.
         * Runtime Analysis: O(n) since we will have to shift the whole list left
         * @return the item that was removed
         */
        @Override
        public E removeFront () {
            if (isEmpty()) {
                throw new NoSuchElementException("List is Empty!");
            }
            E removedItem = buffer[0];
            for (int i = 0; i < size - 1 ; size++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
            return removedItem;
        }

        /**
         * Remove item at the back of the list
         * O(1) since we are only updating the last element in the array (no shifting)
         * @return the item that was removed
         */
        @Override
        public E removeBack () {
            if (isEmpty()) {
                throw new NoSuchElementException("List is Empty!");
            }
            E removedItem = buffer[size - 1];
            buffer[size - 1] = null;
            size--;
            return removedItem;
        }

        /**
         * Remove item from the list
         * Runtime Analysis: O(n) to traverse he whole list
         * @param item the item to be removed
         */
        @Override
        public void remove(E item) {
            for (int i = 0; i < size; i++) {
                if (buffer[i].equals(item)) {
                    remove(i);
                    return;
                }
            }
            size--;
        }

        /**
         * Remove item at a specified index.
         * Runtime Analysis: O(n) for worse case, if item is last in the array it can be O(1)
         * @param i the index where the item should be removed
         * @return the item that was removed
         */
        @Override
        public E remove(int i) {
            if (i < 0 || i >= size) {
                throw new IndexOutOfBoundsException();
            }
            E removedItem = buffer[i];
            for (int j = 0; j < size-1; j++ ) {
                buffer[j] = buffer[j + 1];
            }
            size--;
            return removedItem;
        }
        /**
         * Checks if an item is in the list.
         * Runtime Analysis: O(n) worse case it needs to traverse the whole list to find item.
         * @param item the item to search for
         * @return true if the item is in the list, false otherwise
         */
        @Override
        public boolean contains(E item) {
            if (isEmpty()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (buffer[i].equals(item)) {
                    return true;

                }
            }
        return false;
        }

        /**
         * Checks if the list is empty.
         * O(1) only requires checking size variable
         * @return true if the list is empty, false otherwise
         */
        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Provides a count of the number of items in the list.
         * Runtime Analysis: O(1) only returns the size variable
         * @return number of items in the list
         */
        @Override
        public int size () {
            return size;
        }

        /**
         * Returns an iterator over elements of type {@code T}.
         *
         * @return an Iterator.
         */
        @Override
        public Iterator iterator () {
            return null;
        }
        private class ArrayListIterator implements Iterator<E> {
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no index exists!");
                }
                return buffer[currentIndex++];
            }
        }

        /* increase buffer helper grabs the length of the buffer and doubles it
        * it then copies the original buffer to the new one
        * this runs in O(n) because it simply does a calculation then assigns the new buffer with all the old buffers data
         */
        private void increaseBuffer(int increaseBuffer){
            int newBuffer = buffer.length * 2;
            buffer = Arrays.copyOf(buffer, newBuffer);
            }
        }
