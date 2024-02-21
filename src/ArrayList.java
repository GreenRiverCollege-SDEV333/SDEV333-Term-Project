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
     * Runtime:
     *
     * At best O(1) - The list is empty and no shifting is needed.
     *
     * At worst O(N) - We need to visit every element and reassign it
     * to the next empty spot.
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
     * Runtime: O(1) - We can instantly access the end of the list
     * using the size variable. Each line of code executes in
     * one operation.
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
     * Runtime:
     *
     * At best O(1) - The list is empty and no shifting is needed.
     * Just add to the front.
     *
     * At worst O(N) - In order to add the item, we need to
     * shift every element to the right first to make an
     * empty spot. Therefore, we may need to shift a significant chunk
     * of the list.
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
     * Runtime: O(1) - No elements other than the
     * one at the given index need to be visited.
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
     * Runtime: O(1) - No elements other than the one
     * at the given index need to be visited and replaced.
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
     * Runtime: O(N) - We have to shift the entire list to the left
     * when we remove the item at the front.
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

        // save item that will be removed
        E removedItem = buffer[0];

        // shift all elements to the left
        for (int i = 0; i < size; i++)
        {
            buffer[i] = buffer[i + 1];
        }
        // decrease the size
        size--;

        return removedItem;
    }

    /**
     * Remove item at the back of the list
     *
     * Runtime: O(1) - No elements other than the one
     * at the given index need to be visited and removed.
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

        // save item that will be removed
        E removedItem = buffer[size - 1];

        // reassign the end to null
        buffer[size - 1] = null;

        // decrease the size
        size--;

        return removedItem;
    }

    /**
     * Remove item from the list
     *
     * Runtime:
     *
     * At best O(1) - The list is empty and no shifting is needed.
     *
     * At worst O(N) - We need to visit every element regardless of
     * if the item exists in the list. Once the item is found
     * we need to shift all elements over to the left starting
     * from the current index.
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
     * Runtime:
     *
     * At best O(1) - The list is empty and no shifting is needed to remove
     * an item.
     *
     * At worst O(N) - We only need to access the element through
     * the index - no visiting needed. Once the item is found though,
     * we need to shift all elements over to the left starting
     * from the current index.
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
     * Runtime: O(N) - We need to visit every element regardless of
     * if the item exists in the list.
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
     * Runtime: O(1) - We just need to compare the size variable to return
     * a boolean. No traversal or access to the ArrayList needed.
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
     * Runtime: O(1) - The size is being tracked in all methods that involve
     * changing the ArrayList. We just need to return the size variable.
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
     * Runtime: O(1) - Each line of code in the method executes in one operation,
     * regardless of the size of the ArrayList.
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
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the ArrayList.
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
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the ArrayList.
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
