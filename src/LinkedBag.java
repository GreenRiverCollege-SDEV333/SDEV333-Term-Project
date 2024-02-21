import java.util.Iterator;

/**
 * The LinkedBag class implements the Bag class, which maintains
 * a linked list of the items with no order.
 *
 * @author Will Castillo
 * @param <E> data type of the items in the list.
 */
public class LinkedBag<E> implements Bag<E>
{
    private Node first; // first node in list
    private int size;   // just to remove the error for isEmpty and size methods

    /**
     * Constructor for class that initializes
     * the first node and size fields
     */
    public LinkedBag()
    {
        first = null;
        size = 0;
    }

    private class Node
    {
        E item;
        Node next;
    }

    /**
     * Add an item.
     * @param item the item to be added
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just reassigns and rearranges the nodes and increases the size.
     */
    public void add(E item)
    {   // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     * @return true if the bag is empty, false otherwise
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just compares the size to 0.
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the bag.
     * @return the number of items in the bag
     *
     * Runtime: O(1) This method only executes the fixed number of steps.
     * Just returns the count which is being tracked as items are being
     * added in the add method.
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
     * regardless of the bag size.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator()
    {
        return new LinkedBagIterator();
    }
    private class LinkedBagIterator implements Iterator<E>
    {
        private Node current = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the bag.
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
         * Runtime: O(N) - removing a specific element requires traversing
         * the list until the element is found
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
         * regardless of the size of the LinkedBag.
         */
        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
