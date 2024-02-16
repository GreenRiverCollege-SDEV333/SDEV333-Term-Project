import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {

    private E[] buffer;
    private int size;

    public ResizingArrayStack() {
        buffer = (E[]) new Object[1];
        size = 0;
    }
    private void resize(int max)
    { // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }
    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) { // Add item to top of stack.
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() { // Remove item from top of stack.
        size--;
        E item = buffer[size];
        buffer[size] = null; // Avoid loitering (see text).
        if (size > 0 && size == buffer.length / 4) {
            resize(buffer.length / 2);
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (isEmpty()) { // check if empty
            throw new NoSuchElementException("Stack is empty");
        }
        return buffer[size - 1]; // return top item in stack
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
    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E>
    { // Support LIFO iteration.
        private int i = size;
        public boolean hasNext() { 
            return i > 0; 
        }
        public E next() {
            i--;
            return buffer[i];
        }
    }
}
