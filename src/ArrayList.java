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
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
       if(size == buffer.length){
           resize(buffer.length * 2);
       }
        for (int i = size - 1; i >= 0; i--) {
            buffer[i+1] = buffer[i];
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
    public void addBack(E item) throws IllegalArgumentException{
     if(size == buffer.length){
         resize(size * 2);
     }
        buffer[size] = item;
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
        if(i < 0){
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if(size == buffer.length){
            buffer[i+1] = buffer[i];
        }
        buffer[i] = item;
        size++;
    }
    /**
     * Get the item at a specified index.
     *
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
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     * @return E item that was removed
     */
    @Override
    public E set(int i, E item) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if (size == buffer.length) {
            resize(size + 2);
        }
       E removed = buffer[i];
       buffer[i] = item;
       size++;
       return removed;
    }
    /**
     * Remove item at the front of the list.
     *
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
     *
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
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if(item.equals(buffer[i])){
                for (int j = i; j < size; j++) {
                    buffer[j] = buffer[j + 1];
                }
                size--;

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
     *
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
        if(size < 0){
            throw new IndexOutOfBoundsException("size can not be negative");
        }
        return size;
    }

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
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        ArrayList theIterator = new ArrayList();
        return (Iterator<E>) theIterator;
    }

    private class ArrayListIterator implements Iterable<E>{
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
    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", buffer=" + Arrays.toString(buffer) +
                '}';
    }
}
