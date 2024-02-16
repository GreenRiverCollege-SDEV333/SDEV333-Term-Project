import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    int size;
    Node tail;

    private class Node {
        E data;

        Node prev;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        tail = new Node(item, tail);
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        size--;
        E data = tail.data;
        tail = tail.prev;
        return data;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
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
            Node cur = tail;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E data = cur.data;
                cur = cur.prev;
                return data;
            }
        };
    }
}
