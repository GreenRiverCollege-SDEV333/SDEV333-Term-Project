import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E>
{
    //private fields
    private E[] buffer;
    private int size;

    //default constructor
    public ResizingArrayStack()
    {
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Add an item to the stack.
     *
     * Runtime Analysis: Constant time at worst. There is a conditional that
     * runs at the beginning of the method, but there aren't any loops. The
     * conditional is not constantly running, it only checks once. So, much
     * of the work done here does not change speed depending on the size of the
     * stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        //Add item to the top of the stack
        if (size == buffer.length)
        {
            resize(2 * buffer.length);
        }

        buffer[size++] = item; //access the size variable, then increment it after.
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * Runtime Analysis: Constant time at worst. There aren't any loops that
     * have to run, just a few assignments and indexes/variables being
     * accessed.
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        //Remove item from top of stack
        E item = buffer[size - 1];

        buffer[size - 1] = null; //Avoid loitering

        if (size == buffer.length/4)
        {
            resize (buffer.length / 2);
        }
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * Runtime Analysis: Constant time at worst. The method accesses a variable
     * at a given point in an array and returns it. Nothing to multiply the
     * runtime in here.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        return buffer[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * Runtime Analysis: Constant time in the worst case situation.
     * This method accesses a variable, compares its equality to zero, and
     * returns the result. There isn't anything that can be impacted by a
     * larger or smaller amount of data in the structure.
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
     *
     * Runtime Analysis: Worst-case scenario this runs in constant time. All
     * that happens is that the method accesses a variable's value and returns
     * it. These instructions wouldn't be altered if the size of the array was
     * different.
     *
     * @return the number of items in the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    private void resize(int max)
    {
        //Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];

        for (int i = 0; i < size - 1; i++)
        {
            temp[i] = buffer[i];
        }

        buffer = temp;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Runtime Analysis: O(n) at worst. This method creates a new object and
     * returns it; we can't be 100% certain how long the default constructor
     * for an iterator would take, but that is the only major thing happening
     * in this method. Otherwise, the method is just returning the result
     * of the constructor call.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<E>
    {
        //Support LIFO iteration
        private int i = size - 1;

        public boolean hasNext()
        {
            return i >= 0;
        }

        public E next()
        {
            return buffer[i--]; //return the item, then decrement i.
        }

        public void remove()
        {
            //authors left this one empty
        }
    }
}
