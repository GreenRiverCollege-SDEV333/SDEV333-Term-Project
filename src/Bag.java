/**
 * Bag represents a collection that can store elements of type {@code E}.
 * It provides methods to add elements to the bag, check if the bag is empty,
 * and retrieve the size of the bag.
 *
 * @author Braedon Billingsley
 * @param <E> the type of elements in the bag.
 */
public interface Bag<E> extends Iterable<E> {
    void add(E item);

    boolean isEmpty();

    int size();

}
