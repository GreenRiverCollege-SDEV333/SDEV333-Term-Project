public interface Bag<E> extends Iterable<E> {
    /**
     * Adds an item to the bag
     * @param item An item of the generic type.
     */
    public void add(E item);

    /**
     * Returns true if the bag has no items.
     * @return true if empty.
     */
    public boolean isEmpty();

    /**
     * Gets the amount of items in the bag.
     * @return size
     */
    public int size();
}
