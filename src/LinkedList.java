import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List
{
    //define what a node is
    private class Node
    {
        Object data;
        Node next;
    }

    //set up the head of the list
    private Node head;

    //set up the size field
    private int size;

    //constructor
    public LinkedList()
    {
        size = 0;
    }


    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(Object item)
    {
        add(0, item);
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(Object item)
    {
        add(size, item);
//        //set up a new node
//        Node theNewOne = new Node();
//        theNewOne.data = item;
//
//        //the list currently has nodes in it
//        if (head != null)
//        {
//            //getting an iterator set up
//            LinkedIterator iterator = new LinkedIterator();
//
//            //as long as there's another node, scoot the iterator forward along the list.
//            while (iterator.current.next != null)
//            {
//                iterator.current = iterator.current.next;
//            }
//            if (iterator.current.next == null)
//            {
//                iterator.current.next = theNewOne;
//                size++;
//            }
//
//            //if the iterator can't move forward, then put the new Node into that empty space.
//            if (!iterator.hasNext())
//            {
//                iterator.current = theNewOne;
//                size++;
//            }
//        }
//        else
//        {
//            //if the list is empty, point head at the new node
//            head = theNewOne;
//            size++;
//        }
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
        Node theNewOne = new Node();
        theNewOne.data = item;

        // MAKE ONE SOLID ADD METHOD AND REPURPOSE IT FOR ADDFRONT AND ADDBACK

        if (isEmpty())
        { //if the list is empty, make a new node, point the head at it, increment the size and cut it off from there.
            head = theNewOne;
            size++;
            return;
        }

        //if the index is 0 but the list isn't empty...
        if (i == 0)
        {
            //store the old first node
            Node theOldOne = head;

            //scoot the new first node in front of the old one wire up the new one to the old one
            head = theNewOne;
            theNewOne.next = theOldOne;

            //increment the size and break off from there
            size++;
            return;
        }

        //setting up a size variable and an iterator to walk through the list
        int currentIndex = 0;
        LinkedIterator iterator = new LinkedIterator();

        //as long as the next index isn't the one where the new value belongs AND the next index exists, move forward.
        while (currentIndex < i - 1 && iterator.hasNext())
        {
            iterator.current = iterator.current.next;
            currentIndex++;
        }
        //if the next index IS the one where the value belongs, then create a new node there and link it to the old
        //"next".
        if (currentIndex + 1 >= i)
        {
            //to start, link up the new Node to the current "next" node, if it's not null.
            if (iterator.current != null)
            {
                theNewOne.next = iterator.current.next;
            }
            //now, link up the current Node to the newly-created "next" node.
            iterator.current.next = theNewOne;

            //I hope it's that simple...
            //wait, increment the size.
            size++;
        }
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
        if (size == 0)
        {
            System.out.println("Empty list, nothing to get.");
            return null;
        }
        else if (i > size)
        {
            throw new IndexOutOfBoundsException("Provided index is too high.");
        } else if (i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported.");
        }
        else if (i == 0 || size == 1)
        {
            //WRITE CODE FOR IF THE SIZE IS ONE
            return head.data;
        }
        else
        {
            //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
            //you're looking for, return the Node data at that particular index.

            //setting up a size variable and an iterator to walk through the list
            int currentIndex = 0;
            LinkedIterator iterator = new LinkedIterator();

            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            while (currentIndex < i - 1 && iterator.hasNext())
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }
            //if the next index IS the one we're looking for, return the data at that index.
            if (currentIndex + 1 >= i)
            {
                return iterator.current.next.data;
            }
        }
        //otherwise, return -1.
        return -1;
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
        return remove(size());
//        //so, check if the Node in front of the current one's "next" field is null? And if it is, that must be the
//        //back of the list. In which case, cut off the current one's "next" field so that the old "back" floats off
//        //and gets eaten by the GC.
//        LinkedIterator iterator = new LinkedIterator();
//
//        //as long as the Node in front of this one doesn't have a null pointer...
//        while (iterator.current.next.next != null)
//        {
//            //go forward.
//            iterator.current = iterator.current.next;
//        }
//
//        //if we're at the second-to-last node...
//        if (iterator.current.next.next == null)
//        {
//            //let the last node go. It's IDE food now. Grab the data from it first, though.
//            Object obj = iterator.current.next.data;
//            iterator.current.next = null;
//            return obj;
//        }
//
//        //if we get this far, then we've probably reached the end of the linked list. Return null.
//        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(Object item)
    {
        //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
        //you're looking for, store that Node's object in a variable, grab its pointer to redirect your current Node
        //then set the stored Node's next to null so it floats away like a piece of driftwood in the ocean.

        LinkedIterator iterator = new LinkedIterator();

        //while the next node isn't null
        while (iterator.current.next != null)
        {
            //check to see if the node's data is what we're looking for
            if (iterator.current.next.data.equals(item))
            {
                //if it is, go ahead and re-wire the pointers so the Node gets reclaimed.
                iterator.current.next = iterator.current.next.next;

                //decrement the size of course.
                size--;

                //and break out of the loop.
                break;
            }
            //otherwise, keep going forward.
            else
            {
                iterator.current = iterator.current.next;
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
        //if the list is empty, there's nothing to remove. Exception time.
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty list. Nothing to remove.");
        }
        //If the provided index is invalid, exception time.
        if (i > size)
        {
            throw new IndexOutOfBoundsException("Provided index is too high.");
        }
        else if (i < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported.");
        }
        //if there's only one item in the list, just set head to null and return the item.
        else if (size == 1)
        {
            Object obj = head.data;
            head = null;

            //almost forgot to decrement the size!
            size--;
            return obj;
        }
        //if the index is zero, re-wire head to point to the one after zero and return the item.
        else if (i == 0)
        {
            //Store head's data in an object, set head to the next node and remove the next node from existence.
            Object obj = head.data;
            head = head.next;

            //decrement the size!
            size--;
            return obj;
        }
        else
        {
            //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
            //you're looking for, store that Node in a variable, grab its pointer to redirect your current Node, then
            //set the stored Node's next to null so it floats away like a piece of driftwood in the ocean.


            //setting up a size variable and an iterator to walk through the list
            int currentIndex = 0;
            LinkedIterator iterator = new LinkedIterator();

            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            while (currentIndex < i - 2 && iterator.hasNext())
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }
            //if the next index IS the one we're looking for, return the data at that index.
            if (currentIndex + 2 >= i)
            {
                //store the Node in a variable.
                Node theOneToRemove = iterator.current.next;

                //from here, I need to grab the pointer from this new variable and give it to the current Node.
                iterator.current.next = theOneToRemove.next;

                //cut the stored Node's next field and return its data.
                //also decrement the list size.
                size--;
                theOneToRemove.next = null;
                return theOneToRemove.data;
            }
        }
        //otherwise, return null, I suppose.
        return null;
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
        //walk through the list, keeping track of what node you're on, and if the Node you're on has the value you're
        //looking for, return true. Otherwise, return false.

        LinkedIterator iterator = new LinkedIterator();

        //as long as the next index exists, check for the item and move forward.
        while (iterator.hasNext())
        {
            if (iterator.current.data.equals(item))
            {
                return true;
            }
            iterator.current = iterator.current.next;
        }
        //if the iterator makes it to the end of the list and didn't return true, then it's not here. return false.
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
        return new LinkedIterator();
    }

    //helper class/type that defines how the iterator works
    private class LinkedIterator implements Iterator<E>
    {

        private Node current;

        public LinkedIterator()
        {
            current = head;
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
            //compute the result of whether or not current equals null, then return it
            return current != null;
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
            if (current != null)
            {
                Object item = current.data;
                current = current.next;
                return (E) item;
            } else
            {
                throw new NoSuchElementException("End of list reached.");
            }
        }
    }
}

