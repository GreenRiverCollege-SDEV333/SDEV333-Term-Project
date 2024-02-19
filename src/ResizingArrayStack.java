import java.util.Iterator;

/**
 * Creates a resizing array stack object. Has the ability to add and remove items,
 * peek at the top item, and view the size and status of if the linked stack is
 * empty.
 * @author Sage Bain
 * @param <E>
 */
public class ResizingArrayStack<E> implements Stack<E>{
    private E[] buffer;
    private int size;

    public ResizingArrayStack()
    {
        buffer = (E[])new Object[1];
        size = 0;
    }

    /**
     * This method will always run at O(n) because we are manually copying
     * all items over from the original buffer to a new buffer.
     * @param max
     */
    private void resize(int max)
    {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Worst case scenario, this method will run at O(n) if we need to resize
     * the buffer due to it being at max capacity. Best case scenario,
     * this method runs at constant time due to being able to insert the new
     * item at the end of the buffer in a single statement.
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    { // Add item to top of stack.
        if (size == buffer.length) {
            resize(buffer.length*2);
        }
        buffer[size++] = item;
    }

    /**
     * Worst case scenario, this method will run at O(n).
     * This is because if the method detects the buffer is using only 1/4
     * of its capacity, it will resize itself down by 1/2 of its original
     * capacity. Best case scenario, this will run at constant time.
     * @return
     */
    @Override
    public E pop()
    { // Remove item from top of stack.
        E item = buffer[--size];
        buffer[size] = null; // Avoid loitering
        if (size > 0 && size == buffer.length/4) {
            resize(buffer.length/2);
        }
        return item;
    }

    /**
     * This will always run at constant time since it simply returns
     * the item located at buffer index 0.
     * @return
     */
    @Override
    public E peek()
    {
        return buffer[size-1];
    }

    /**
     * This will always run at constant time since it simply returns
     * true or false based on if size is equal to 0.
     * @return
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * This will always run at constant time since it simply returns the
     * value of size.
     * @return
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     *
     * @return a new ListIterator
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E>
    {
        private int i = size;
        public boolean hasNext()
        {
            return i > 0;
        }
        public E next()
        {
            return buffer[--i];
        }
        public void remove()
        {

        }
    }
}
