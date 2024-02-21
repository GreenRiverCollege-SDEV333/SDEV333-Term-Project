import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Iterable<E>
{
    private E[] array; //stack items
    private int size;     //number of items

    public ResizingArrayStack()
    {
        array = (E[]) new Object[10];
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    private void resize()
    {   //move stack to a new array of size max
        E[] temp = (E[]) new Object[2 * array.length];
        for (int i = 0; i < size; i++)
        {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void push(E item)
    {   //add item to top of stack
        if (size == array.length)
        {
            resize();
        }
        array[size] = item;
        size++;
    }

    public E pop()
    {   //remove item from top of stack
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException(0);
        }
        E item = array[size - 1];
        array[size - 1] = null; // avoid loitering
        size--;
        return item;
    }

    public Iterator<E> iterator()
    {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<E>
    {   //support LIFO iteration
        private int i = size;
        public boolean hasNext() { return i > 0; }
        public E next() { return array[--i]; }
        public void remove() { }

    }

}
