/**
 *  This class represents a Stack that uses a LinkedList under the hood.
 *  @author Jared Eller
 *  @verison 1.0
 *  @date 2/20/24
 */

import java.util.Iterator;

public class LinkedStack <E> implements Stack<E>
{
    private Node head; //top of stack (most recently added node)
    private int size;

    private class Node
    {
        //nested class to define nodes
        E item;
        Node next;
    }

    /**
     * Add an item to the stack.
     * Runtime Analysis: Constant time at worst. All that happens is a node
     * getting stored in a variable, a new node being created, and the new
     * node's parameters getting set up. None of this is really changed by
     * how much data is in the stack or by what data gets inputted.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        //Add item to top of stack.
        Node oldFront = head;
        head = new Node();
        head.item = item;
        head.next = oldFront;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * Runtime Analysis: Constant time at worst. This method has no loops or
     * control flow, all that happens is that a Node's pointer gets updated and
     * its data gets stored in a variable and returned. Nothing that could
     * really change the method's runtime drastically.
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        //Remove item from top of stack.
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * Runtime Analysis: Constant time at worst. All this method does is return
     * the value from a variable.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        return head.item;
    }

    /**
     * Checks to see if the stack is empty.
     * Runtime Analysis: Constant time in the worst-case scenario. This method
     * compares the top of the stack to null and returns the value,
     * nothing else.
     *
     * @return true if the stack is empty, false if it isn't
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the stack.
     * Runtime Analysis: Constant time at worst. This method just returns a
     * variable's value, nothing else happens.
     *
     * @return the number of items in the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * Runtime Analysis: O(n) at worst. This method creates a new object and
     * returns it; we can't be 100% certain how long the default constructor
     * for an iterator would take, but that is the only major thing happening
     * in this method. Otherwise, the method is just returning the result
     * of the constructor call.
     *
     * @return an Iterator.
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
