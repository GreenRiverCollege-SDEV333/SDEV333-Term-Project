/*
 * SDEV333 Best class :D
 * Ming Li
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * Add an item
     * @param item the item to be added
     */
    void add(E item);

    /**
     * Checks to see if the bad is empty
     * @return true of the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the bag.
     * @return the number of items in the bag
     */
    int size();
}
