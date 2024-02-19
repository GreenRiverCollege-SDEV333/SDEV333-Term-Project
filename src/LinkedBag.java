import java.util.Iterator;

/**
 * Creates a linked list bag object. Has the ability to add items, check the
 * size of the bag, and status of if the bag is empty.
 * @author Sage Bain
 * @param <E>
 */
public class LinkedBag<E> implements Bag<E> {
    private Node head;
    private int size;

    public LinkedBag()
    {
        head = null;
        size = 0;
    }
    private class Node
    {
        E item;
        Node next;
    }

    /**
     * This will always run in constant time as we are simply creating a new
     * head Node and incrementing size, no looping or iteration required.
     * @param item the item to be added
     */
    @Override
    public void add(E item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    /**
     * This will always run in constant time as we are simply returning
     * true or false based on if head is equal to null.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * This will always run in constant time as we are simply returning
     * the value of size.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return a new ListIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<E>
    {
        private Node current = head;
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove()
        {

        }
        public E next()
        {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
