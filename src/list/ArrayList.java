package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * an list.ArrayList data structure remake
 * @param <E> any type of data
 */

public class ArrayList <E> implements List<E> {
//    fields

    //fields
    private int size;
    private E[] buffer;

//    constructor
    public ArrayList ()
    {
        size = 0;
//       buffer = new buffer <E> [10]
        buffer = (E[]) new Object[10];
    }
    /**
     * runtime O(1)
     * this will run in a linear notation it will go through every item one by one
     * this will make the size of the array to a certain size.
     * @param newSize
     */
    private void resize (int newSize)
    {

        //create a temporary new array with the new size.
        E[] tempBuffer = (E[]) new Object[newSize];

        //copy everything over from buffer into newbuffer.
        for (int i = 0; i < buffer.length; i++) {
            tempBuffer[i] = buffer[i];
        }

        // set the new temp array as the main array .
        buffer  = tempBuffer;
    }
    /**
     * runtime o(1)
     * this will use the resize method and multiple it by 2, which will be the same function.
     * this method will check if the size is equal to the buffer.length,
     * if it is equal to buffer length, it will double the size.
     */
    private void fullSize()
    {
        if(size >= buffer.length)
        {
            resize(size * 2 );
        }
    }
    /**
     * Add item to the front.
     * runtime o(n)
     * this method will have to shift go to every indexes till reaches the end,
     * and shift all of the elements in to the left.
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        //check if the size is full, if so, make it resize.
        fullSize();
        //if the array is empty
        if (size != 0) {
            //move all the values over to one index.
            for (int i = size; i >= 1; i--) {
                buffer[i] = buffer[i - 1];
            }
            // put the value at the front of the array of position 0 ;
        }
        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     * runtime o(1)
     * This method will find the back element and add it to the back,
     * no need to go through each element.
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        fullSize();

        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * runtime: o(n)
     * This method will have to find a certain index,
     * after finding the index, shifts all the element to the right,
     * add the element to that specific element.
     *
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index , E item)
    {
        fullSize(); // this will check if the array is full, if it is, it will resize into a bigger array
        // let say we want to add 22 to index 3
        if(size == 0 )
        {
            index = 0;
            buffer[index] =item;
            size++;

        } else if(index > size || index < 0 )
        {
            throw new IndexOutOfBoundsException(" The index is out of bound bruh...");

        }
        else if(index == 0 )
        {
            for (int i = size; i >= 1 ; i--) {
                buffer[i] = buffer[i-1];
            }
            buffer[0] = item;
            size++;
        }
        else {

            for (int i = size; i >= index; i--) {
                buffer[i] = buffer[i - 1];
            }
            buffer[index] = item;
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * runtime: o(1)
     * This method will access all the element and find the certain element
     * at the specific index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index)
    {
        if(index > size)
        {
            throw new IndexOutOfBoundsException("The index is more than the size. ");
        }else if(index < 0 )
        {
            throw new IndexOutOfBoundsException("Index is less than 0, it can not be less than 0");
        }
        else{
            return buffer[index];
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Runtime: o(1)
     * This will find a certain element at a specific index and change the value of it.
     *
     * @param index    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index , E item)
    {
        if(index > size)
        {
            throw new IndexOutOfBoundsException("The index is more than the size. ");
        }else if(index < 0 )
        {
            throw new IndexOutOfBoundsException("Index is less than 0, it can not be less than 0");
        }
        else{
            buffer[index] = item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * Runtime: o(n)
     * remove the front element, after that
     * it will go through all of the elements and shift
     * it to the left.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        // get the index of front which will be buffer[0]
        E temp = buffer[0];
        if(size == 0 )
        {
            throw new NoSuchElementException(" The array is empty... ");
        }
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i+1];
        }
        size--;
        return temp;
    }

    /**
     * Remove item at the back of the list
     *
     * runtime: o(1)
     * this method will get the last index,
     * and remove it
     * without having to scan through all of the elements.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        //set the back value as 0
        if(size == 0)
        {
            throw new NoSuchElementException("The array is empty... ");
        }
        E temp = buffer[size - 1];
        buffer[size- 1] = null;
        size--;
        return temp;
    }

    /**
     * Remove item from the list
     *
     * Runtime: o(n)
     * find element that matches the parameters, after removing
     * the element, it will have to shift all of the remaining elements
     * to the left.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        int index = -1;
        if(size == 0)
        {
            throw new NoSuchElementException("The array is empty... ");
        }
        for (int i = 0; i < buffer.length; i++) {
            if(item.equals(buffer[i]))
            {
                index = i ;
            }

        }
        if(index != -1) {
            if (index == 0) {
                removeFront();
            } else if (index == (size - 1)) {
                removeBack();
            } else {
                for (int j = index; j < size - 1; j++) {
                    buffer[j] = buffer[j + 1];
                }
                size--;
            }
        }

    }

    /**
     * Remove item at a specified index.
     *
     * runtime: o(n)
     * it will search for a specific index,
     * after finding the index, it will delete the element
     * which will have to shift all the remaining elements.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index)
    {
        if(index >= size)
        {
            throw new IndexOutOfBoundsException("invalid index");
        }else if( index < 0)
        {
            throw new IndexOutOfBoundsException("index cannot be negative");
        } else if (size == 0 ) {
            throw new NoSuchElementException("The list is empty ");
        }

        // save a copy of value .
        E copyOfRemovedValue = buffer[index];

        //shift value to left
        for (int i = index; i < size ; i++) {
            buffer[i] = buffer[i+1];
        }
        buffer[size - 1] = null;

        //decrement size
        size--;

        return copyOfRemovedValue;
    }

    /**
     * Checks if an item is in the list.
     *
     * runtime: o(n)
     * this method will search through all of the element until
     * it matches the element that it is looking for.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        //it will use loop to search for the value
        if(size == 0 )
        {
            throw new NoSuchElementException(" The list is empty. ");
        }else {

            for (int i = 0; i < size; i++) {
                if (buffer[i] == item) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Checks if the list is empty.
     * runtime o(1)
     * this method will only require to check true or false base on the size
     * which does not require to shift any element.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0 )
        {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Provides a count of the number of items in the list.
     *
     * runtime: o(1)
     * This will only give a return of a variable,
     * no more than that so it will run in constant time
     *
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
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>
    {
        //private fields

        private int i ;
        //constructor.
        private ListIterator ()
        {
            i = 0 ;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(i >= size)
            {
                throw new NoSuchElementException("i is now out of bounds");
            }
            E currentValue  = buffer[i];
            i++;
            return currentValue;
        }
    }
}
