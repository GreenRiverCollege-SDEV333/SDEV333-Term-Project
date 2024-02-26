import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * implement all of the methods in the Stack <E> interface, and implement the interator()
 * method from the iterable <E> interface
 *
 * Pushdown (LIFO) Stack - resizing array implementation
 * @author Kayley Young
 */

public class ResizingArrayStack<E> implements Stack<E> {
    private E[] buffer;
    private int size;
    private static final int SIZE = 10;
    /**
     * constructor initializes the fields.
     */
    public ResizingArrayStack() {
        this.buffer = (E[]) new Object[SIZE];
        this.size = 0;
    }

    /**
     * resizes array by placing items in old array into new array
     * @param max
     */
    public void resize(int max){
        E[] newBuffer = (E[]) new Object[max];
        //copy everything over from buffer into newBuffer
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        //
        buffer = newBuffer;
    }
    /**
     * Add an item to the stack.
     *
     * This method runs in O(1) because with single operations the complexity class is constant.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //add item to top of stack
        if (size == buffer.length){
            resize( 2 * buffer.length);
        }
        buffer[size++] = item;

    }

    /**
     * Removes the most recently added item from the stack.
     *
     * This method runs in O(1) because with single operations the complexity class is constant.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        E item = buffer[--size];
        //allow garbage collector to come by overwriting to null
        buffer[size] = null;
        if (size > 0 && size == buffer.length / 2){
            resize(buffer.length / 2);
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * This method runs in O(1) because with single operations the complexity class is constant.
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return buffer[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * This method runs in O(1) because with single comparison operation the complexity class is constant.
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
     * This method runs in O(1) because with single operations the complexity class is constant.
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
    private class ReverseArrayIterator implements Iterator<E>{

        private int item = size;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return item > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the iteration");
            }
            return buffer[--item];
        }
    }
}
