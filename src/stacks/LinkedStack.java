/**
 * LinkedList implementation of the Stack interface
 *
 * @author Lillian Nelson
 * @version 1.0
 */

package stacks;
import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item>
{
    // private fields
    private Node head; // top of stack (most recently added node)
    private int size; // number of items

    private class Node
    { // nested class to define nodes
        Item item;
        Node next;
    }

    /**
     * Returns if LinkedStack is empty
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     * @return if head is null
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns size of LinkedStack
     * 0(1) or constant time in the worst case
     * no matter size the return is same
     *
     * @return size
     */
    public int size()
    {
        return size;
    }

    /**
     * pushes a new item into the LinkedStack
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @param item Item to push
     */
    public void push(Item item)
    { // Add item to top of stack
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
        size++;
    }

    /**
     * Removes an item from the stack
     * 0(1) or constant time in the worst case
     * no matter size operations stay the same
     *
     * @return the item removed
     */
    public Item pop()
    { // Remove item from top of stack
        Item item = head.item;
        head = head.next;
        size--;
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
        return new LinkedIterator();
    }
    private class LinkedIterator implements Iterator<Item>
    {
        private LinkedStack.Node current = head;

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
