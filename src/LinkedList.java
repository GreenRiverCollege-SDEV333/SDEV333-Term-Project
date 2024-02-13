import java.util.*;

public class LinkedList<E> implements List<E> {
    // define what a node is
    private class Node {
        E data;
        Node next;
    }

    // set up the head field
    private Node head;

    // set up the size field
    private int size;

    // adda constructor to initialize the fields
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
        // set up a new node
        Node theNewOne = new Node();
        theNewOne.data = item;
        theNewOne.next = head;
        head = theNewOne;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = theNewOne;

        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        Node currentNode = head;
        E lastData;

        // If the index is less than or equal to size since it won't makes sense to work if it's bigger than the size
        if (index <= size) {
            for (int i = 0; i < size - index; i++) {
                currentNode = currentNode.next;
            }

            // First time
            lastData = currentNode.next.data; // Grabs the next data so it won't be lost
            currentNode.next = currentNode; // The next node is equal to the current node
            currentNode.data = item; // Replaces the current data to the value since we are adding the index here
            currentNode = currentNode.next; // Then we move to the next node

            // The rest of the time
            for (int i = size + 1; i > index; i--) {
                currentNode.data = lastData;
                lastData = currentNode.next.data; // Grabs the next data so it won't be lost
                currentNode.next = currentNode; // The next node is equal to the current node
                currentNode = currentNode.next; // Then we move to the next node
            }

            size++;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        Node currentNode = head;
        E placeholder = currentNode.data;

        for (int i = 0; i < size - 1; i++) {
            currentNode.data = currentNode.next.data;
            currentNode = currentNode.next;
        }

        size--;

        return placeholder;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        E placeholder = currentNode.data;
        currentNode.data = null;
        currentNode.next = null;

        size--;

        return placeholder;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            if (currentNode.data == item) {
                currentNode.data = null;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node currentNode = head;
        boolean containValue = false;

        for (int i = 0; i < size; i++) {
            if (currentNode.data == item) {
                containValue = true;
            }

            currentNode = currentNode.next;
        }

        return containValue;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        else {
            return true;
        }
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
        return new LinkedList.LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<E> {

        private Node currentNode;

        private LinkedListIterator() {
            currentNode = head;
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
            return currentNode != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            E currentNodeData = currentNode.data;
            currentNode = currentNode.next;
            return currentNodeData;
        }
    }
}
