/**
 * Author : Levi Miller
 * file: LinkedBag.java, implements bag interface
 */
import java.util.Iterator;

public class LinkedBag<E> implements Bag<E> {
    private Node first;  // first node in list
    private int size;

    public class Node {
        E item;
        Node next;
    }
    /**
     * default constructor: initializing fields
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public LinkedBag() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Adds an item to the front of the bag
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public void add(E item) {  // same as push() in Stack
        Node first = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = first;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     * RunTime analysis: constant O(1) no loops worse case in constant
     *
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * RunTime analysis: constant O(1) no loops worse case in constant
     *
     * @return the number of items in the bag
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns items from bag
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns if there is a next element in bag is ,so it's true if not it's false
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns next element in list
         */
        public E next() {
            E item = current.item;
            current = current.next;
            return item;

        }
    }
}
