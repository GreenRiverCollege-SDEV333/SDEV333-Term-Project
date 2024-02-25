import java.util.Arrays;
import interfaces.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ryder Dettloff
 * Resizing Arraystack implements adding and removing from the top of a stack.
 * @param <E>
 */
public class ResizingArrayStack<E> implements Stack<E> {
    //Array Stack Fields
    private E[] buffer;
    private int size;
    private static final int INITIAL_SIZE = 10;


    //Array Stack Constructor
    public ResizingArrayStack() {
        this.buffer = (E[]) new Object[INITIAL_SIZE];
        this.size = 0;

    }

    /**
     * doubles the size of the buffer to be used in the push method
     * (HELPER METHOD)
     */
    private void increaseBuffer(int increaseBuffer) {
        //helper for push/pop doubles size of array and copies it over to the new one
        int newBuffer = buffer.length * 2;
        buffer = Arrays.copyOf(buffer, newBuffer);
    }

    /**
     * Add an item to the stack.
     * checks to see if buffer is of size then pushes the item to the stack
     * @param item the item to be added
     * Time Complexity: is O(1)(constant) becuase of simple indexing (could take O(N)(Linear) if array needs to be resized Worst case)
     */
    @Override

    public void push(E item) {
        //checks if buffer needs an increase in size
        if (size == buffer.length) {
            increaseBuffer(2 * buffer.length);
        }
        //assigns item to the top of stack and increments it
        buffer[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     * Time Complexity O(1)(constant) due to simple indexing
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        // access item at top of stack and sets it to null for garbage collector
        E item = buffer[size - 1];
        size--;
        buffer[size] = null;
        //decreases the size of the buffer
        if (size > 0 && size == buffer.length / 2) {
            increaseBuffer(buffer.length % 2);
        }

        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *  Time Complexity O(1)(constant) due to simple indexing
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        //exception if the stack is empty(no peek)
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, cannot peek()");
        }

        //finds and returns the top of stack with the index
        return buffer[size-1];
    }

    /**
     * Checks to see if the stack is empty.
     * Time Complexity O(1)(constant) due to checking value of size compared to 0
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * Time Complexity O(1) (constant) due to just checking value of arrau
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
    public Iterator iterator() {
        return null;
    }


    //copied from my ArrayList class , need to update
    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no index exists!");
            }
            return buffer[currentIndex++];
        }
    }
}