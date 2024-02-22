/**
 * LinkedList implementation of the Bag interface
 *
 * @author Lillian Nelson
 * @version 1.0
 */
package lists;

import java.util.Iterator;

public class LinkedBag<Item> implements Iterable<Item>
{
    private Node head; // first Node in the list

    private class Node
    {
        Item item;
        Node next;
    }

    /**
     * adds a new item into the LinkedBag
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @param item Item to add
     */
    public void add(Item item)
    { // Same as push() in Stack
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    /**
     * Returns an iterator over elements of type Item
     * 0(1) constant time returning iterator
     *
     * @return an Iterator.
     */
    public Iterator<Item> iterator()
    {
        return new LinkedBag.LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item>
    {
        private LinkedBag.Node current = head;

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
}
