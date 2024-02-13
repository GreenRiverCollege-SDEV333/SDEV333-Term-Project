package abstractDataTypes;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tobygoetz
 * @version 1.0
 * Generic ArrayList, to be used with any data type
 * @param <E> specifies data type to be used in ArrayList
 */
public class ArrayList<E> implements List<E> {

    private static final int CAPACITY = 10;

    // fields
    private E[] buffer;
    private int size;

    /**
     * Constructor for ArrayList
     */
    public ArrayList()
    {
        size = 0;
        buffer = (E[]) new Object[CAPACITY];
    }


    /**
     * Add item to the front.
     * (7(size) + 3) + (5(BL) + 6) == 15(size) + 9 at worst
     * 7(size) + 3 at best
     * 0(size)
     * This function is linear because it reassigns all values to the
     * index proceeding it, but calls resize() which is equivalently
     * linear as well.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        //loop while index is greater than zero
        for (int i = size; i > 0; i--) {                                // { 1 + 1 + 2 = 4
            //if buffer is at capacity increase buffer by one index
            if (size == buffer.length) {                                // 1
                this.resize(buffer.length + 1);                 // f(n)= 5BL + 6 + 1 == O(n)
            }
            //index at highest buffer gets shifted right
            buffer[i] = buffer[i - 1];                                  // 1 + 1 } * size
        }
        buffer[0] = (E) item;                                           // 1
        size++;                                                         // 2
    }                                                                   // == f(size)= 7(n) + 8(n) + 3

    /**
     * Add item to the back.
     * (5BL + 6) + 3 = 5BL + 9 at worst
     * f(n) = 2 at best
     * This function is constant at best and linear at worst.
     * Function is only linear if buffer needs to resize to
     * accommodate for 1 additional index
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        //if buffer is at capacity increase buffer by one index
        if ( size == buffer.length) {
            resize(size + 1);
        }
        //add value to size which is one index greater than last value
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     * (7 + n)(size - index) + (6 + n) at worst
     * O(3 + n) constant at best
     * This function is linear at worst because it iterates (size - index) times
     * and constant at best when invalid index throws exception which I am
     * assuming is a constant constructor call.
     *
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item)
    {
        if (index < 0 || index > size) {                                         // 3
            throw new IndexOutOfBoundsException("Specified Index Must Be " +     // + n
                    "In the Range of 0-" + size);
        } else {
            //loop while index is greater than index value specified
            for (int i = size; i >= index; i--) {                                // { 4
                //if buffer is at capacity increase buffer by one index
                if (size == buffer.length) {                                     // 1
                    this.resize(buffer.length + 1);                      // 5BL + 6
                }
                //index at highest buffer gets shifted right
                if (i != 0) {                                                    // 1
                    buffer[i] = buffer[i - 1];                                   // 1 } * (size - index)
                }                                                                // == (7 + n)(size - index) + (6 + n)
            }
        }
        buffer[index] = item;                                                    // 1
        size++;                                                                  // 2
    }

    /**
     * Get the item at a specified index.
     * O(2 + n) at worst
     * O(3) at best
     * This function is linear across assuming that
     * thrown exception is a relative linear constructor call and
     * accounting for branches (I presume)
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index)
    {
        if (index < 0 ) {                                               // 1
            throw new IndexOutOfBoundsException(                        // n
                    "Index must be greater than 0");
        } else if (index >= size ) {                                    // 1
            if (size == 0) {                                            // 1
                throw new IndexOutOfBoundsException(                    // n
                        "This list is empty");
            } else {
                throw new IndexOutOfBoundsException(                    // n
                        "Specified Index Must Be " +
                                "In the Range of 0-" + (size - 1));     // 1
            }
        } return buffer[index];                                         // 1
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * O(3 + 1) at best
     * O(4 + n) at worst
     * This function is constant'ish but still technically linear
     * because if O(3) = O(3 * n), then n = 1. Boom math...
     * I want to say constant because I know a fixed amount at worst
     * and at best, but not as constant as size()
     *
     * @param index    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item)
    {
        if (index < 0 || index >= size) {                                     // 3
            throw new IndexOutOfBoundsException("Specified Index Must Be " +  // n
                    "In the Range of 0-" + (size - 1));                       // 1
        } else {
            buffer[index] = item;                                             // 1
        }
    }

    /**
     * Remove item at the front of the list.
     * (6(size - 2) + 8) + ((5BL + 6) +2)
     * O(BL) at worst
     * O(size - 2) at best if buffer does not need to resize
     * This function is linear because it iterates over entire
     * array and possibly again through resize()
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        if (!isEmpty()) {                               // 1 + O(3)
            E removed = buffer[0];                      // 1
            for (int i = 0; i <= size - 2; i++) {       // { 4
                buffer[i] = buffer[i + 1];              // 1 + 1 } * (size - 2)
            } size--;                                   // 2

            //Reduce buffer until original buffer size is reached
            if (size >= 10) {                           // 1
                resize(size);                           // 5BL + 6
                //after buffer becomes 10 set removed values back to null
            } else {
                buffer[size] = null;                    // 1
            }
            return removed;
        } else {
            return null;
        }
    }

    /**
     * Remove item at the back of the list
     * O(1) at best??
     * O(9) at worst
     * Constant at best because return null is an assignment'ish
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        if (!isEmpty()) {                     // O(3)
            E removed = buffer[size - 1];     // 1 + 1
            buffer[size - 1] = null;          // 1 + 1
            size--;                           // 2
            return removed;
        } else {
            return null;
        }
    }

    /**
     * Remove item from the list
     * (3 + BL) or O(12) or (11(size - 1) + 3) + 3 + O(size) + 5BL + 6)
     * so 0(2n) at worst
     * This function could definitely been written cleaner but in Britain
     * they have phrase 'any road' meaning you'll always get there as long
     * as you keep driving... My logic took a binary search approach to finding
     * the answer, but instead of analyzing one or the other I analyzed both.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        if (this.contains(item)) {                               // 0(size)
            if (this.buffer[0].equals(item)) {                   // 1array access + 1 conditional
                this.removeFront();                              // 0(BL)
            } else if (this.buffer[size - 1].equals(item)) {     // 1 + 1 + 1
                this.removeBack();                               // 0(9)
            } else {
                int index = 0;                                   // 1
                while (!buffer[index].equals(item)) {            // { 1 + 1
                    index++;                                     // 1 + 1 } * (BL - B[i])
                }
                for (int i = index; i < size - 1; i++) {         // { 4
                    buffer[i] = buffer[i + 1];                   // 1 + 1 } * size - 1
                }
                size--;                                          // 2
                if (size >= 10) {                                // 1
                    resize(size);                                // 5BL + 6
                    //after buffer becomes 10 set removed values back to null
                } else {
                    buffer[size] = null;                         // 1 + 1
                }
            }
        }
    }

    /**
     * Remove item at a specified index.
     * (((8(size -1) + 4) + 2) + 2) + 1)
     * O(size - 1) at worst
     * O(2) at best
     * Almost constant on invalid input but linear if removing any index
     * but the index at the back of array, I think I accounted for branching
     * in this one. My assumption is don't include unreachable code in
     * the calculation of the y-axis, but probably the conditionals themselves.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index)
    {
        // first, check the index to see if it is valid
        if (index < 0) {                                                          // 1
            throw new IndexOutOfBoundsException("Index cannot be negative");      // 1
        } else if (index >= size) {                                               // 1
            throw new IndexOutOfBoundsException("Index is higher than size");     // 1
        }

        // save a copy of the value to be removed so that we can return it later
        E copyOfRemovedValue = buffer[index];                                     // 1 + 1

        // if index is last index with valid data, set data to null
        if (index == size - 1) {                                                  // 1 + 1
            buffer[index] = null;                                                 // 1 + 1
            // shift all values over starting at index to be removed
        } else {                                                                  // { 4
            for (int i = index; i < size - 1; i++) {                              // 1 + 1 + 1 + 1 } * (size - 1)
                buffer[i] = buffer[i + 1];
            }
        } size--;                                                                 // 2
        // set trailing index to null to account for reduced size
        buffer[size] = null;                                                      // 1 + 1

        return copyOfRemovedValue;                                                // 1
    }

    /**
     * Checks if an item is in the list.
     * O(size) at worst
     * O(1) at best
     * This function is linear but constant in the case that an
     * array is empty
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(Object item)
    {
        int index = 0;                          // 1
        while (index != size) {                 // { 1
            if (buffer[index].equals(item)) {   // 1 + 1
                return true;                    // 1
            } else {
                index++;                        // 1 + 1 } * size
            }
        } return false;                         // 1
    }

    /**
     * Checks if the list is empty.
     * 0(3) at best and worst
     * This method is constant and will always be constant'ish
     * but linear for all intents and purposes
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && buffer[0] == null;  // 3
    }

    /**
     * Provides a count of the number of items in the list.
     * O(1) at best and worst
     * Doesn't get much better than this
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;      // 1
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(2) at best??
     * I wouldn't know if the constructor is this.iterator = iterator
     * because it's implicit and can't remember nor find how to look
     * up imported static function calls in intellij
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();                 // 1 + 1'ish
    }

    private class ArrayListIterator implements Iterator<E> {

        private int index;

        private ArrayListIterator() { index = 0;}

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
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
                throw new NoSuchElementException("Index is out of range");
            }

            E currentValue = buffer[index];
            index++;
            return currentValue;
        }
    }

    /**
     * Helper method to resize ArrayIntlist to support
     * more data
     * f(BL) = 5BL + 6
     * O(n) at worst and at best
     * This function is linear at worst because it loops over all existing
     * indices in the buffer and still linear but insignificantly faster
     * if new buffer is less than existing buffer
     */
    private void resize(int newSize) {
        //create new space, separate from the old space (buffer)
//        int newSize = size + CAPACITY;
        E[] newBuffer = (E[]) new Object[newSize];                     // 1 + 3 (Assuming that new object is constant)

        // copy everything over from buffer into newBuffer
        if (newSize > buffer.length) {                                 // 1
            for (int i = 0; i < buffer.length; i++) {                  //  { 1 + 1 + 2 (i = i + 1) * BL
                newBuffer[i] = buffer[i];                              //  1  }  == 5BL + 6
            }                                                          //
        } else {                                                       //
            for (int i = 0; i < newBuffer.length; i++) {               // { 1 + 1 + 2 * NBL
                newBuffer[i] = buffer[i];                              // 1 } == 5BL + 6
            }                                                          //
        }

        // set the new space into buffer
        buffer = newBuffer;                                            // 1

        // the old space is no longer "pointed to" and will eventually
        // be cleaned up by the garbage collector
    }

    /**
     * If I remember right Strings are objects which are arrays of characters,
     * thus a new String = an iteration over an array to build that string.
     * So that being, each new String here is actually 0(String.length) +
     * operands + static method call to toString which probably iterates again...
     * O(bigNumber * character) + few operands
     * 0(n) at worst...
     *
     * @return String representation of ArrayList
     */
    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", indices=" + Arrays.toString(buffer) +

                '}';
    }
}
