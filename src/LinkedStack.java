import java.util.Iterator;

/**
 * A generic implementation of a linked stack
 * @param <E> generic type
 * @author Lois Lanctot
 * @version 1.0
 */
public class LinkedStack<E> implements Stack<E> {

    private Node head;
    private int size;

    private class Node {
        E item;
        Node next;
    }

    /**
     * Add an item to the stack.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the item that was removed
     */
    @Override
    public E pop() {
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return head.item;
    }

    /**
     * Checks to see if the stack is empty.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the stack.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private Node current;

        public ListIterator() {
            this.current = head;
        }

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
         */
        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
