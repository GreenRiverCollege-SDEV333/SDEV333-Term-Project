package part_2;

import interfaces.Queue;

import java.util.Iterator;

/**
 * Implements the FIFO Queue (linked-list) data structure.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class LinkedQueue<E> implements Queue<E>
{
    //fields
    private Node head;
    private Node tail;
    private int size;

    //class to create nodes for linkedlist
    private class Node
    {
        E data;
        Node next;
    }

    /**
     * Constructor for LinkedQueue.
     */
    public LinkedQueue()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an item to the end of queue.
     * Time complexity: O(1)
     * Time is constant because all operations are singular.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item)
    {
        //save head to new node
        Node oldHeaD = head;

        //recreate head as a new node
        head = new Node();

        //save item to new head's data
        head.data = item;

        if(isEmpty())
        {
            //assign head to head if queue is empty
            tail = head;
        }
        else
        {
            //reference oldHead to head
            oldHeaD.next = head;
        }

        //increment size
        size++;
    }

    /**
     * Remove an item from the beginning of queue.
     * Time complexity: O(1)
     * Time is constant because either an exception is thrown or singular operations are executed.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue()
    {
        //throw exception if queue is empty, cannot dequeue an empty queue
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty, cannot pop()");
        }

        //save data from node to be removed
        E item = tail.data;

        //remove tail
        tail = tail.next;

        if(isEmpty())
        {
            //set tail to null if queue is empty
            head = null;
        }

        //decrement size
        size--;

        //return item
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the queue.
     * Time complexity: O(1)
     * Time is constant due to a single comparison operation.
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
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>
    {
        private Node curr = tail;

        @Override
        public boolean hasNext()
        {
            return !isEmpty();
        }

        @Override
        public E next()
        {
            E item = tail.data;
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
