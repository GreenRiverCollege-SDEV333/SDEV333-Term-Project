import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>
{
    // define a node
    private class Node {
        E data;
        Node next;
    }

    // set up the head field
    private Node head;

    // set up the size field
    private int size;

    // add constructor to initialize
    public LinkedList()
    {
        head = null;
        size = 0;
    }
    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        // set up a new node
        Node newNode = new Node();

        if (head == null)
        {
            // the list is currently empty
            head = newNode;
            head.data = item;
            size++;
        }
        else
        {
            // the list current has some nodes in it
            newNode.next = head;
            head = newNode;
            head.data = item;
            size++;
        }
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        // keep track of current node
        // to traverse through the list
        Node current = head;

        Node node = new Node();
        node.data = item;

        // if the list is empty
        if (size == 0)
        {
            head = node;
            size++;
        }

        // the list has some nodes in it
        // traverse through list until we hit the end
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = node;
    }

    /**
     * Add an item at specified index (position).
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item)
    {
        if (i >= size)
            throw new IndexOutOfBoundsException("Index is out of range");

        // create index variable and current node
        int index = 0;
        Node current = head;

        // new node
        Node newNode = new Node();
        newNode.data = item;

        if (head == null)
            addFront(item);
        //index 1 is null, assign new node
        else if (head.next == null)
            head.next = newNode;

        else
        {
            // keep track of previous node
            Node previousNode = current;

            // traverse list until we get to index
            while (index != i && current.next != null)
            {
                previousNode = current;
                current = current.next;
                index++;
            }
            // assign the previousNode's next to newNode's next
            newNode.next = previousNode.next;

            // previousNode -> newNode
            previousNode.next = newNode;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    @Override
    public E get(int i)
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");

        if (i >= size)
            throw new IndexOutOfBoundsException("Index is out of range");

        // create index variable and current node
        int index = 0;
        Node current = head;

        // move through list until you get to the
        // give index
        while (index != i)
        {
            current = current.next;
            index++;
        }
        return current.data;
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item)
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");

        if (i >= size)
            throw new IndexOutOfBoundsException("Index is out of range");

        int index = 0;
        Node current = head;
        Node previousNode = current;

        // move through list
        while (index != i)
        {
            current = current.next;
            index++;
        }
        // replace data
        current.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");

        // if there is only one node
        if (head.next == null)
        {
            E removedElement = head.data;
            head = null;
            return removedElement;
        }
        else
        {
            E removedElement = head.data;
            head = head.next;
            return removedElement;
        }
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
        //only 1 element (head)
        if (size == 1)
        {
            E removedElement = head.data;
            head = null;
            return removedElement;
        }
        else
        {
            Node current = head;
            Node previousNode = current;

            // move through the list
            while (current.next != null)
            {
                previousNode = current;
                current = current.next;
            }
            // store data into element to return
            E removedElement = current.data;

            // then reassign next to null
            previousNode.next = null;

            return removedElement;
        }
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
        //only 1 element (head)
        if (size == 1)
            head = null;
        else
        {
            Node current = head;
            Node previousNode = current;

            // move through the list
            // until there is a match
            while (current.data != item)
            {
                previousNode = current;
                current = current.next;
            }
            // then reassign next to null
            previousNode.next = null;
        }
    }

    /**
     * Remove item at a specified index.
     *
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    @Override
    public E remove(int i)
    {
        E removedElement;

        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
        //only 1 element (head)
        else if (size == 1)
        {
            removedElement = head.data;
            head = null;
            return removedElement;
        }

        else
        {
            // nodes to keep track
            Node current = head;
            Node previousNode = current;

            int currentIndex = 0;

            // move through the list
            while (currentIndex != i)
            {
                previousNode = current;
                current = current.next;
                currentIndex++;
            }

            removedElement = current.data;

            // then reassign next to null
            previousNode.next = current;

            return removedElement;
        }
    }

    /**
     * Checks if an item is in the list.
     *
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    @Override
    public boolean contains(E item)
    {
        // exceptions
        if (size == 0)
            throw new NoSuchElementException("The list is empty");
            //only 1 element (head)

        Node current = head;

        while (current.data != item)
        {
            current = current.next;

            // this means we've hit the end of the list
            // and the element does not exist
            if (current.next == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Provides a count of the number of items in the list.
     *
     * @return number of items in the list
     */
    @Override
    public int size()
    {
        if (isEmpty())
            return 0;

        Node current = head;
        int sizeCount = 0;

        while (current.next != null)
        {
            current = current.next;
            sizeCount++;
        }
        return sizeCount;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new SinglyLinkedIterator();
    }

    //helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<E>{

        private Node current;

        public SinglyLinkedIterator() {
            current = head;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            if (current == null) {
                return false;
            }
            else {
                return true;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next()
        {
            if (current == null)
            {
                throw new NoSuchElementException("There is no next one to go to!!");
            }
            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
