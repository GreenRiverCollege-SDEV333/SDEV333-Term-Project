import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Author Daniel Knoll
 * @param <E> desired data type.
 */
public class ArrayList<E extends Comparable<E>> implements List<E>{
    private E[] buffer;
    private int size;
    public ArrayList() {
        buffer = (E[]) new Object[10];
        size = 0;
    }

    public void resize() {
        E[] newBuffer = (E[]) new Object[size * 2];

        for (int i = 0;i < size; i++) {
            newBuffer[i] = buffer[i];
        }

        buffer = newBuffer;
    }

    /**
     * Add item to the front.
     * this is O(2n+c) for the worst case of needing a resize + shifting the array over.
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        if (size >= buffer.length) {
            resize();
        }
        for (int i = size + 1;i >= 0 ; i--) {
            buffer[i] = buffer[i - 1];
        }
        buffer[0] = item;
        size++;
    }

    /**
     * Add item to the back.
     * O(n+2) in case it needs resize
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        if(size >= buffer.length) {
            resize();
        }
        buffer[size] = item;
        size++;
    }

    /**
     * Add an item at specified index (position).
     * O(n+2) for shifting and affecting 2 variables
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if (size >= buffer.length) {
            resize();
        }
        for (int j = size + 1; j > i; j--) {
            buffer[j] = buffer[j - 1];
        }
        buffer[i] = item;
        size++;
    }

    /**
     * Get the item at a specified index.
     * O(1) return statement only
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        return buffer[i];
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * O(1) set a variable only
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        buffer[i] = item;
    }

    /**
     * Remove item at the front of the list.
     * O(n) for iterating through the buffer
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        E item = buffer[0];
        for (int i = 0;i < size;i++) {
            buffer[i] = buffer[i+1];
        }
        size--;
        return item;
    }

    /**
     * Remove item at the back of the list
     * O(4) a few variables affected
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        E item = buffer[size - 1];
        buffer[size - 1] = null;
        size--;
        return item;
    }

    /**
     * Remove item from the list
     * worst case it will go through each item before finding its target (or not find it at all)
     * which makes this O(n)
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        for (int i = 0 ; i < size; i++) {
            if (buffer[i] == item) {
                remove(i);
            }
        }
    }

    /**
     * Remove item at a specified index.
     * worst case it will remove from the back which means it iterates through entire buffer making this
     * O(n)
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        E item = buffer[i];
        for (int j = i;j < size;j++) {
            buffer[j] = buffer[j + 1];
        }
        size--;
        return item;
    }

    /**
     * Checks if an item is in the list.
     * worst case it finds the contained item at the end or not at all making this
     * O(n)
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * O(1) returning one variable
     * @return number of items in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private int i;
        private ListIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            if (buffer[i + 1] != null) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return buffer[++i];
        }
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        List.super.forEach(action);
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }
}
