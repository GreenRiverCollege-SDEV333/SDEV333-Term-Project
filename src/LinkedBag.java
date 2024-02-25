import interfaces.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Ryder Dettloff
 * LinkedBag data structure
 * @param <E>
 */
public class LinkedBag<E> implements Bag<E>
    {
        //fields
        private Node head;
        private int size;

        //Node constructor
        private class Node
        {
            E data;
            Node nextNode;
        }

        public LinkedBag(){
            this.head = null;
            this.size = 0;
        }
    /**
     * Add an item to the bag.
     * time complexity: O(N)(Constant) simple operations. creating/assigning variables. size of bag doesn't matter
     * @param item the item to be added
     */
    @Override
    public void add(E item) {
        //assign head to prev node

        Node prev = head;
        //create new node to be the head
        head = new Node();
        //assign new item to heads data
        head.data = item;
        //set the new head's next node to previous
        head.nextNode = prev;
        //increment size
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     *time complexity: O(N)(Constant) comparing size to 0
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        //compare size to 0, return boolean value
        return size == 0;
    }

    /**
     * Returns a count of the number of items in the bag.
     *time complexity: O(N)(Constant) returing size variab;e
     * @return the number of items in the bag
     */
    @Override
    public int size() {
        //return size variable
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

        public class ListIterator implements Iterator<E>{
            // returns ture if iteration has no more elements
            private Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            // returns next element in the iteration

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                //goes to the next node in the stack and returns it
                E item = current.data;
                current = current.nextNode;
                return item;
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
        Bag.super.forEach(action);
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
        return Bag.super.spliterator();
    }
}
