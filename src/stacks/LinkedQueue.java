/**
 * LinkedList implementation of the Queue interface
 *
 * @author Lillian Nelson
 * @version 1.0
 */
package stacks;

import org.w3c.dom.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LinkedQueue<Item> implements Queue<Item> //this was red needed to be abstract?
{
    private Node head; // link to least recently added node
    private Node tail; // link to most recently added node
    private int size;

    private class Node
    { // nested class to define nodes
        Item item;
        Node next;
    }

    /**
     * Returns if LinkedQueue is empty
     * 0(1) or constant time in the worst case
     * no matter size operation is the same
     * @return if head is null
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns size of LinkedQueue
     * 0(1) or constant time in the worst case
     * no matter size the return is the same
     *
     * @return size
     */
    public int size()
    {
        return size;
    }

    /**
     * adds a new item into the LinkedQueue
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @param item Item to add
     */
    public Item enqueue(Item item)
    { // Add item to the end of the list
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty())
        {
            head = tail;
        }
        else
        {
            oldTail.next = tail;
        }
        size++;
        return item;
    }
    /**
     * Removes an item from the LinkedQueue
     * 0(1) or constant time in the worst case
     * no matter size operations stay the same
     *
     * @return the item removed
     */
    public Item dequeue()
    { // Remove item from the beginning of the list
        Item item = head.item;
        head = head.next;
        size--;
        if (isEmpty())
        {
            tail = null;
        }
        return item;
    }

    /**
     * Returns an iterator over elements of type Item
     * 0(1) constant time returning iterator
     *
     * @return an Iterator.
     */
    public Iterator<Item> iterator()
    {
        return new LinkedQueue.LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item>
    {
        private LinkedQueue.Node current = head;

        /**
         * Returns true if the iteration has more elements.
         * 0(1) or constant time in the worst case
         * return is the same
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        /**
         * Returns the next element in the iteration
         * 0(1) or constant time in the worst case
         * because no matter size operations are the same
         *
         * @return the next Item
         */
        @Override
        public Item next()
        {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

        /**
         * Left Blank?
         */
        @Override
        public void remove()
        {

        }

    }
    //added by java
    @Override
    public Item peek()
    {
        return head.item;
    }

    @Override
    public boolean contains(Object o)
    {
        return false;
    }
    @Override
    public boolean add(Item item)
    {
        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public boolean offer(Item item)
    {
        return false;
    }

    @Override
    public Item remove()
    {
        return null;
    }

    @Override
    public Item poll()
    {
        return null;
    }

    @Override
    public Item element()
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }


}
