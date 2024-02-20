/**
 *  This class is an implementation of a list
 *  using a resizable array to store elements.
 *  The size of the array is adjusted to accommodate
 *  the number of elements added to the list.
 *
 * @author Dhiyaa Nazim
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

    private int size;
    private E[] buffer;

    public ArrayList(){
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Add item to the front.
     * @param item the item to be added
     *
     * This method runs in O(n) or linear time
     * since adding items to the front would require
     * moving every single item in the list to insert
     * the item in the front. Resizing could also
     * occur which would involve visiting and copying all
     * items in the old list to the new list.
     */
    @Override
    public void addFront(E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
        }
        for (int i = size; i >= 1; i--){
            buffer[i] = buffer[i-1];
        }
        buffer[0] = item;
        size++;
    }


    /**
     * Add item to the back.
     * @param item the item to be added
     *
     * This method runs in O(n) or linear time
     * even though adding an item to the back
     * doesn't require shifting, in a worse case
     * scenario the list might be full and resizing
     * could occur which would involve visiting
     * and copying all items in the old list to the new list.
     */
    @Override
    public void addBack(E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
        }

        buffer[size] = item;
        size++;

    }

    /**
     * Add an item at specified index (position).
     * @param i the index where the item should be added
     * @param item the item to be added
     *
     * This method runs in O(n) time.
     * Based on the index, the list may have to shift
     * at the specified index. Regardless, the worse case
     * scenario would be if the list is full and
     * resizing occurs which would require copying everything
     * from the old list to the new list. Therefore,
     * the time complexity is linear as it would require
     *  visiting every item to copy to the new list.
     */
    @Override
    public void add(int i, E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int j = 0; j < buffer.length; j++){
                newBuffer[j] = buffer[j];
            }
            buffer = newBuffer;
        }
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        for (int j = size; j >= i; j--){
            buffer[j] = buffer[j-1];
        }
        buffer[i] = item;
        size++;

    }


    /**
     * Get the item at a specified index.
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     *
     * This method runs in O(1) time, since it only
     * requires access to the array at it's index
     * without any shifting or moving items in
     * the list. Therefore, the time complexity is
     * constant as it only requires a single line to access
     * the array at its index.
     */
    @Override
    public E get(int i) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return buffer[i];

    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * @param i the index where the item should be saved
     * @param item the item to be saved
     *
     * This method runs in O(1) or constant time.
     * Similar to the previous method, this only
     * requires a single array access to the index of
     * the array. The only thing that changes is the item
     * at the index, the size doesn't change and no shifting
     * is involved in this method.
     */
    @Override
    public void set(int i, E item) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        buffer[i] = item;
    }


    /**
     * Remove item at the front of the list.
     * @return the item that was removed
     *
     * This method runs in O(n) or linear time.
     * Removing the item in the front requires
     * shifting the entire list to fill the removed index
     * which means visiting every item and changing their
     * index.
     */
    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }

        E remove = buffer[0];
        for (int i = 0; i <= size - 2; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[size - 1] = null;

        size--;

        return remove;

    }

    /**
     * Remove item at the back of the list
     * @return the item that was removed
     *
     * This method runs in O(1) time,
     * since finding the last item in the
     * list is as simple as accessing the array
     * at the last index. Since the list has nothing
     * after that item, it wouldn't require any shifting
     * or visiting/changing any other items.
     */
    @Override
    public E removeBack() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }

        E remove = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        return remove;
    }

    /**
     * Remove item from the list
     * @param item the item to be removed
     *
     * The method runs in O(n) time in a
     * worse case scenario. Without knowing the
     * index of the item, it would require searching
     * the entire list to find the specified item to remove.
     * And if the item is in the front or middle of the list,
     * shifting would have to occur to fill up the empty index
     * in the list.
     *
     */
    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        int index = 0;
        for(int i = 0; i < size; i++) {
            if (buffer[i].equals(item)) {
                index = i;
            }
        }
        for(int j = index; j < size - 1; j++){
            buffer[j] = buffer[j + 1];
        }
        buffer[size-1] = null;
        size--;
    }

    /**
     * Remove item at a specified index.
     * @param i the index where the item should be removed
     * @return the item that was removed
     *
     * The method runs in O(n) time.
     * In a worse case scenario, the item could
     * be in the front or middle of the list which
     * would then require to shift the entire right side
     * of the list to fill up the empty index that
     * was removed. Therefore, the time complexity
     * is linear as it would require visiting
     * and changing the index of all the items on
     * the right side of the index that was removed.
     */
    @Override
    public E remove(int i) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        E remove = buffer[i];
        for(int j = i; j < size - 1; j++){
            buffer[j] = buffer[j + 1];
        }
        buffer[size-1] = null;
        size--;
        return remove;
    }

    /**
     * Checks if an item is in the list.
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     *
     * This method runs in O(n) or linear time
     * as checking for an item in the list without
     * knowing its index would require searching and visiting
     * every index of the list. In a worse case scenario,
     * the item might be at the end of the list and that
     * would mean visiting every single index in the
     * list to find it.
     */
    @Override
    public boolean contains(E item) {
        for(int i = 0; i < size; i++){
            if(buffer[i].equals(item)){
                return true;
            }
        }
        return false;
    }


    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     *
     * This method runs in constant time, or O(1)
     * as this method only requires a simple operation
     * that doesn't need to shift or search the list.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Provides a count of the number of items in the list.
     * @return number of items in the list
     *
     * This method runs in O(1) time as it only requires
     * the access of a variable to execute
     * and doesn't need to shift or search the list.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<E> {

        private int i;
        private IntListIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            if(i >= size){
                throw new NoSuchElementException("i is now out of bounds");
            }
            E currentItem = buffer[i];
            i++;
            return currentItem;
        }
    }
}
