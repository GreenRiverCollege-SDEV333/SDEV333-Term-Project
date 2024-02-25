import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E>{
    private Node head;
    private Node tail;
    private int size;


    private class Node
    {
        E data;
        Node nextNode;
    }

    public LinkedQueue()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an item to the queue.
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item)     {

        //create a new head node that will be the top of the queue
        head = new Node();
        Node prev = head;
        head.data = item;
        //check if queue is empty, if it is set the tail to head(new data)
        if(isEmpty())
        {
            tail = head;
        }
        else
        {
            //if it isn't empty set the prev node to the head and add item to end of queue
            prev.nextNode = head;
        }

        size++;
    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue()     {
        if(isEmpty())
        {
            //check if stack is empty
            throw new IllegalStateException("Stack is empty, cannot pop()");
        }
        //get tail(back) of queue. if tails next node is empty, set head to null.
        E item = tail.data;
        tail = tail.nextNode;
        if(isEmpty())
        {
            head = null;
        }
        //decrement size to account for dequeue
        size--;
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the queue.
     *
     * @return the number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<E>{
        // returns ture if iteration has no more elements
        private Node current = head;
        public boolean hasNext() {
            return current != null;
        }
        // returns next element in the iteration

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            //goes to the next node in the stack and returns it
            E item = current.data;
            current = current.nextNode;
            return item;
        }
    }
}
