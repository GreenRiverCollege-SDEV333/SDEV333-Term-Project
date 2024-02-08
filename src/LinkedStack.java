import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked Node stack implementation. LIFO.
 * @author Rob smith
 * @version 1.0
 * @param <E> class / data type of the items in the LinkedStack
 */
public class LinkedStack<E> implements Stack<E>{

    private Node head;
    private int size;

    private class Node{
        E data;
        Node next;
    }

    /**
     * Constructor for LinkedStack class.
     */
    public LinkedStack(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty.
     * Runtime of this is O(1). It's simply returning a single boolean with no loops.
     * @return true if the LinkedStack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks the size of the list.
     * Runtime of this is O(1). It's simply returning a single int with no loops.
     * @return the size of the LinkedStack
     */
    public int size() {
        return size;
    }

    /**
     * Adds the specified object to the front of the list.
     * Runtime of this is O(1). It always takes the same amount of time to add a node to the front of a linked list
     * because there is no looping to shift like in an array.
     * @param item the item to be added
     */
    public void push(E item){
        Node newNode = new Node();
        newNode.data = item;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        this.size++;
    }


    /**
     * Pop removes the first element in the linked list and returns the value of the data inside it.
     * Runtime for this operation is O(1), removing the first element is a constant time operation regardless of the
     * size of the list.
     * @return the data from the node removed from the list.
     */
    public E pop(){
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else {
            E result = head.data;
            head = head.next;
            size--;
            return result;
        }
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * Runtime is O(1) because there is no looping involved.)
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return head.data;
    }

    /**
     * returns an object to iterate through the Linked-stack.
     * Runtime is O(1) because it is merely instantiating an object with no looping.
     * @return an object to iterate through the Linked-stack
     */
    public Iterator<E> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E> {

        Node current = head;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * Runtime is O(1) because there is no looping involved it is just checking where int he LinkedStack the
         * iterator is currently located.
         * @return {@code true} if the current position is not the end of the list, aka, null.
         */
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        /**
         * Returns the next element in the iteration.
         * Runtime for this is O(1) because it's only accessing a single point of data not looping through the
         * LinkedStack in its entirety.
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E value = current.data;
            current = current.next;
            return value;
        }
    }

}
