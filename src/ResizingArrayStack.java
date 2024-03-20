import java.util.Iterator;

/**
 * class for the resizing array
 * @param <E> data type
 * @author  Huy Nguyen
 * @version 1.9
 */

public class ResizingArrayStack<E> implements Stack<E>{
    private E[] buffer;
    private int size;

    /**
     * constructor
      */
    public ResizingArrayStack(){
        this.size = 0;
        buffer = (E[]) new Object[10];
    }

    private void resize(int newSize)
    {
        //creates new array with new size
        E[] newBuffer = (E[]) new Object[newSize];

        //add into the new buffer
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }

        //set field as new buffer
        buffer = newBuffer;
    }

    /**
     *add an item to the stack
     * This will always be O(1) since you're accessing an index of an array to
     * set the new value
     * @param item the item to be added
     */
    @Override
    public void push(E item) {
        //resizing
        if (size == buffer.length){
            resize(2 * buffer.length);
        }

        buffer[size] = item;
        size++;
    }

    /**
     *the methods remove the last value in the structure and returns it
     * this utilizes indexing in an array meaning that it will always be O(1)
     *
     * @return returns the value removed
     */
    @Override
    public E pop() {
        //save value
        E value = buffer[size-1];

        //remove the value
        buffer[size] = null;

        //resize to make it smaller
        if (size== buffer.length /4){
            resize(buffer.length/2);
        }

        size--;
        return value;
    }

    /**
     * this returns the value of the newest item in the stack
     * this will always be O(1) because you re indexing the last position
     * of an array which is always constant time
     * @return the last value of the stack
     */
    @Override
    public E peek() {
        return buffer[size-1];
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you're only checking one value
1     * @return the size of the stack
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you are returning the field
     * @return the size of hte stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * get the iterator to go through the data structure
     *
     * @return an iterator of the object
     */
    @Override
    public Iterator<E> iterator() {
        return new StackItorator();
    }

    private class StackItorator implements Iterator<E>{
        private int i = size;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            E value = buffer[i-1];
            i--;
            return value;
        }
    }
}
