import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private Node first; // top of stack (most recently added node)
    private int size; // number of items

    public LinkedStack() { // default constructor
        first = null;
        size = 0;
    }
    private class Node { // nested class to define nodes
        E item;
        Node next;
    }
    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        // Add item to top of stack.
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item to remove");
        }
        E item = first.item; // removes item from top of stack.
        first = first.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item to view");
        }
        return first.item;
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }
}
