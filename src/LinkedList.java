import java.util.Iterator;

public class LinkedList<E> implements List<E>{

    // Node class
    private class Node {
        E data;
        Node next;
    }

    // fields
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }
    @Override
    public void addFront(E item) {

    }

    @Override
    public void addBack(E item) {

    }

    @Override
    public void add(int i, E item) {

    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public void set(int i, E item) {

    }

    @Override
    public E removeFront() {
        return null;
    }

    @Override
    public E removeBack() {
        return null;
    }

    @Override
    public void remove(E item) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
