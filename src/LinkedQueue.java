/**
 * LinkedQueue implementation

 * This queue uses linked nodes to store data, both a head and a tail
 * for quick access to enqueuing to the back, and dequeuing from the front.
 *
 * @author R.J. Trenchard
 * 2/15/2024
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

    int size;
    Node head, tail;

    private class Node {
        E data;

        Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    /**
     * Add an item to the queue.
     * O(1), adding to a queue is instant if we keep track of the head and tail.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        // case: size is 0, create head and tail
        if (size == 0) {
            head = tail = new Node(item);
        }
        // case: any other size, add to back
        else {
            tail = tail.next = new Node(item, tail);
        }

        size++;
    }

    /**
     * Remove an item from the queue.
     * O(1), dequeuing is instant and involves no loops.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        // check if there's anything in the queue
        if (size == 0) throw new NoSuchElementException();

        size--;

        // dequeuing should be generally safe
        E data = head.data;
        head = head.next;

        return data;
    }

    /**
     * Checks to see if the queue is empty.
     * O(1), size access is instant
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the queue.
     * O(1), size access is instant
     *
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n) - guaranteed to be O(n) if you iterate through the list once
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node cur = head;

            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();

                E data = cur.data;
                cur = cur.next;
                return data;
            }
        };
    }
}
