import java.util.Iterator;
import java.util.NoSuchElementException;
/*
still need to do runtime analysis of each method!!
@ Ryder Dettloff
@ version 1.0
@ 02-13-2024
 */
public class LinkedList<E> implements List<E> {
    private class Node {
        E data;
        Node nextNode;
    }

    //set up the head
    private Node head;
    //set up the size field
    private int size;

    //add constructor to initialize the data
    public LinkedList() {
        head = null;
        size = 0;

    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        Node newNode = new Node();
        newNode.nextNode = head;
        head = newNode;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {

    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {

    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return (E) current;
    }


    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("no such index exists!");
        }
        Node current = head;
        for (int index = 0; index < i; index++) {
            current = current.nextNode;
        }
        current.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        return null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {

    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        return null;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node current = head;
        if (isEmpty()) {
            return false;
        }
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
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
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<E> {
        private Node current;

        private LinkedListIterator() {
            current = head;
        }
// returns ture if iteration has no more elements
        @Override
        public boolean hasNext() {
            return current != null;
        }
// returns next element in the iteration
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.nextNode;
            return data;
        }
    }
}
