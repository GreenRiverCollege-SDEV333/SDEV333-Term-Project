package APIs;

import Stack.LinkedStack;

import java.util.Iterator;

/**
 *
 * @param <E>
 */
public class LinkedBag<E> implements Bag<E> {
    /**
     * A container which contains an item and a connection to another Node
     */
    private class Node {
        /**
         * The item stored within the Node
         */
        E item;

        /**
         * The node this Node is pointing to
         */
        Node next;

        /**
         * Creates a node, and stores the given item within it
         * @param item the item being stored in node
         */
        public Node(E item) {
            // store given item
            this.item = item;

            // node starts off disconnected
            next = null;
        }
    }

    /**
     * The first node in nag
     */
    private Node first;

    /**
     * The number of items stored in this bag
     */
    private int size;

    /**
     * Constructs an empty LinkedBag
     */
    public LinkedBag() {
        // bag starts off empty
        first = null;
        size = 0;
    }

    /**
     * Adds the given item to the bag
     *
     * @param item the item to be added
     */
    @Override
    public void add(E item) {

    }

    /**
     * Checks whether the bag is empty, and returns true/false accordingly
     *
     * @return true if the bag is empty; otherwise false
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Gets and returns the number of items stored in the bag
     *
     * @return the number of items stored in the bag
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
