/**
 * This class is an implementation of a stack using
 * a linked list with the methods for adding to the
 * top of the stack (push), removing the most recently
 * added from the stack (pop), and getting the item
 * at the top of the stack (peek)
 *
 * @author Dhiyaa Nazim
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node first;
    private int size;

    private class Node {
        E item;
        Node next;
    }
    public LinkedStack(){
        first = null;
        size = 0;
    }
    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     *
     * This method runs in O(1) or constant time
     * since it only involves adding an item to the
     * top of the stack. No traversing or loops are involved.
     */
    @Override
    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     *
     * Similar to push, this method runs in O(1)
     * as it only involves removing the item at the
     * top of the stack. No traversing or loops are involved.
     */
    @Override
    public E pop() {
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     *
     * This method only involves accessing an item and
     * doesn't involve traversing or loops.
     * Therefore, the runtime is constant or O(1) complexity.
     */
    @Override
    public E peek() {
        return first.item;
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     *
     * The runtime analysis on this method is O(1)
     * as it only involves comparing the first node
     * with null. It doesn't have any loops or traversing.
     */

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
     *
     * This method only involves accessing a variable and
     * doesn't involve traversing or loops.
     * Therefore, the runtime is constant or O(1) complexity.
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
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E> {
        private Node current = first;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current !=  null;
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
                throw new NoSuchElementException("No more elements in the iteration");
            }
            E item = current.item;
            current = current.next;
            return item;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
