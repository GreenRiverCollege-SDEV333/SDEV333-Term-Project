package part_2;

import interfaces.Bag;

import java.util.Iterator;

/**
 * Implements the Bag (linked-list) data structure.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class LinkedBag<E> implements Bag<E>
{
    //fields
    private Node head;
    private int size;

    //class to create nodes for linkedlist
    private class Node
    {
        E data;
        Node next;
    }

    /**
     * Constructor for LinkedBag.
     */
    public LinkedBag()
    {
        this.head = null;
        this.size = 0;
    }

    /**
     * Add an item to the bag.
     * Time complexity: O(1)
     * Time is constant due to singular operations.
     *
     * @param item the item to be added
     */
    @Override
    public void add(E item)
    {
        //save head node for new head to reference
        Node oldHead = head;

        //create new head node
        head = new Node();

        //save item to new head.data
        head.data = item;

        //reference oldHead
        head.next = oldHead;

        //increment size
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
     *
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the bag.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
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
    }
}
