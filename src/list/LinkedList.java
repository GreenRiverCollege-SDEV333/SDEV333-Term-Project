package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represent a Linkedlist data structure
 * @param <E>
 */
public class LinkedList <E>  implements List<E> {

    //define what a node is
    private class Node {
        E data;
        Node next;
    }
    //fields
    private Node head;
    private int size;
    public LinkedList ( )
    {
        head = null;
        size = 0;
    }
    /**
     * Add item to the front.
     *  runtime: o(1)
     *  this method will only need one action, which
     *  is putting the node as head.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = item;

        if (head == null)
        {
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else
        {
            //the list currently has some nodes in it.
            theNewOne.next = head;
            head = theNewOne;
            size++;
        }
    }

    /**
     * Add item to the back.
     *
     * runtime: o(n)
     * this will through all the data, and add the element
     * to the back
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        // creata a new node.
        Node theNewOne = new Node();
        // put the value as the new node data.
        theNewOne.data = item;
        Node current = head;

        if(head == null)
        {
            // if the list is empty
            head = theNewOne;
            size++;
        }
        else {
            //if the list is not empty
            while (current.next != null) {
                current = current.next;
            }
            current.next = theNewOne;
            size++;
        }

    }

    /**
     * Add an item at specified index (position).
     *
     *  runtime: o(n)
     *  this will count the indexes, find a certain indexes,
     *  will go through all the nodes until it stop at
     *  the specify index, and link it to the list.
     *
     * @param index   the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        // Create a node pointer to head
        Node current = head;
        // create a new node
        Node theNewOne = new Node();
        //set the value to the new node data.
        theNewOne.data = item;
        if(index < 0 )
        {
            throw new IndexOutOfBoundsException("the index can not be less than 0 ");
        } else if (index > size) {
            if(size == 0 )
            {
                head = theNewOne;
            }else {
                throw new IndexOutOfBoundsException( "The index is greater than the list itself. ");
            }

        }else{

            if(current != null) { // if the point is not null or any of the current value is not null
                if (index == 0) { // if the index is 0, we can use addfront that is already created.
                    addFront(item);
                } else{ // else if there is already values in there, we will do a fori loop that ends with the index
                    for (int i = 1; i < index; i++) {
                        current = current.next;
                    }
                    //create a temp node so we wont lose the data.
                    Node temp = current.next;
                    // set the current.next connect to the new node.
                    current.next = theNewOne;
                    //set the new node . next connects to the existing node.
                    theNewOne.next = temp;
                    size++;
                }
            }
        }
    }

    /**
     * Get the item at a specified index.
     *
     * runtime: o(n)
     * this will go through all the node, it will
     * get the element at a specify index. which it will go through
     * all of the indexes if it is in the back .
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        if(index < 0 )
        {
            throw new IndexOutOfBoundsException("The index can not be less than zero . ") ;
        }else if(index > size){
            throw new IndexOutOfBoundsException("the index can not be more than the size. ");
        }else if(index == 0 ){
            return head.data;
        }else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            return current.next.data;
        }
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * runtime: o(n)
     * it will run through specify index, which in worse case
     * can be all the way at the back and if so, it will go through
     * each nodes and count the index.
     *
     * @param index  the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index , E item) {
        if(index < 0 )
        {
            throw new IndexOutOfBoundsException("The index can not be less than zero . ") ;
        }else if(index > size){
            throw new IndexOutOfBoundsException("the index can not be more than the size. ");
        } else {
            if(head == null) {
                throw new NoSuchElementException("The list is empty");
            }
            else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.data = item;
            }
        }
    }

    /**
     * Remove item at the front of the list.
     * runtime: o(i)
     * this will remove the front, and reassign the new element as the head
     * this is constant since it will not touches every node.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        E temp = head.data;
        if(head == null)
        {
            throw new NoSuchElementException("The list is empty");
        }
        else {
            head = head.next;
            size--;
        }
        return temp;
    }

    /**
     * Remove item at the back of the list
     *
     * runtime: o(n)
     * this will have go through all of the nodes until
     * it reaches to the back of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        E temp = null;
        if(head == null) // if the head is null meaning there is no list at all , the list is empty, can not remove anything
        {
            throw new NullPointerException("The head is null, meaning there is no list. ");
        }
        else if(head.next == null) // if the head.next is null meaning there is only one item in a list. it will delete itself.
        {
            head = null;
            size--;
        }
        else { // else if there is more than 1 item in list, it will check for the next next node
            // create a pointer that starts at head.
            Node current = head;
            //check for the next next node instead of next node.
            while(current.next.next != null){
                //current will move to next node if there next next node is not null
                temp = current.data;
                current = current.next;
            }
            //if the next next node is null, it will stopped and cut off the current.next and set it to null
            current.next = null;
            size--;

        }
        return temp;
    }

    /**
     * Remove item from the list
     * runtime: best case o(1) the head, will just need to reassigned head
     * runtime worst case o(n)  will go through each element to find the matching item,
     * or even if there are no match elemenet, it went all through all of the nodes.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
//        if the first item is the item
        if(head.data.equals(item))
        {
            removeFront();
        }else {

            Node current = head;
            while (current.next != null)
            {
                if(current.next.data.equals(item))
                {
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
        }

    }

    /**
     * Remove item at a specified index.
     *
     * runtime: o(n)
     * it will have to search through the list at a certain index
     * and remove .
     * worse case is to find the index is all the way at the bottom of the list.
     * which will scan through all the nodes
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        if(index < 0 )
        {
            throw new IndexOutOfBoundsException("The index can not be less than zero . ") ;
        }else if(index > size){
            throw new IndexOutOfBoundsException("the index can not be more than the size. ");
        }else if(index == 0 )
        {
            E temp = head.data;
            head = head.next;
            return temp;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = current.next.next;
            size--;
            return temp.data;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * runtime o(n)
     * this method will through all of the element to check if the list
     * contain a certain item in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        //this will loop through all the Linked-list.
        if(head == null)
        {
            throw new NoSuchElementException(" The list is empty. ");
        }
        Node current = head;
        if(current.next == null)
        {
            if(current.data == item){
                return true;
            }
        }
        while (current.next != null) {
            current = current.next;
            if (current.data == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * runtime: o(1)
     * this will only require checking the head, to see if it is null
     * and it will return true or false.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(head == null ){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * runtime: o(1)
     * this will only need to access the field size and check
     * the value of the size
     *
     * @return number of items in the list
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
