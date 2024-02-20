/**
 * Author : Levi Miller
 * file: LinkedStack.java, implements LinkedStack interface
 */
import java.util.Iterator;
public class LinkedStack<E> implements Stack<E> {

    private Node head; // top of stack (most recently added node)
    private int size;

    public class Node {  // nested class to define nodes
        E item;
        Node next;
    }
    /**
     * default constructor: initializing fields
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public LinkedStack() {
        this.head = null;
        this.size = 0;

    }

    /**
     * Checks if the stack is empty.
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }  // Or: N == 0.

    /**
     * Provides a count of the number of items in the stack
     * RunTime analysis: constant O(1) no loops worse case in constant
     * @return number of items in the stack
     */
    public int size() {
        return size;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * push item on stack
     * */
    public void push(E item) {  // Add item to top of stack.
        Node first = head;
        head = new Node();
        head.item = item;
        head.next = first;
        size++;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * pop item off stack
     * */
    public E pop() {  // Remove item from top of stack.
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns iterated nodes
     * */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = head;
        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns if there is a next element in stack is ,so it's true if not it's false
         * */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * */
        public void remove() {
        }
        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns next element in list
         * */
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     */
    @Override
    public E peek() {
        return null;
    }

}


