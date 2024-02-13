import java.util.Iterator;
import java.util.*;

public class ArrayList<E> implements List<E> {
    private int size;
    private E[] buffer;

    public ArrayList() {
        size = 0;
        buffer = (E[]) new Object[10];
    }


    @Override
    public void addFront(E item) {
        if (size == buffer.length) {
            resize();
        }
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }
        buffer[0] = item;
        size++;
    }

    @Override
    public void addBack(E item) {
        if (size == buffer.length) {
            resize();
        }
        buffer[size++] = item;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (size == buffer.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }
        buffer[index] = item;
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return buffer[index];
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        buffer[index] = item;
    }

    @Override
    public E removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = buffer[0];
        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        size--;
        return removedItem;
    }

    @Override
    public E removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = buffer[size - 1];
        buffer[--size] = null;
        return removedItem;
    }

    @Override
    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    buffer[j] = buffer[j + 1];
                }
                buffer[--size] = null;
                return;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        E removedItem = buffer[index];
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[--size] = null;
        return removedItem;
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i].equals(item)) {
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

    private void resize() {
        E[] newBuffer = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException("No more elements in list");
            }
            return buffer[index++];
        }
    }
}
