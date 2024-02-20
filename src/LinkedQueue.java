import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
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
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}