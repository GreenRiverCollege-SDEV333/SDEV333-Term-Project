import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl<E> implements Queue<E> {

    int size;
    Node head;

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
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        size++;
        head = new Node(item, head);
    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {

        if (size == 0) throw new NoSuchElementException();

        size--;

        E data = head.data;
        head = head.next;

        return data;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Most implementations of queues I find have no iterator... so should this move forward or backward?
     * should it pop elements or simply read them?
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
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
