import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue <E> implements Queue <E> {
//    Create Private Class Node
    private class Node {
        E data;
        Node next; //address of the after this one in line

        Node prev; //address of the node before this one in line

        //the Node constructor, next and prev will be null in default, you can change it everytime you construct a node.
        public Node() {
            next = null;
            prev = null;
        }
    }
//    fields
    private Node pre;
    private Node post;
    private int size;
    public LinkedQueue() {
        // an empty list has 2 sentinel (dummy) nodes that serves as bookends
        pre = new Node();
        post = new Node();
        pre.next = post; // this will connect the pre to the post
        // pre.prev will be null by default
        post.prev = pre; // this will connect the post to the pre
        //post.next will be null by default
        size = 0;
    }
    /**
     * Add an item to the end of the list (queue) .
     *
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        //Renaming the post.prev as theLastOne
        Node theLastOne = post.prev;
        //make a new node
        Node theNewOne = new Node();

        //theNewOne data is set as the value
        theNewOne.data = item;

        //connect theNewOne.next to post Node
        theNewOne.next = post;

        //connect the previous node to pre
        theNewOne.prev = theLastOne;

        //connect the prev from post as theNewOne
        post.prev = theNewOne;

        //connect the next from pre as theNewOne
        theLastOne.next = theNewOne;
        // size will increase everytime a new data is created.
        size++;
    }

    /**
     * Remove an item from the queue.
     *
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        E removedItem = null;
        if(size > 0 )
        {
            //rename the pre.next which is the variable in the front .  this to the one to remove
            Node theOneToRemove = pre.next;
            removedItem = theOneToRemove.data;
            //assign the front to the next node
            theOneToRemove.next.prev = pre;
            pre.next = theOneToRemove.next;
            size--;
        }
        return removedItem;
    }

    /**
     * Checks to see if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0 )
        {
            return true;
        }
        else {
            return false;
        }
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
    @Override
    public Iterator<E> iterator() {
        DoublyLinkedListIterator theIterator = new DoublyLinkedListIterator();
        return theIterator;
    }

    //helper class/type define how the iterator works
    private class DoublyLinkedListIterator implements Iterator<E> {
        private Node current;

        public DoublyLinkedListIterator()
        {
            current = pre;
        }


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            } else {
                return true;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to! ");
            }
            E item = current.data;
            current = current.next;
            return item;
        }

    }
}
