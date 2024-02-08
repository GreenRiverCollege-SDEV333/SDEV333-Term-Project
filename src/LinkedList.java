import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
/**
 * Implementation of the LinkedList<E> using the List<E> interface. This is my term assignment 1 Linked List.
 * @author Rob Smith
 * @version 1.0
 * @param <E> class / data type of the items in the LinkedList
 */
public class LinkedList<E> implements List<E> {
    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private int size;

    /**
     * Constructor for the LinkedList<E> class.
     * Runtime is O(1) as it always takes the same time to construct.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add item to the front.
     * Runtime of adding to front for a linked-list is always O(1). Adding to the front takes the same amount
     * of time regardless of the size of the list or it's contents.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item) {
        Node newNode = new Node();
        newNode.data = item;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        this.size++;
    }

    /**
     * Add item to the back.
     * Runtime of this method is O(n) because a linked list must walk through the list to locate the back of the list
     * before it can add a node to the back location.
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
     * Runtime for this method is O(n) because the worst case is that it must add a node to the end, the back. Adding
     * tot the back is a single traversal of the complete list, yielding O(n).
     *
     * @param index the index where the item should be added
     * @param item  the item to be added
     */
    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node();
        newNode.data = item;
        if (index == 0) {
            this.addFront(item);
        } else if (index == size) {
            this.addBack(item);
        } else {
            Node current = head.next;
            Node previous = head;
            int currentIndex = 1;
            while (current != null) {
                if (currentIndex == index) {
                    newNode.next = current;
                    previous.next = newNode;
                    size++;
                }
                previous = current;
                current = current.next;
                currentIndex++;
            }
        }
    }

    /**
     * Get the item at a specified index.
     * Runtime for this method is O(n) because if the index is the last element of the list it must traverse the
     * entire list to retrieve the data from the last index.
     *
     * @param index the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int index) {
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int currentIndex = 0;
        Node current = head;
        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        return null;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * Run time for this method is O(n) because the index can be the last position of the linked list, so it can run
     * through one entire traversal of the linked list.
     *
     * @param index the index where the item should be saved
     * @param item  the item to be saved
     */
    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else if (head == null && index > 0) {
            throw new NoSuchElementException("Empty List");
        } else if (index == 0) {
            head.data = item;
        }
        Node current = head.next;

        int currentIndex = 1;
        while (current != null) {
            if (currentIndex == index) {
                current.data = item;
            }
            current = current.next;
            currentIndex++;
        }
    }

    /**
     * Remove item at the front of the list.
     * This is always a runtime of O(1). It takes the same time to remove the first node regardless of the size of
     * the linked list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront() {
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else {
            E result = head.data;
            head = head.next;
            size--;
            return result;
        }
    }

    /**
     * Remove item at the back of the list
     * Runtime for this is always O(n) because a singly linked list must be traversed in its entirety to remove
     * the last node of the linked list.
     * @return the item that was removed
     */
    @Override
    public E removeBack() {
        Node current = head;
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else if (current.next == null) {
            E result = current.data;
            head = null;
            size--;
            return result;
        }
        while (current.next.next != null) {
            current = current.next;
        }
        E result = current.data;
        current.next = null;
        size--;
        return result;
    }

    /**
     * Remove item from the list
     * This method has run a time of O(n) because it must traverse the linked list to find the item in the parameter.
     * It may not find the item, so it will go through the entire linked list.
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if (head == null) {
            return;
        }
        Node current = head;
        Node previous = current.next;
        while (current != null) {
            if (current.data == item) {
                current.data = (E) (Integer) 0;
                previous.next = current.next;
                size--;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Remove item at a specified index.
     * Runtime for remove() is O(n) because it must loop through the linked list until it reaches the specified
     * index, and then remove the item from the list. This could be the last node, so its O(n).
     *
     * @param index the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int index) {
        E value = null;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else if (head == null) {
            throw new NoSuchElementException("Empty List");
        } else if (index == 0) {
            value = head.data;
            head.data = (E) (Integer) 0;
            head = head.next;
            size--;
            return value;
        }

        Node current = head.next;
        Node previous = head;
        int currentIndex = 1;
        while (current != null) {
            if (currentIndex == index) {
                value = current.data;
                current.data = (E) (Integer) 0;
                previous.next = current.next;
                size--;
                break;
            }
            previous = current;
            current = current.next;
            currentIndex++;
        }
        return value;
    }

    /**
     * Checks if an item is in the list.
     * Runtime for this method is O(n) because the method must loop through the linked list to find the item
     * and check if it matches the node data item.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item) {
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     * Runtime for this method is O(1) since we're just checking a variable and returning a boolean on a single
     * condition without looping.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     * Runtime for this method is O(1) since we're just checking a variable and returning its value.
     *
     * @return number of items in the list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Pretty printing method for printing a LinkedList<E>.</E>
     * Runtime for toString is always O(n) because it is walking through the linked list to the end.
     * @return String of the node data in the linked list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (size > 0) {
            Node current = head;
            do {
                sb.append(current.data);
                if (current.next != null) {
                    sb.append(',');
                    sb.append(' ');
                }
                current = current.next;
            } while (current != null);
            sb.append(']');
        } else {
            return "null";
        }

        return sb.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * Runtime is I(1) because it only instantiates an object and returns it there is no looping.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedList.LinkedListIterator();
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side effects that modify the underlying source of elements, unless an
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
     * capabilities, is un-sized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private int i;
        Node current = head;

        private LinkedListIterator() {
            this.i = 0;
        }
        /**
         * Tracker of if there's a next for the iterator.
         * @return returns the boolean representing if there's another element after the current element.
         */
        public boolean hasNext() {
            return i < size;
        }

        /**
         * Item to retrieve the element values for the iterator.
         * Runtime is O(1) because it's only looking at a single location and not looping.
         * @return the data of the current element.
         */
        public E next() {
            E currentItem = current.data;
            current=current.next;
            i++;
            return currentItem;
        }
    }

}
