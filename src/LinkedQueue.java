import java.util.Iterator;

/**
 * class which represents the implementation of a queue using a linkedlist
 * @author Huy Nguyen
 * @version 1.0
 * @param <E>
 */
public class LinkedQueue <E> implements Queue<E>{
    private Node head;
    private Node tail;
    private int size;

    /**
     * class to create the linked queue
     *
     * @author Huy Nguyen
     * @version 1.0
     */
    private class Node
    {
        E data;
        Node next;
    }

    /**
     * method to add a value to the tail
     * This will always be O(1) because you're simpling setting references
     * to the newest node being added into the queue to the tail
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        // Create a new node and set its data
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;


        //empty queue set reference to both
        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            // Link the current tail to the new node and update the tail reference
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * method to remove head reference and return the value removed
     * this will always be O(1) because you are simply you already have a head reference to
     * get the value of the queue, and you just advance it one time to remove the reference
     * @return
     */
    @Override
    public E dequeue() {
        //get value and advances to the next node removing reference
        E value = head.data;
        head = head.next;

        //make sure no references
        if (head==null){
            tail = null;
        }
        size--;
        return value;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you're only checking one value
     * @return the size of the stack
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you are returning the field
     * @return the size of hte stack
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>{
        private Node curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E value = curr.data;
            curr = curr.next;
            return value;
        }
    }
}
