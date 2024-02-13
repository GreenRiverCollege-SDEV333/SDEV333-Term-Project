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

    @java.lang.Override
    public void addBack(E item) {
        if(size == buffer.length)
        {
            resize(size * 2);
        }

        buffer[size] = item;
        size++;
    }

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
            for (int j = size; j >= i; j--) {
                buffer[j] = buffer[j - 1];
            }
        }
        buffer[i] = item;
        size++;
    }

    @java.lang.Override
    public E get(int i) {
        if(i > size)
        {
            throw new IndexOutOfBoundsException();
        }
        return buffer[i];
    }

    @java.lang.Override
    public void set(int i, E item) {
        if(i > size)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        buffer[i] = item;
    }

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

    @java.lang.Override
    public void remove(E item) {
        if(!contains(item))
        {
            throw new NoSuchElementException("This element does not exist!");
        }
        for (int i = 0; i < size-1; i++) {
            if(buffer[i].equals(item))
            {
                for (int j = i; j < size; j++) {
                    buffer[j] = buffer[j+1];
                }
                //remove the final index value
                buffer[size - 1] = null;
                //decrement size
                size--;
            }
        }
    }

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
        for (int j = i; j < size; j++) {
            buffer[j] = buffer[j+1];
        }
        //remove the final index value
        buffer[size - 1] = null;
        //decrement size
        size--;
        //return the removed value
        return removedItem;
    }

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

    @java.lang.Override
    public boolean isEmpty() {
        return size == 0;
    }

    @java.lang.Override
    public int size() {
        return size;
    }

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
