import java.util.Iterator;

/**
 * The LinkedStack class is a Stack implementation that
 * is based on a linked-list data structure. It can be used to create
 * stacks containing any type of data
 *
 * @author Will Castillo
 * @param <E> data type of the items in the stack
 */
public class LinkedStack<E> implements Stack<E>
{
    private Node first; // top of stack (most recently added node)
    private int size;

    /**
     * Constructor for class that
     * initializes the first node and size fields
     */
    public LinkedStack()
    {
        first = null;
        size = 0;
    }

    private class Node
    {   // nested class to define nodes
        E item;
        Node next;
    }

    /**
     * Checks to see if the LinkedStack is empty.
     * @return true if the stack is empty, false otherwise
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Compares the first to null.
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the LinkedStack.
     * @return the number of items in the stack
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Returns the count which is being tracked as items are being
     * pushed and popped.
     */
    public int size()
    {
        return size;
    }

    /**
     * Add an item to the LinkedStack.
     * @param item the item to be added
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * Just reassigns and rearranges the nodes and increases the size.
     */
    public void push (E item)
    {   // add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * @return the item that was removed
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     */
    public E pop()
    {   // remove item from top of stack
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the LinkedStack.
     * Does not modify the stack or the item at the top.
     * @return item at the top of the stack.
     *
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * We need to access one item in the stack.
     */
    @Override
    public E peek()
    {
        return first.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Runtime: O(1) - Each line of code in the method executes in one operation,
     * regardless of the LinkedStack size.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E>
    {
        private Node current = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the LinkedStack.
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
         * regardless of the size of the LinkedStack.
         */
        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
