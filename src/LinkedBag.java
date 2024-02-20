import java.util.Iterator;

public class LinkedBag<E> implements Bag<E>
{
    private Node head; //first node in list
    private int size;

    private class Node
    {
        E item;
        Node next;
    }

    /**
     * Add an item to the bag.
     *
     * Runtime Analysis: Constant time in the worst-case scenario.
     * No loops, no conditionals, nothing that could make a serious impact
     * on the performance of this method.
     *
     * @param item the item to be added
     */
    @Override
    public void add(E item)
    {
        //same as push() in Stack
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     *
     * Runtime Analysis: Constant time at worst. This method just returns the
     * computation of whether or not the first node in the list is equal to
     * null. A few variables accessed, a computation done, a return done.
     *
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the bag.
     *
     * Runtime Analysis: Constant time at worst. All this method does is access
     * the value of a variable and return it.
     *
     * @return the number of items in the bag
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Runtime Analysis: O(n) at worst. This method creates a new object and
     * returns it; we can't be 100% certain how long the default constructor
     * for an iterator would take, but that is the only major thing happening
     * in this method. Otherwise, the method is just returning the result
     * of the constructor call.
     *
     * @return an Iterator.
     * @return
     */
    public Iterator<E> iterator()
    {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E>
    {
        private Node current = head;

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
            E item = current.item;
            current = current.next;
            return item;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove()
        {
            //the book left this method blank
        }
    }
}
