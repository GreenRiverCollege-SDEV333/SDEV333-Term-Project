import java.util.Iterator;

public class ResizingArrayStack<E> implements Stack<E>{
    private E[] buffer;
    private int size;

    public ResizingArrayStack()
    {
        buffer = (E[])new Object[1];
        size = 0;
    }

    private void resize(int max)
    {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }
    @Override
    public void push(E item)
    { // Add item to top of stack.
        if (size == buffer.length) {
            resize(buffer.length*2);
        }
        buffer[size++] = item;
    }

    @Override
    public E pop()
    { // Remove item from top of stack.
        E item = buffer[--size];
        buffer[size] = null; // Avoid loitering
        if (size > 0 && size == buffer.length/4) {
            resize(buffer.length/2);
        }
        return item;
    }

    @Override
    public E peek()
    {
        return buffer[0];
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E>
    {
        private int i = size;
        public boolean hasNext()
        {
            return i > 0;
        }
        public E next()
        {
            return buffer[--i];
        }
        public void remove()
        {

        }
    }
}
