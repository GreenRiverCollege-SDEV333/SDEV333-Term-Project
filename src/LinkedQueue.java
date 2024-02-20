/**
 * Author: Levi Miller
 * file: LinkedQueue.java, implements Queue interface
 */
import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E> {
    private Node head; // link to least recently added node
    private Node tail;  // link to most recently added node
    private int size;      // number of items on the queue

    private class Node {  // nested class to define nodes
        E item;
        Node next;
    }

    /**
     * default constructor: initializing fields
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the queue is empty.
     * RunTime analysis: constant O(1) no loops worse case in constant
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }  // Or: N == 0.

    /**
     * Provides a count of the number of items in the queue
     * RunTime analysis: constant O(1) no loops worse case in constant
     *
     * @return number of items in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Add an item at the end of the queue
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public void enqueue(E item) {  // Add item to the end of the list.
        Node outlast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) head = tail;
        else outlast.next = tail;
        size++;
    }

    /**
     * removes an item at the front of the queue
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public E dequeue() {  // Remove item from the beginning of the list.
        E item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        size--;
        return item;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns iterated nodes
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = head;

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns if there is a next element in queue is ,so it's true if not it's false
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         */
        public void remove() {
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns next element in list
         */
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}

