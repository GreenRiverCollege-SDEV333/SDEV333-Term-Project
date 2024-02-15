import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue (FIFO) which uses linked list / nodes to store data
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E>
{
    private class Node{
        E data;
        LinkedQueue.Node next;

        Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedQueue(){
        this.size = 0;
        this.head = null;
    }

    /**
     * Add an item to the queue.
     *
     * Time Complexity: O(n) each item leading up to the last node is accessed
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item)
    {
        Node newNode = new Node(item);

        if (size == 0) {
            head = newNode;
            size++;
            return;
        }


        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        size++;
    }

    /**
     * Remove an item from the queue.
     *
     * Time Complexity: O(1) only first node is accessed
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue()
    {
        E removed = (E) head.data;
        head = head.next;
        size--;
        return removed;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return true if the queue is empty, false otherwise
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
     * Returns a count of the number of items in the queue.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return the number of items in the queue
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
            private LinkedQueue.Node current = head;

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
