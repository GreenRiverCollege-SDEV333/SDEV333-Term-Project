import java.util.Iterator;
import java.util.NoSuchElementException;

/*
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
     * Runtime Analysis: O(1) for linkedlist, it creates a new head node which is the same regardless of size
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
     * Runtime Analysis: O(n) required traversing through the whole list to get to the last node
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node newNode = new Node();
        Node current = head;
            if (isEmpty()) {
                head = newNode;
            }
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
            size++;
        }


    /**
     * Add an item at specified index (position).
     * Runtime Analysis: O(n) may require traversing through the whole list
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        Node newNode = new Node();
        Node previousNode = (Node) get(i - 1);
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            addFront(item);
        } else {
            newNode.nextNode = previousNode.nextNode;
            previousNode.nextNode = newNode;
            size++;

        }
    }

    /**
     * Get the item at a specified index.
     * Runtime Analysis: (may require traversing the whole list to find the given index O(n))
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
     * Runtime Analysis: (may require traversing the whole list to find the fiven index O(n))
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
     * Runtime Analysis: O(1) only need to change the head reference
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        E removedItem = head.data;
        head = head.nextNode;
        size--;
        return removedItem;
    }

    /**
     * Remove item at the back of the list
     * Runtime Analysis: (May require traversing the whole list to get to the last node O(n))
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node previousNode = (Node) get(size - 2);
        if (isEmpty()) {
            throw new NoSuchElementException("No item exists! The list is empty!");
        }
        if (size == 1) {
            return removeFront();
        }
        E removedItem = previousNode.nextNode.data;
        previousNode.nextNode = null;
        size--;
        return removedItem;
    }

    /**
     * Remove item from the list
     * Runtime Analysis (may require traversing the whole list to find the given item O(n))
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node current = new Node();
        if (isEmpty()) {
            throw new NoSuchElementException("No item exists! The list is empty!");
        }
        if (head.data.equals(item)) {
        removeFront();
        size--;
        }
        while(current.nextNode != null && !current.nextNode.data.equals(item)) {
            current = current.nextNode;
            }
        if (current.nextNode != null) {
            current.nextNode = current.nextNode.nextNode;
            size--;
        }
    }

    /**
     * Remove item at a specified index.
     * Runtime Analysis (may require traversing the whole list to find the given index O(n))
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
        public E remove(int i) {
        Node previousNode = (Node) get(i - 1);
            if (i < 0 || i >= size) {
                throw new IndexOutOfBoundsException("no index exists!");
            }
            if (i == 0) {
                return removeFront();
            }

            E removedItem = previousNode.nextNode.data;
            previousNode.nextNode = previousNode.nextNode.nextNode;
            size--;
            return removedItem;
        }

    /**
     * Checks if an item is in the list.
     * Runtime Analysis (may require traversing the whole list to find the given item O(n))
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
     * O(1) only requires checking the variable
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * O(1) only requires returning the size variables data
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(1) because the methods within simply assign variables new data or check
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

        public boolean hasNext() {
            return current != null;
        }
        // returns next element in the iteration

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
