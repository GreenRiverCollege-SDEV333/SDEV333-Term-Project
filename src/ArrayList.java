import java.util.Iterator;

public class ArrayList<E> implements List<E>, Iterable<E>
{

    private int capacity = 10;
    private Object[] array;
    private int size;

    public ArrayList(){
        size = 0;
        array = new Object[capacity];
    }

    /**
     * Add item to the front.
     *
     * Time Complexity: O(n) because all elements are shifted, which takes linear time.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(Object item)
    {
        add(0, item);
    }

    /**
     * Add item to the back.
     *
     * Time Complexity: O(n) because resize may be called which takes linear time.
     * Otherwise, O(1) since no other elements would need to be adjusted
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(Object item)
    {
        if(size == array.length){
            resizeArray();
            add(size, item);
            return;
        }

        add(size, item);
    }

    /**
     * Doubles size of current array
     *
     * Time Complexity: O(n) since each element of the old array must be accessed to copy it to the new array
     *
     */
    private void resizeArray() {

        int newCapacity = array.length * 2;

        Object[] newArray = new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;

    }

    /**
     * Add an item at specified index (position).
     *
     * Time Complexity: O(n) since elements will be shifted to account for positioning of new element
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, Object item)
    {
        if(i > array.length || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        if(size == array.length){
            resizeArray();
        }

        for (int j = array.length - 1; j > i; j--)
        {
            array[j] = array[j - 1];
        }

        array[i] = item;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * Time Complexity: O(1) Only have to access one element of the array
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public Object get(int i)
    {
        if(i > array.length || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return array[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Time Complexity: O(1) because only one element needs to be accessed
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, Object item)
    {
        if(i > array.length || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        array[i] = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * Time Complexity: O(1) since only the first element needs to be adjusted
     *
     * @return the item that was removed
     */
    @Override
    public Object removeFront()
    {
        return remove(0);
    }

    /**
     * Remove item at the back of the list
     *
     * Time Complexity: O(1) since only the last element needs to be adjusted
     *
     * @return the item that was removed
     */
    @Override
    public Object removeBack()
    {
        return remove(array.length - 1);
    }

    /**
     * Removes the first instance of item from the list
     *
     * Time Complexity: O(n) since each element before the matching item must be accessed
     *
     * @param item the item to be removed
     * @return the item that was removed
     */
    @Override
    public Object remove(Object item)
    {
        if(size == 0){
            return null;
        }

        for (int i = 0; i < size; i++)
        {
            if(array[i] == item){
                remove(i);
            }
        }

        return item;
    }

    /**
     * Remove item at a specified index.
     *
     * Time Complexity: O(1) since only the element at the desired index must be accessed
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public Object remove(int i)
    {
        if(i > array.length || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        if(size == 0){
            return null;
        }

        Object removed = array[i];

        array[i] = null;

        size--;

        return removed;
    }

    /**
     * Checks if an item is in the list.
     *
     * Time Complexity: O(n) since each element before the desired item must be accessed
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(Object item)
    {
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == item){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * Time Complexity: O(1) since only the size variable must be accessed
     *
     * @return true if the list is empty, false otherwise
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
     * Provides a count of the number of items in the list.
     *
     * Time Complexity: O(1) since only the size variable must be accessed
     *
     * @return number of items in the list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
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

                return (E) array[current++];
            }
        };

        return iterator;
    }

    /**
     * Returns a string containing all elements in the array list.
     *
     * Time Complexity: O(n) since each element must be accessed to be added to the contents string
     *
     * @return a string that represents the contents of the array list.
     */
    @Override
    public String toString()
    {

        String contents = "{ ";

        for (int i = 0; i < array.length; i++)
        {
            contents += array[i] + " ";
        }

        contents += "}";

        return contents;
    }
}
