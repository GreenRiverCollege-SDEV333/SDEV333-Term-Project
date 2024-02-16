import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedStack represents a stack data structure implemented using a linked list.
 * It implements the Stack interface.
 *
 * @author Braedon Billingsley
 * @param <E> the class / data type of the items in the stack
 */
public class LinkedStack<E> implements Stack<E> {

    private Node first; // top of stack (most recently added node)
    private int size; // number of items

    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack() { // default constructor
        first = null;
        size = 0;
    }
    private class Node { // nested class to define nodes
        E item;
        Node next;
    }
    /**
     * Add an item into the LinkedStack.
     * The worst case time complexity of this method is O(1).
     *
     * @param item  item to add into the stack.
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
     * The worst case time complexity of this method is O(1).
     *
     * @return the item that was removed.
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
     * The worst case time complexity of this method is O(1).
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
     * Checks if the LinkedStack is empty.
     * The worst case time complexity of this method is O(1).
     *
     * @return true if LinkedStack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the size of the LinkedStack.
     * The worst case time complexity of this method is O(1).
     *
     * @return size of the LinkedStack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over a set of elements of type {@code E}.
     * The worst case time complexity of this method is O(1).
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
    }
}
