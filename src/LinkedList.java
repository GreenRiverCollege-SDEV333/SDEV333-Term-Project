import java.util.Iterator;

public class LinkedList<E> implements List<E>
{
    //fields
    private Node head;
    private int size;

    private class Node
    {
        E data;
        Node next;

        private Node(E data)
        {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Add item to the front.
     *
     * @param item the item to be added
     */
    @Override
    public void addFront(E item)
    {
        //create new node
        Node newNode = new Node(item);

        //set next reference to head
        newNode.next = head;

        //reassign head to newNode
        head = newNode;

        //increment size
        size++;
    }

    /**
     * Add item to the back.
     *
     * @param item the item to be added
     */
    @Override
    public void addBack(E item)
    {
        if(head == null)
        {
            //assign node to head if linkedlist is empty
            addFront(item);
        }
        else
        {
            //create a new node
            Node newNode = new Node(item);

            //keep track of current node
            Node curr = head;

            while(curr.next != null)
            {
                //traverse linkedlist to end
                curr = curr.next;
            }

            //assign newNode to pointer reference of tail
            curr.next = newNode;

            //increment size
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
    public void add(int i, E item)
    {
        //throw exception if index is out of bounds
        if(i < 0 || i > size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if(i == 0)
        {
            //add new node to front if index 0
            addFront(item);
        }
        else if(i == size)
        {
            //add new node to tail if index is the last
            addBack(item);
        }
        else
        {
            //create a new node
            Node newNode = new Node(item);

            //keep track of current node
            Node curr = head;

            //traverse to specified index
            for(int j = 0; j < i -1; j++)
            {
                curr = curr.next;
            }

            //insert newNode
            newNode.next = curr.next;
            curr.next = newNode;

            //increment size
            size++;
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
        //throw exception if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //keep track of current node
        Node curr = head;

        //traverse to specified index
        for(int j = 0; j < i; j++)
        {
            curr = curr.next;
        }

        //return node at specified index
        return curr.data;
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
        //throw exception if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //keep track of current node
        Node curr = head;

        //traverse to specified index
        for(int j = 0; j < i; j++)
        {
            curr = curr.next;
        }

        //reassign data of curr
        curr.data = item;
    }

    /**
     * Remove item at the front of the list.
     *
     * @return the item that was removed
     */
    @Override
    public E removeFront()
    {
        //throw exception if linkedlist is empty
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        //save node to be removed
        Node removedNode = head;

        //reassign head to the next node
        head = head.next;

        //decrement size
        size--;

        //return removed node data
        return removedNode.data;
    }

    /**
     * Remove item at the back of the list
     *
     * @return the item that was removed
     */
    @Override
    public E removeBack()
    {
        //throw exception if linkedlist is empty
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        //remove head if size == 1
        if(size == 1)
        {
            return removeFront();
        }

        //track current node
        Node curr = head;

        //traverse to second to last node
        while(curr.next.next != null)
        {
            curr = curr.next;
        }

        //save node to be removed
        Node removedNode = curr.next;

        //reassign curr.next to null, deleting last node
        curr.next = null;

        //decrement size
        size--;

        //return removed node data
        return removedNode.data;
    }

    /**
     * Remove item from the list
     *
     * @param item the item to be removed
     */
    @Override
    public void remove(E item)
    {
        //throw exception if linkedlist is empty
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        //if head equals item, remove head
        if(head.data.equals(item))
        {
            removeFront();
            return;
        }

        //track current/prev node
        Node curr = head;
        Node prev = curr;

        //traverse linkedlist until either item is found or linkedlist ends
        while(curr.next != null && !curr.data.equals(item))
        {
            prev = curr;
            curr = curr.next;
        }

        //throw exception if item not found
        if(curr.next == null)
        {
            throw new IllegalArgumentException("Item not found");
        }

        //reassign prev.next reference to curr.next
        prev.next = curr.next;

        //decrement size
        size--;
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
        //throw exception if index is out of bounds
        if(i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //remove head if i == 0
        if(i == 0)
        {
            //remove head node and return node data
            return removeFront();
        }

        //track current node
        Node curr = head;

        //traverse to one before index of node to be removed
        for(int j = 0; j < i - 1; j++)
        {
            curr = curr.next;
        }

        //save node to be removed
        Node removedNode = curr.next;

        //reassign curr.next reference to the node after curr.next
        curr.next = curr.next.next;

        //decrement size
        size--;

        return removedNode.data;
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
        //track current node
        Node curr = head;

        //traverse linkedlist to search for item
        while(curr != null)
        {
            if(curr.data.equals(item))
            {
                return true;
            }

            curr = curr.next;
        }

        //item not found
        return false;
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
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>
    {
        private Node curr;

        LinkedListIterator()
        {
            curr = head;
        }

        @Override
        public boolean hasNext()
        {
            return curr != null;
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new IllegalStateException("List empty");
            }
            E data = curr.data;
            curr = curr.next;
            return data;
        }
    }
}
