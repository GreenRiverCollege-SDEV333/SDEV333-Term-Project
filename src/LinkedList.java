import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    Node head;
    int size;

    protected class Node {
        Node next;
        E data;

        public Node() {
            this(null,null);
        }

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
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
        add(0, item);
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        add(size(), item);
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        // check if in range
        if (i < 0 || i > size() ) throw new IndexOutOfBoundsException(String.format("%d out of range.", i));

        size++;

        // case: size is 0/no head
        if (head == null) {
            head = new Node(item);
            return;
        }

        // case: index 0, need to reassign head
        if (i == 0) {
            head = new Node(item, head);
            return;
        }

        // case: valid index
        // wind to the place we want to add.
        Node cur = head;
        for (int j = 0; j < i - 1; j++) {
            cur = cur.next;
        }

        // insert an item at this point
        cur.next = new Node(item, cur.next);

    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        // check if valid range
        if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException(String.format("%d out of range.", i));

        Node cur = head;

        // wind to index and return that data
        for (int j = 0; j < i; j++)
            cur = cur.next;

        return cur.data;
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
        // check if valid range
        if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException(String.format("%d out of range.", i));

        // wind to index, set that item.
        Node cur = head;
        for (int j = 0; j < i; j++)
            cur = cur.next;

        cur.data = item;

    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        return remove(0);
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return remove(size()-1);
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (cur.data.equals(item)) {
                remove(i);
                return;
            }
            cur = cur.next;
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
        // check if valid range
        if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException(String.format("%d out of range.", i));

        size--;

        // case: index is at position 0, need to reassign head
        if (i == 0) {
            E data = head.data;
            head = head.next;
            return data;
        }

        // case: any other index
        Node cur = head, prev = cur;
        for (int j = 0; j < i; j++) {
            prev = cur;
            cur = cur.next;
        }

        E data = cur.data;

        // remove reference to current node
        prev.next = cur.next;

        return data;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (cur.data.equals(item)) return true;
            cur = cur.next;
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
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                E data = cur.data;
                cur = cur.next;
                return data;
            }
        };
    }
}
