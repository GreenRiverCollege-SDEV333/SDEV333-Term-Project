import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a singly linked list.
 *
 * @author Noah Lanctot
 * @version 1.0
 * @param <E> the type of elements in this list
 */
public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    /**
     * Constructs an empty LinkedList.
     */
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

    /**
     * Adds the specified element to the front of this list.
     * This method has a runtime complexity of O(1).
     *
     * @param item the element to be added to the front of this list
     */
    @Override
    public void addFront(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds the specified element to the back of this list.
     * This method has a runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * may need to traverse the list to find the last node.
     *
     * @param item the element to be added to the back of this list
     */
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

    /**
     * Adds the specified element at the specified index in this list.
     * This method has a runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * may need to traverse the list to find the node before the specified index.
     *
     * @param index the index at which the specified element is to be inserted
     * @param item the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Returns the element at the specified index in this list.
     * This method has a runtime complexity of O(n),
     * where n is the index of the element to be retrieved,
     * because it may need to traverse the list to find the node at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Replaces the element at the specified index in this list with the specified element.
     * This method has a runtime complexity of O(n),
     * where n is the index of the element to be replaced,
     * because it may need to traverse the list to find the node at the specified index.
     *
     * @param index the index of the element to replace
     * @param item the element to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Removes and returns the element at the front of this list.
     * This method has a runtime complexity of O(1).
     *
     * @return the element at the front of this list
     * @throws NoSuchElementException if this list is empty
     */
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

    /**
     * Removes and returns the element at the back of this list.
     * This method has a runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * may need to traverse the list to find the second-to-last node.
     *
     * @return the element at the back of this list
     * @throws NoSuchElementException if this list is empty
     */
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

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * This method has a runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * may need to traverse the list to find the specified element.
     *
     * @param item the element to be removed from this list
     */
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

    /**
     * Removes and returns the element at the specified index in this list.
     * This method has a runtime complexity of O(n),
     * where n is the index of the element to be removed,
     * because it may need to traverse the list to find the node before the specified index.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Returns true if this list contains the specified element.
     * This method has a runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * may need to traverse the list to find the specified element.
     *
     * @param item the element to be checked for containment in this list
     * @return true if this list contains the specified element
     */
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

    /**
     * Returns true if this list contains no elements.
     * This method has a runtime complexity of O(1).
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this list.
     * This method has a runtime complexity of O(1).
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in this list.
     * This method has a runtime complexity of O(1).
     *
     * @return an iterator over the elements in this list
     */
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