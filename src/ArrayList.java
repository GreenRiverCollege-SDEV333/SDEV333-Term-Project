/**
 * Author: Levi Miller
 * File: ArrayList.java implements arraylist
 */
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{

    private int size;
    private E[] buffer;

    public ArrayList(){
        buffer = (E[]) new Object[10];
        size = 0;
    }
    /**
     * Add item to the front.
     * Runtime analysis: the O level is O(n) so linear time
     * The program has to run over the size(n) of the list
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
       if(size == buffer.length){ // +1
           resize(buffer.length * 2); // +1
       }
        for (int i = size - 1; i >= 0; i--) {
            buffer[i+1] = buffer[i]; // +2
        }
        buffer[0] = item; // + 1
        size++; // + 2
    }
    /**
     * Add item to the back.
     * Runtime analysis: the O level is worst case is O(1) it is constant f(n) = n + 5
     * The program checks the size of list then adds to back of list
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) throws IllegalArgumentException{
     if(size == buffer.length){  // + 1
         resize(size * 2); // +1
     }
        buffer[size] = item; //+ 1
        size++; // +2
    }
    /**
     * Add an item at specified index (position).
     * RunTime analysis: is constant or O(1) there are no loops
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if(i < 0){ // +1
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if(size == buffer.length){ // + 1
            buffer[i+1] = buffer[i]; // + 2
        }
        buffer[i] = item; // +1
        size++; // +2
    }
    /**
     * Get the item at a specified index.
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        return buffer[i];
    }
    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * RunTime analysis: O(1) constant no loops worst case constant
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if (size == buffer.length) {
            resize(size + 2);
        }
       E removed = buffer[i];
       buffer[i] = item;
       size++;
    }
    /**
     * Remove item at the front of the list.
     * RunTime analysis: one loop so linear time worse cast O(n)
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        E removed = buffer[0];
        buffer[size - 1] = null;
        size--;
        return removed;
    }
    /**
     * Remove item at the back of the list
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
       E removed = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        return removed;
    }
    /**
     * Remove item from the list
     * RunTime analysis: nested loop worse cast O(n^2)
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if(item.equals(buffer[i])){
                for (int j = i; j < size; j++) {
                    if(size == buffer.length){
                        resize(size * 2);
                    }
                    buffer[j] = buffer[j + 1];
                }
                size--;
                i--;
            }
        }
    }
    /**
     * Remove item at a specified index.
     * RunTime analysis: one loop so linear time worse cast O(n)
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if (i < 0){
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if(i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        E removed = buffer[i];
        for (int j = i; j <= size-1 ; j++) {
            buffer[i] = buffer[1 + i];
        }
        buffer[size - 1] = null;
        return removed;
    }
    /**
     * Checks if an item is in the list.
     * RunTime analysis: one loop so linear time worse cast O(n)
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if(item.equals(buffer[i])){
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if the list is empty.
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Provides a count of the number of items in the list.
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return number of items in the list
     */
    @Override
    public int size() {
        if(size < 0){
            throw new IndexOutOfBoundsException("size can not be negative");
        }
        return size;
    }
    /**
     * RunTime analysis: one loop so linear time worse cast O(n)
     * resizes array when the array is full and copy over previous array
     * */
    private void resize(int newSize){
        // create a new space separate from the old buffer
        E[] temp =  (E[]) new Object[(int) newSize];
        // copy everything over from the buffer into new buffer
        for (int i = 0; i < buffer.length; i++) {
            temp[i] = buffer[i];
        }
        // reassign temp data back to buffer with bigger array
        buffer = temp;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        ArrayList theIterator = new ArrayList();
        return (Iterator<E>) theIterator;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", buffer=" + Arrays.toString(buffer) +
                '}';
    }
}
