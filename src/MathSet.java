/**
 * MathSet API (interface / abstract data type)
 * represents a mathematical set. Sets in mathematics
 * have unique elements (keys) and there are no duplicate keys.
 * <p>
 * In this MathSet API, we have an additional constraint that
 * traditional mathematical sets do not have. In mathematical sets,
 * elements are unordered; order of keys does not matter. In this
 * MathSet API, we require items to be Comparable, so we can maintain
 * them in order. By keeping items in order, we can guarantee
 * some reasonable performance for the set operations (union,
 * intersection, difference, symmetric difference) and for search
 * (contains).
 *
 * @param <E> class/data type of the keys or elements in the set
 */
public interface MathSet<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Adds a key (item) to the set. Duplicate items
     * are not added.
     *
     * @param key the key (item) to be added
     */
    void add(E key);

    /**
     * Removes a key (item) from the set.
     *
     * @param key the key (item) to be removed
     */
    void remove(E key);

    /**
     * Checks if a key (item) is an element in the set.
     *
     * @param key the key (item) to check
     * @return true if the key is in the set, false otherise
     */
    boolean contains(E key);

    /**
     * Checks if this set is equal to another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is equal to the other set
     */
    boolean equals(MathSet<E> other);

    /**
     * Checks if this set is a subset of another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is a subset of the other set
     */
    boolean isSubsetOf(MathSet<E> other);

    /**
     * Checks if this set is a proper subset of another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is a proper subset of the other set
     */
    boolean isProperSubsetOf(MathSet<E> other);

    /**
     * Computes the union of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the union
     */
    MathSet<E> union(MathSet<E> other);

    /**
     * Computes the intersection of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the intersection
     */
    MathSet<E> intersection(MathSet<E> other);

    /**
     * Computes the difference of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the difference
     */
    MathSet<E> difference(MathSet<E> other);

    /**
     * Computes the symmetric difference of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the symmetric difference
     */
    MathSet<E> symmetricDifference(MathSet<E> other);

    /**
     * Checks if this set is empty.
     *
     * @return true if this set is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a count of the number of keys (elements) in this set
     * also known as the cardinality of the set.
     *
     * @return number of keys (elements) in this set.
     */
    int size();
}
