import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<E> implements List<E> {

    private Node head;
    private int size;
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        Node newNode = new Node();
        newNode.data = item;
        //check whether the current Node is empty
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        this.size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item) {
        Node current = head;
        Node newNode = new Node();
        newNode.data = item;
        if (current == null) {
            addFront(item);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound.");
        }
        Node newNode = new Node();
        newNode.data = item;
        if (i == 0) {
            this.addFront(item);
        } else if (i == size) {
            this.addBack(item);
        } else {
            Node current = head.next;
            Node previous = head;
            int index = 1;
            while (current != null) {
                if (index == i) {
                    break;
                }
                previous = current;
                current = current.next;
                index++;
            }
            previous.next = newNode;
            newNode.next = current;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i) {
        if (head == null) {
            throw new NoSuchElementException("The List is currently empty.");
        } else if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound.");
        }
        //declare new index for comparision
        int index = 0;
        //assign head to current
        Node current = head;
        //while loop check for null and reutnr if new index met required index
        while (current != null) {
            if (index == i) {
                return current.data;
            }
            //if index not match move to the new one
            current = current.next;
            index++;
        }
        return null;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item) {
        if (head == null) {
            throw new NoSuchElementException("The List is currently empty.");
        } else if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound.");
        }

        //declare new index for comparision
        int index = 0;
        //assign head to current
        Node current = head;
        //while loop check for null and reutnr if new index met required index
        while (current != null) {
            if (index == i) {
                current.data = item;
            }
            //if index doesn't match move to the new one
            current = current.next;
            index++;
        }
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        Node delete = null;
        if (head != null) {
            delete = head;
            head = head.next;
        }
        return delete != null ? delete.data : null;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack() {

        if (head == null) {
            return null;
        }
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        if (prev != null) {
            prev.next = null;
        } else {
            head = null;
        }
        size--;
        return current.data;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        Node current = head;
        Node previous = null;
        if (current == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        //check if head matches the item
        while (current != null) {
            if (current.data.equals(item)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = head.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i) {
        if (head == null) {
            throw new NoSuchElementException("The List is currently empty.");
        } else if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound.");
        }
        int index = 0;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (index == i) {
                size--;
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                current.next = null;
                return current.data;
            }
            prev = current;
            current = current.next;
            index++;
        }
        return null;
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
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
        return this.size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
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

    private class Node {
        E data;
        Node next;
    }

    public class LinkedListIterator implements Iterator<E> {
        private Node current;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
