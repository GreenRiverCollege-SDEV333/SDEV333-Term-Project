import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

    // fields
    private int size;
    private E[] buffer;

    public ArrayList()
    {
        //initialize my fields
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Runtime analysis: Worst case scenario, this will run at O(2n) time.
     * This is because if we have a full buffer, we will need to resize.
     * To resize, we go through every element and copy to a new buffer.
     * We then have to addFront() by moving all elements over right one,
     * and then add the item to the front.
     * @param item the item to be added
     */
    @java.lang.Override
    public void addFront(E item) {
        if(size == buffer.length)
        {
            resize(size * 2);
        }

        for(int i = size; i >= 1; i--)
        {
            buffer[i] = buffer[i-1];
        }
        buffer[0] = item;
        size++;
    }

    /**
     * Runtime analysis: Worst case scenario, this will run at O(n). This is because
     * if our buffer is full, we will have to resize. Resizing means visiting all
     * elements in our original buffer and copying them over to a new one.
     * Then we will add our new item to the end of our buffer. Best case scenario,
     * this runs in constant time since we can just add an item to the back
     * and increment size.
     * @param item the item to be added
     */
    @java.lang.Override
    public void addBack(E item) {
        if(size == buffer.length)
        {
            resize(size * 2);
        }

        buffer[size] = item;
        size++;
    }

    /**
     * Worst case scenario, this would run at O(2n) time. This is because
     * if our buffer is full, we would need to resize, meaning we have to
     * loop through the entire buffer to add all items to a new, larger buffer.
     * After that, the index could be the first index meaning we have to shift
     * every element over to the right one index.
     * @param i the index where the item should be added
     * @param item the item to be added
     */
    @java.lang.Override
    public void add(int i, E item) {
        if(i > size || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(size == buffer.length)
        {
            resize(size * 2);
        }
        if (i != size) {
            for (int j = size; j > i; j--) {
                buffer[j] = buffer[j - 1];
            }
        }
        buffer[i] = item;
        size++;
    }

    /**
     * In every scenario, this would run in constant time. Since we are just
     * returning an element located at in index, this is a single line return
     * statement. There is no need to do a loop, traversal, or shifting of elements.
     * @param i the index where the item should be retrieved
     * @return
     */
    @java.lang.Override
    public E get(int i) {
        if(i > size)
        {
            throw new IndexOutOfBoundsException();
        }
        return buffer[i];
    }

    /**
     * In every scenario, this would run in constant time. Since we are just
     * changing a single elements value at an index, this is a single line,
     * with no traversal, loop, or shifting of the buffer required.
     * @param i the index where the item should be saved
     * @param item the item to be saved
     */
    @java.lang.Override
    public void set(int i, E item) {
        if(i > size)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        buffer[i] = item;
    }

    /**
     * In every scenario, this would run at O(n). This is because since we are
     * removing the front element, we have to shift every element over to the
     * left one. This requires a loop to visit every element in the buffer.
     * @return
     */
    @java.lang.Override
    public E removeFront() {
        if(!isEmpty())
        {
            E returnedItem = buffer[0];
            for (int i = 0; i <= size - 2; i++) {
                buffer[i] = buffer[i + 1];
            }
            buffer[size - 1] = null;
            size--;
            return returnedItem;
        }
        throw new NoSuchElementException("There are no elements to remove!");
    }

    /**
     * Best and worst case scenario, if not accounting for the exception thrown,
     * this would run in constant time. This is because we have no need to
     * shift elements over since we are removing the final index.
     * We also do not need to loop through any elements since we can
     * remove the item from the index of size-1.
     * @return
     */
    @java.lang.Override
    public E removeBack() {
        if(!isEmpty())
        {
            E returnedItem = buffer[size-1];
            buffer[size-1] = null;
            size--;
            return returnedItem;
        }
        throw new NoSuchElementException("There are no elements to remove!");
    }

    /**
     * Worst case scenario, this would be O(2n) runtime. This is because
     * the worst case would be either that the item is at the front
     * or at the back. If the item is at the front, we would find
     * the item immediately, but then would need to shift every item
     * over to the left. If the item is at the back, we still have to
     * search through the entire buffer until we find it at the final
     * index.
     * @param item the item to be removed
     */
    @java.lang.Override
    public void remove(E item) {
        if(!contains(item))
        {
            throw new NoSuchElementException("This element does not exist!");
        }
        for (int i = 0; i < size; i++) {
            if(buffer[i].equals(item))
            {
                for (int j = i; j < size-2; j++) {
                    buffer[j] = buffer[j+1];
                }
                //remove the final index value
                buffer[size - 1] = null;
                //decrement size
                size--;
            }
        }
    }

    /**
     * Worst case scenario, this method will run at O(n). This is because the
     * index it could be searching for could be the first index in the buffer.
     * meaning it would have to reorder every index over to the left.
     * Best case scenario, this would run at constant time, as
     * it could be the very last index given, meaning it would have to do
     * no reordering, or the index could not be valid, meaning an exception would
     * be thrown.
     * @param i the index where the item should be removed
     * @return
     */
    @java.lang.Override
    public E remove(int i) {
        //check to see if index is valid
        if(i >= size || i < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        // save a copy of the value to be returned later
        E removedItem = buffer[i];

        //shift values to the left
        for (int j = i; j < size-2; j++) {
            buffer[j] = buffer[j+1];
        }
        //remove the final index value
        buffer[size - 1] = null;
        //decrement size
        size--;
        //return the removed value
        return removedItem;
    }

    /**
     * Worst case scenario, this will run at linear time or O(n). This is because
     * the contains method could loop to the last element in the buffer and find
     * the item, or it could loop to the end of the buffer and not find the item.
     * Either way, it could potentially have to search through every index.
     * @param item the item to search for
     * @return
     */
    @java.lang.Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if(buffer[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This will always run in constant time since we are just returning
     * a true or false based on if size is equal to 0.
     * @return
     */
    @java.lang.Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Runtime analysis: This will always run in constant time since we are just
     * returning the variable size.
     * @return
     */
    @java.lang.Override
    public int size() {
        return size;
    }

    /**
     * In every scenario, this would run at O(n). This is because we have to
     * create a new buffer, and go through the old buffer to copy all the
     * elements over to the new one.
     * @param newSize
     */
    private void resize(int newSize)
    {
        E[] newBuffer = (E[])new Object[newSize];

        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        //set the new space into the buffer
        buffer = newBuffer;

        //the old space is no longer "pointed to" and will eventually
        //be cleaned up by the garbage collector
    }

    @java.lang.Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            // fields
            private int i;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if(i >= size)
                {
                    throw new NoSuchElementException("i is out of bounds");
                }
                E currentValue = buffer[i];
                i++;
                return currentValue;
            }
        };
    }
}
