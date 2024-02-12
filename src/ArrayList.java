import java.util.Iterator;

/**
@author Leah Konma
@version 1.0
Implements the List<E> interface
 */
public class ArrayList<E> implements List<E>{
    private int size;
    private E[] buffer;

    public ArrayList(){
        this.size = 0;
        this.buffer = (E[])new Object[10];
    }

    /**
     * Add item to the front.
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        //shifts all items to the right
        for (int i = size; i >= 1 ; i--) {
            buffer[i] = buffer[i-1];
        }

        //add the new item to the front
        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        //adds the item to the back (size)
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size || size == 0){
            throw new IndexOutOfBoundsException("Invalid index");
        }else{
            //start at back and go to index
            for (int i = size; i > index; i--) {
                buffer[i] = buffer[i-1];
            }

            buffer[index] = item;
        }

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
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }else{
            for (int j = 0; j <= size; j++) {
                if (j == i){
                    return buffer[i];
                }
            }
        }
        return null;
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
        return null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {

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
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
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
