import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node head;
    private int size;

    private class Node {
        E data;
        Node next;
        public Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public LinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public void addFront(E item) {
        Node newNode = new Node(item, null);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addBack(E item) {
        Node newNode = new Node(item, null);
        if (head == null){
            head = newNode;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int i, E item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node indexNode = head;
        for(int j  = 0; j < i; j++){
            indexNode = indexNode.next;
        }
        Node newNode = new Node(item, indexNode.next);
        indexNode.next = newNode;

        size++;

    }

    @Override
    public E get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node getNode = head;
        for(int j  = 0; j < i; j++){
            getNode = getNode.next;
        }
        E item = getNode.data;
        return item;
    }

    @Override
    public void set(int i, E item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node indexNode = head;
        for(int j  = 0; j < i; j++){
            indexNode = indexNode.next;
        }
        indexNode.data = item;
    }

    @Override
    public E removeFront() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        E remove = head.data;
        head = head.next;
        size--;
        return remove;
    }

    @Override
    public E removeBack() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        Node lastNode = head;
        Node prevNode = null;

        while(lastNode.next != null){
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        E remove = lastNode.data;
        prevNode.next = null;
        lastNode.data = null;

        size--;
        return remove;
    }

    @Override
    public void remove(E item) {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from an empty list");
        }
        Node indexNode = head;
        Node prevNode = null;

        for(int i = 0; i < size - 1; i++) {
            prevNode = indexNode;
            indexNode = indexNode.next;
            if (indexNode.data.equals(item)){
                prevNode.next = indexNode.next;
                indexNode = null;
            }
        }
        size--;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node indexNode = head;
        for(int j = 0; j < i - 1; j++){
            indexNode = indexNode.next;
        }
        Node removeNode = indexNode.next;
        E value = removeNode.data;

        indexNode.next = removeNode.next;
        size--;

        return value;
    }

    @Override
    public boolean contains(E item) {
        Node indexNode = head;
        for(int i = 0; i < size; i++){
            if( indexNode.data.equals(item)){
                return true;
            }
            indexNode = indexNode.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
