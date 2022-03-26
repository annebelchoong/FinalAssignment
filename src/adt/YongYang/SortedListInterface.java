package adt.YongYang;

/**
 *
 * @author yongyangboon
 */
public interface SortedListInterface<T extends Comparable<T>> {

    public void add(T newEntry);

    // public boolean add(T anEntry, int givenPosition);

    public boolean remove(T anEntry);

    public T remove(int givenPosition);

    public int getPosition(T anEntry);

    public T getEntry(int givenPosition);

    public boolean replace(int givenPosition, T newEntry);

    // public T getLastEntry();

    public boolean contains(T anEntry);

    public void clear();

    public int getNumOfEntries();

    public boolean isEmpty();

}
