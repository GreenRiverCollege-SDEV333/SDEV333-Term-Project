package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack <E> implements Stack<E> {
//    fields
    private E[] items;
    private int size;
//    constructor
    public ResizingArrayStack()
    {
        items = (E[]) new Object[10];
        size = 0;
    }

    /**
     *  Runtime: o(n)
     *      * This method will copy the orginal array if it is more size reaches the length of the array.
     *      * this go through all of the element to copy and put it in the array.
     * @param newSize
     */
    private void resize (int newSize)
    {

        //create a temporary new array with the new size.
        E [] tempBuffer = (E[]) new Object[newSize];

        //copy everything over from buffer into newbuffer.
        for (int i = 0; i < items.length; i++) {
            tempBuffer[i] = items[i];
        }

        // set the new temp array as the main array .
        items  = tempBuffer;
    }

    /**
     * Add an item to the stack.
     * Runtime: o(1)
     *      * This method will add the node to the back of the list.
     *      * Since  this is an array list  , it will be constant since you just need the index of the back
     *      and will add the item to it.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if(size == items.length)
        {
            resize(2 * items.length);
        }
        items[size + 1] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *  Runtime: o(1)
     *      *       This method will remove the element in the back of the list.
     *      *       Since  this is an array list  , it will be constant since you just need the index of the back
     *      *      and will remove the item to it.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        E itemRemoved = items[size - 1 ];
        items[size-1] = null;
        size--;
        return itemRemoved;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     *  Runtime: o(1)
     *      *   This method will look for the element in the back of the list.
     *      *   Since  this is an array list  , it will be constant since you just need the index of the back
     *      *   and will look the item to it.
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return items[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * Runtime; o(1)
     * Method will only require the size field to either have a true or false,
     * it will access the size field, if it is more than 0 it will be true,
     * else, it will be false;
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * Runtime: o(1)
     * This method will only check the size field to see what it is stored.
     *
     * @return the number of items in the stack
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
        return new StackIterator();
    }
    private class StackIterator implements Iterator<E>
    {
        //private fields

        private int i ;
        //constructor.
        private StackIterator ()
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
            E currentValue  = items[i];
            i++;
            return currentValue;
        }
    }
}
