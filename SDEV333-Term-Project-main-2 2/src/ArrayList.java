import java.util.Iterator;
import java.util.NoSuchElementException;



public class ArrayList <E> implements List<E>{
    private static final int BUFFER_CAPACITY=10;//
    private Object[] elements;//array to store elements
    private int size;// current size of the list

    //constructor to initialize arraylist
    public ArrayList(){
        elements = new Object[BUFFER_CAPACITY];//initialize the array with default capacity
        size=0;// setting size to 0
    }
    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */

    //o(n)
    //because it involves shifting all elements to right and has to make space for new item
    @Override
    public void addFront(E item) {
add(0, item);// add to insert at index 0
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */

    //o(1)-adding an elements to the end of array
    @Override
    public void addBack(E item) {
if(size== elements.length){// check if the array is full
throw  new IllegalArgumentException("arraylist is full");

}
elements[size++]=item;// adding the item at the end of list
    }

    /**
     * Add an item at specified index (position).
     *
     * @param index   the index where the item should be added
     * @param item the item to be added
     */

    //o(n)worst case -have to shift the elements to right by one position
    @Override
    public void add(int index, E item) {
if(index<0||index>size){
    throw new IndexOutOfBoundsException("index out of range");

}
if(size==elements.length){
    throw new IllegalArgumentException("array full");

}
//shifting elements to the right to make space for the new item
       for (int i =size; i >index; i--){
           elements[i]=elements[i-1];
       }
       elements[index]=item;// adding item at an index
size++;//
    }

    /**
     * Get the item at a specified index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    //O(1) this directly accesses the elements at the specified index
    @Override
    public E get(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("index out of range");
        }
        return (E) elements[index];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param index   the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int index, E item) {
if(index<0||index>=size){
    throw new IndexOutOfBoundsException("out of range");

}
elements[index]=item;// set the item at specified index
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        return remove(0);// to remove method to remove from index 0
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        return remove(size-1);//remove form last index
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
for(int i=0; i <size; i++){
    if(elements[i].equals(item)){
        remove(i);//remove the item at index i
        return;
    }
}
    }

    /**
     * Remove item at a specified index.
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("out of range");

        }
        E removedItem =(E) elements[index];// store the item to remove
        for (int i = index; i<size-1; i++){
            elements[i]=elements[i+1];
        }
        elements[--size]=null;
        return removedItem;// return the remove item
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    //o(n) worst case cause it needs to traverse the entire array to check if item is present
    @Override
    public boolean contains(E item) {
       for(int i=0;i<size; i++){
           if(elements[i].equals(item)){
               return true;// item found then true
           }
       }
       return false;// else false
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    //o(1) ebcuase it just checks the size of the array to know if it is empty
    @Override
    public boolean isEmpty() {
        return size==0;// return true if size is 0 meaning list empty
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    //O(1)directly returns the size of array
    @Override
    public int size() {
        return size;// returning the current size of the list
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    //
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex=0;//
            @Override
            public boolean hasNext(){
             return currentIndex<size;//check if there are more elemetns
            }

            @Override
            public E next() {
                if (!hasNext()){
                    throw new NoSuchElementException();// if no more elements left

                }
                return (E) elements[currentIndex++];//
            }
        };
    }
}
