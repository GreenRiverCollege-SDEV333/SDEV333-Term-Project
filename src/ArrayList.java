import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A resizing ArrayList<E> object that implements List<E> interface.
 *
 * @author Braedon Billingsley
 */
public class ArrayList<E> implements List<E> {

    private int size;

    private Object[] buffer;

    public ArrayList() {
        buffer = new Object[10];
        size = 0;
    }

    /**
     * Add item to the front.
     * Runs in O(n) or linear time complexity. This is because
     * each existing element needs to be shifted by one position
     * to make room.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if (size == buffer.length) { // resize by multiple of 2 if full
            resize();
        }
        for (int i = size; i >= 1; i--) { // loop backwards from size - 5, 4, 3, 2, 1
            buffer[i] = buffer[i - 1]; // copy index one to the right
        }
        buffer[0] = item; // add item to front of buffer
        size++; // increase size by one
    }

    /**
     * Add item to the back.
     * Runs in O(1) or constant time complexity for most cases, or
     * in O(n) or linear time complexity for worst cases.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if (size == buffer.length) { // resize by multiple of 2 if full
            resize();
        }

        buffer[size] = item; // add object to back of buffer
        size ++; // increase size by one
    }

    /**
     * Add an item at specified index (position).
     * Runs in O(n) because on average it must shift half
     * of the elements over by one spot. When inserting to front,
     * the time complexity is at its worst case.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if (size == buffer.length) { // resize by multiple of 2 if full
            resize();
        } else if (i < 0) { // check index if it's valid
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (i > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        for (int j = size - 1; j >= i; j--) { // loop backwards from size - 1 to i
            buffer[j + 1] = buffer[j]; // shift elements to the right
        }

        buffer[i] = item; // add item to specified index
        size++; // increase size by one
    }

    /**
     * Get the item at a specified index.
     * Runs in O(1) or constant time complexity.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        //first check index if its valid
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (i >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return (E) buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * O(1) time complexity. Setting a value at a specific
     * index is constant time.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if (i < 0) { // check index if its valid
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (i >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        buffer[i] = item; // overwrite item to specified index
    }

    /**
     * Remove item at the front of the list.
     * Runs in O(n) or linear time because
     * each element needs to shift one position
     * after removing the front element.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (isEmpty()) { // check if empty
            System.out.println("List is empty, no item to remove.");
            return null;
        }

        E frontItem = (E) buffer[0]; // save front item to return

        for (int i = 0; i <= size; i++) { // loop backwards from size - 5, 4, 3, 2, 1
            buffer[i] = buffer[i + 1]; // copy index one to the right
        }

        size--; // decrease size by one
        return frontItem;
    }

    /**
     * Remove item at the back of the list
     * Runs in O(1) or constant time because it involves removing
     * the last element then decreasing the size of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (isEmpty()) { // check if empty
            System.out.println("List is empty, no item to remove.");
            return null;
        }
        E backItem = (E) buffer[size - 1]; // save item in back of list to return
        buffer[size - 1] = null;
        size --; // decrease size by 1;

        return backItem;
    }

    /**
     * Remove item from the list
     * Runs in O(n) or linear time as it requires
     * searching for item first and possibly shifting
     * all remaining elements.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if (isEmpty()) { // check if empty
            System.out.println("List is empty, no item to remove.");
            return;
        }
        int itemIndex = -1; // value to store the items index
        for (int i = 0; i < size; i++) { // loop until index is found
            if (buffer[i].equals(item)) {
                itemIndex = i;
                break; // break from loop when index found
            }
        }

        if (itemIndex == -1) { // Check if item is in the list.
            System.out.println("Item not found.");
            return;
        }

        for (int i = itemIndex; i < size - 1; i++) { // shift from left to right
            buffer[i] = buffer[i + 1];
        }

        buffer[size - 1] = null;
        size --; // decrease size by 1;
    }

    /**
     * Remove item at a specified index.
     * Runs in O(n) or linear time for the same reasons
     * as remove(E item) except the index is known.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if (isEmpty()) { // check if empty
            System.out.println("List is empty, no item to remove.");
            return null;
        } else if (i < 0) { // check index if its valid
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (i >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        E removedItem = (E) buffer[i]; // store item to be removed and cast to generic.
        for (int j = i; j < size - 1; j++) { // shift to right
            buffer[j] = buffer[j + 1];
        }

        buffer[size - 1] = null;
        size --; // decrease size by 1;
        return removedItem; // return item removed from list
    }

    /**
     * Checks if an item is in the list.
     * O(n) or linear time, and in the worst case scenario,
     * it has to traverse through the entire list to find the item.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        if (isEmpty()) { // check if empty
            System.out.println("List is empty and contains no items.");
            return false;
        }
        for (int i = 0; i < size; i++) { // loop until index is found
            if (buffer[i].equals(item)) { // if item is found return true
                return true;
            }
        }
        return false; // return false if list does not contain item
    }

    /**
     * Checks if the list is empty.
     * runs in O(1) or constant time complexity, it just involves
     * checking the size attribute.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * O(1) or constant time. Getting the size is an instant operation
     * and doesn't depend on size of the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(1) or constant time. The returned iterators hasNext() and next()
     * methods also have O(1) constant time but iterating over entire
     * set of elements will take O(n) time or linear time complexity
     * .
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int current = 0; // keep track of current index
            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return current < size && buffer[current] != null; // check if there's another element, and return true
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public E next() {
                if (!hasNext()) { // return next unless index out of bounds
                    throw new NoSuchElementException();
                }
                return (E) buffer[current++]; // return next element of type E
            }
        };
    }

    private void resize() {
        Object[] newBuffer = new Object[buffer.length * 2]; // 2 is the variable factor to resize by, consider adding as parameter
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }
}
