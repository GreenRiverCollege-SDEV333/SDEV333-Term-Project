import java.util.Iterator;

/**
 * class for the LinkedStack
 * @param <E> data type
 * @author Huy Nguyen
 * @version 1.0
 *
 */
public class LinkedStack<E> implements Stack<E> {
    //fields
    private Node head;
    private int size;
    private class Node{
        E data;
        Node next;
    }

    /**
     *  constructor
     */

    public LinkedStack(){
        head = null;
        size = 0;
    }

    /**
     * this will always run at O(1) because it will always be adding at the
     * front of the LinkedList which is constant time access
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //save reference to head
       Node saveHead = head;
       head = new Node();
       head.data = item;

       //set head to save original reference
       head.next = saveHead;
       size++;
    }

    /**
     * this wille be running at constant time O(1) because you
     * are you only getting the value of the head and returning it
     * and making a new reference which does not require iterating
     * through the rest of the data, cause the head already points
     * to the reference of the data.
     * @return
     */
    @Override
    public E pop() {
        //save reference
        E valye = head.data;

        //remove first node
        head = head.next;
        size--;
        return valye;
    }

    /**
     * returns the head data
     * this will always be running at constant time because you're
     * checking the head of the node which does not require to iterate
     * through any other nodes meaning it will be O(1)
     * @return the data at the front of the list
     */
    @Override
    public E peek() {
        return head.data;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you're only checking one value
     1     * @return the size of the stack
     */
    @Override
    public boolean isEmpty() {
        return size==0;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E>{
        //set reference to the head of the object
        Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.data;

            //iterate once
            current = current.next;
            return value;
        }
    }
}
