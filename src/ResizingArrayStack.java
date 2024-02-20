/**
 * This class is a resizing array that implements the stack.
 * It allows resizing of the array when the capacity is full
 * and has methods to add items (push), remove items (pop)
 * and retrieve item (peek) in the stack.
 *
 * @author Dhiyaa Nazim
 */
import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E>{
    private E[] array;
    private int size;

    public ResizingArrayStack() {
        array = (E[]) new Object[1];
        size = 0;
    }

    /**
     * Resizes the array with a new size
     * @param max the int for new array size
     *
     * This method runs in O(n) as this method
     * is for resizing an array with a new array
     * size. This requires a loop and visiting
     * every item and copying it to the new array
     */
    private void resize(int max) {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    /**
     * Add an item to the stack.

     * @param item the item to be added
     *
     * This method runs in a O(n) or linear time
     * in a worst case scenario if the array is full
     * as it will use resize() to copy over the
     * entire array into a new array which would require
     * a loop to visit all the items. Otherwise, it will
     * run in constant time if resize is not used.
     */
    @Override
    public void push(E item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     *
     * Similar to the push method, if array is full
     * this method will run in a O(n) or linear time
     * in a worst case scenario as it will use resize()
     * to copy over the entire array into a new array
     * which would require a loop to visit all the items.
     * Otherwise, it will run in constant time if resize is not used.
     */
    @Override
    public E pop() {
        size--;
        E item = array[size];
        array[size] = null;

        if (size > 0 && size == array.length/4) {
            resize(2 * array.length);
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * @return item at the top of the stack.
     *
     * This method runs in constant time as it
     * only need to access the array at the top
     * of the stack which doesn't rely on the size
     * of the array or any loops. Therefore,
     * runtime will be O(1).
     */
    @Override
    public E peek() {
        return array[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     *
     * The runtime for this method will be O(1)
     * since it's only comparing a variable and
     * doesn't rely on the array.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the stack
     *
     * Similar to isEmpty(), this method is
     * only accessing a variable and doesn't
     * rely on the array. Therefore, the runtime is
     * O(1) or constant time.
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

    private class ReverseArrayIterator implements Iterator<E> {
        private int i = size - 1;
        public boolean hasNext() {
            return i >= 0;
        }
        public E next() {
            E current = array[i];
            i--;
            return current;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
