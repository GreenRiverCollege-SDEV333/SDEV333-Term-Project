import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> implements Bag<E> {
    private Node first; // beginning of bag
    private int size;   // number of elements in bag

    public LinkedBag() {
        first = null;
        size = 0;
    }

    @Override
    public void add(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class Node {
        E item;
        Node next;
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

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
