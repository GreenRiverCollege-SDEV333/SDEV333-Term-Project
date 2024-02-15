package part_2;

import interfaces.Stack;

import java.util.Iterator;

/**
 * Implements the Pushdown (LIFO) Stack (linked-list) data structure.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class LinkedStack<E> implements Stack<E>
{
    //fields
    private Node head;
    private int size;

    //node class to create nodes for linkedlist
    private class Node
    {
        E data;
        Node next;
    }

    /**
     * Add an item to the stack.
     * Time complexity: O(1)
     * Time is constant because all operations involve singular tasks.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        //save head to reference after new head is created
        Node oldHead = head;

        //create a new head
        head = new Node();

        //save item to head data
        head.data = item;

        //reference the old head
        head.next = oldHead;

        //increment size
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * Time complexity: O(1)
     * Time is constant because all operations involve singular tasks.
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        //throw exception if stack is empty, cannot pop an empty stack
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot pop()");
        }

        //save item to be removed
        E item = head.data;

        //remove head from stack
        head = head.next;

        //decrement size
        size--;

        //return item removed
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * Time complexity: O(1)
     * Time is constant because either an exception is thrown or the first node's data is returned.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        //throw exception if stack is empty, cannot peek an empty stack
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot peek()");
        }

        //return top of stack
        return head.data;
    }

    /**
     * Checks to see if the stack is empty.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
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
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>
    {
        private Node curr = head;

        @Override
        public boolean hasNext()
        {
            return curr != null;
        }

        @Override
        public E next()
        {
            E item = curr.data;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove()
        {
            //do nothing
        }
    }
}
