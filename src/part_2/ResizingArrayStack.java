package part_2;

import interfaces.Stack;

import java.util.Iterator;

/**
 * Implements the Pushdown (LIFO) Stack data structure.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class ResizingArrayStack<E> implements Stack<E>
{
    //fields
    private E[] buffer;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public ResizingArrayStack()
    {
        this.buffer = (E[]) new Object[INITIAL_SIZE];
        this.size = 0;
    }

    /**
     * Add an item to the stack.
     * Time complexity: O(1)
     * Time is constant due to operations only doing single operations.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        //check size of stack
        if(size == buffer.length)
        {
            resize(2 * buffer.length);
        }

        //add item to stack
        buffer[size] = item;

        //increment size
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * Time complexity: O(1)
     * Time is constant due to single operations.
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        //throw exception if stack is empty, cannot pop an empty stack
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot pop()");
        }

        //save item from top of stack
        E item = buffer[size - 1];

        //decrement size
        size--;

        //delete item from stack
        buffer[size] = null;

        //shrink stack capacity if necessary to save memory
        if(size > 0 && size == buffer.length / 2)
        {
            resize(buffer.length / 2);
        }

        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * Time complexity: O(1)
     * Time is constant because either an exception is thrown or an array index is returned.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        //throw exception if stack is empty, cannot peek an empty stack
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot peek()");
        }

        //return top of stack
        return buffer[0];
    }

    /**
     * Checks to see if the stack is empty.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
     *
     * @return the number of items in the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    //resize method to create more space for list
    private void resize(int newSize)
    {
        if(buffer.length == size)
        {
            E[] newBuff = (E[]) new Object[newSize];
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
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E>
    {
        private int iteratorSize = size;

        public boolean hasNext()
        {
            return iteratorSize > 0;
        }

        public E next()
        {
            return buffer[--iteratorSize];
        }

        public void remove()
        {
            //do nothing
        }
    }
}
