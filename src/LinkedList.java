import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    //define what a Node is
    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private int size;

    /**
     * constructor for the LinkedList
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = item;

        if (head == null) {
            // the list is currently empty
            head = theNewOne;
        }
        else {
            //the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
        }
        size++;
    }

    /**
     * Add item to the back.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        Node current = head;

        if (head == null) {
            head = theNewOne;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = theNewOne;
        }
        size++;
    }

    /**
     * Add an item at specified index (position).
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {

        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node theNewOne = new Node();
            theNewOne.data = item;
            Node current = head;

            if (size == 0) {
                head = theNewOne;
            }
            else {
                while (i != 0) {
                    if (i != 1) {
                        current = current.next;
                    }
                    i--;
                }

                if (current.next == null) {
                    addBack(item);
                }
                else {
                    theNewOne.next = current.next;
                    current.next = theNewOne;
                }
            }

            size++;
        }

    }

    /**
     * Get the item at a specified index.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        Node current = head;
        i++;
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else {
            while (i != 1) {
                current = current.next;
                i--;
            }
            return current.data;
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        // if index is out of bounds
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node current = head;

        for (int j = 0; j < i; j++) {
            current = current.next;
        }

        current.data = item;
    }


    /**
     * Remove item at the front of the list.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (head != null) {
            E removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }

        throw new IndexOutOfBoundsException("Index is out of bounds");
    }

    /**
     * Remove item at the back of the list
     * item at that index is overwritten.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node current = head;

        if (current != null) {
            if (current.next != null && current.next.next != null) {
                while (current.next.next != null) {
                    current = current.next;
                }
            }
            E removedData = current.data;
            current.next = null;
            size--;
            return removedData;
        }
        throw new IndexOutOfBoundsException("Index is out of bounds");

    }

    /**
     * Remove item from the list
     * item at that index is overwritten.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node current = head;

        while (current.next != null) {
            if (current.data == item) {
                current = current.next;
            }

            current = current.next;
        }
        size--;

    }

    /**
     * Remove item at a specified index.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        //validate index
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;

        // if the index is the first element
        if (i == 0) {
            E value = head.data;
            head = head.next;
            size--;
            return value;
        }

        for (int j = 0; j < i - 1; j++) {
            current = current.next;
        }

        E value = current.next.data;

        if (current.next.next != null) {
            current.next = current.next.next;
        }
        else {
            current.next = null;
        }

        size--;
        return value;
    }

    /**
     * Checks if an item is in the list.
     * This method runs in O(n) or linear time in the worst case because of the time it takes to traverse the nodes
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node current = head;

        if (current != null) {
            if (current.next != null) {
                while (current.next != null) {
                    if (current.data == item) {
                        return true;
                    }
                    current = current.next;
                }
            }
            return current.data == item;
        }

        return false;
    }

    /**
     * Checks if the list is empty.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Provides a count of the number of items in the list.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return number of items in the list
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

        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {


        private Node current;

        public LinkedListIterator() {
            current = head;
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
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
