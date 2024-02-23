import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {
    private E[] stack;
    private int size;

    public ResizingArrayStack() {
        this.size = 0;
        stack = (E[]) new Object[10];
    }

    private void resize(int max) {
        //Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        if (size >= 0) {
            System.arraycopy(stack, 0, temp, 0, size);
        }
        stack = temp;
    }

    /**
     * This method will add an item to the Stack
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        if (size == stack.length) resize(2 * stack.length);
        stack[size] = item;
        size++;
    }

    @Override
    public E pop() {
        //remove item from top of stack.
        E value = stack[size - 1];
        stack[size - 1] = null;
        if (size == stack.length / 4) resize(stack.length / 2);
        size--;
        return value;
    }

    @Override
    public E peek() {
        //Return the item at the top of the stack.
        return stack[size - 1];
    }

    /**
     * This method checks if the Stack is empty.
     *
     * @return true if the Stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This method returns the number of items in the Stack.
     *
     * @return the number of items in the Stack
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    /**
     * Private iterator implementation for the ResizingArrayStack class.
     */

    private class StackIterator implements Iterator<E> {
        private int currentIndex;

        /**
         * Constructs a new StackIterator starting from the top of the stack.
         */
        public StackIterator() {
            this.currentIndex = size - 1;
        }

        /**
         * Checks if there are more elements to iterate.
         *
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }


        /**
         * Returns the next element in the iteration and moves the iterator to the previous position.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if there are no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[currentIndex--];
        }
    }
}
