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
     * Runtime: O(1) - This method only executes the fixed number of steps.
     * There is no shifting needed or traversing through the LinkedList.
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
     * Runtime:
     * At best O(1) - If the list is empty or only has one element, the method
     * works similarly to adding to the front. No traversal needed
     *
     * At worst O(N) - Regardless of if there are a few elements or several million,
     * we must visit each node to get to the end of the list.
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
        else if (size == 1)
        {
            head.next = node;
            size++;
        }
        else
        {
            // the list has some nodes in it
            // traverse through list until we hit the end
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = node;
            size++;
        }
    }

    /**
     * Add an item at specified index (position).
     *
     * Runtime:
     * At best O(1) - The list is small: adding to the head or head.next.
     *
     * At worst O(N) - The list is large and the index given is toward the back.
     * Almost every element needs to be visited.
     *
     * @param i    the index where the item should be added
     * @param item the item to be added
     */
    @Override
    public void add(int i, E item)
    {
        if (i > size)
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
        {
            head.next = newNode;
            size++;
        }

        else
        {
            // keep track of previous node
            Node previousNode = current;

            // traverse list until we get to index
            while (index != i)
            {
                previousNode = current;
                current = current.next;
                index++;
            }
            // assign the previousNode's next to newNode's next
            newNode.next = previousNode.next;

            // previousNode -> newNode
            previousNode.next = newNode;
            size++;
        }
    }

    /**
     * Get the item at a specified index.
     *
     * Runtime:
     *
     * At best O(1) - Accessing the head/front of the LinkedList.
     *
     * At worst O(N) - The list is large and the index given is toward the back.
     * Almost every element needs to be visited.
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

        if (i > size)
            throw new IndexOutOfBoundsException("Index is out of range");

        // the size is 1
        if (size == 1)
        {
            return head.data;
        }
        else
        {
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
    }

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     *
     * Runtime:
     *
     * At best O(1) - Reassigning the front
     *
     * At worst O(N) - If the list is large and the given index is toward the back.
     * Almost all elements needs to be visited.
     *
     * @param i    the index where the item should be saved
     * @param item the item to be saved
     */
    @Override
    public void set(int i, E item)
    {
        // exceptions
        if (size == 0 && i != 0)
            throw new NoSuchElementException("The list is empty");

        if (i > size)
            throw new IndexOutOfBoundsException("Index is out of range");

        int index = 0;
        Node current = head;

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
     * Runtime: O(1) - This method only needs to visit the front
     * and completes each line in one execution.
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
     * Runtime:
     *
     * At best O(1) - Removing the front of the list if there is only one element
     *
     * At worst O(N) - We need to run through the entire list in order to get to the end
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
     * Runtime:
     *
     * At best O(1) - Removing the front of the list if there is only one element
     *
     * At worst O(N) - We may need to run through the entire list in order to find an item.
     * There is a possibility that the item does not exist.
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
     * Runtime:
     *
     * At best O(1) - Removing the front of the list if there is only one element.
     *
     * At worst O(N) - We need to run through each element until we get to the
     * desired index.
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
     * Runtime:
     *
     * At best O(1) - Removing the front of the list if there is only one element.
     *
     * At worst O(N) - We may need to run through the entire list in order to find an item.
     * There is a possibility that the item does not exist.
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

        // if there is only 1 in the list and it is not the item
        if (size == 1 && current.data != item)
            return false;

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
     * Runtime: O(1) - Can be completed in one line because we're
     * doing a boolean statement and only making a comparison. We
     * do not need to access the LinkedList at all.
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
     * Runtime: O(N) - We need to visit every single node in the
     * LinkedList in order to get the size.
     *
     * @return number of items in the list
     */
    @Override
    public int size()
    {
        if (isEmpty())
            return 0;

        Node current = head;

        // if there is only one element
        if (current.next == null)
            return 1;
        // otherwise, count the items in the list
        else
        {
            int sizeCount = 1;

            while (current.next != null)
            {
                sizeCount++;
                current = current.next;
            }
            return sizeCount;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * Runtime: O(1) - Each line of code in the method executes in one operation,
     * regardless of the size of the LinkedList.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new SinglyLinkedIterator();
    }

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
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the LinkedList.
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
         * Runtime: O(1) - Each line of code in the method executes in one operation,
         * regardless of the size of the LinkedList.
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
