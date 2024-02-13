import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

    private int size;
    private E[] buffer;

    public ArrayList(){
        size = 0;
        buffer = (E[]) new Object[10];
    }

    @Override
    public void addFront(E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
        }
        for (int i = size; i >= 1; i--){
            buffer[i] = buffer[i-1];
        }
        buffer[0] = item;
        size++;
    }

    @Override
    public void addBack(E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int i = 0; i < buffer.length; i++){
                newBuffer[i] = buffer[i];
            }
            buffer = newBuffer;
        }

        buffer[size] = item;
        size++;

    }

    @Override
    public void add(int i, E item) {
        if (size == buffer.length) {
            E[] newBuffer = (E[]) new Object[size*2];
            for(int j = 0; j < buffer.length; j++){
                newBuffer[j] = buffer[j];
            }
            buffer = newBuffer;
        }
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        for (int j = size; j >= i; j--){
            buffer[j] = buffer[j-1];
        }
        buffer[i] = item;
        size++;

    }

    @Override
    public E get(int i) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return buffer[i];

    }

    @Override
    public void set(int i, E item) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        buffer[i] = item;
    }

    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }

        E remove = buffer[0];
        for (int i = 0; i <= size - 2; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[size - 1] = null;

        size--;

        return remove;

    }

    @Override
    public E removeBack() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }

        E remove = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        return remove;
    }

    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        int index = 0;
        for(int i = 0; i < size; i++) {
            if (buffer[i].equals(item)) {
                index = i;
            }
        }
        for(int j = index; j < size - 1; j++){
            buffer[j] = buffer[j + 1];
        }
        buffer[size-1] = null;
        size--;
    }

    @Override
    public E remove(int i) {
        if (isEmpty() || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        E remove = buffer[i];
        for(int j = i; j < size - 1; j++){
            buffer[j] = buffer[j + 1];
        }
        buffer[size-1] = null;
        size--;
        return remove;
    }

    @Override
    public boolean contains(E item) {
        for(int i = 0; i < size; i++){
            if(buffer[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
