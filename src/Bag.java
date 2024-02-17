/**
 * Bag interface only supports adding and iterating.
 *
 * @param <E> Type to be added
 * @author R.J. Trenchard
 */

public interface Bag<E> extends Iterable<E> {
    /**
     * Adds an item to the bag
     * @param item An item of the generic type.
     */
    void add(E item);

    /**
     * Returns true if the bag has no items.
     * @return true if empty.
     */
    boolean isEmpty();

    /**
     * Gets the amount of items in the bag.
     * @return size
     */
    int size();
}
