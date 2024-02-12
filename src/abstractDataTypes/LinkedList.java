package abstractDataTypes;

import interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tobygoetz
 * @version 1.0
 *
 * Generic LinkedList to be used with any data type
 * @param <E>
 */
public class LinkedList<E> implements List<E> {

    // Fields
    private Node head;
    private int size;

    /**
     *  Constructor to initialize the fields of LinkedIntList
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    // Node Class
    private class Node {
        private E data;
        private Node next;

        /**
         * Constuctor for Node that accepts on Integer data
         * and sets the next to null
         * @param data Integer value of Node
         */
        private Node(E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Constuctor for Node that accepts on Integer data
         * and sets the next to null
         * @param data Integer Value of Node
         * @param next Points to the next Node in list
         */
        private Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data + " -> ";
        }
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        // new Node to be added
        Node addedToFront = new Node(item);
        // the list currently has some nodes in it
        if (head != null) {
            addedToFront.next = head;
        }
        head = addedToFront;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        Node addToBack = new Node(item);

        if (head == null) {
            head = addToBack;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = addToBack;
        } size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index the index where the item should be added
     * @param item  the item to be added
     */
    @Override
    public void add(int index, E item)
    {
        int dex = 1;
        //if requested index is out of range throw exception
        if (index < 0 || index > (size )) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size));
            //else find Node at index
        } else {
            //check if index is head
            if (index == 0) {
                addFront(item);
                //check if index is at the end
            } else if (index == (size)) {
                addBack(item);
                //remove everywhere else
            } else {
                Node current = head;
                while (dex <= index - 1) {
                    current = current.next;
                    dex++;
                }
                current.next = new Node(item, current.next);
                size++;
            }
        }
    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index)
    {
        int dex = 1;

        //if requested index is out of range throw exception
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size - 1));
            //else find Node at index
        } else {
            //head is always at index 0
            if (index == 0) {
                return head.data;
            } else {
                Node current = head;
                while(dex <= index) {
                    current = current.next;
                    dex++;
                }
                return current.data;
            }
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index the index where the item should be saved
     * @param item  the item to be saved
     */
    @Override
    public void set(int index, E item)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Specified Index Must Be " +
                    "In the Range of 0-" + (size - 1));
        } else {
            Node newNode = new Node(item);
            Node current = head;

            if (index == 0) {
                if (head != null) {
                    newNode.next = head.next;
                } head = newNode;

            } else if (index == (size - 1)) {
                while (current.next.next != null) {
                    current = current.next;
                } current.next = newNode;

            } else {
                for (int i = 1; i < index; i++) {
                    current = current.next;
                }
                newNode.next = current.next.next;
                current.next = newNode;
            }
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        if (head != null) {
            E removedData = head.data;
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            size--;
            return removedData;
        } return null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        if (head != null) {
            Node current = head;

            if (current.next != null) {
                while (current.next.next != null) {
                    current = current.next;
                }
                E removedData = current.next.data;
                current.next = null;
                size--;
                return removedData;
            } else {
                E removedData = head.data;
                head = null;
                size = 0;
                return removedData;
            }
        } return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        if (this.contains(item)) {
            Node current = head;
            if (head.data.equals(item)) {
                removeFront();
            } else {
                while (!current.next.data.equals(item)) {
                    current = current.next;
                }
                current.next = current.next.next;
                size--;
            }
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index)
    {
        int dex = 1;
        E removedData;

        //if requested index is out of range throw exception
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size - 1));
        } else {
            //check if index is head
            if (index == 0) {
                removedData = head.data;
                removeFront();
            } else {
                Node current = head;
                while (dex <= index - 1) {
                    current = current.next;
                    dex++;
                }
                removedData = current.next.data;
                current.next = current.next.next;
                size--;
            }
            return removedData;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        if (head != null) {
            Node current = head;
            if (current.data.equals(item)) {
                return true;
            } else {
                while (current.next != null) {
                    current = current.next;
                    if (current.data.equals(item)) {
                        return true;
                    }
                }
            }
        } return false;
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
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!");
            }
            E dataValue = current.data;
            current = current.next;
            return dataValue;
        }

        @Override
        public String toString() {
            return "LinkedListIterator{" +
                    "current=" + current +
                    '}';
        }
    }



    @Override
    public String toString() {
        Node current = head;
        String list = "LinkedIntList{size=" + size + ", list=[";

        if (current == null) {
            list += "]}";
        } else {
            while (current != null) {
                list += current.data;
                if (current.next != null) {
                    list += ", ";
                } else {
                    list += "]}";
                }
                current = current.next;
            }
        } return list;
    }
}
