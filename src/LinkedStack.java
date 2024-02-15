import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack (FILO) which uses linked list / nodes to store data
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E>
{
    private class Node{
        E data;
        LinkedStack.Node next;

        Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedStack(){
        this.size = 0;
        this.head = null;
    }

    /**
     * Add an item to the stack.
     *
     * Time Complexity: O(1) only one node is modified
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        if(size == 0){
            head = new Node(item);
            size++;
            return;
        }

        head.next = new Node(item);
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * Time Complexity: O(n) each node leading up to last node is accessed
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        E removed;

        Node current = head;
        Node previous = null;

        while(current.next != null){
            previous = current;
            current = current.next;
        }

        removed = (E) current.data;

        if(previous != null){
            previous.next = null;
        }

        size--;

        return removed;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * Time Complexity: O(n) each node leading up to last node is accessed
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        Node current = head;

        while(current != null){
            current = current.next;
        }

        return current.data;
    }

    /**
     * Checks to see if the stack is empty.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return the number of items in the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Time Complexity: O(1) since iterators are always on constant time
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<>()
        {
            private LinkedStack.Node current = head;

            @Override
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public E next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object data = current.data;
                current = current.next;
                return (E) data;
            }
        };
    }
}
