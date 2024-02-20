/**
 * This class is an implementation of a bag
 * using a singly linked list to store elements
 * and deletion of elements.
 *
 * @author Dhiyaa Nazim
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> implements Bag<E>{

    private Node first;
    private int size;
    private class Node {
        E item;
        Node next;
    }
    public LinkedBag(){
        first = null;
        size = 0;
    }
    /**
     * Add an item to the bag.
     *
     * @param item the item to be added
     *
     * This method involves creating a
     * new node and updating the first node
     * of the linked list. Therefore, the
     * time complexity is O(1) or constant time.
     */
    @Override
    public void add(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     *
     * @return true if the bag is empty, false otherwise
     *
     * The runtime analysis on this method is O(1)
     * as it only involves comparing the first node
     * with null. It doesn't have any loops or traversing.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the bag.
     *
     * @return the number of items in the bag
     *
     * Similar to isEmpty(), this method is
     * only accessing a variable and doesn't
     * rely on the array. Therefore, the runtime is
     * O(1) or constant time.
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
