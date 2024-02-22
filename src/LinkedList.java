import java.util.Iterator;

public class LinkedList <E> implements List <E> {
    //set up the head
    private Node head;

    // set up the head field
    private  int size;
    private class Node {
        E data;
        Node next;
        public Node(E value){
            this.data=value;
        }

    }
    public LinkedList(){
        head = null;
        size = 0;
    }


    /**
     * Add item to the front.
     *
     * O(1) because regardless of the size of the linked list,
     * all actions take constant time.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        // set up a new node
        Node theNewOne = new Node(item);

        if (head == null){
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else{
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
            size++;
        }
    }

    /**
     * Add item to the back.
     * in the worst case scenario
     * this code is O(n) where n is the number of nodes in the linked list.
     * we need to traverse through the entire
     * linked list to reach the end and add the new node.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     * in the worst case scenario
     * this code is O(n) where n is the size of the linked list.
     * worst case - have to iterate through the entire
     * linked list to find the correct position to insert the new node.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        Node newNode = new Node(item);
        if (i == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;

    }

    /**
     * Get the item at a specified index
     * .
     *  O(n) where n is the index i. This is because the code
     *  iterates through the linked list nodes until it reaches the node at index i.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        Node current = head;
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        for (int j = 0; j < i; j++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     *  O(n) where n is the index i. This is because the code
     *  iterates through the linked list nodes until it reaches the node at index i.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     *  this method is O(1) because it performs a constant
     *  number of operations regardless of the size of the linked list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if(head == null){
            //if there is nothing to delete
            throw new IndexOutOfBoundsException("Array is empty");
        }

        E removedItem = head.data;
        if (head.data == null) {
            head = null;
        } else {
            head = head.next;
        }
        size--;
        return removedItem;
    }

    /**
     * Remove item at the back of the list
     *
     * this code is O(n) because we would need to traverse
     * through the entire linked list to find the second to last node.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node current = head;
        E removedItem = current.data;
        if(current == null){
            //if there is nothing to delete
            throw new IndexOutOfBoundsException("Array is empty");
        }
        if(current.next == null){
            //if there is only 1 value in the array
            removedItem = head.data;
            current = null;

        }else{
            //for traversing the list to the second to last node, then remove current.next
            while (current.next.next !=null){
                current = current.next;
            }
            removedItem = current.next.data;
            current.next = null;

        }
        size--;
        return removedItem;


    }

    /**
     * Remove item from the list
     *
     *  in the worst case scenario, this code is O(n)
     *  we may have to iterate through all the
     *  elements in the linked list to find and delete the specified item.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node current = head;
        if(current == null){
            //if there is nothing to delete
            throw new IndexOutOfBoundsException("Array is empty");
        }
        // Handle case where item is at the beginning of the list
        while (head != null && head.data.equals(item)) {
            head = head.next;

        }
        while (current != null && current.next != null) {
            if (current.next.data.equals(item)) {
                current.next = current.next.next;

            }
            else {
                current = current.next;
            }
        }
        size--;

    }

    /**
     * Remove item at a specified index.
     *
     *  in the worst case scenario, this code is O(n)
     *   we may have to iterate through n
     *    elements in the linked list to find and delete the specified item at index listed.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        Node current = head;
        E removed;//keep track of the removed value
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        if(i == 0){
            removed = head.data;
            head = head.next;

        }else{
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }

            removed = current.next.data;
            current.next = current.next.next;
            size--;
        }

        return removed;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node current = head;//traverse the list from start to finish
        if(current == null){
            throw new IndexOutOfBoundsException("Array is empty");
        }
        while(current!= null){
            if(current.data.equals(item)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
