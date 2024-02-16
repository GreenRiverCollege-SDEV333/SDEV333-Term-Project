/**
 * Linked Bag implementation
 * Bag uses linked nodes to store its data
 *
 * @author R.J. trenchard
 * 2/15/2024
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> implements Bag<E> {

    int size;
    Node head, tail;

    private class Node {
        E data;

        Node next;

        public Node (E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds an item to the bag
     * O(1), because we keep track of the tail end, we can always add to it without searching for it.
     *
     * @param item An item of the generic type.
     */
    @Override
    public void add(E item) {
        // case: Bag is empty, create head
        if (this.isEmpty()) {
            tail = head = new Node(item);
        }
        // case: bag has elements, add element to tail end
        else {
            tail = tail.next = new Node(item);
        }
        size++;
    }


    /**
     * Returns true if the bag has no items.
     * O(1), empty access is instant
     *
     * @return true if empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the amount of items in the bag.
     * O(1), size access is instant
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n), will always loop over the whole list
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();

                E data = cur.data;
                cur = cur.next;
                return data;
            }
        };
    }
}
