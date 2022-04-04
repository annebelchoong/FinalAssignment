/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt.HuiYun;

import java.util.Iterator;

/**
 *
 * @author Chia Hui Yun
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {
    public boolean add(T newEntry);

    public boolean remove(T anEntry);

    public boolean contains(T anEntry);

    public void clear();

    public int getNumberOfEntries();

    public boolean isEmpty();

    Iterator<T> getIterator();

    public T getEntry(int givenPosition);

}
