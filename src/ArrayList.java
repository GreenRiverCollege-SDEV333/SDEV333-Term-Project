import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class representing the ArrayList with the ability to resize
 * @author Huy Nguyen
 * @version 1.0
 * @param <E> the data type
 */
public class ArrayList<E> implements List<E>{

    private int size;
    private E[] buffer;

    /**
     * constructor for ArrayList
     */
    public ArrayList(){
        this.size = 0;
        this.buffer = (E[]) new Object[10];
    }

    /**
     * Method to add at the front of the buffer
     * This will be running at O(n) where n is the current size of the array because it
     * but iterate through each item in the array to shift it over before adding
     * in the item at the first index position.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        //check to see if it is full then resize it
        if (size == buffer.length){
            resize(2 * buffer.length);
        }

        //shifts the array to the right
        for (int i = size; i >= 1 ; i--) {
            buffer[i] = buffer[i-1];
        }

        //set first position to added item
        buffer[0] = item;
        size++;
    }

    /**
     * Method to add at the back of the buffer
     * inserting in an ideal scenario will but O(1) because we are using an array,
     * and it will be inserting into an index position. Worst case would be O(n)
     * if we need to invoke the resize method which will iterate through all
     * the items within the array.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        //check to see if it is full then resize it
        if (size == buffer.length){
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }


    /**
     * Method to add at a specific index position
     * best case this will be runtime O(1) because you'll be inserting at the end
     * where there is no need to shift the array, and you're inserting into an array
     * which is always O(1) time. Worst case will be O(n) where n is the number
     * of time you need to iterate through the buffer to shift items over to make space
     * to add the item in the index position.
     *
     * @param index the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int index, E item) {
        //check if out of bound
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
        //check to see if it is full then resize it
        if (size == buffer.length){
            resize(2 * buffer.length);
        }

        //shift everything over right by 1
        for(int i = size; i >= index; i--){
            buffer[i+1] = buffer[i];
        }
        //add at the index position
        buffer[index] = item;
        size++;
    }

    /**
     * method used to get the content of the index position of the buffer
     * this will always be O(1) time because you're accessing an index with an array
     *
     * @param i the index where the item should be retrieved
     * @return value of index position.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
        else{
            return buffer[i];
        }
    }

    /**
     *methods set the value of the buffer to a value without shifting the contents
     *This will always be O(1) because you're accessing an index position of an array to set
     * @param i the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
        else{
            buffer[i] = item;
        }
    }

    /**
     * method used to remove the front of the buffer and shift items over
     * this runtime for this will always be O(n) where n is the size of the buffer
     * because you need to iterate through each item of the buffer to shift the
     * value
     * @return the remove item
     */
    @Override
    public E removeFront() {
        if (size==0){
            throw new NoSuchElementException("empty");
        }
        //saves the value of the item being removed
        E value = buffer[0];

        //shift buffer left
        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i+1];
        }

        //set last index position to null
        buffer[size-1] = null;
        size--;
        return value;
    }

    /**
     * Remove the item at end of the buffer
     * Runtime will always be O(1) because you're accessing the index of an array
     * them setting last position to null
     *
     * @return the remove value
     */
    @Override
    public E removeBack() {
        if (size==0){
            throw new NoSuchElementException("empty");
        }
        E value = buffer[size-1];
        buffer[size-1] = null;
        size--;
        return value;
    }

    /**
     * remove a specific item from the buffer
     * worst cast runtime would just be a little worst than
     * O(2n) because it will need to iterate through the array
     * to find the item once which is n then against again to
     * shift the array which is another n items, so realistically
     * it should be closer to O(n + m) for runtime.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        //finding the item
        for (int i = 0; i < size; i++) {
            //found item, shift array
            if (buffer[i].equals(item)){
                for (int j = i; j < size - 1; j++) {
                    buffer[j] = buffer [j + 1];
                }
                size--;
            }
        }
    }

    /**
     * removing an item at a specific index will always be a runtime of O(n)
     * where n is the index position. it has to iterate through each index
     * position to shift the contents over from the removed
     *
     * @param index the index where the item should be removed
     * @return the removed value
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("out of bounds");
        }

        //save return value
        E value = buffer[index];

        //removing and transferring values
        for (int i = index; i < size; i++){
            buffer[i] = buffer[i+1];
        }
        buffer[size-1] = null;
        size--;

        return value;
    }

    /**
     * this will always be a runtime of O(n) where n is the number
     * of times it must iterate through to find the item, at worst
     * it will be equal to the size of the buffer which is the max
     * amount of time it will need to iterate through
     *
     * @param item the item to search for
     * @return if the item is found
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * returns if the size is zero
     * this will always be o(1) because there is always one check which is the size
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * returns the size of the buffer
     * this will always be O(n) because it is returning a field
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if (i >= size){
                    throw new NoSuchElementException("out of bound");
                }
                E value = buffer[i];
                i++;
                return value;
            }
        };
    }

    /**
     * helper method to help resize
     * runtime is O(n) where n is the size of the current buffer because it has
     * to iterate through each value to add into the new buffer
     *
     * @param newSize the size of the new buffer
     */
    public void resize(int newSize){
        //creates new array with new size
        E[] newBuffer = (E[]) new Object[newSize];

        //add into the new buffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        //set field as new buffer
        buffer = newBuffer;
    }

}
