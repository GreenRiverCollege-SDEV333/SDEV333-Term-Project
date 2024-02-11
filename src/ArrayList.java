import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    private int size;
    private E[] buffer;

    public ArrayList() {
        buffer = (E[])new Object[10];
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * Runtime analysis: Best case is O(1) constant for an empty array, and worse case is O(N)
     * for looping through an entire array shifting all values over.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if(size == buffer.length) { // 1
            increaseBuffer(); // O(N) 5 + (8 * n)
        }
        for(int i = size; i > 0; i--) { // 6 * n
            buffer[i] = buffer[i - 1]; //
        }
        buffer[0] = item; // 1
        size++; // 2
    }

    /**
     * Add item to the back.
     *
     * Runtime Analysis: Best case is O(1) for an empty array/ array that's
     * not full. Worst case is O(N) linear having to increase the buffer size.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if(size == buffer.length) {
            increaseBuffer();
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * Runtime Analysis: Best case is O(1) for an empty array, adding a value at index 0. Worst case is
     * O(N) for looping through an entire array of N size, or if the length needs to be increased.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if(isEmpty()) {
            if(i == 0) {
                buffer[i] = item;
                size++;
            } else {
                throw new IndexOutOfBoundsException("List is empty.");
            }
        } else {
            if(size == buffer.length) {
                increaseBuffer();
            }
            for(int j = size + 1; j > i; j--) {
                buffer[j] = buffer[j - 1];
            }
            buffer[i] = item;
            size++;
        }

    }

    /**
     * Get the item at a specified index.
     *
     * Runtime Analysis: Worst case is O(1) for an empty array, and returning
     * a value at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to return.");
        } else if(i > size - 1|| i < 0) {
            throw new IndexOutOfBoundsException("List is empty.");
        } else {
            return buffer[i];
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Runtime Analysis: Best case is O(1) for an empty array, and only having to access
     * an index/ change the value.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if(isEmpty()) {
            if(i == 0) {
                buffer[i] = item;
                size++;
            } else {
                throw new NoSuchElementException("List is empty, must set first index.");
            }
        } else if(i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            buffer[i] = item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * Runtime Analysis: Best case is O(1) for an empty array, and worst case is
     * O(N) for looping through an entire array to shift all values over.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty.");
        } else {
            E removedVal = buffer[0];
            for(int i = 0; i < size - 1; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
            return removedVal;
        }
    }

    /**
     * Remove item at the back of the list
     *
     * Runtime Analysis: Best case is O(1) for an empty array, and worst case is
     * O(N) for looping through an entire array of N size.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty.");
        } else {
            E removedVal = buffer[size - 1];
            buffer[size - 1] = null;
            size--;
            return removedVal;
        }
    }

    /**
     * Remove item from the list
     *
     * Runtime Analysis: Best case is O(1) constant for an empty array. Worst case is
     * O(N) linear with having to loop through an array then calling the remove method.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to remove.");
        } else {
            for(int i = 0; i < size; i++) {
                if(buffer[i].equals(item)) {
                    remove(i);
                }
            }
            size--;
        }
    }

    /**
     * Remove item at a specified index.
     *
     * Runtime Analysis: Best case is O(1) constant in the case of an empty
     * array/invalid index. At its worst it's O(N) linear due to looping through an array
     * of N size, and the index potentially being at the end.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if(isEmpty() || i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            E removedVal = buffer[i];
            for(int j = i; j < size - 1; j++) {
                buffer[j] = buffer[j + 1];
            }
            size--;
            return removedVal;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * Runtime Analysis: At its best the method runs at O(1) in the case of
     * an empty array, and at its worst O(N) Linear due looping through an
     * array of N length with the possibility of the desired val being at
     * the end.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        if(isEmpty()) {
            return false;
        }
        for(int i = 0; i < size; i++) {
            if(buffer[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * Runtime Analysis: O(1) constant, this is the worst
     * case scenario because it simply returns the result of
     * a comparison.
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
     * Runtime Analysis: Runs at O(1) constant at it's worst
     * because it's always just returning a single variable.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Runtime analysis: At it's worst it's O(N) linear because it has
     * to loop through all values an array twice, and the size of the
     * array can vary.
     */

    private void increaseBuffer() {
        E[] hold = (E[])new Object[buffer.length]; // 2
        for(int i = 0; i < size - 1; i++) { // 4 * n
            hold[i] = buffer[i];
        }

        buffer = (E[])new Object[buffer.length * 2]; // 3
        for(int i = 0; i < size - 1; i++) {  // 4 * n
            buffer[i] = hold[i];
        }
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

    public class ArrayListIterator implements Iterator<E> {

        private int i;

        private ArrayListIterator() {
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
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E currentVal = buffer[i];
            i++;
            return currentVal;
        }
    }



}
