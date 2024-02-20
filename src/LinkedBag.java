import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedBag represents a bag (or multiset) data structure implemented using a linked list.
 *
 * @param <E> the type of elements stored in the stack
 * @author Noah Lanctot
 * @version 1.0
 */
public class LinkedBag<E> implements Bag<E> {

    private Node<E> first;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    /**
     * Initializes an empty bag.
     */
    public LinkedBag() {
        first = null;
        size = 0;
    }

    /**
     * Adds an item to the bag.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @param e the item to add
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>();
        newNode.item = e;
        newNode.next = first;
        first = newNode;
        size++;
    }

    /**
     * Checks whether the bag is empty.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the bag.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the number of items in the bag
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to traverse the items in the bag.
     *
     * @return an iterator to traverse the items in the bag
     */
    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<E> {
        private Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}