package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag <E> implements Bag<E> {
//    Create Private Class Node
    private class Node
    {
        E data;
        Node next;
    }
    //    fields
    private Node head;
    private int size;
    //    constructor
    public LinkedBag() {
        head = null;
        size = 0;
    }

    /**
     * Add an item to the stack.
     *
     * Runtime: o(n)
     * This method will add the node to the back  of the list.
     * Since  this is a singly linkedlist , it will going through all of the entire nodes until it reaches the back nodes.
     *
     * @param item the item to be added
     */
    @Override
    public void add(E item) {
        //            create new node
        Node newItem = new Node();
//            make the node data equals to item
        newItem.data = item;
//        if the first item is the head, which mean the list is empty
        if (head == null){
            head = new Node();
            head.data = item;
            size++;
        }else { // if the list is not empty
            Node current = head;
            while(current.next != null )
            {
                current = current.next;
            }
            current.next = newItem;
            size++;
        }
    }
    /**
     * Checks to see if the stack is empty.
     *
     * Runtime: o(1)
     * This method will only check the size field to see if the size is either zero or not zero .
     *
     * @return true if the stack is empty, false otherwise
     */

    @Override
    public boolean isEmpty() {
        if(size == 0 )
        {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * Runtime: o(1)
     *      * This method will only check the size field to see what it is stored.
     *
     * @return the number of items in the stack
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
        LinkedIterator theIterator = new LinkedIterator();
        return theIterator;
    }
    private class LinkedIterator implements Iterator<E> {
        private Node current;

        public LinkedIterator( ) {
            current = head;
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
            if(current == null)
            {
                return false;
            }
            else{
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
            if(current == null)
            {
                throw new NoSuchElementException("There is no next one to go to! ");
            }
            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
