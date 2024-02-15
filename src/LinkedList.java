import java.util.Iterator;

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
         * @param item the item being stored in node
         */
        public Node(E item) {
            this.item = item;
        }
    }

    /**
     * The first Node of the current LinkedList
     */
    private Node head;

    /**
     * The number of Nodes contained within this LinkedList
     */
    private int size;

    /**
     * Constructs an empty LinkedList
     */
    public LinkedList() {
        // list starts off empty
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
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
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {

    }

    /**
     * Add an item at specified index (position).
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {

    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {

    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        return null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return null;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {

    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Checks if an item is in the list.
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
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0 && head == null;
    }

    /**
     * Provides a count of the number of items in the list.
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
        return null;
    }
}
