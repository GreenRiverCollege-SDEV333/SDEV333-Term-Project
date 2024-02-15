package APIs;

public interface Bag<E> extends Iterable<E> {
    /**
     * Adds the given item to the bag
     * @param item the item to be added
     */
    void add(E item);

    /**
     * Checks whether the bag is empty, and returns true/false accordingly
     * @return true if the bag is empty; otherwise false
     */
    boolean isEmpty();

    /**
     * Gets and returns the number of items stored in the bag
     * @return the number of items stored in the bag
     */
    int size();
}