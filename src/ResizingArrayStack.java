import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E>
{
    private E[] buffer; // stack items
    private int size;

    public ResizingArrayStack()
    {
         buffer = (E[]) new Object[1];
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

    private void resize(int max)
    {   // Move stack to a new array of size max.
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++)
        {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    public void push(E item)
    {   //Add item to top of stack
        if (size == buffer.length)
        {
            resize(2 * buffer.length);
        }
        buffer[size] = item;
        size++;
    }

    public E pop()
    {   // remove item from top of stack
        E item = buffer[size];
        size--;
        buffer[size] = null; // avoid loitering
        if (size > 0 && size == buffer.length/4)
        {
            resize(buffer.length/2);
        }
        return item;
    }

    @Override
    public E peek()
    {
        return null;
    }

    public Iterator<E> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E>
    {   // support LIFO iteration
        private int i = size - 1;

        public boolean hasNext()
        {
            return i >= 0;
        }

        public E next()
        {
            return buffer[i--];
        }

        public void remove()
        {

        }
    }

}
