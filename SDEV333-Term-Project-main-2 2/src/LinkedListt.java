import java.util.Iterator;
import java.util.NoSuchElementException;

//linked list implementing the list interface
public class LinkedListt<E> implements List<E> {

    //node
    private class Node {
        E data;
        Node next;
    }


    private Node head;// head node of the linked list
    //size of the linked list
    private int size;

    //constructor
    public LinkedListt() {
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */

    //O(1)adds new node at starting of list
    @Override
    public void addFront(E item) {
        Node newNode = new Node();// new node
        newNode.data = item;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    //o(n) worst case
    @Override
    public void addBack(E item) {
        Node newNode = new Node();
        newNode.data = item;
        if (head == null) {// if list empty
            head = newNode;//set head to new node
        } else {
            Node current = head;//
            while (current.next != null) {//to  last node
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    //o(n)need to terverse the linked list to find node at specififed index before addin new node
    @Override
    public void add(int i, E item) {//
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();

        }
        if (i == 0) {
            addFront(item);
            return;
        }
        Node newNode = new Node();
        newNode.data = item;
        Node current = head;
        for (int index = 0; index < i - 1; index++) {
            current = current.next;
        }
        newNode.next = current.next;// next of new node to next of current
        current.next = newNode;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */

    //0(n)?
    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();

        }
        Node current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    //
    @Override
    public void set(int i, E item) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();

        }
        Node current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        current.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    //0(1)it removes the first node form list
    @Override
    public E removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();

        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {// if empty
        if (isEmpty()) {
            throw new NoSuchElementException();

        }
        if (size == 1) {//if only one left in list
            return removeFront();

        }
        Node prev = null;
        Node current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        size--;
        return current.data;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    //0()
    @Override
    public void remove(E item) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head.data.equals(item)) {
            head = head.next;
            size--;
            return;
        }
        Node prev = null;
        Node current = head;
        while (current != null && !current.data.equals(item)) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException();

        }
        prev.next = current.next;
        size--;
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    //
    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {

        }
        if (i == 0) {
            return removeFront();
        }
        Node prev = null;
        Node current = head;
        for (int index = 0;
             index < i; index++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        size--;
        return current.data;
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
        while (current != null) {

            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    //o(1) this checks size if it is zero
    @Override
    public boolean isEmpty() {
        return  size==0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    //0(1)returns the size of the list
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
        return new Iterator<E>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current=current.next;
                return data;
            }
        };
    }
}
