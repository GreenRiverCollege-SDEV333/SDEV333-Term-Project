/**
 * Toby Goetz
 */

package abstractDataTypes;

import interfaces.Bag;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Book People
 * @version  1.0
 * @param <E>
 */
public class LinkedBag<E> implements Bag<E>
{
    private Node first;
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
     * Add an item to the Bag.
     * O(1) at worst
     * This function is constant at worst because it only makes
     * a few assignments at the front of the list
     * @param item data value of any type
     */
    @Override
    public void add(E item)
    { // Add item to the bag
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     * O(1) at worst
     * This function is constant because it acceses an
     * instance variable and returns a boolean value
     * @return boolean true if bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the Bag.
     * O(1) at worst
     * This function is constant at worst because it
     * only accesses an instance variable
     * @return the number of items in the stack
     */
    @Override
    public int size() {
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
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public E next()
            {
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
     * @return String value representing the Bag
     */
    @Override
    public String toString() {
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
        return "LinkedBag{" + "size=" + size +
                "[" + nodes + "]}";
    }
}
