/**
 * Author : Levi Miller
 */
import java.util.Iterator;
public class LinkedStack<E> implements Stack<E> {

    private Node head; // top of stack (most recently added node)
    private int size;      // number of items


    private class Node {  // nested class to define nodes
        E item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }  // Or: N == 0.

    public int size() {
        return size;
    }

    public void push(E item) {  // Add item to top of stack.
        Node oldfirst = head;
        head = new Node();
        head.item = item;
        head.next = oldfirst;
        size++;
    }

    public E pop() {  // Remove item from top of stack.
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return null;
    }

}


