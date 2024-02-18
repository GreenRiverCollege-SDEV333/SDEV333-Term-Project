import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    Node head;
    private int size;

    public class Node {
        E data;
        Node next;

        public Node() {
            data = null;
            next = null;
        }
    }
    /**
     * Add an item to the stack.
     *  O(5) just a few constants
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if (size == 0) {
            Node newhead = new Node();
            newhead.data = item;
            head = newhead;
            size++;
        }
        else {
            Node newhead = new Node();
            newhead.data = item;
            newhead.next = head;
            head = newhead;
            size++;
        }
    }

    /**
     * Removes the most recently added item from the stack.
     *  O(5) a few constants
     * @return the item that was removed
     */
    @Override
    public E pop() {
        E item = null;
        if (head.data != null) {
            item = head.data;
        }
        if (head.next != null) {
            head = head.next;
            size--;
        } else {
            head = null;
            size --;
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * O(2) from if and return
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * Checks to see if the stack is empty.
     * O(1) from return statement
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    /**
     * Returns a count of the number of items in the stack.
     * O(1) return statement
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new LinkedStackIterator();
    }
    private class LinkedStackIterator implements Iterator<E> {

        private LinkedStack.Node current;

        public LinkedStackIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (current == null || current.next == null) {
                return false;
            }
            else {
                return true;
            }
        }
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!");
            }
            E dataValue = (E) current.data;
            current = current.next;
            return dataValue;
        }
    }
}
