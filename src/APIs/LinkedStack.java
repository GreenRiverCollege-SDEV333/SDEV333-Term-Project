package APIs;

import List.LinkedList;

import java.util.Iterator;

public class LinkedStack<E> implements Stack<E> {
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
     * The top of the stack (most recently added node)
     */
    private Node top;

    /**
     * The number of items stored in this stack
     */
    private int size;

    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {

    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        return null;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == null && size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
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
        return null;
    }
}