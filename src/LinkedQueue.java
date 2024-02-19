import java.util.Iterator;

public class LinkedQueue<E> implements Queue<E>{
    private Node head;
    private Node tail;
    private int size;

    private class Node
    {
        E item;
        Node next;
    }
    @Override
    public void enqueue(E item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if(isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        size++;
    }

    @Override
    public E dequeue() {
        E item = head.item;
        head = head.next;
        if(isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>
    {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
