import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue (Container) which uses linked list / nodes to store data
 * @param <E>
 */
public class LinkedBag<E> implements Bag<E>
{

    private class Node{
        E data;
        LinkedBag.Node next;

        Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    private LinkedBag.Node head;
    private int size;

    public LinkedBag(){
        this.size = 0;
        this.head = null;
    }

    /**
     * Adds item to the bag
     *
     * Time Complexity: O(1) Only one node is accessed
     *
     * @param beingAdded the item to be added
     */
    @Override
    public void add(E beingAdded)
    {
        Node oldHead = head;
        head = new Node(beingAdded);
        head.next = oldHead;
        size++;
    }

    /**
     * Checks to see if the bag is empty
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return true if bag is empty, false if otherwise
     */
    @Override
    public boolean isEmpty()
    {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns a count of the number of items in the bag
     *
     * Time Complexity: O(1) size variable checked once
     *
     * @return the number of items in the bag
     */
    @Override
    public int size()
    {
        return size;
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Time Complexity: O(1) since iterators are always on constant time
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<>()
        {
            private LinkedBag.Node current = head;

            @Override
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public E next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object data = current.data;
                current = current.next;
                return (E) data;
            }
        };
    }
}
