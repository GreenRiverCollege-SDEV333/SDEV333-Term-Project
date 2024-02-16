/**
 * Toby Goetz
 */

package abstractDataTypes;

import interfaces.Stack;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Book People
 * @version 1.0
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private Node first;
    private int size;

    private class Node
    { // Nested class to define Node
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
     * Add an item to the stack.
     * O(1) at worst
     * This function is constant at worst because it only makes
     * a few assignments at the front of the list
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    { // Add item to the top of the stack
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * O(1) at worst
     * This function is constant at worst because it only makes
     * a few assignments at the front of the list
     * @return the item that was removed
     */
    @Override
    public E pop()
    { // Remove item from the top of the stack
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * O(1) at worst
     * This function is constant because it accesses an
     * element in an array
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return first.item;
    }

    /**
     * Checks to see if the stack is empty.
     * O(1) at worst
     * This function is constant because it acceses an
     * instance variable and returns a boolean value
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the stack.
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
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next()
            {
                E item = current.item;
                current = current.next;
                return null;
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
     * @return String value representing the list
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
        return "LinkedStack{" +
                "(" + size + " left on stack) " +
                nodes;
    }
}
