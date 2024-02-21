import java.util.Iterator;

/**
 * The ResizingArrayStack is an implementation of the Stack API
 * is a model for collection ADTs that keep items in an array.
 * It resizes the array to keep the array size within a constant
 * factor of the stack size
 *
 * @author Will Castillo
 * @param <E> data type of the items in the stack
 */
public class ResizingArrayStack<E> implements Stack<E>
{
    private E[] buffer; // stack items
    private int size;

    /**
     * Constructor for class that
     * initializes the buffer and size fields
     */
    public ResizingArrayStack()
    {
         buffer = (E[]) new Object[1];
         size = 0;
    }

    /**
     * Checks to see if the ResizingArrayStack is empty.
     * @return true if the stack is empty, false otherwise
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just compares the size to 0 (which is being tracked in the pop and
     * push methods). No access to stack array is needed.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the ResizingArrayStack.
     * @return the number of items in the stack
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * No access to stack array is needed. Just returns the variables.
     *
     */
    public int size()
    {
        return size;
    }

    private void resize(int max)
    {   // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++)
        {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Add an item to the ResizingArrayStack.
     * @param item the item to be added
     *
     * Runtime: O(N) - If we need to create a larger stack
     * then the runtime will be linear. In the private helper
     * method, we have to loop and visit through the entire stack
     * and place it into a temporary array.
     */
    public void push(E item)
    {   //Add item to top of stack
        if (size == buffer.length)
        {
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * @return the item that was removed
     *
     * Runtime:
     *
     * Worst case: O(N) - If we need to create a larger stack
     * then the runtime will be linear. In the private helper
     * method, we have to loop and visit through the entire stack
     * and place it into a temporary array
     *
     * Best case: O(1) - This method only executes the fixed number of steps.
     * Just remove the item and return it.
     */
    public E pop()
    {   // remove item from top of stack
        E item = buffer[size];
        size--;
        buffer[size] = null; // avoid loitering
        if (size > 0 && size == buffer.length/4)
        {
            resize(buffer.length/2);
        }
        return item;
    }

    /**
     * Returns the item at the top of the ResizingArrayStack.
     * Does not modify the stack or the item at the top.
     * @return item at the top of the stack.
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * We just need to access one item in the buffer.
     */
    public E peek()
    {
        return buffer[size - 1];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Runtime: O(1) - Each line of code in the method executes in one operation,
     * regardless of the size ArrayStack
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E>
    {   // support LIFO iteration
        private int i = size - 1;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the ArrayStack.
         *
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext()
        {
            return i >= 0;
        }

        /**
         * Returns the next element in the iteration and advances the iterator.
         *
         * @return the next element in the iteration
         *
         * Runtime: O(1) -  Each line of code in the method executes in one operation,
         * regardless of the size of the ArrayStack. Just needs to access one index.
         */
        public E next()
        {
            return buffer[i--];
        }

        /**
         * Removes the last element returned by this iterator. This
         * method is not implemented in this iterator.
         *
         * Runtime: O(N) - removing a specific element requires traversing
         * the list until the element is found
         */
        public void remove()
        {

        }
    }

}
