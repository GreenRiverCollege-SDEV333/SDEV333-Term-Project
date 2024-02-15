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

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    private Node<E> loopList(int i, Node<E> current) {

        for(int j = 0; j < i; j++){
            current = current.next;
        }
        return current;
    }

    /**
     * Remove item at the front of the list.
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
     * Remove item at the back of the list
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
     * Remove item from the list
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
     *
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
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // returns true if list is empty
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size; // returns size field
    }

    /**
     * Returns an iterator over elements of type {@code T}.
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
