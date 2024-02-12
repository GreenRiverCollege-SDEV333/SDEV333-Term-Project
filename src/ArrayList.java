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
        return null;
    }

    @java.lang.Override
    public void set(int i, E item) {

    }

    @java.lang.Override
    public E removeFront() {
        return null;
    }

    @java.lang.Override
    public E removeBack() {
        return null;
    }

    @java.lang.Override
    public void remove(E item) {

    }

    @java.lang.Override
    public E remove(int i) {
        return null;
    }

    @java.lang.Override
    public boolean contains(E item) {
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
    public java.util.Iterator<E> iterator() {
        return null;
    }
}
