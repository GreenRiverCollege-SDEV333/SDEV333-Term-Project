import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Iterable<E> {
    private Node<E> front;  // Reference to the first node
    private int size;

    private static class Node<E> {
        public E data;
        public Node<E> next;
        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Add item to the front.
     * constant time, O(1), because it only involves reassigning
     * the first reference and incrementing the size.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        front = new Node<>(item, front); // replace front with item then point to front
        size++;
    }

    /**
     * Add item to the back.
     * Worst case, this operation is performed in
     * linear time, O(n), where n is the size of the list.
     * This is because in the worst case,
     * it involves traversing to the end of the list.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node<E> newNode = new Node<>(item, null);

        if (isEmpty()) {  // if list is empty, add new node to front
            front = newNode;
        } else {  // else, traverse to end of list and add new node there
            Node<E> current = front;

            // Move to the end of the list
            while (current.next != null) {
                current = current.next;
            }

            // Add new node at the end
            current.next = newNode;
        }

        size++;
    }

    /**
     * Add an item at specified index (position).
     * runs in O(n) or linear time in the worst case because
     * it may have to traverse all the items when adding
     * an item to the end of the list.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        checkIndex(i); // handle index out of bounds errors

        if (i == 0) {
            addFront(item);  // add to front method
        } else if (i == size) {
            addBack(item); // add to back method
        } else {
            Node<E> current = (Node<E>) get(i - 1); // get node before insertion using get method
            current.next = new Node<>(item, current.next); // add node and pointer to next after current
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     * Runs in worst-case linear time, O(n),
     * where n is the size of the list, because it involves
     * traversing the list up to a variable position.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        checkIndex(i); // handle index out of bounds errors

        Node<E> current = front; // start the list
        current = loopList(i, current); // loop the list to index

        return current.data; // return the data from the node
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * O(n) in the worst case because it may have to
     * traverse all the items in the case where the item is
     * being replaced at the end of the list but could be much faster
     * depending on position to be replaced.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        checkIndex(i); // handle index out of bounds errors

        Node<E> current = front; // start the list
        current = loopList(i, current); // loop the list to index

        current.data = item;
    }

    /**
     * A private helper method for checking if a given index is valid.
     * Runs in O(1) time because it simply compares an integer value
     * against the range of indexes.
     *
     * @param i the index to be checked
     * @throws IndexOutOfBoundsException if the index is not in the range 0 through size inclusive
     */
    private void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    /**
     * A private helper method for looping through a list
     * O(n) because it involves a loop that could iterate all
     * elements in the list depending on the value of i.
     *
     * @param i the index to loop to
     * @param current the current node in the list
     * @return the node at the i-th index
     */
    private Node<E> loopList(int i, Node<E> current) {

        for(int j = 0; j < i; j++){
            current = current.next;
        }
        return current;
    }

    /**
     * Remove item at the front of the list.
     * O(1) because it involves a constant amount of work
     * by grabbing data from the front of the list, moving
     * the front reference to the next node, then reducing
     * the size of the list and returning the item.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (isEmpty()) { // handle exceptions
            throw new NoSuchElementException("List is empty");
        }

        E item = front.data; // grab the object at the front of the list
        front = front.next; // set the object to the second object on the list
        size--; // decrease size after removing front Node

        return item;
    }

    /**
     * Remove item at the back of the list.
     * O(n) or linear time in worst case because
     * it may traverse all items in the case where the
     * item removed is an item from the end of the list.
     * The best case time is O(1), when there's only one
     * item in the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (front.next == null) {  // one node in the list
            E item = front.data; // grab only item in list
            front = null; // set to null and decrease size
            size--;
            return item; // return item deleted
        } else {
            Node<E> current = front; // or traverse until the end is found
            while (current.next.next != null) {
                current = current.next;  // stop at the node before last
            }
            E item = current.next.data; // grab the last node
            current.next = null; // set to null and decrease size
            size--;
            return item; // return deleted item
        }
    }

    /**
     * Remove a specific item from the list.
     * In the worst case O(n), where n is the size of the list.
     * This occurs when the item to be removed is at the end or
     * doesn't exist. If it's at the beginning of the list,
     * the runtime is constant O(1).
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if (isEmpty()) { // handle exceptions
            throw new NoSuchElementException("List is empty");
        }

        if (front.data.equals(item)) {  // removing front node
            front = front.next;
            size--;
        } else {
            Node<E> current = front;
            while (current.next != null && !current.next.data.equals(item)) {
                current = current.next;
            }

            if (current.next != null) {  // found
                current.next = current.next.next;
                size--;
            }
        }
    }

    /**
     * Remove item at a specified index.
     * In worst case it runs in O(n) time, n being the
     * size of the list. This is because it has to traverse all the items to find the one
     * to be removed.
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        checkIndex(i); // handle exceptions

        if (i == 0) {  // remove and return front node
            E item = front.data;
            front = front.next;
            size--;
            return item;
        } else { // or loop until index and remove/ return current index.
            Node<E> current = front;
            current = loopList(i, current); // loop to index using helper

            E item = current.next.data;
            current.next = current.next.next;
            size--;

            return item;
        }
    }

    /**
     * Checks if an item is in the list.
     * Runs in linear time O(n) in the worst case,
     * where n is the size of the list. This is because it could require visiting all n nodes
     * if the item is either the last one or not present in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node<E> current = front; // enter the list
        while (current != null) { // traverse until null
            if (current.data.equals(item)) { // return true if Node is found
                return true;
            }
            current = current.next; // or move to next node
        }
        return false;
    }

    /**
     * Check if the list is empty.
     * Constant time O(1), because it simply involves
     * comparing the value of size with 0.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // returns true if list is empty
    }

    /**
     * Provides a count of the number of items in the list. This method simply returns the size,
     * so it runs in constant time, O(1).
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size; // returns size field
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * The iterator's `hasNext()` and `next()` methods have
     * a time complexity of O(1) or constant time.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() { // returns anonymous class implementing Iterator<E>
            private Node<E> current = front; // starts the list

            @Override
            public boolean hasNext() { // true unless next is null
                return current != null;
            }

            @Override
            public E next() { // traverse to next Node until empty returning current Node
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
