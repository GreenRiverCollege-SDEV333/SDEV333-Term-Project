import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node head;
    private int size;

    private class Node {
        E data;
        Node next;
        public Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     * @param item the item to be added
     *
     * The method runs in O(1) or constant time,
     * since the operation does not traverse the
     * list or depend on the size of the list,
     * it has a constant time complexity
     */
    @Override
    public void addFront(E item) {
        Node newNode = new Node(item, null);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    /**
     * Add item to the back.
     * @param item the item to be added
     *
     * The method runs in O(n) as adding an item to
     * the back of a linked list requires visiting
     * every item in the list to reach the last node.
     * Therefore, the runtime complexity is linear.
     */
    @Override
    public void addBack(E item) {
        Node newNode = new Node(item, null);
        if (head == null){
            head = newNode;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * Add an item at specified index (position).
     * @param i the index where the item should be added
     * @param item the item to be added
     *
     * The method runs in O(n) as adding an item at
     * a specified index requires traversing the list
     * until it reaches the index. Therefore, in a worse case
     * scenario it would be linear time as it may require
     * searching the entire list to find the index.
     */
    @Override
    public void add(int i, E item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node indexNode = head;
        for(int j  = 0; j < i - 1; j++){
            indexNode = indexNode.next;
        }
        Node newNode = new Node(item, indexNode.next);
        indexNode.next = newNode;

        size++;

    }

    /**
     * Get the item at a specified index.
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     *
     * The method runs in O(n) or linear time in a
     * worse case scenario as getting an item at
     * a specified index may require traversing the
     * entire list to find the index.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node getNode = head;
        for(int j  = 0; j < i; j++){
            getNode = getNode.next;
        }
        E item = getNode.data;
        return item;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * @param i the index where the item should be saved
     * @param item the item to be saved
     *
     *  This method runs in O(n) time since setting
     *  an item at a specified index may require
     *  traversing the list to search for the item.
     *  Therefore, it would linear time in a
     *  worse case scenario as the item could
     *  be at the end of the list and would have to
     *  visit every item to reach the end.
     */
    @Override
    public void set(int i, E item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node indexNode = head;
        for(int j  = 0; j < i; j++){
            indexNode = indexNode.next;
        }
        indexNode.data = item;
    }

    /**
     * Remove item at the front of the list.
     * @return the item that was removed
     *
     * This method runs in O(1) or constant time
     * since removing an element in the front doesn't require
     * traversing and only involves updating the head.
     * The method doesn't depend on the size of the list.
     */
    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        E remove = head.data;
        head = head.next;
        size--;
        return remove;
    }


    /**
     * Remove item at the back of the list
     * @return the item that was removed
     *
     * This method runs in O(n) or linear time
     * since removing the item at the back of the
     * list would require visiting every item to
     * reach the end. Therefore, since this method depends
     * on the size of the list, it would be linear time.
     */
    @Override
    public E removeBack() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        Node lastNode = head;
        Node prevNode = null;

        if(size == 1){
            E remove = lastNode.data;
            lastNode = null;
            size--;
            return remove;
        }

        while(lastNode.next != null){
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        E remove = lastNode.data;
        prevNode.next = null;
        lastNode.data = null;

        size--;
        return remove;
    }

    /**
     * Remove item from the list
     * @param item the item to be removed
     *
     * This method runs in O(n) time
     * since this method would require to traverse
     * and search the list for an item. Worse case scenario,
     * the item could be at the end of the list thus,
     * the time complexity is linear.
     */
    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        Node indexNode = head;
        Node prevNode = null;

        for(int i = 0; i < size - 1; i++) {
            prevNode = indexNode;
            indexNode = indexNode.next;
            if (indexNode.data.equals(item)){
                prevNode.next = indexNode.next;
                indexNode = null;
            }
        }
        size--;
    }

    /**
     * Remove item at a specified index.
     * @param i the index where the item should be removed
     * @return the item that was removed
     *
     * This method runs in O(n). Similar to the
     * previous method, this would require traversing
     * the list until the specified index to find the
     * item. Worse case scenario, the index might be at
     * the end of the list thus, the time complexity would
     * be linear.
     */
    @Override
    public E remove(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node indexNode = head;
        for(int j = 0; j < i - 1; j++){
            indexNode = indexNode.next;
        }
        Node removeNode = indexNode.next;
        E value = removeNode.data;

        indexNode.next = removeNode.next;
        size--;

        return value;
    }


    /**
     * Checks if an item is in the list.
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     *
     * This method runs in O(n) or linear time
     * as checking for an item in a list would
     * require searching for the item which means
     * traversing the list to find it. Worse case
     * scenario the item might be at the end of
     * the list and would require visiting every
     * item in the entire list to find it.
     */
    @Override
    public boolean contains(E item) {
        Node indexNode = head;
        for(int i = 0; i < size; i++){
            if( indexNode.data.equals(item)){
                return true;
            }
            indexNode = indexNode.next;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     *
     * This method runs in constant time, or O(1)
     * as this method only requires a simple operation
     * that doesn't need to traverse or search the list.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * @return number of items in the list
     *
     * This method runs in O(1), similar to the previous
     * method, it only requires a simple operation to execute
     * and doesn't need to traverse or search the list.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node current;
        public LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(current == null){
                throw new NoSuchElementException("Current is null!");
            }

            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
