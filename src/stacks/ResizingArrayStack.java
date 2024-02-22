/**
 * Array implementation of the Stack interface
 *
 * @author Lillian Nelson
 * @version 1.0
 */
package stacks;
import java.util.Iterator;
import java.util.Stack;

public class ResizingArrayStack<Item> extends Stack<Item>
{
    private Item[] array; //stack items
    private int size;     //number of items

    public ResizingArrayStack()
    {
        array = (Item[]) new Object[10];
        size = 0;
    }

    /**
     * Returns if ArrayStack is empty
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @return if size is 0
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns size of ArrayStack
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @return size
     */
    public int size()
    {
        return size;
    }

    /**
     * Creates a new array to resize
     * 0(n) linear time in the worst case
     * loops through the array
     *
     * */
    private void resize()
    {   //move stack to a new array of size max
        Item[] temp = (Item[]) new Object[2 * array.length];
        for (int i = 0; i < size; i++)
        {
            temp[i] = array[i];
        }
        array = temp;
    }

    /**
     * pushes a new item into the array stack
     * 0(1) or constant time in the worst case
     * no matter size operations are the same
     *
     * @param item Item to push
     * @return
     */

    public Item push(Item item)
    {   //add item to top of stack
        if (size == array.length)
        {
            resize();
        }
        array[size] = item;
        size++;
        return item;
    }

    /**
     * Removes an item from the stack
     * 0(1) or constant time in the worst case
     * no matter size operations stay the same
     *
     * @return the item removed
     */

    public Item pop()
    {   //remove item from top of stack
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException(0);
        }
        Item item = array[size - 1];
        array[size - 1] = null; // avoid loitering
        size--;
        return item;
    }

    /**
     * Returns an iterator over elements of type Item
     * 0(1) constant time returning iterator
     *
     * @return an Iterator.
     */
    public Iterator<Item> iterator()
    {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<Item>
    {   //support LIFO iteration
        private int i = size;

        /**
         * Returns true if the iteration has more elements.
         * 0(1) or constant time in the worst case
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() { return i > 0; }

        /**
         * Returns the next element in the iteration.
         * 0(1) or constant time in the worst case
         * @return the next element in the iteration
         */
        public Item next() { return array[--i]; }

    }

}
