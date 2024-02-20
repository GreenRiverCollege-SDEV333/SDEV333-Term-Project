import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E> {
    private Node head; // link to least recently added node
    private Node tail;  // link to most recently added node
    private int size;      // number of items on the queue

    private class Node {  // nested class to define nodes
        E item;
        Node next;
    }

    public LinkedQueue() {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public boolean isEmpty() {
        return head == null;
    }  // Or: N == 0.

    public int size() {
        return size;
    }

    public void enqueue(E item) {  // Add item to the end of the list.
        Node oldlast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) head = tail;
        else oldlast.next = tail;
        size++;
    }

    public E dequeue() {  // Remove item from the beginning of the list.
        E item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        size--;
        return item;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    // See page 150 for test client main().
}

