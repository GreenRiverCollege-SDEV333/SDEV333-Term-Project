package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a LinkedList using the List interface for generics
 * @param <E> Class may store various types of values
 * @author Zalman I.
 */
public class LinkedList<E> implements List<E> {
    /**
     * A container which contains an item and a connection to another Node
     */
    private class Node {
        /**
         * The item stored within the Node
         */
        E item;

        /**
         * The node this Node is pointing to
         */
        Node next;

        /**
         * Creates a node, and stores the given item within it
         *
         * Runtime: O(1) as it always takes the same runtime to conduct this operation
         *
         * @param item the item being stored in node
         */
        public Node(E item) {
            // store given item
            this.item = item;

            // node starts off disconnected
            next = null;
        }
    }

    /**
     * The first Node of the current LinkedList
     */
    private Node head;

    /**
     * The number of items stored in this LinkedList
     */
    private int size;

    /**
     * Constructs an empty LinkedList
     *
     * Runtime: O(1) as it always takes the same runtime to conduct this operation
     */
    public LinkedList() {
        // list starts off empty
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * Runtime: O(1) as we can quickly access the front of list via the head variable,
     * regardless of how many nodes follow it.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        // create new node containing given item
        Node newNode = new Node(item);

        // if the list is not empty
        if(!isEmpty()) {
            // point new node at head
            newNode.next = head;
        }

        // override head with newly created node
        // (making new node first node in list)
        head = newNode;

        // account for new item in list
        size++;
    }

    /**
     * Add item to the back.
     *
     * Runtime: O(1) if the list is empty. Otherwise, O(n), as runtime depends on the number of nodes already
     * in list we need to pass to reach the end.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        // if list is empty
        if(isEmpty()) {
            // add item at front of list
            addFront(item);
        }

        // if list is not empty
        else {
            // create new node containing given item
            Node newNode = new Node(item);

            // setup tracker and run to end of list
            Node current = head;

            while(current.next != null) {
                current = current.next;
            }

            // point final node at new node
            current.next = newNode;

            // account for new item in list
            size++;
        }
    }

    /**
     * Add an item at specified index (position).
     *
     * Runtime: O(1) if the given index is 0 as we use the addFront method.
     * Otherwise O(n) as we may potentially have to traverse all the way to middle or end of list.
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        // if given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if given index was at front or back, use those methods
        else if(index == 0) {
            addFront(item); // O(1)
        }

        else if(index == size) {
            addBack(item); // O(n)
        }

        else {
            // setup trackers
            Node previous = null;
            Node current = head;
            int currIndex = 0;

            // run through list, up to given index
            while(current != null && currIndex != index) {
                // update trackers
                previous = current;
                current = current.next;
                currIndex++;
            }

            // place given item in new node
            Node newNode = new Node(item);

            // update links of previous and current nodes to account for new node
            previous.next = newNode;
            newNode.next = current;

            // account for new item in list
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * Runtime: O(n) as runtime will depend on how many nodes we need to pass in list to reach the requested index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        // if given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if list is empty
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve item from empty LinkedList");
        }

        // setup trackers
        int currIndex = 0;
        Node current = head;

        // run through list, up to given index
        while(current != null && currIndex != index) {
            // update trackers
            current = current.next;
            currIndex++;
        }

        // return item at current node/index
        return current.item;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Runtime: O(1) if the list is empty as we use the addFront method.
     * Otherwise, O(n) as runtime will depend on how many nodes we need to pass in list to reach the requested index.
     *
     * @param index the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if list is empty
        if(isEmpty()) {
            // add given item to list at front
            addFront(item);
        }

        else {
            // setup trackers
            int currIndex = 0;
            Node current = head;

            // run through list, up to given index
            while (current != null && currIndex != index) {
                // update trackers
                current = current.next;
                currIndex++;
            }

            // overwrite item in current node with given item
            current.item = item;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * Runtime: O(1) as we can quickly access the front of list via the head variable,
     * regardless of how many nodes follow it.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        // if list contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty LinkedList");
        }

        // get requested item from head
        E requestedItem = head.item;

        // overwrite head with next item in sequence,
        // if no next item, head will become null
        head = head.next;

        // account for element removal
        size--;

        return requestedItem;
    }

    /**
     * Remove item at the back of the list
     *
     * Runtime: O(n), as runtime depends on the number of nodes already in list we need to pass to reach the end.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        // if list contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty LinkedList");
        }

        // setup trackers and run through list till second to last node
        Node current = head;

        while(current.next.next != null) {
            current = current.next;
        }

        // get requested item from final node
        E requestedItem = current.next.item;

        // update current node to stop tracking final node
        current.next = null;

        // account for item removal
        size--;

        return requestedItem;
    }

    /**
     * Remove item from the list
     *
     * Runtime: O(n) as we use the contains method to check if item exists, which may require running through entire list.
     * If it does exist, we then use the remove method, which in the worse case also runs at O(n).
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        // if list contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty LinkedList");
        }

        // check if list contains given item - O(n)
        if(!contains(item)) {
            throw new NoSuchElementException("Given item is not located in LinkedList");
        }

        // setup trackers and flag
        Node current = head;
        int currIndex = 0;
        boolean itemNotFound = true;

        // run through list until item is found
        while(current != null && itemNotFound) {
            // check if the current node contains given item
            if(item.equals(current.item)) {
                // call the other remove method on current index
                remove(currIndex);

                // cease loop, item was found and removed
                itemNotFound = false;
            }

            // update trackers
            current = current.next;
            currIndex++;
        }
    }

    /**
     * Remove item at a specified index.
     *
     * Runtime: O(1) if the given index is 0 as we use the addFront method.
     * Otherwise, O(n) as we may potentially have to traverse all the way to middle or end of list to unlink a node.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        // if the given index is out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }
        
        // if list contains no items, one cannot be removed
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove item from empty LinkedList");
        }

        // if given index was at front or back, use those methods
        else if(index == 0) {
            return removeFront();
        }

        else if(index == size) {
            return removeBack();
        }

        else {
            // setup trackers
            Node previous = null;
            Node current = head;
            int currIndex = 0;

            // run through list, up to given index
            while(current != null && currIndex != index) {
                // update trackers
                previous = current;
                current = current.next;
                currIndex++;
            }

            // get item stored in node at current index
            E requestedItem = current.item;

            // point previous node at current's next node,
            // thereby cutting out current
            previous.next = current.next;

            // account for removal of item
            size--;

            return requestedItem;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * Runtime: O(n) as searching for the item may require running through most of, or the entire list
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        // if list is not empty
        if(!isEmpty()) {
            // setup pointer
            Node current = head;

            // run through list
            while (current != null) {
                // check if the current Node contains given item
                if (item.equals(current.item)) {
                    // item was found
                    return true;
                }

                // move on to next node
                current = current.next;
            }
        }

        // item not located in list, or list empty
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * Runtime: O(1) as we are instantly accessing some variables and checking a condition.
     * This operation would always take the same runtime to conduct.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && head == null;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * Runtime: O(1) as we are instantly retrieving a variable.
     * This operation would always take the same runtime to conduct.
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
        return new LinkedListIterator();
    }

    /**
     * Implementation of an Iterator for the LinkedList class
     */
    private class LinkedListIterator implements Iterator<E> {
        /**
         * The current Node being tracked by the Iterator
         */
        private Node current;

        /**
         * Constructs a LinkedList iterator with the head tracked as the first Node
         */
        LinkedListIterator() {
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
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get the item stored in current node
            E currItem = current.item;

            // move on to the next node
            current = current.next;

            // return the current item
            return currItem;
        }
    }
}
