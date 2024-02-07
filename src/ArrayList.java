import java.util.Iterator;

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
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if(isEmpty()) {
            buffer[0] = item;
        } else {
            for(int i = size; i > 0; i--) {
                buffer[i] = buffer[i - 1];
            }
            buffer[0] = item;
        }
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if(size == buffer.length) {

        } else {
            buffer[size] = item;
        }
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty.");
        } else {
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
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty.");
        } else {
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

    }

    /**
     * Remove item at the front of the list.
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
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for(int i = 0; i < size; i++) {
            if(buffer[i] == item) {

            }
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
        return null;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for(E value : buffer) {
            if(value == item) {
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
        return null;
    }
}
