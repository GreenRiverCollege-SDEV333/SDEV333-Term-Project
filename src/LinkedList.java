import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void addFront(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addBack(E item) {
        if (head == null) {
            addFront(item);
        } else {
            Node<E> newNode = new Node<>(item);
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            addFront(item);
        } else {
            Node<E> newNode = new Node<>(item);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }

    @Override
    public E removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = head.data;
        head = head.next;
        size--;
        return removedItem;
    }

    @Override
    public E removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (size == 1) {
            return removeFront();
        }
        Node<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        E removedItem = current.next.data;
        current.next = null;
        size--;
        return removedItem;
    }

    @Override
    public void remove(E item) {
        if (isEmpty()) {
            return;
        }
        if (head.data.equals(item)) {
            removeFront();
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data.equals(item)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            return removeFront();
        }
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        E removedItem = current.next.data;
        current.next = current.next.next;
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(E item) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in list");
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
