/**
 * Author : Levi Miller
 * file: ResizingArrayStack.java  implements stack interface
 * only errors are from casting and Resizing isn't being used in the test client per instruction
 */

import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E> {
    // fields
    private E[] buffer;  // stack items
    private int size; // number of items

    /**
     * default constructor: initializing fields
     * RunTime analysis: constant O(1) no loops worse case in constant
     */
    public ResizingArrayStack() {
        this.buffer = ((E[]) new Object[10]);
        this.size = 0;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns if array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns size
     */
    public int size() {
        return size;
    }


    /**
     * RunTime analysis: one loop so linear time worse cast O(n)
     * resizes array when the array is full and copy over previous array
     */
    private void resize(int max) {  // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        if (size >= 0) System.arraycopy(buffer, 0, temp, 0, size);
        buffer = temp;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * push item on stack and checks if array is full
     */
    public void push(E item) {  // Add item to top of stack.
        if (size == buffer.length) resize(2 * buffer.length);
        buffer[size] = item;
        size++;
        //  or buffer[size++] = item;

    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * pop item off stack and checks if array is not utilising the space
     */
    public E pop() {  // Remove item from top of stack.
        size--;
        E item = buffer[size];  // or E item = buffer[size--];
        buffer[size] = null;  // Avoid loitering (see text).
        if (size > 0 && size == buffer.length / 4) resize(buffer.length / 2);
        return item;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * RunTime analysis: no loop so constant time worse cast O(1)
     * returns reversed array
     */
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<E> {  // Support LIFO iteration.
        private int i = size;

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns if there is a next element in array
         */
        public boolean hasNext() {
            return i > 0;
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         * returns next element in array and decrement to index
         */
        public E next() {
            i--;
            return buffer[i];  // or buffer[i--]
        }

        /**
         * RunTime analysis: no loop so constant time worse cast O(1)
         */
        public void remove() {
        }
    }

}


