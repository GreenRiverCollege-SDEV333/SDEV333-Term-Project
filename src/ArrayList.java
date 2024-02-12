import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final double MAX_CAPACITY = 0.85;
    private static final double MIN_CAPACITY = 0.5;
    private static final int DEFAULT_BUFFER = 10;

    private E[] arrayData;
    int arraySize;

    /**
     * Generate an arraylist of the default buffer size
     */
    public ArrayList() {
        this(DEFAULT_BUFFER);
    }

    /**
     * Generate an array list of a specified buffer size
     * @param bufsize
     */
    public ArrayList(int bufsize) {
        arrayData = (E[])new Object[bufsize];
        arraySize = 0;
    }

    // performs resizing if too large or too small of a buffer size.
    private void autoResize() {
        double capacity = this.size() / arraySize;

        // grow when we reach max capacity
        if (capacity > MAX_CAPACITY) grow();
        // shrink if we're below the min capacity, but the default buffer must have a size.
        else if (capacity < MIN_CAPACITY && arraySize > DEFAULT_BUFFER) shrink();
    }

    // general index checker
    private void checkIfInRange(int i) {
        if (i < 0 || i >= arraySize) throw new IndexOutOfBoundsException(String.format("%d is not a valid index.", i));
    }

    private void grow() {
        // hold old data
        E[] buf = arrayData;

        // create new array of a larger size
        arrayData = (E[]) new Object[buf.length + DEFAULT_BUFFER];

        this.copy(buf, arrayData);
    }

    private void shrink() {
        // hold old data
        E[] buf = arrayData;

        // create new array of a smaller size
        arrayData = (E[]) new Object[buf.length - DEFAULT_BUFFER];

        this.copy(buf, arrayData);
    }

    private void copy(E[] from, E[] to) {
        // copy old data to new array
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        add(0, item);
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        add(this.size(), item);
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        // special range check, add will be able to perform addBack
        if (i < 0 || i > this.size()) throw new IndexOutOfBoundsException(String.format("%d is not a valid index.", i));

        autoResize();

        // move all from rhs of index right by one
        for (int idx = this.size(); idx > i; idx--) {
            arrayData[idx] = arrayData[idx-1];
        }

        // set new value and array size
        arrayData[i] = item;
        arraySize++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        checkIfInRange(i);
        return arrayData[i];
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
        checkIfInRange(i);
        arrayData[i] = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        return remove(0);
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return remove(this.size()-1);
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0; i < this.size(); i++) {
            if (arrayData[i].equals(item)) remove(i); // call the integer type remove, since it will do the same thing once we find the index
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        checkIfInRange(i);

        autoResize();

        E data = arrayData[i];

        // shift all from rhs left to shrink, adjust array size
        for (int idx = i; idx < this.size(); i++) {
            arrayData[idx] = arrayData[idx+1];
        }
        arraySize--;

        return data;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < arraySize; i++)
            if (arrayData[i].equals(item)) return true;
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return arraySize;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arraySize;
            }

            @Override
            public E next() {
                return arrayData[index++];
            }
        };
    }
}
