import java.util.Iterator;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Adds an item to the top of the stack.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        Node<E> newNode = new Node<>(item);

        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the item most recently added
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        E data = top.data;
        top = top.next;
        size--;

        return data;
    }

    /**
     * Returns the item most recently added to this stack without removing it.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the item most recently added
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return top.data;
    }

    /**
     * Checks whether the stack is empty.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the stack.
     * Time complexity: O(1) (amortized), O(N) (worst-case when resizing)
     *
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to traverse the items in the stack.
     *
     * @return an iterator to traverse the items in the stack
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements in the stack");
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}