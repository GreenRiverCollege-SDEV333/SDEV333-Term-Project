import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node head;
    private int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void push(E item) {
        Node newNode = new Node();
        newNode.data = item;
        if (head == null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (head == null) {
            throw new NoSuchElementException("The List is empty");
        } else {
            E result = head.data;
            head = head.next;
            size--;
            return result;
        }
    }

    @Override
    public E peek() {
        return head.data;
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
        return new StackIterator();
    }

    private class Node {
        E data;
        Node next;
    }

    private class StackIterator implements Iterator<E> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            E value = current.data;
            current = current.next;
            return value;
        }
    }
}
