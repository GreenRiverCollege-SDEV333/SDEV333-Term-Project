/**
 * Bag interface
 * @param <Item> class / data type of the items in the queue
 */
public interface Bag<Item> extends Iterable<Item> {

    /**
     * Add an item to the bag
     * @param item the item to be added
     */
    void add(Item item);

    /**
     * Checks to see if the bag is empty
     * @return true if empty, false is not empty
     */
    boolean isEmpty();

    /**
     * Returns the count of items in the queue
     * @return the number of items in the queue
     */

    int size();
}
