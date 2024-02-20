package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack <E> implements Stack<E> {
//    fields
    private Node head;
    private int size;
//    constructor
    public LinkedStack() {
        head = null;
        size = 0;
    }
//    private node class
    private class Node
    {
        E data;
        Node next;
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
    public void push(E item) {
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
     * Removes the most recently added item from the stack.
     *
     * Runtime: o(n)
     * this method will remove the items that is in the back of the list,
     * since this is the singly linkedlist with no tracking for the tail.
     * in worse case, we have to loop through the entire linkedlist to remove
     * the back item .
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        E temp;
        if(head == null)
        {
            throw new NoSuchElementException(" The list is empty ");
        } else if (head.next == null ) {
            temp = head.data;
            head = null;
            size--;
        } else {
            Node current = head;
            while(current.next.next != null)
            {
                current = current.next;
            }
            temp = current.next.data;
            current.next = null;
            size--;
        }
        return temp;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * Runtime: o(n)
     *      * this method will look at the items that is in the back of the list,
     *      * since this is the singly linkedlist with no tracking for the tail.
     *      * in worse case, we have to loop through the entire linkedlist to find
     *      * the back item .
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        E temp;
        if(head == null)
        {
            throw new NoSuchElementException(" The list is empty ");
        } else if (head.next == null ) {
            temp = head.data;
        } else {
            Node current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            temp = current.data;
        }
        return temp;
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
        if(size == 0 ){
            return true;
        }
        else {
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
        return new LinkedIterator();
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
