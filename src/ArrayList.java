import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>
{
    private E[] buffer;
    private int size;

    public ArrayList()
    {
       buffer = (E[]) new Object[10];
       size = 0;
    }
    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        //start at 0, stop at the last element, increment by one
        for (int i = size - 1; i >= 0; i--)
        {
            //shift over to the right
            buffer[i + 1] = buffer[i];
        }
        // put the value at th front of the array
        // and increment the size
        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        // access the buffer at index size
        // and assign item to this index
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
    public void add(int i, E item)
    {
        // jump to the end of the array and shift the elements over
        // to the right
        for (int j = size - 1; j >= i; j--)
        {
            // at the next index = current index
            buffer[j + 1] = buffer[j];
        }
        // assign the item at the index
        buffer[i] = item;
        // increase size
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i)
    {
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
        if (i >= buffer.length)
            throw new IndexOutOfBoundsException("The index is larger than the" +
                    "size of the list");

       return buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item)
    {
        if (size == 0)
        {
          buffer[i] = item;
          size++;
        }

        if (i >= buffer.length)
            throw new IndexOutOfBoundsException("The index is larger than the" +
                    "size of the list");

        buffer[i] = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The list is empty");
        }

        return buffer[0];
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The list is empty");
        }

        return buffer[size - 1];
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The list is empty");
        }

        // get to the specific index to where the item is
        // via iterating an index variable
        int index = 0;
        while (buffer[index] != item)
        {
            index++;
            if (index >= buffer.length)
            {
                throw new IndexOutOfBoundsException("The element does" +
                        "not exist");
            }
        }

        // shift elements over to the left using the index
        // increase until we get to
        for (int i = index; i <= size - 1; i++)
        {
            // buffer[1] = buffer[2]
            buffer[i] = buffer[i + 1];
        }
        // decrease the size
        size--;
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i)
    {
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
        if (i >= buffer.length || i >= size)
            throw new IndexOutOfBoundsException("The index is larger than the" +
                    "size of the list");

        // assign the item at the given index to a variable
        E itemRemoved = buffer[i];

        // shift elements over to the left using the index
        // increase until we get to
        for (int j = i; j <= size - 1; j++)
        {
            // buffer[1] = buffer[2]
            buffer[j] = buffer[j + 1];
        }
        // decrease the size
        size--;

        return itemRemoved;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        if (size == 0)
            throw new IndexOutOfBoundsException("The list is empty");

        for (int i = 0; i < size; i++)
        {
            if (buffer[i].equals(item))
                return true;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
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
     *
     * @return number of items in the list
     */
    @Override
    public int size()
    {
        return size;
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

    private class ArrayListIterator implements Iterator<E>
    {
        private int i;

        public ArrayListIterator()
        {
            i = 0;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            return i < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next()
        {
            if (i >= size)
            {
                throw new NoSuchElementException("i is now out of bounds");
            }
            E currentValue = buffer[i];
            i++;

            return currentValue;
        }
    }

}
