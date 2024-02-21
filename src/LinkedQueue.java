import java.util.Iterator;

/**
 * The LinkedQueue is based on a linked-list data structure
 * that implements the Queue class. It can be used to create queues
 * containing any data type.
 *
 * @author Will Castillo
 * @param <E> data type of the items in the stack
 */
public class LinkedQueue<E> implements Queue<E>
{
    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int size;   // number of items on the queue

    private class Node
    {   // nested class to define nodes
        E item;
        Node next;
    }

    /**
     * Constructor for class that initializes
     * the first node, last node and size.
     */
    public LinkedQueue()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Add an item to the queue.
     * @param item the item to be added
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just reassigns and rearranges the nodes and increases the size.
     */
    @Override
    public void enqueue(E item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }
        size++;
    }

    /**
     * Remove an item from the queue.
     * @return the item that was removed
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     */
    @Override
    public E dequeue()
    {   // remove item from the beginning of the list
        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty())
        {
            last = null;
        }
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     * @return true if the queue is empty, false otherwise
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just compares the first to null.
     */
    @Override
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the queue.
     * @return the number of items in the queue
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just returns the count which is being tracked as items are being added
     * in enqueue and dequeue methods
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
     * regardless of the queue size
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E>
    {
        private Node current = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the queue. Compares the current and null.
         *
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext()
        {
            return current != null;
        }

        /**
         * Removes the last element returned by this iterator. This
         * method is not implemented in this iterator.
         *
         * Runtime: O(1) - Each line of code in the methods executes in
         * one operation, regardless of the size of the queue.
         */
        public void remove()
        {

        }

        /**
         * Returns the next element in the iteration and advances the iterator.
         *
         * @return the next element in the iteration
         *
         * Runtime: O(1) -  Each line of code in the method executes in one operation,
         * regardless of the size of the queue.
         */
        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }

    }
}
