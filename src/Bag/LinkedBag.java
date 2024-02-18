package Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * The first node in bag
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
        // create new node containing given item
        Node newNode = new Node(item);

        // if the bag is not empty
        if(!isEmpty()) {
            // point new node at first, so it isn't lost
            newNode.next = first;
        }

        // override first with newly created node
        // (making new node first node in bag)
        first = newNode;

        // account for new item in bag
        size++;
    }

    /**
     * Checks whether the bag is empty, and returns true/false accordingly
     *
     * @return true if the bag is empty; otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && first == null;
    }

    /**
     * Gets and returns the number of items stored in the bag
     *
     * @return the number of items stored in the bag
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedBagIterator();
    }

    /**
     * Implementation of an Iterator for the LinkedBag class
     */
    private class LinkedBagIterator implements Iterator<E>
    {
        /**
         * The current Node being tracked by the Iterator
         */
        private Node current;

        /**
         * Constructs a LinkedBag iterator, with the first node tracked first
         */
        LinkedBagIterator() {
            current = first;
        }

        /**
         * Checks if list contains another element, and returns true/false accordingly
         * @return true if list contains another element; otherwise false
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Gets and returns the first item in the list
         * @return the first item in the list
         */
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get first item of list
            E currItem = current.item;

            // move on to the next item
            current = current.next;

            return currItem;
        }
    }
}
