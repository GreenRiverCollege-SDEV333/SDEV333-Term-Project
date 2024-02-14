import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final double MAX_CAPACITY = 0.75;
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
     * @param bufsize size of the initial underlying buffer.
     */
    public ArrayList(int bufsize) {
        arrayData = (E[])new Object[bufsize];
        arraySize = 0;
    }

    // performs resizing if too large or too small of a buffer size.
    // worst case: O(n), linear progression each time we need to make new spaces.
    // grow/shrink are included in this

    private void autoResize() {
        double capacity = this.size() / (double)arrayData.length;

        // grow when we reach max capacity
        if (capacity > MAX_CAPACITY) grow();
        // shrink if we're below the min capacity, but the default buffer must have a size.
        else if (capacity < MIN_CAPACITY && arrayData.length > DEFAULT_BUFFER) shrink();
    }

    // general index checker
    private void checkIfInRange(int i) {
        if (i < 0 || i >= arraySize) throw new IndexOutOfBoundsException(String.format("%d is not a valid index.", i));
    }

    private void grow() {
        // hold old data
        E[] buf = arrayData;
        int newLength = arrayData.length + DEFAULT_BUFFER;

        // create new array of a larger size
        arrayData = (E[]) new Object[newLength];

        this.copy(buf, arrayData);
    }

    private void shrink() {
        // hold old data
        E[] buf = arrayData;
        int newLength = arrayData.length - DEFAULT_BUFFER;

        // don't try if the new length is too small
        if (newLength < DEFAULT_BUFFER) return;

        // create new array of a smaller size
        arrayData = (E[]) new Object[newLength];

        this.copy(buf, arrayData);
    }

    // O(n), linear copy.
    private void copy(E[] from, E[] to) {
        // copy old data to new array
        int shortest = (to.length < from.length) ? to.length : from.length;
        for (int i = 0; i < shortest; i++) {
            to[i] = from[i];
        }
    }

    /**
     * Add item to the front.
     * O(n) - adding a new item to the beginning means you need to look at every element
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        add(0, item);
    }

    /**
     * Add item to the back.
     * O(n) - would be O(1) if arrays could be expanded without copying, but no luck there.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        add(this.size(), item);
    }

    /**
     * Add an item at specified index (position).
     * O(n) - item added to the beginning would move the whole array.
     * additionally, changes in array capacity would result in a second pass.
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
     * O(1) - Access is constant in an array
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
     * O(1) - access/setting is constant
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
     * O(n) - changes in array capacity will result in copying all data
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return remove(this.size()-1);
    }

    /**
     * Remove item from the list
     * O(n) - changes in array capacity will result in copying all data
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0; i < this.size(); i++) {
            if (arrayData[i].equals(item)) {
                remove(i); // call the integer type remove, since it will do the same thing once we find the index
                return; // we probably only want to remove one item at a time
            }

        }
    }

    /**
     * Remove item at a specified index.
     * O(n) - changes in array capacity will result in copying all data
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
        for (int idx = i; idx < this.size(); idx++) {
            arrayData[idx] = arrayData[idx+1];
        }
        arraySize--;

        return data;
    }

    /**
     * Checks if an item is in the list.
     * O(n) - item not present will go over whole array
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
     * O(1) - instant access to size
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * O(1) - instant access to size
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return arraySize;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n) - by its nature
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        E[] readOnly = arrayData.clone();

        return new Iterator<E>() {
            int index = 0;
            int size = size();

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new IndexOutOfBoundsException();
                E value = readOnly[index];
                index++;
                return value;
            }
        };
    }

    // for use in testing
    protected int getArraySize() {
        return arrayData.length;
    }
}
