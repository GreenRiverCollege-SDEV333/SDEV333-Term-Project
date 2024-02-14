import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Iterable<E>
{

    // define node
    private class Node{
        Object data;
        Node next;

        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    // set up head field
    private Node head;
    //set up size field
    private int size;

    /**
     * Add item to the front.
     *
     * Time Complexity: O(1) only the head needs to be updated
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        add(0, item);
    }

    /**
     * Add item to the back.
     *
     * Time Complexity: O(n) every element must be accessed from node to node to get to the end
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        add(size, item);
    }

    /**
     * Add an item at specified index (position).
     *
     * Time Complexity: O(n) Each Node before the desired index must be accessed
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item)
    {
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node newNode = new Node(item);

        if(size == 0){
            head = newNode;
            size++;
            return;
        }

        if(i == 0){
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        for (int j = 0; j < i - 1; j++)
        {
            current = current.next;
        }

        if(current.next != null){
            newNode.next = current.next;
        }

        current.next = newNode;
        size++;
    }

    /**
     * Get the item at a specified index.
     *
     * Time Complexity: O(n) potentially have to access several elements before finding desired Node
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public Object get(int i)
    {
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        if(size == 0){
            return null;
        }

        Node current = head;

        for (int j = 0; j < i; j++)
        {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Time Complexity: O(n) every proceeding node must be accessed to reach the desired node
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item)
    {
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        Node newNode = new Node(item);

        if(size == 0){
            return;
        }

        Node current = head;

        for (int j = 0; j < i; j++)
        {
            current = current.next;
        }

        if(current.next != null){
            newNode.next = current.next;
        }

        current.data = newNode.data;
    }

    /**
     * Remove item at the front of the list.
     *
     * Time Complexity: O(n) since the remove method is O(n)
     *
     * @return the item that was removed
     */
    @Override
    public Object removeFront()
    {
        return remove(0);
    }

    /**
     * Remove item at the back of the list
     *
     * Time Complexity: O(n) since the remove method is O(n)
     *
     * @return the item that was removed
     */
    @Override
    public Object removeBack()
    {
        return remove(size-1);
    }

    /**
     * Remove item from the list
     *
     * Time Complexity: O(n) since each Node may have to be accessed before reaching desired index
     *
     * @param item the item to be removed
     * @return
     */
    @Override
    public Object remove(E item)
    {
        if(head.data == item){
            Node removed = head;
            head = head.next;
            return removed.data;
        }

        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                prev.next = current.next;
                return current.data;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    /**
     * Remove item at a specified index.
     *
     * Time Complexity: O(n) since each Node may have to be accessed before reaching desired index
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public Object remove(int i)
    {
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        if(i == 0){
            Node removed = head;
            head = head.next;
            return removed.data;
        }

        Node prev = null;
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == i) {
                prev.next = current.next;
                return current.data;
            }
            prev = current;
            current = current.next;
            count++;
        }

        return null;
    }

    /**
     * Checks if an item is in the list.
     *
     * Time Complexity: O(n) since each Node may have to be accessed before reaching desired Node data
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        Node current = head;

        while (current != null)
        {
            if(current.data == item){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * Time Complexity: O(1) checks size variable once
     *
     * @return true if the list is empty, false otherwise
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
     * Provides a count of the number of items in the list.
     *
     * Time Complexity: O(1) checks size variable once
     *
     * @return number of items in the list
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
            private Node current = head;

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

    /**
     * Returns a string containing all elements in the linked list.
     *
     * Time Complexity: O(n) since each element must be accessed to be added to the contents string
     *
     * @return a string that represents the contents of the linked list.
     */
    @Override
    public String toString()
    {
        Node current = head;

        String contents = "{ ";

        while (current != null)
        {
            contents += current.data + " ";
            current = current.next;
        }

        contents += "}";

        return contents;
    }
}
