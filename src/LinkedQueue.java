import java.util.Iterator;

/**
 * Creates a new LinkedQueue object. Has the ability to add and remove items
 * from the linked queue, as well as check the size and status of if the
 * linked queue is empty.
 * @author Sage Bain
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E>{
    private Node head;
    private Node tail;
    private int size;

    private class Node
    {
        E item;
        Node next;
    }

    /**
     * This will always run in constant time, as there is no need to iterate
     * through the linked queue. We are simply making adding a new item to the
     * tail of the queue, and checking if the linked queue was originally empty.
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if(isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        size++;
    }

    /**
     * This will always run in constant time, as there is no need to iterate
     * through the linked queue. We are simply moving head forward one space.
     * Afterward, we check to see the linked queue was originally empty. If so,
     * we set tail to null. Then we decrement size and return the removed item.
     * @return item to be removed
     */
    @Override
    public E dequeue() {
        E item = head.item;
        head = head.next;
        if(isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }

    /**
     * This will always run at constant time since we are simply returning
     * true or false based on if head is equal to null.
     * @return true or false based on if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * This will always run at constant time since we are simply returning
     * the value of size.
     * @return size
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
