/**
 * Collection structure
 *
 * @param <E> class, data type of the items in the bag
 */

public interface Bag<E> extends Iterable<E> {

    /**
     * Add an item to the bag.
     *
     * @param item to be added
     */
    void add(E item);

    /**
     * Checks whether the bag is empty
     *
     * @return true, if the bag is empty. False otherwise
     */
    boolean isEmpty();

    /**
     * Return a count of the number of items in the bag.
     *
     * @return the number of items that is in the bag
     */
    int size();

}
