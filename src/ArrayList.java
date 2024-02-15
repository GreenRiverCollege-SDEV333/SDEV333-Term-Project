import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic implementation of an array list
 * @param <E> generic type
 * @author Lois Lanctot
 * @version 1.0
 */
public class ArrayList<E> implements List<E> {

    private int size;
    private E[] buffer;

    /**
     * Constructor for an ArrayIntList object
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     */
    public ArrayList() {
        size = 0;
        this.buffer = (E[]) new Object[10];
    }


    /**
     * Add item to the front.
     * This method runs in O(n) or linear time in the worst case
     * because of the time needed to resize and shift elements
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if (size == buffer.length) {
            resize(size * 2);
        }

        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }

        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     * This method runs in O(n) or linear time in the worst case because of the time needed to resize
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if (size == buffer.length) {
            resize(size * 2);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     * This method runs in O(n) or linear time in the worst case because of the time needed to resize and shift elements
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        if (index == 0 && size == 0) {
            size++;
        }
        else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (size == buffer.length) {
            resize(size * 2);
        }

        for (int j = size; j >= index; j--) {
            buffer[j] = buffer[j - 1];
        }

        buffer[index] = item;
        size++;
    }

    /**
     * Get the item at a specified index.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than size");
        }
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be less than zero");
        }
        return buffer[index];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param index    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
        //if index is out of bounds
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }

        buffer[index] = item;
    }

    /**
     * Remove item at the front of the list.
     * This method runs in O(n) or linear time in the worst case because of the time needed to shift elements
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (size != 0) {

            E frontItem = null;
            for (int i = 0; i <= size; i++) {
                frontItem = buffer[i];
                buffer[i] = buffer[i+1];
            }
            size--;
            return frontItem;
        }
        return null;
    }

    /**
     * Remove item at the back of the list
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (size != 0) {
            E frontItem = buffer[size];
            buffer[size] = null;
            size--;
            return frontItem;
        }
        return null;
    }

    /**
     * Remove item from the list
     * This method runs in O(n) or linear time in the worst case because of the time needed to shift elements
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == item) {
                buffer[i] = buffer[i+1];
                size--;
            }
        }

    }

    /**
     * Remove item at a specified index.
     * This method runs in O(n) or linear time in the worst case because of the time needed to shift elements
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        //validate index
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than size");
        }
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be less than zero");
        }

        E copyOfRemovedValue = buffer[index];

        for (int j = index; j <= size - 1; j++) {
            buffer[j] = buffer[j + 1];
        }

        buffer[size - 1] = null;

        size--;

        return copyOfRemovedValue;
    }

    /**
     * Checks if an item is in the list.
     * This method runs in O(n) or linear time in the worst case because if
     * the item is at the end you'd need to search through all the elements in the list
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
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;
    }


    private void resize(int newSize) {
        //create new space, separate from the old space
        E[] newBuffer = (E[]) new Object[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;

    }

    /**
     * Returns an iterator over elements of type {@code E}.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        //private fields
        private int index;

        private ArrayListIterator() {
            index = 0;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
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
                throw new NoSuchElementException("i is now out of bounds");
            }

            E currentValue = buffer[index];
            index++;

            return currentValue;
        }
    }


}
