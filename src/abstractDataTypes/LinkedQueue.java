/**
 * Toby Goetz
 */

package abstractDataTypes;

import interfaces.Queue;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Book People
 * @version 1.0
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E>
{
    private Node first;
    private Node last;
    private int size;

    private class Node
    {
        E item;
        Node next;

        private Node(E item)
        {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Add an item to the queue.
     * O(1) at worst
     * This function is constant at worst because it only makes
     * a few assignments at the front of the list and isEmpty()
     * is constant as well
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item)
    { // Add item to the end of the list.
        Node oldLast = last;
        last = new Node(item);
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        } size++;
    }

    /**
     * Remove an item from the queue.
     * O(1) at worst
     * This function is constant at worst because it only makes
     * a few assignments at the front of the list and isEmpty()
     * is constant as well
     * @return the item that was removed
     */
    @Override
    public E dequeue()
    { // Remove item from the beginning of the list.
        E item = first.item;
        first = first.next;

        if ( isEmpty()) {
            last = null;
        } size--;

        return item;
    }

    /**
     * Checks to see if the queue is empty.
     * O(1) at worst
     * This function is constant because it acceses an
     * instance variable and returns a boolean value
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the queue.
     * O(1) at worst
     * This function is constant at worst because it
     * only accesses an instance variable
     * @return the number of items in the queue
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n) at worst
     * This function is linear at worst because it loops over
     * all elements in the array. It could be Constant if the array
     * is empty. Depends on how the client code uses it.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ListIterator<>()
        {
            private Node current = first;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E item) {

            }

            @Override
            public void add(E item) {

            }
        };
    }

    /**
     * O(n) at worst
     * This function is linear at worst because it loops over
     * all elements in the array. It could be Constant if the array
     * is empty.
     * @return String value representing the queue
     */
    @Override
    public String toString()
    {
        Node current = first;
        String nodes = "";
        if (current != null) {
            nodes += (current.item + ", ");
            while (current.next != null) {
                current = current.next;
                nodes += (current.item);
                if (current.next != null) {
                    nodes += ", ";
                }
            }
        }
        return "LinkedQueue{" +
                "(" + size + " left on stack) " +
                nodes;

    }
}
