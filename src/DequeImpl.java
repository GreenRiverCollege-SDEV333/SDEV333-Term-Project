/**
 * Double-ended Queue implementation
 * Can add and remove from both sides of the queue.
 *
 * @author R.J. Trenchard
 * @date 2/15/2024
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeImpl<E> implements Deque<E> {

    private int size;
    private Node head, tail;

    private class Node {
        E data;
        Node prev, next;

        public Node(E data) {
           this(data, null, null);
        }

        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public DequeImpl() {
        int size = 0;
        head = tail = null;
    }

    /**
     * Checks if the deque is empty.
     * O(1), size access is recorded during node creation/deletion
     *
     * @return true if the deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     * O(1), size access is constant
     *
     * @return number of items in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Add an item to the left end of the deque.
     * @param item item to be added
     */
    @Override
    public void pushLeft(E item) {
        // case: size is 0, need to assign new head and tail
        if (size == 0) {
            head = tail = new Node(item);
        }

        // case: size is 1, we need to decouple head and tail and make them point to each other
        else if (size == 1) {
            tail.prev = head = new Node(item, null, tail);
        }

        // case: any other size
        else {
            head = head.prev = new Node(item, null, head);
        }

        size++;

    }

    /**
     * Add an item to the right end of the deque.
     * O(1), adding right is instant
     *
     * @param item item to add
     */
    @Override
    public void pushRight(E item) {
        // case: size is 0, need to assign new head and tail
        if (size == 0) {
            head = tail = new Node(item);
        }

        // case: size is 1, adding one we need to decouple head and tail and make them point to each other
        else if (size == 1) {
            head.next = tail = new Node(item, head, null);
        }

        // case: any other size
        else {
            tail = tail.next = new Node(item, tail, null);


        }

        size++;
    }

    /**
     * Remove an item from the left end of the deque.
     * O(1), left access is instant
     *
     * @return the item on the left end of the queue
     */
    @Override
    public E popLeft() {
        if (head == null) throw new NoSuchElementException("No elements left in queue.");

        E data = head.data;

        size--;

        // case: size is 0, the resulting dequeue will be null;
        if (size == 0) {
            head = tail = null;
        }

        // case: size is 1, head will point to tail.
        else if (size == 1) {
            head = tail;

            // erase references to prev/next
            head.next = head.prev = null;
        }

        // case: any other size
        else {
            // move right one node
            head = head.next;
            // and null its reference to the previous node
            head.prev = null;
        }

        return data;
    }

    /**
     * Remove an item from the right end of the deque.
     *  O(1), contrast to something like a linked list, we can instantly access the right end of a dequeue
     *
     * @return the item on the right end of the queue
     */
    @Override
    public E popRight() {
        if (tail == null) throw new NoSuchElementException("No elements left in queue.");

        E data = tail.data;

        size--;

        // case: size is 0, the resulting dequeue will be null;
        if (size == 0) {
            head = tail = null;
        }

        // case: size is 1, tail will point to head.
        else if (size == 1) {
            tail=head;

            // erase references to next
            tail.next = tail.prev = null;
        }

        // case: any other size
        else {
            // move head back one node
            tail = tail.prev;

            tail.next = null;
        }

        return data;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n), as usual, an iterator will always pass a list once and once only unless break occurs.
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
                return cur != null;
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
