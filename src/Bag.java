/**
 * Author : Levi Miller
 * file: Bag.java, Bag interface
 */

/**
 * Collect and iterate over items Bag API
 *
 * @param <Item>> class / data type of the items in the bag
 */
public interface Bag<Item> extends Iterable<Item> {
    /**
     * Add an item to the bag.
     *
     * @param item the item to be added
     */
    void add(Item item);

    /**
     * Checks to see if the bag is empty.
     *
     * @return true if the bag is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of items in the stack.
     *
     * @return the number of items in the bag
     */
    int size();
}
