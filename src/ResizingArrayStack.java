import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {

    private E[] buffer;
    private int size;

    public ResizingArrayStack() {
        buffer = (E[]) new Object[50];
        size = 0;
    }

    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if(size == buffer.length) {
            increaseBuffer(buffer.length * 2);
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
    public E pop() {
        E removedItem = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        if(size > 0 && size == buffer.length/4) {
            increaseBuffer(buffer.length / 2);
        }
        return removedItem;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty, no value to return");
        }
        return buffer[size - 1];
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

    private void increaseBuffer(int max) {
        E[] temp = (E[]) new Object[max];
        for(int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ResizingArrayStackIterator();
    }

    private class ResizingArrayStackIterator implements Iterator<E> {
        private int i;

        private ResizingArrayStackIterator() {
            i = size;
        }

        public boolean hasNext() {
            return i > 0;
        }

        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E currentVal = buffer[i];
            i--;
            return currentVal;
        }

    }
}
