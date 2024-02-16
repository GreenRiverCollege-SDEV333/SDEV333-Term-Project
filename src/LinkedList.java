import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> implements List<E>{
    private class Node {
        E data;
        Node next;
    }
    //set up the head
    private Node head;

    //set up the size field
    int size;

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
        Node theNewOne = new Node();
        theNewOne.data = item;
        if (head == null) {
            head = theNewOne;
            theNewOne.next = null;
        } else {
            theNewOne.next = head;
            head = theNewOne;
        }
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node finder = head;
        for (int i = 0; finder.next != null; i++) {
            finder = finder.next;
        }
        Node toAdd = new Node();
        toAdd.data = item;
        finder.next = toAdd;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        Node finder = head;
        for (int j = 0; j < i - 1; i++) {
            finder = finder.next;
        }
        Node toAdd = new Node();
        toAdd.next = finder.next;
        toAdd.data = item;
        finder.next = toAdd;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        Node finder = head;
        for (int j = 0; j < i - 1; j++) {
            finder = finder.next;
        }
        return finder.data;
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
        Node finder = head;
        for (int j = 0; j < i; j++) {
            finder = finder.next;
        }
        finder.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        E item = head.data;
        head.data = null;
        head = head.next;
        size--;
        return item;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node finder = head;
        for (int i = 0; i < size - 1; i++) {
            finder = finder.next;
        }
        E item = finder.next.data;
        finder.next = null;
        size--;
        return item;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node finder = head;
        if (head.data == item) {
            head = head.next;
            size--;
        }
        while (finder.next.data != item) {
            if (finder.next.data == item) {
                finder.next = finder.next.next;
                size--;
            }
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        Node finder = head;
        for (int j = 0; j < i - 1; j++) {
            finder = finder.next;
        }
        E item = finder.next.data;
        finder.next = null;
        size--;
        return item;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node finder = head;
        while (finder.next != null) {
            if (finder.data == item) {
                return true;
            }
            finder = finder.next;
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
        return (Iterator<E>) new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<Integer> {

        private Node current;

        public LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (current == null || current.next == null) {
                return false;
            }
            else {
                return true;
            }
        }
        @Override
        public Integer next() {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!!");
            }
            int item = (int) current.data;
            current = current.next;
            return item;
        }
    }
}
