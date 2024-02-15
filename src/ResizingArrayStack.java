import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Stack (FILO) which uses array to store data
 * @param <E>
 */
public class ResizingArrayStack<E> implements Stack<E>
{

    private int size;
    private E[] contents;
    private final int arrayLength = 10;

    /**
     * Default constructor
     *
     * Time Complexity: O(1) instantiates variables once
     */
    public ResizingArrayStack(){
        this.size = 0;
        this.contents = (E[]) new Object[arrayLength];
    }

    /**
     * Creates a new array with double the current size and saves all information in the previous array.
     *
     * Time Complexity: O(n) each element in contents array must be accessed
     *
     * @param currentLength The length of the contents array
     */
    public void resizeArray(int currentLength){
        E[] newArray = (E[]) new Object[currentLength*2];
        for (int i = 0; i < contents.length; i++)
        {
            newArray[i] = contents[i];
        }
        contents = newArray;
    }

    /**
     * Add an item to the stack.
     *
     * Time Complexity: O(n) since resize is O(n), otherwise O(1) since content array only accessed at one spot
     *
     * @param item the item to be added
     */
    @Override
    public void push(E item)
    {
        if(contents.length == size){
            resizeArray(contents.length*2);
        }
        contents[size] = item;
        size++;
    }

    /**
     * Removes the most recently added item from the stack.
     *
     * Time Complexity: O(1) contents array only accessed at one spot
     *
     * @return the item that was removed
     */
    @Override
    public E pop()
    {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E removed = contents[size - 1];
        contents[size] = null;
        size--;
        return removed;
    }

    /**
     * Returns the item at the top of the stack.
     * Does not modify the stack or the item at the top.
     *
     * Time Complexity: O(1) contents array only accessed at one spot
     *
     * @return item at the top of the stack.
     */
    @Override
    public E peek()
    {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return contents[size];
    }

    /**
     * Checks to see if the stack is empty.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns a count of the number of items in the stack.
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return the number of items in the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Time Complexity: O(1) since iterators are always on constant time
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        Iterator<E> iterator = new Iterator<E>()
        {
            private int current = 0;

            @Override
            public boolean hasNext()
            {
                return current < size;
            }

            @Override
            public E next()
            {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }

                return (E) contents[current++];
            }
        };

        return iterator;
    }
}
