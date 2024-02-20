import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> implements Bag<E> {

    private Node<E> first;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    public LinkedBag() {
        first = null;
        size = 0;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>();
        newNode.item = e;
        newNode.next = first;
        first = newNode;
        size++;
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
        return new BagIterator();
    }

    private class BagIterator implements Iterator<E> {
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