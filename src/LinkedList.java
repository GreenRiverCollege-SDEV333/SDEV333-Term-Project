import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class which represents the LinkedList
 * @author Huy Nguyen
 * @version 1.0
 *
 * @param <E>
 */

public class LinkedList<E> implements List<E>{

    //node for linked list
    private class Node{
        E data;
        Node next;
    }

    //fields
    private Node head;
    private int size;

    //constructor

    /**
     * constructor for the LinkedList creating a head with no reference and no size
     */
    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * method to add at the front of list
     * This will always be n(1) because it always have
     * a head reference for the next node to and only need
     * to change the references for the head
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        Node theNewOne = new Node();
        theNewOne.data = item;
        //empty list
        if (head == null){
            head = theNewOne;
            size++;
        }
        else{
            //assign new front references
            theNewOne.next = head;
            head = theNewOne;
            size++;
        }
    }

    /**
     * method to add a node at the end of the list
     * this is a singlely LinkedList instead of a doublely
     * LinkedList meaning that it will have to keep iterating
     * all the towards at the end to add an item. Making
     * the runtime O(n) where n is the size of the linkedList
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        //create new node
        Node temp = new Node();
        temp.data = item;

        //empty
        if (head == null){
            head = temp;
            size++;
        }
        else{
            Node curr;
            //set reference to head
            curr = head;

            //move till the last element
            while(curr.next != null){
                curr = curr.next;
            }

            //set last node to temp
            curr.next = temp;
            size++;
        }
    }

    /**
     * method to add a node at a specific index position
     * The runtime of this will always be O(n) where n is the
     * index position because that will be how many times
     * the linkedList needs to traverse nodes in order to reach
     * the correct position to add the node
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        Node curr;
        Node temp = new Node();
        temp.data = item;

        if (index < 0){
            throw new IndexOutOfBoundsException("The index value is out of bounds");
        }

        //adding at the front
        else if (index == 0 || size==0 ){
            temp.next = head;
            head = temp;
            size++;
        }

        //adding at the end of the list
        else if (index >= size){
            curr = head;
            while (curr.next != null){
                curr = curr.next;
            }

            //set the second to last reference to
            curr.next = temp;
            size++;
        }
        //adding at index position
        else{
            curr = head;
            //traverse through the linked list
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            //saves the next reference of current.
            Node saveReference = curr.next;

            //set the node equal to temp
            curr.next = temp;

            //set reference to the node after for temp
            temp.next = saveReference;
            size++;
        }
    }

    /**
     * method used to get the node's data value given an index int
     * The runtime of this will be at worst O(n) where n is the value
     * of the index position because you need to iterate through n many
     * nodes to finds it's data value. best would be O(1) assuming it's
     * the first node.
     *
     * @param index the index where the item should be retrieved
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("This index is invalid");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     *
     *
     * @param index the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
        //out of bounds
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("This index is invalid");
        }

        Node curr;
        curr = head;
        //iterate index many number of times to set
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = item;
    }

    /**
     * method used to remove the front node
     * this will always be O(1) because you're simple setting new references to
     * the head
     *
     * @return the value being removed
     */
    @Override
    public E removeFront() {
        //head is empty do nothing
        if (head == null){
            return null;
        }
        else{
            E value = head.data;
            //skip to the next node
            head = head.next;
            size--;
        }
        return head.data;
    }

    /**
     * method used to remove the last node
     * This will always be running at O(n) where n is the size
     * of the LinkedList. This is because you always need to go
     * to the end of the list to remove the last item by removing
     * the last node reference.
     * @return
     */
    @Override
    public E removeBack() {
        //head is empty do nothing
        if (head == null){
            return null;
        }
        //one item so return head reference
        if (size == 1){
            E value = head.data;
            head = null;
            size--;
            return value;
        }
        else{
            Node curr = head;
            while (curr.next.next != null){
                curr = curr.next;
            }
            E value = curr.next.data;
            curr.next = null;
            return value;
        }
    }

    /**
     * method to remove a specific node with contained data
     * this will always be O(n) where n is the number of
     * times you need to iterate to find the item in the
     * LinkedList.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node curr = head;

        //if the list is empty
        if (head ==null){
            return;
        }

        //if the head needs to be removed
        if (head.data.equals(item)){
            head = head.next;
            size--;
            return;
        }
        //iterating to find the item
        while (curr.next != null){

            if (curr.next.data.equals(item)){
                //remove the reference
                curr.next = curr.next.next;
                size--;
                return;
            }

            //move through the linked list
            curr = curr.next;
        }
    }

    /**
     * method to remove a specific node at a index position
     * this will always be O(n) where n is the index value because you
     * need to iterate through the nodes i number of times to find
     * that specific node to remove the reference from
     *
     * @param index the index where the item should be removed
     * @return the value removed
     */
    @Override
    public E remove(int index) {
        Node curr;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("This index is invalid");
        }
        //removing at the front
        if (index == 0) {
            curr = head;
            Node saveNode = curr;

            //remove the front node
            head = head.next;
            size--;
            return saveNode.data;
        }

        //removing at the end
        else if (index == size - 1) {
            curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }

            Node saveNode = curr.next;
            //save current value to this variable
            curr.next = null;
            size--;
            return saveNode.data;
        }
        else {
            curr = head;

            //advance index number of places to before the removed element
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node prev = curr;

            //save the node being removed
            Node saveNode = curr.next;

            //form a new reference
            prev.next = curr.next.next;

            size--;
            return saveNode.data;
        }
    }

    /**
     * method used to see if contains a specific item
     * the runtime for this method will always be O(n)
     * where n is the number of time it must iterate
     * through the LinkedList to find the item. It must
     * iterate potentially the whole list to see if the
     * item is present within the nodes.
     *
     * @param item the item to search for
     * @return if the linkedList contains the item or not
     */
    @Override
    public boolean contains(E item) {
        //with an empty list
        Node curr = head;

        if (head == null){
            return false;
        }

        else if (size == 1){
            return curr.data.equals(item);
        }

        while (curr.next != null){

            //found within the list
            if (curr.data.equals(item)){
                return true;
            }

            //advances through the list
            curr = curr.next;
        }

        //return if it is in the list (last element)
        return curr.data.equals(item);
    }

    /**
     * checks to see if it is empty
     * this will always be O(1) because it is only one check to see if head is
     * equal to null or no references
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /**
     * returns the size of the LinedList
     * this will always be O(1) because it is simply returning a field for the object
     * @return the size of the LinkedList
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private Node current;
            @Override
            public boolean hasNext() {
                current = head;
                return current != null;
            }
            @Override
            public E next() {
                if (current == null){
                    throw new NoSuchElementException("There is no next one to go to!");
                }
                E value = current.data;

                //iterate one
                current = current.next;
                return value;
            }
        };
    }
}
