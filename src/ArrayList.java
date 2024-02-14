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

    public ArrayList(int capacity) {
        buffer = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        for (int i = size - 1; i >= 0; i--) { // shift elements
            buffer[i + 1] = buffer[i];
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
            increaseBuffer(size + 1);
            buffer[size++] = item;
        }

        /**
         * Add an item at specified index (position).
         *
         * @param i    the index where the item should be added
         * @param item the item to be added
         */
        @Override
        public void add(int i, E item) {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException();
            }
        }

        /**
         * Get the item at a specified index.
         *
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
         *
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
         *
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
         *
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
         *
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
         *
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
                buffer[j] = buffer[j + 1]; // to avoid memory leak
            }
            size--;
            return removedItem;
        }
        /**
         * Checks if an item is in the list.
         *
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

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no index exists!");
                }
                return buffer[currentIndex++];
            }
        }
        private void increaseBuffer ( int increaseBuffer){
            if (increaseBuffer > buffer.length) {
                int newBuffer = buffer.length * 2;
                if (newBuffer < increaseBuffer) {
                    newBuffer = increaseBuffer;
                }
                buffer = Arrays.copyOf(buffer, newBuffer);
            }
        }
    }
