import java.util.Iterator;

/**
 * class for the LinkedBag
 * @param <E> data type
 * @author Huy Nguyeb
 * @version  1.0
 */
public class LinkedBag <E> implements Bag<E>{
    private Node head;
    private int size;
    private class Node{
        E data;
        Node next;
    }

    public LinkedBag(){
        this.head = null;
        this.size = 0;
    }

    /**
     *method to add at the front of the linked list of the bag
     * the runtime will always be O(1) because it's adding at the
     * front of a linked list which already has a head reference to utilize
     * @param item added item
     */
    @Override
    public void add(E item) {
        Node theNewNode = new Node();
        theNewNode.data = item;
        if (head== null){
            head = theNewNode;
        }
        else{
            theNewNode.next = head;
            head = theNewNode;
        }
        size++;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you're only checking one value
      @return the size of the stack
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * method to get the size of the stack
     * will always be O(1) because you are returning the field
     * @return the size of hte stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * method to get the iterator object
     * everything here will be O(1) and same for all the other iterators,
     * the methods within these are simple looking ahead one element of data
     * and doesn't need to iterator. Since they're already position to
     * look into the data one forward, only one iteration is needed
     * so runtime will be O(1)
     * @return an iterator object of the data structure
     */
    @Override
    public Iterator iterator() {
        return new LinkedbagIterator();
    }
    private class LinkedbagIterator implements Iterator<E>{
        Node curr = head;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E value = curr.data;
            curr = curr.next;
            return value;
        }
    }
}
