import java.util.Iterator;

public class LinkedStack<E> implements Stack<E> {

    private Node head;
    private int size;
    private class Node
    {
        E item;
        Node next;
    }

    public LinkedStack()
    {
        head = null;
        size = 0;
    }
    @Override
    public void push(E item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    @Override
    public E pop() {
        E toBeRemoved = head.item;
        head = head.next;
        size--;
        return toBeRemoved;
    }

    @Override
    public E peek() {
        return head.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
