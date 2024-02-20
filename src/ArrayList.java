import java.util.Iterator;
import java.util.*;

/**
 * Implementation of a dynamic array-based list.
 *
 * @author Noah Lanctot
 * @version 1.0
 * @param <E> the type of elements in this list
 */
public class ArrayList<E> implements List<E> {
    private int size;
    private E[] buffer;

    /**
     * Constructs an empty ArrayList with an initial capacity of 10.
     */
    public ArrayList() {
        size = 0;
        buffer = (E[]) new Object[10];
    }

    /**
     * Adds the specified element to the front of this list.
     * If the internal buffer is full, this method resizes the buffer.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to shift all existing elements to the right.
     *
     * @param item the element to be added to the front of this list
     */
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

    /**
     * Adds the specified element to the back of this list.
     * If the internal buffer is full, this method resizes the buffer.
     * This method has a worst-case runtime complexity of O(1),
     * as it simply inserts the element at the end of the buffer.
     *
     * @param item the element to be added to the back of this list
     */
    @Override
    public void addBack(E item) {
        if (size == buffer.length) {
            resize();
        }
        buffer[size++] = item;
    }

    /**
     * Adds the specified element at the specified index in this list.
     * If the internal buffer is full, this method resizes the buffer.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to shift all existing elements after the specified index to the right.
     *
     * @param index the index at which the specified element is to be inserted
     * @param item the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Returns the element at the specified index in this list.
     * This method has a worst-case runtime complexity of O(1),
     * as it accesses the element directly by index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return buffer[index];
    }

    /**
     * Replaces the element at the specified index in this list with the specified element.
     * This method has a worst-case runtime complexity of O(1),
     * as it accesses the element directly by index.
     *
     * @param index the index of the element to replace
     * @param item the element to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        buffer[index] = item;
    }

    /**
     * Removes and returns the element at the front of this list.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to shift all existing elements to the left.
     *
     * @return the element at the front of this list
     * @throws NoSuchElementException if this list is empty
     */
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

    /**
     * Removes and returns the element at the back of this list.
     * This method has a worst-case runtime complexity of O(1),
     * as it simply removes the element at the end of the buffer.
     *
     * @return the element at the back of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = buffer[size - 1];
        buffer[--size] = null;
        return removedItem;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to shift all existing elements after the removed element to the left.
     *
     * @param item the element to be removed from this list
     */
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

    /**
     * Removes and returns the element at the specified index in this list.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to shift all existing elements after the specified index to the left.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
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

    /**
     * Returns true if this list contains the specified element.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it may
     * need to iterate through all elements to find the specified element.
     *
     * @param item the element to be checked for containment in this list
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     * This method has a runtime complexity of O(1).
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this list.
     * This method has a runtime complexity of O(1).
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Resizes the internal buffer by doubling its capacity.
     * This method has a worst-case runtime complexity of O(n),
     * where n is the number of elements in the list, because it
     * needs to copy all existing elements to the new buffer.
     */
    private void resize() {
        E[] newBuffer = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }

    /**
     * Returns an iterator over the elements in this list.
     * This method has a runtime complexity of O(1).
     *
     * @return an iterator over the elements in this list
     */
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