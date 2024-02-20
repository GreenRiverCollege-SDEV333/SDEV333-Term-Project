import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E>
{
    private Node head; //link to least recently added node
    private Node tail; //link to most recently added node
    private int size;

    private class Node
    {
        //nested class to define nodes
        E item;
        Node next;
    }

    /**
     * Add an item to the queue.
     *
     * Runtime Analysis: I think this would be logarithmic at worst.
     * There's decision logic but it doesn't come into play very much here,
     * it's mostly just assigning a few new values as needed.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item)
    {
        //make a new variable to store the old end in
        Node oldTail = tail;

        //add the new data to a new node at the end of the list
        tail = new Node();
        tail.item = item;
        tail.next = null;

        //if it's empty, then the head and tail of the list are the same!
        if(isEmpty())
        {
            head = tail;
        }
        else
        {
            //otherwise, point the old end to the new end.
            oldTail.next = tail;
        }
        size++;
    }

    /**
     * Remove an item from the queue.
     *
     * Runtime Analysis: Once again, logarithmic at worst. There's an singular
     * if condition present in this method, otherwise it's mainly just walking
     * through the process of letting a node get eaten by the garbage collector
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue()
    {
        //Remove an item from the beginning of the list.
        E item = head.item;
        head = head.next;

        //decrement the size!!!! Stop forgetting to do this!!!
        size--;
        if (isEmpty())
        {
            //if the list is empty, set the most recent node to null.
            tail = null;
        }
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * Runtime Analysis: Constant time at worst. This method compares a node
     * to null, and returns the result of the computation. Nothing more.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * Runtime Analysis: Constant time at worst. This method just accesses a
     * variable's value and returns that.
     *
     * @return the number of items in the queue
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
        private Node current = tail;

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
