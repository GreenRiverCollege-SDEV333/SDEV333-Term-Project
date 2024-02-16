/**
 * Toby Goetz
 */

package abstractDataTypes;

import interfaces.Stack;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Book People
 * @version 1.0
 * @param <E>
 */
public class ResizingArrayStack<E> implements Stack<E> {

    private E[] arr;
    private int size;

    /**
     * Constructor to instantiate ResizingArrayStack
     * 0(1) at worst because of a few assignments
     */
    public ResizingArrayStack()
    {
        this.arr = (E[]) new Object[1];
        size = 0;
    }

    /**
     * Add an item to the stack.
     * O(n) at worst
     * O(1) at best
     * This function is linear at worst because it utilizes
     * resize() to resize the array which is linear. It is
     * logarithmically constant, meaning that resize() is
     * only called n^2 times
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    { // Add item to the top of stack
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = item;
    }

    /**
     * Removes the most recently added item from the stack.
     * O(n) at worst
     * O(1) at best
     * This function is linear at worst because it utilizes
     * resize() to resize the array which is linear. It is
     * logarithmically constant, meaning that resize() is
     * only called n^2 times (math might be wrong)
     * @return the item that was removed
     */
    @Override
    public E pop()
    { // Remove item from top of Stack
        E item = arr[--size];
        arr[size] = null;
        if (size > 0 && size == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     * O(1) at worst
     * This function is constant because it accesses an
     * element in an array
     * @return item at the top of the stack.
     */
    @Override
    public E peek() {
        return arr[size - 1];
    }

    /**
     * Checks to see if the stack is empty.
     * O(1) at worst
     * This function is constant because it acceses an
     * instance variable and returns a boolean value
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the stack.
     * O(1) at worst
     * This function is constant at worst because it
     * only accesses an instance variable
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * O(n) at worst
     * This function is linear at worst because it loops over
     * all elements in the array. It could be Constant if the array
     * is empty. Depends on how the client code uses it.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E>
    { // Support LIFO iteration
        private int current = size;
        @Override
        public boolean hasNext() {
            return current > 0;
        }
        @Override
        public E next() {
            return arr[--current];
        }
        @Override
        public  void remove() {}

        @Override
        public String toString() {
            return "ReverseArrayIterator{" +
                    "i=" + current +
                    '}';
        }
    }

    /**
     * Resizes the instance Array arr
     * O(n) at worst
     * This function is linear at worst because it loops over
     * all elements in the array. It could be Constant if the array
     * is empty.
     * @param newLength initializes the Array arr to newLength size
     */
    private void resize(int newLength)
    { //Move stack to a new array of size newLength
        E[] temp = (E[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    /**
     * O(n) at worst
     * This function is linear at worst because it loops over
     * all elements in the array. It could be Constant if the array
     * is empty.
     * @return String value representing the list
     */
    @Override
    public String toString() {
        return "ResizingArrayStack{ " +
                "(" + size + " left on stack) " +
                Arrays.toString(arr) + " }";
    }
}
