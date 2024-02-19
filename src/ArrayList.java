import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List
{
    //private fields
    private E[] buffer;
    private int size;

    public ArrayList ()
    {
        size = 0;
        buffer = (E[])new Object[10];
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(Object item)
    {
        //resizing the array if needed
        if (size >= (buffer.length * 2))
        {
            resize(size * 2);
        }

        //scooting the indexes over as needed
        if (!isEmpty())
        {
            for (int i = size - 1; i > -1; i--)
            {
                buffer[i + 1] = buffer[i];
            }

            //put the value at position 0
            buffer[0] = (E)item;
            size++;
        }
        else
        {
            //if the list is empty, just add the item to the front.
            buffer[0] = (E)item;
            size++;
        }
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(Object item)
    {
        //resizing the array if needed
        if (size >= (buffer.length * 2))
        {
            resize(size * 2);
        }
            buffer[size] = (E)item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, Object item)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException("Provided index outside ArrayList bounds");
        }

        if (i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported");
        }

        //resizing the array if needed
        if (size >= (buffer.length * 2))
        {
            resize(size * 2);
        }

        //shuffling stuff over if the current index isn't empty
        if (buffer[i] != null)
        {
            for (int j = size - 1; j > -1; j--)
            {
                buffer[j + 1] = buffer[j];
            }
        }

        //inserting the value at the index
        buffer[i] = (E)item;
        size++;
    }

    private void resize(int newSize)
    {
        //create a new space, separate from the old one
        E[] newBuffer = (E[])new Object[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < size; i++)
        {
            newBuffer[i] = buffer[i];
        }

        //set the new space into buffer
        buffer = newBuffer;

        //the old buffer space is no longer "pointed to" and will eventually be cleaned up by the
        //garbage collector
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public Object get(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException("Provided index outside ArrayList bounds");
        }
        else if (i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported");
        }
        else
        {
            return buffer[i];
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, Object item)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException("Provided index outside ArrayList bounds");
        }
        else if (i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported");
        }
        else
        {
            buffer[i] = (E)item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public Object removeFront()
    {
        return remove(0);
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public Object removeBack()
    {
        return remove(size - 1);
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(Object item)
    {
        //check if the list is empty first
        if(isEmpty())
        {
            System.out.println("List is empty. Nothing to remove");
        }

        //if it isn't empty, this loop will remove the first occurrence of the item, assuming the item appears multiple
        //times in the array.
        for (int i = 0; i < size; i++)
        {
            if (buffer[i].equals(item))
            {
                buffer[i] = null;
                size--;
                break;
            }
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public Object remove(int i)
    {
        //check if the list is empty first
        if(isEmpty())
        {
            System.out.println("List is empty. Nothing to remove");
            return null;
        }
        //check that the provided index isn't out of bounds or negative
        else if(i > size)
        {
            throw new IndexOutOfBoundsException("Provided index is outside ArrayList bounds");
        }
        else if(i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported");
        }
        else
        {
            //store the object in a local variable, overwrite the index, then return the object.
            Object obj = buffer[i];
            buffer[i] = null;
            size--;
            return obj;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(Object item)
    {
        //search through the entire array sequentially
        for (int i = 0; i < size; i++)
        {
            //if a given index is equal to the item being searched for, return true
            if (buffer[i].equals(item))
            {
                return true;
            }
        }
        //if you make it through the entire loop, then it isn't here; return false.
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
        //is the size 0? Yes? Return true. Otherwise, return false.
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
        //return the size variable.
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator()
    {
        return new ArrayListIterator();
    }

    //create a private helper Iterator class
    private class ArrayListIterator implements Iterator<E>
    {
        //private fields
        private int i;

        private ArrayListIterator()
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
                throw new NoSuchElementException("i is out of bounds");
            }

            Object currentValue = buffer[i];
            i++;
            return (E)currentValue;
        }
    }
}
