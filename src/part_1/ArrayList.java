package part_1;

import interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements the ArrayList data structure.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class ArrayList<E> implements List<E>
{
    //fields
    private int size;
    private E[] buffer;
    private static final int INITIAL_SIZE = 10;

    /**
     * Constructor for part_1.ArrayList class.
     */
    public ArrayList()
    {
        this.size = 0;
        this.buffer = (E[]) new Object[INITIAL_SIZE];
    }

    /**
     * Add item to the front.
     * Time complexity: O(n)
     * This method at its worst test-case, has to visit each index.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        //check arraylist size
        resize();

        //shift all indices up one
        //copy contents of the original array, but insert starting at index 1
        //this will leave index 0 and index 1 identical, allowing for insertion of item at index 0
        System.arraycopy(buffer, 0, buffer, 1, size);

        //set index 0 to item
        buffer[0] = item;

        //increment size
        size++;
    }

    /**
     * Add item to the back.
     * Time complexity: O(1)
     * This method does a simple insertion in the back of the arraylist.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        //check arraylist size
        resize();

        //set back index to item
        buffer[size] = item;

        //increment size
        size++;
    }

    /**
     * Add an item at specified index (position).
     * Time complexity: O(n)
     * This method will always run at O(n) unless an exception is thrown. Each index much be accessed and/or reassigned.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item)
    {
        //check arraylist size
        resize();

        //check if index is out of bounds
        if(i < 0 || i > size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        else if(i == 0)
        {
            addFront(item);
        }
        else
        {
            //reassign indices after specified index
            System.arraycopy(buffer, i, buffer, i + 1, size - i);

            //assign item to specified index
            buffer[i] = item;

            //increment size
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     * Time complexity: O(1)
     * Retrieving an element (accession) from the arraylist is of constant time.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i)
    {
        //check if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //return desired index
        return buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * Time complexity: O(1)
     * Assigning an index of the arraylist is of constant time.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item)
    {
        //check if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //set item to desired index
        buffer[i] = item;
    }

    /**
     * Remove item at the front of the list.
     * Time complexity: O(n)
     * This method will always run at O(n) unless an exception is thrown. Each index much be accessed and/or reassigned.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        //cannot remove from empty arraylist
        if(size == 0)
        {
            throw new NoSuchElementException("part_1.ArrayList is empty");
        }

        //save item to be removed
        E removedItem = buffer[0];

        //delete first index of arraylist
        System.arraycopy(buffer, 1, buffer, 0, size - 1);

        //decrement size
        size--;

        //return removed item
        return removedItem;
    }

    /**
     * Remove item at the back of the list
     * Time complexity: O(1)
     * Assigning the last index in the arraylist is of constant time.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        //cannot remove from empty arraylist
        if(size == 0)
        {
            throw new NoSuchElementException("part_1.ArrayList is empty");
        }

        //save back item to return
        E removedItem = buffer[size - 1];

        //set last index to null
        buffer[size - 1] = null;

        //decrement size
        size--;

        //return removed item
        return removedItem;
    }

    /**
     * Remove item from the list
     * Time complexity: O(n)
     * This method will always run at O(n) unless an exception is thrown. Each index much be accessed and/or reassigned.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        for (int i = 0; i < size; i++)
        {
            if (item.equals(buffer[i]))
            {
                //copy remainder of array starting at index removed
                System.arraycopy(buffer, i + 1, buffer, i, size - i - 1);

                //set last index to null
                buffer[size - 1] = null;

                //decrement size
                size--;

                //exit loop
                return;
            }
        }

        //throw exception if item not in list
        throw new IllegalArgumentException("Item not in list");
    }

    /**
     * Remove item at a specified index.
     * Time complexity: O(n)
     * This method will always run at O(n) unless an exception is thrown. Each index much be accessed and/or reassigned.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i)
    {
        //check if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        //save item to remove
        E removedItem = buffer[i];

        //copy remainder of array starting at index removed
        System.arraycopy(buffer, i + 1, buffer, i, size - i - 1);

        //set last index to null
        buffer[size - 1] = null;

        //decrement size
        size--;

        //return removed item
        return removedItem;
    }

    /**
     * Checks if an item is in the list.
     * Time complexity: O(n)
     * This method has the worst test-case of accessing every index.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        //iterate through arraylist and check each index for item
        for(int i = 0; i < buffer.length; i++)
        {
            if(buffer[i] != null && buffer[i].equals(item))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the list is empty.
     * Time complexity: O(1)
     * Running a comparison operation and returning a boolean is of constant time.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * Time complexity: O(1)
     * Returning a field is of constant time.
     *
     * @return number of items in the list
     */
    @Override
    public int size()
    {
        return size;
    }

    //Resize arraylist as needed
    //Create a new arraylist double the length, copy contents of buffer, then copy to buffer
    private void resize()
    {
        if(buffer.length == size)
        {
            E[] newBuff = (E[]) new Object[size * 2];
            System.arraycopy(buffer, 0, newBuff, 0, size);
            buffer = newBuff;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ArrayListIterator();
    }

    //private helper class for iterator
    private class ArrayListIterator implements Iterator<E>
    {
        private int i;

        private ArrayListIterator()
        {
            this.i = 0;
        }

        @Override
        public boolean hasNext()
        {
            return i < size;
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("i is out of bounds");
            }

            E curr = buffer[i];
            i++;
            return curr;
        }
    }
}
