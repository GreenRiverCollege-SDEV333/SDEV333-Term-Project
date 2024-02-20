/**
 * This class is an implementation of a queue
 * using a linked list with the methods for adding (enqueue)
 * and removing (dequeue) items
 *
 * @author Dhiyaa Nazm
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node first; // least recently added node
    private Node last;  // most recently added node
    private int size;
    private class Node {
        E item;
        Node next;
    }
    public LinkedQueue(){
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Add an item to the queue.
     *
     * @param item the item to be added
     *
     * This method runs in O(1) or constant time
     * since it only involves updating the last
     * node of the linked queue
     */
    @Override
    public void enqueue(E item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     *
     * Similar to enqueue, this method runs in O(1)
     * as it only involves updating the first node
     * of the linked queue
     */
    @Override
    public E dequeue() {
        E item = first.item;
        first = first.next;
        size--;
        if(isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
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
     * Returns a count of the number of items in the queue.
     *
     * @return the number of items in the queue
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
