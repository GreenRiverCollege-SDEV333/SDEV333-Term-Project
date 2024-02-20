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
     * Runtime Analysis: O(n) in the worst case. There is a check to determine
     * if the list is empty, but it only runs once. Inside that check if a for
     * loop that has to shuffle every single item over to the next empty space.
     * How many items have to get shuffled is dependent on how large the list
     * is, meaning this method would run in O(n) time complexity at the worst.
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
        }
        //put the value at position 0
        buffer[0] = (E)item;
        size++;
    }

    /**
     * Add item to the back.
     *
     * Runtime Analysis: Constant time in the worst case. This method just
     * resizes the Array if it's getting too full, and then adds an item to the
     * back of the list. No shuffling done, just a rewrite, so the instructions
     * that run shouldn't be dependent on any external factors.
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
     * Runtime Analysis: O(n^2) worst-case There is an if condition that has
     * to evaluate every single up to a given point to determine whether or not
     * it's empty and from there, a for loop will run inside the if statement
     * if a given index isn't empty. In the worst-case scenario, an item will
     * be added to the front of the list, meaning every other item has to be
     * checked to see if it's null and then moved over if it isn't.
     *
     * Each of these operations will be much, much longer if the list has more
     * indexes in it and if the user selects a low index to insert into.
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
     * Runtime Analysis: Constant time in a worst-case scenario. Each branch
     * within the if/else tree only has a few instructions, none of which are
     * dependent on the size of the array or the data provided to the
     * structure.
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
     * Runtime Analysis: Constant time at worst. There's a few conditionals,
     * but the runtime of the method doesn't change based on any factors
     * outside the method's control; each condition has a set number of
     * instructions to be performed.
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
     * Runtime Analysis: O(n) in a worst-case scenario. This method calls
     * another method, remove(int i), and having written that method myself I
     * already know that it runs in O(n) time complexity; this method doesn't
     * complicate things much more, it just calls that method and provides
     * a parameter.
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
     * Runtime Analysis: O(n) in a worst-case scenario. This method calls
     * another method, remove(int i), and having written that method myself I
     * already know that it runs in O(n) time complexity; this method doesn't
     * complicate things much more, it just calls that method and provides
     * a parameter.
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
     * Runtime Analysis: O(n) in a worst-case scenario. The for loop has to
     * search through the array for a provided value, and in the worst case it
     * will need to search through every index for the value. How long this
     * takes is dependent on the size of the ArrayList itself.
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
     * Runtime Analysis: Constant time; O(9) I think? There's quite a few
     * instructions in one of the branches of this method's control flow, but
     * even then the method doesn't really increase in time complexity based
     * on the size of the array due to the nature of ArrayLists. Every item is
     * indexed, so it's fairly quick to access a given index.
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
            return "List is empty. Nothing to remove";
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
     * Runtime Analysis: O(n) in a worst-case scenario. There's a for loop that
     * has to search through the items in the ArrayList; in a worst-case
     * situation, it has to search every item in the list. As a result, the
     * runtime of this method is dependent on the size of the structure it's
     * called on. O(n).
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
     * Runtime Analysis: Constant time. Maybe O(3) if you wanted specifics?
     * The only value that has to be accessed is a global variable, and
     * after the variable has been accessed it's compared against 0. From
     * there, the result of this computation is returned. Nothing too complex.
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
     * Runtime Analysis: Constant time in a worst-case scenario.
     * All this method does is access a variable and return it. The same two
     * instructions each method call, nothing more.
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
     * Runtime Analysis: Constant time or O(2), maybe O(3) in a worst-case
     * situation. This method returns a new object which was in turn returned
     * from another method. No loops, no control flow, nothing else.
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
