package List;

/***
 * List.List interface (API / abstract data type)
 * @param <E> Class or data type of the items in the list.
 */
public interface List<E> extends Iterable<E> {
    /**
     * Add item to the front.
     * @param item the item to be added
     */
    void addFront(E item);

    /**
     * Add item to the back.
     * @param item the item to be added
     */
    void addBack(E item);

    /**
     * Add an item at specified index (position).
     * @param i the index where the item should be added
     * @param item the item to be added
     */
    void add(int i, E item);

    /**
     * Get the item at a specified index.
     * @param i the index where the item should be retrieved
     * @return the item located at that index
     */
    E get(int i);

    /**
     * Set (save) an item at a specified index. Previous
     * item at that index is overwritten.
     * @param i the index where the item should be saved
     * @param item the item to be saved
     */
    void set(int i, E item);

    /**
     * Remove item at the front of the list.
     * @return the item that was removed
     */
    E removeFront();

    /**
     * Remove item at the back of the list
     * @return the item that was removed
     */
    E removeBack();

    /**
     * Remove item from the list
     * @param item the item to be removed
     */
    void remove(E item);

    /**
     * Remove item at a specified index.
     * @param i the index where the item should be removed
     * @return the item that was removed
     */
    E remove(int i);

    /**
     * Checks if an item is in the list.
     * @param item the item to search for
     * @return true if the item is in the list, false otherwise
     */
    boolean contains(E item);

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides a count of the number of items in the list.
     * @return number of items in the list
     */
    int size();
}
