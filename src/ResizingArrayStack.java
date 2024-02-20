import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack <E> implements Stack <E> {
//    fields
    private E[] items;
    private int size;
//    constructor
    public ResizingArrayStack()
    {
        items = (E[]) new Object[10];
        size = 0;
    }
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
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return items[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
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
