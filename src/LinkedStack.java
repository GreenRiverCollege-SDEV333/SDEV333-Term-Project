import java.util.Iterator;

/**
 * Creates a linked stack object. Has the ability to add and remove items,
 * peek at the top item, and view the size and status of if the linked stack is
 * empty.
 * @author Sage Bain
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private Node head;
    private int size;
    private class Node
    {
        E item;
        Node next;
    }

    public LinkedStack()
    {
        head = null;
        size = 0;
    }

    /**
     * This will always run at constant time, since there is no need to
     * go through all the elements in the LinkedStack. This method
     * simply creates a new head element and increments size in 5 lines.
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    /**
     * This will always run at constant time, since there is no need to go
     * through all the elements in the LinkedStack. This method simply
     * saves the element to be removed in a variable, moves head one element
     * forward, decrements size, and returns the removed Node.
     * @return
     */
    @Override
    public E pop() {
        E toBeRemoved = head.item;
        head = head.next;
        size--;
        return toBeRemoved;
    }

    /**
     * This will always run at constant time, since we are simply
     * returning the value at head.
     * @return
     */
    @Override
    public E peek() {
        return head.item;
    }

    /**
     * This will always run at constant time, since we are simply
     * returning true or false based on if size is equal to 0 or not.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * This will always run at constant time, since we are simply
     * returning the value of size.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return a new ListIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>
    {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
