import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 2C – Pushdown (LIFO) Stack (linked-list implementation
 * @author Kayley Young
 */
public class LinkedStack<E> implements Stack<E> {
    private Node head;
    private int size;
    private class Node {
        E data;
        Node next;

    }
    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }
        /**
     * Add an item to the stack.
     *
     * This method runs in O(1) because with a constant number of operations the complexity class is constant.
     *
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //save a link to the list
        Node theOldOne = head;
        //create new node for the beginning
        head = new Node();
        //save the instance variables in the new node
        head.data = item;
        head.next = theOldOne;
        size++;

    }

    /**
     * Removes the most recently added item from the stack.
     *
     * This method runs in O(1) because with a constant number of operations the complexity class is constant.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        //save a link to the item being removed
        E item = head.data;
        //remove top of stack
        head = head.next;
        size--;

        //return item that was removed
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * This method runs in O(1) because with a constant number of operations the complexity class is constant.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return head.data;
    }

    /**
     * Checks to see if the stack is empty.
     *
     *   This method runs in O(1) because with single operations  the complexity class is constant.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     *  This method runs in O(1) because with single operations the complexity class is constant.
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
     * This method runs in O(n) because the iterator implementation iterates through each element in the linked list once,
     * making the time complexity linear with respect to the number of elements in the list.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>{
        private Node current = head;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("there is no next one to go to");
            }
            E item = current.data;
            current = current.next;

            return item;
        }
    }
}
