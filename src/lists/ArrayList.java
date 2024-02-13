/**
 * Abstract arrayList methods
 * @author Lillian Nelson
 * @version 1.0
 */
package lists;

import java.util.*;
import java.util.List;


public class ArrayList<E> implements List<E>
{
    //fields:
    private int size;
    private E[] buffer;

    //constructor
    public ArrayList()
    {
        //initialize variables
        size = 0;
        this.buffer = (E[]) new Object[10];
    }

    /**
     * inserts the specified value at the front of the list
     * Shifts the value currently at the front of the list
     * 0(n) linear time to loop over an array
     *
     * @param value to be inserted
     */
    public void addFront(E value)
    {
        if (size == buffer.length)
        {
            resize(size * 2);
        }
        for (int i = size; i > 0; i--)
        {
            buffer[i] = buffer[i - 1];
        }

        buffer[0] = value;
        size++;
    }

    /**
     * inserts the specified value at the back of the list
     * O(1) constant time accessing an index of an array
     *
     * @param value to be inserted
     */
    public void addBack(E value)
    {
        if (size == buffer.length)
        {
            resize(size * 2);
        }
        buffer[size] = value;
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * 0(n) linear time to loop through array
     *
     * @param index the place selected
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E value)
    {
        if (size == buffer.length)
        {
            resize(2);
        }
        for (int i = size + 1; i > 0; i--)
        {
            buffer[i + 1] = buffer[i];
        }
        buffer[index] = value;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * 0(n) linear time to loop through array
     */
    public E removeFront()
    {
        if (!isEmpty())
        {
            E head = null;
            for (int i = 0; i <= size - 2; i++)
            {
                head = buffer[i];
                buffer[i] = buffer[i + 1];
            }
            size--;
            return head;
        }

        return null;
    }

    /**
     * Removes the value located at the back of the list
     * O(1) constant time accessing an index of an array
     */
    public E removeBack()
    {
        if (size != 0)
        {
            E head = buffer[size];
            buffer[size] = null;
            size--;
            return head;
        }
        return null;
    }

    /**
     * Remove item at a specified index.
     * 0(n) linear time to loop through array
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index)
    {
        //validate index
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index cannot be greater than size");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Index cannot be less than zero");
        }

        E copyOfRemoveValue = buffer[index];

        for (int i = index; i <= size - 1; i++)
        {
            buffer[i] = buffer[i + 1];
        }

        buffer[size - 1] = null;

        size--;

        return copyOfRemoveValue;
    }


    /**
     * Returns the value at the specified position in the list.
     * O(1) constant time accessing an index of an array
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index)
    {
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index cannot be greater than size");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Index cannot be less than zero");
        }

        return buffer[index];
    }
    /**
     * Returns true if this list contains the specified value.
     * * 0(n) linear time to loop through array
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    public boolean contains(Object value)
    {
        for (int i = 0; i < size; i++)
        {
            if (buffer[i] == value)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     * * 0(n) linear time to loop through array
     *
     * @param value value to search for
     * @return the index of the first occurrence of value
     */
    public int indexOf(Object value)
    {
        for (int i = 0; i < size; i++)
        {
            if (buffer[i] == value)
            {
                return i;
            }
        }

        return -1;
    }
    /**
     * Returns true if this list contains no values.
     * O(1) constant time?
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     * O(1) constant time?
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     * O(1) constant time
     */
    @Override
    public void clear()
    {
        //created a new array
        buffer = (E[]) new Object[10];

        size = 0;

    }
    /**
     * takes array and creates a new one to make more space
     * 0(n) linear time to loop through array
     *
     * @param newSize bigger array
     */

    private void resize(int newSize)
    {
        //create new space, separate from the old(buffer)
        E[] newBuffer = (E[]) new Object[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++)
        {
            newBuffer[i] = buffer[i];
        }

        //set the new space into buffer
        buffer = newBuffer;
        //old space is no longer "pointed to" and will be cleaned by the garbage collector
    }

    /**
     * Returns an iterator over elements of type E
     * 0(1) constant time returning iterator
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
        //private fields
        private int i;

        private ArrayListIterator()
        {
            i = 0;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
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
            if (i > size)
            {
                throw new NoSuchElementException("i is out of bounds");
            }
            E currentValue = buffer[i];
            i++;
            return currentValue;
        }
    }


    //added by java
    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public E set(int index, E element)
    {
        return null;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator()
    {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean add(E e)
    {
        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }
}