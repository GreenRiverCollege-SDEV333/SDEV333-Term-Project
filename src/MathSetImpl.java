import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MathSetImpl<E extends Comparable<E>> implements MathSet<E> {
    /**
     * Adds a key (item) to the set. Duplicate items
     * are not added.
     *
     * @param key the key (item) to be added
     */
    @Override
    public void add(E key) {

    }

    /**
     * Removes a key (item) from the set.
     *
     * @param key the key (item) to be removed
     */
    @Override
    public void remove(E key) {

    }

    /**
     * Checks if a key (item) is an element in the set.
     *
     * @param key the key (item) to check
     * @return true if the key is in the set, false otherise
     */
    @Override
    public boolean contains(E key) {
        return false;
    }

    /**
     * Checks if this set is equal to another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is equal to the other set
     */
    @Override
    public boolean equals(MathSet<E> other) {
        return false;
    }

    /**
     * Checks if this set is a subset of another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is a subset of the other set
     */
    @Override
    public boolean isSubsetOf(MathSet<E> other) {
        return false;
    }

    /**
     * Checks if this set is a proper subset of another set.
     *
     * @param other the set to compare this set against
     * @return true if this set is a proper subset of the other set
     */
    @Override
    public boolean isProperSubsetOf(MathSet<E> other) {
        return false;
    }

    /**
     * Computes the union of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the union
     */
    @Override
    public MathSet<E> union(MathSet<E> other) {
        return null;
    }

    /**
     * Computes the intersection of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the intersection
     */
    @Override
    public MathSet<E> intersection(MathSet<E> other) {
        return null;
    }

    /**
     * Computes the difference of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the difference
     */
    @Override
    public MathSet<E> difference(MathSet<E> other) {
        return null;
    }

    /**
     * Computes the symmetric difference of this set and another specified set.
     * Does not change the contents of this set.
     *
     * @param other the second set for the operation
     * @return new MathSet that contains the symmetric difference
     */
    @Override
    public MathSet<E> symmetricDifference(MathSet<E> other) {
        return null;
    }

    /**
     * Checks if this set is empty.
     *
     * @return true if this set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns a count of the number of keys (elements) in this set
     * also known as the cardinality of the set.
     *
     * @return number of keys (elements) in this set.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
