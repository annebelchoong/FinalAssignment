
package adt.Guna;

import java.util.Iterator;

/**
 *
 * @author Gunaseelan
 */
public interface SortedListInterface<T extends Comparable<T>> {

  public boolean add(T newEntry);

  public boolean remove(T anEntry);

  public boolean contains(T anEntry);

  public void clear();

  public int getNumberOfEntries();

  public boolean isEmpty();

  public T getEntry(int givenPosition);

  Iterator<T> getIterator();
}
