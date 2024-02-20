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

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E item) {
        Node<E> newNode = new Node<>(item);

        newNode.next = top;
        top = newNode;
        size++;
    }

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

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

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