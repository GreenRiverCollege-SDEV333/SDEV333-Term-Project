package APIs;

import Stack.LinkedStack;

import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E> {
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
     * The front of the queue (least recently added node)
     */
    private Node front;

    /**
     * The back of the queue (most recently added node)
     */
    private Node back;

    /**
     * The number of items stored in this stack
     */
    private int size;

    /**
     * Constructs an empty LinkedStack
     */
    public LinkedQueue() {
        // queue starts off empty
        front = null;
        back = null;
        size = 0;
    }

    /**
     * Add an item to the queue.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {

    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        return null;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * @return the number of items in the queue
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