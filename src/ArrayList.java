import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
public class ArrayList<E> implements List<E> {
    private static final int BUFFER_CAPACITY = 10;
    private E[] elements;
    private int size;

    public ArrayList() {
        elements = (E[]) new Object[BUFFER_CAPACITY];
        size = 0;
    }

    public void addFront(E item) {
        add(0, item);
    }

    public void addBack(E item) {
        add(size, item);
    }

    public void add(int i, E item) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("invalid index" + i);

        }
        if (size == elements.length) {
            resize();
        }
        System.arraycopy(elements, i, elements, i + 1, size - 1);
        elements[i] = item;
        size++;
    }

    public E get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("index out of bounds" + i);
    return elements[i];
}


public void set(int i, E Item){
       if(i<0 || i>= size)
           throw new IndexOutOfBoundsException("index out of bound"+i);

       elements[i] = item;
    }
    @Override
    public E removeFront() {
        return remove(0);
    }
        @Override
public E removeBack(){
    return remove(size -1);

}
@Override
public void remove(E item){
    for(int i = 0; i <size; i++){
        if(elements[i].equals(item)){
            return;
        }
    }
}
@Override
public boolean contains(E item){
    for (int i =0; i< size; i++){
        if (elements[i].equals(item)){
            return true;
        }
    }
    return false;
}

@Override
public boolean isEmpty(){
    return size ==0;

}
@Override
public int size(){
    return size;
}
@Override
public void resize(){
    int newCapacity = elements.length*2;
    elements= Arrays.copyOf(elements, newCapacity);
}

public Iterator<E>iterator(){
    return new ArrayListIterator();
}
private class ArrayListIterator implements Iterator<E> {
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();

        }
        return elements[currentIndex++];
    }
}}
