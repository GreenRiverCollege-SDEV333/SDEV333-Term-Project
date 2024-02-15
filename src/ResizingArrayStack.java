import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E> {

    private E[] array;
    private int size;


    /**
     * a constructor for the ResizingArrayStack class
     */
    public ResizingArrayStack() {
        this.array = (E[]) new Object[1];
        this.size = 0;
    }

    /**
     * Add an item to the stack.
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //add item to top of stack
        if (size == array.length) {
            resize(2*array.length);
        }
        System.out.println(item);
        array[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * @return the item that was removed
     */
    @Override
    public E pop() {
        //remove item from top of stack
        size--;
        E item = array[size];
        array[size] = null; //avoid loitering
        if (size > 0 && size == array.length/4) {
            resize(array.length/2);
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
        return array[size - 1];
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


    private void resize(int max) {
        //move stack to a new array of size max
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
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
        //support LIFO iteration
        private int i = size-1;


        public boolean hasNext() {
            return i >= 0;
        }

        public E next() {
            i--;
            return array[i];
        }


    }
}
