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
     * Runtime Analysis: O(n) at worst. This method makes a call to the
     * add (int i, Object item) method found below it, and having
     * written that method myself, I can confirm that it runs at O(n) in a
     * worst case scenario. This method simply calls that method and hands it
     * a few parameters, so the runtime shouldn't be any more complicated.
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
     * Runtime Analysis: O(n) at worst. This method makes a call to the
     * add (int i, Object item) method found below it, and having
     * written that method myself, I can confirm that it runs at O(n) in a
     * worst case scenario. This method simply calls that method and hands it
     * a few parameters, so the runtime shouldn't be any more complicated.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(Object item)
    {
        add(size, item);
    }

    /**
     * Add an item at specified index (position).
     *
     * Runtime Analysis: O(n) at worst. There's a while loop, but there aren't
     * any more loops or conditionals that occur within the loop; this loop
     * has to run a certain number of times depending on the user's submitted
     * index value, and that number of times can be represented as n. So,
     * this method runs at O(n) in a worst-case situation.
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
     * Runtime Analysis: At worst, O(n). There is a while loop that runs inside
     * an else statement, but this condition is only ever checked once, at the
     * start of the method. No conditionals or loops run inside the while loop.
     * As a result, I believe this is O(n).
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
     * Runtime Analysis: O(n) at worst. This method borrows much of its
     * traversal algorithm from remove(int i), and as a result there is a while
     * loop that runs for a set number of times depending on the user's
     * provided index. No other loops run inside this while loop, but there are
     * other conditionals that run. I believe this constitutes O(n) in a worst
     * case scenario.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, Object item)
    {
        //if the list is empty, there's nothing to set. Exception time.
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty list. Nothing to set.");
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
        //if there's only one item in the list, set it to null.
        else if (size == 1)
        {
            head.data = item;
        }
        //if the index is zero, re-assign the head data.
        else if (i == 0)
        {
            head.data = item;
        }
        else
        {
            //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
            //you're looking for, change that Node's data.


            //setting up a size variable and an iterator to walk through the list
            int currentIndex = 0;
            LinkedIterator iterator = new LinkedIterator();

            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            while (currentIndex < i - 2 && iterator.hasNext())
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }
            //if the next index IS the one we're looking for, overwrite the data.
            if (currentIndex + 2 >= i)
            {
                iterator.current.next.next.data = item;
            }
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * Runtime Analysis: O(n). This method calls another method that I already
     * wrote, and I know that this other method called runs in O(n) time. All
     * this method does is call that other method and feed it a specific
     * parameter; the aforementioned method has a while loop. For a more
     * thorough explanation, check the documentation for remove(int i).
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
     * Runtime Analysis: O(n). This method calls another method that I already
     * wrote, and I know that this other method called runs in O(n) time. All
     * this method does is call that other method and feed it a specific
     * parameter; the aforementioned method has a while loop. For a more
     * thorough explanation, check the documentation for remove(int i).
     *
     * @return the item that was removed
     */
    @Override
    public Object removeBack()
    {
        return remove(size());
    }

    /**
     * Remove item from the list
     *
     * Runtime Analysis: O(n^2) at worst. There is an if conditional branch
     * stored inside a while loop; the check on whether or not this branch
     * should continue happens for n times based on how many times the while
     * loop has to happen. So, at its worst, this method would be O(n^2).
     * I think.
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
     * Runtime Analysis: At worst, I believe this runs in O(n) time. While
     * there are a number of if/else conditions and loops in this method,
     * most of the conditions don't have many instructions within them and
     * there is never more than one loop occurring at a time. The while loop
     * loops over a set of nodes for however many times the algorithm deems
     * necessary based on the user's provided index "i".
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
     * Runtime Analysis: O(n^2) at the worst. There is a while loop, and inside
     * that while loop, an if statement. Each set of instructions that is
     * involved with the if statement has to be evaluated a number of times and
     * on top of that, the instructions involved with the if have to run every
     * time the while loop repeats itself, which itself runs a number of times.
     *
     * So, O(n^2).
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
                return true; //3n + .equals call?
            }
            iterator.current = iterator.current.next; //3n + .hasNext call?
        }
        //if the iterator makes it to the end of the list and didn't return true, then it's not here. return false.
        return false; //2
        //(3n + 3)n + 2
    }

    /**
     * Checks if the list is empty.
     *
     * Runtime Analysis: O(3) in the worst-case scenario. This method accesses
     * the size variable, computes whether or not it's equal to zero, then
     * returns the result of this computation.
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
     * Runtime Analysis: O(2) in the worst-case scenario. All this method
     * does is access a variable and return its value.
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
     * Runtime Analysis: I'm going to venture it's around O(2) or O(3) at the
     * absolute worst. All that has to be done is return an object created
     * by another method; no data processing, no conditionals, no looping.
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

