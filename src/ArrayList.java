import java.util.Iterator;

/**
 *
 * implement all of the methods in the List <E> interface, and implement the interator()
 * method from the iterable <E> interface
 * @author Kayley Young
 */
public class ArrayList <E> implements List <E> {
    private int size;
    private E[] buffer;

    /**
     * add constructor
     */
    public ArrayList(){
        //initialize my fields
        size = 0;
        //You can create a new array of primitive types like ints with syntax
        // like buffer = new int[10]. In class, we did an example (in SymbolTable)
       // buffer = (ItemType) new Object[10] to create an array of generic objects.
        buffer = (E[]) new Object[10];
    }

    /**
     * Add item to the front.
     * This method runs in O(n) because the
     *  loop that shifts elements in the buffer
     *  has to iterate through n elements where n is the size of the buffer.
     *  the complexity class is linear.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
       if (buffer.length == size){
            resize(size * 2);
        }

        for (int i = size; i > 0 ; i--) {
            buffer[i] = buffer[i-1];
        }

        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     *
     * O(1) for adding an item to the buffer.
     * This is because the code simply adds the item variable
     * to the buffer array and increments the size variable,
     * the complexity class is constant.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if (size == buffer.length){
            resize(size + 2);
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     *
     *  This method runs in O(n) because the loop that shifts elements
     *  in the buffer has to iterate through n elements where n is the size of the buffer.
     *  the complexity class is linear.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (size == buffer.length){
            resize(size + 2);
        }

        for (int j = size; j > i; j--) {
            buffer[j] = buffer[j-1];
        }
        buffer[i] = item;
        size++;
    }
    public void resize(int newSize){

        //create new space, separate from the old space (buffer)
        E[] newBuffer = (E[]) new Object[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        //
        buffer = newBuffer;

        // the old space is no longer "pointed to" and will eventually
        // be cleaned up by the garbage collector
    }

    /**
     * Get the item at a specified index.
     *
     *This method runs in O(1) because it only involves simple comparisons
     * and returning a value from an array, regardless of the size of the array.
     * the complexity class is constant.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        return buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * This method runs in O(1) because it only has to checks
     * the index of buffer and places 1 item inside it
     *  the complexity class is constant.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        buffer[i] = item;

    }

    /**
     * Remove item at the front of the list.
     *
     *  in the worst case scenario this method is O(n).
     *  when removing an element from the array,
     *  we need to shift all the elements to the left by one position.
     *  This requires iterating through
     *  the array and shifting each element.
     *  the complexity class is linear.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if(!isEmpty()) {
            E copyOfRemovedValue = null;
            for (int i = 0; i <= size - 2; i++) {
                 copyOfRemovedValue = buffer[i];
                buffer[i] = buffer[i + 1];
            }

            //zero out the far right since everything was shifted to the left
            buffer[size -1] = null;
            size--;
            return copyOfRemovedValue;
        }else{
            throw new IndexOutOfBoundsException("Array is empty, nothing to remove");
        }
    }

    /**
     * Remove item at the back of the list
     *
     * This method runs in O(1) because it only has to checks
     * the index of size-1 in the buffer and set it to null
     * the complexity class is constant.
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        if (!isEmpty()){
            E copyOfRemovedValue = buffer[size-1];
            buffer[size-1] = null;
            size--;
            return copyOfRemovedValue;
        }else{
            throw new IndexOutOfBoundsException("Array is empty, nothing to remove");
        }
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {

    }

    /**
     * Remove item at a specified index.
     *
     * in the worst case scenario this method is O(n).
     * when the element to be removed is at the beginning of the buffer,
     * all elements after it need to be shifted to the left by one position.
     * the complexity class is linear.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if(i < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (i>= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        //save a copy of the value to be removed so we can return it later
        E copyOfRemovedValue = buffer[i];

        //shift values to the left
        for (int j = i; j <= size -1; j++){
            buffer[j] = buffer[j+1];
        }

        buffer[size - 1] = null;
        // don't forget to decrement size
        size--;

        return copyOfRemovedValue;
    }

    /**
     * Checks if an item is in the list.
     *
     *This method runs in O(n) because it has a single for loop that
     * iterates through the buffer array of size n. the complexity class is linear.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == item){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * This method runs in O(1) because it only has to check 1 variable
     * and the complexity class is constant.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.This method runs in O(1) because it only has to check 1 variable
     *  and the complexity class is constant.
     *
     * @return number of items in the list
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
        return null;
    }
}
