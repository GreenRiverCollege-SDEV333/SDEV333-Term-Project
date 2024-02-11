import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private int size;

    public LinkedList() {
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
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node newNode = new Node();
        newNode.data = item;
        if(isEmpty()) {
            head = newNode;
        } else if(size == 1) {
            head.next = newNode;
        } else {
            int counter = 0;
            for(Node current = head; current != null; current = current.next) {
                if(counter == size - 1) {
                    current.next = newNode;
                    break;
                }
                counter++;
            }
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
        if(i == 0) {
            addFront(item);
        } else if(isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty, value must be added to the front");
        } else if(i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        Node newNode = new Node();
        newNode.data = item;
        int counter = 0;
        for(Node current = head; current.next != null; current = current.next) {
            if(counter == i - 1) {
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
            counter++;
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
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to return.");
        } else if (i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException("Invalid index.");
        } else if(size == 1) {
            return head.data;
        }
        int counter = 0;
        E retreivedVal = null;
        for(Node current = head; current != null; current = current.next) {
            if(counter == i) {
                retreivedVal = current.data;
            }
            counter++;
        }
        return retreivedVal;
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
        if(isEmpty() && i > 0) {
            throw new IndexOutOfBoundsException("List is empty, value must be placed at the front");
        } else if(i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        int counter = 0;
        for(Node current = head; current != null; current = current.next) {
            if(counter == i) {
                current.data = item;
            }
            counter++;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to remove.");
        }
        E removedVal = head.data;
        head = head.next;
        size--;
        return removedVal;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        E removedVal = null;
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to remove");
        } else if (size == 1) {
            removedVal = head.data;
            head = null;
            return removedVal;
        }
        for(Node current = head; current != null; current = current.next) {
            if(current.next.next == null) {
                removedVal = current.next.data;
                current.next = null;
                size--;
            }
        }
        return removedVal;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to remove.");
        } else if (size == 1) {
            if(head.data.equals(item)) {
                head.data = null;
                size--;
            }
        }
        for(Node current = head; current.next != null; current = current.next) {
            if(current.next.data.equals(item)) {
                current.next = current.next.next;
                size--;
                break;
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
        E removedVal = null;
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty, no values to remove.");
        } else if(i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if(size == 1) {
            removedVal = head.data;
            head.data = null;
            size--;
            return removedVal;
        }
        int counter = 0;

        for(Node current = head; current != null; current = current.next) {
            if(counter == i - 1) {
                removedVal = current.next.data;
                current.next = current.next.next;
                size--;
                break;
            }
            counter++;
        }
        return removedVal;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        if(isEmpty()) {
            return false;
        } else if(size == 1) {
            return head.data.equals(item);
        }
        for(Node current = head; current.next != null; current = current.next) {
            if(current.data.equals(item)) {
                return true;
            }
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
        return size == 0;
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
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<E> {

        private Node current;

        private LinkedListIterator() {
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
            E val = current.data;
            current = current.next;
            return val;
        }
    }
}
