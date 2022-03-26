package adt.YongYang;

public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int INITIAL_CAPACITY = 100;

    public SortedArrayList() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SortedArrayList(int startingCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[startingCapacity];
    }

    @Override
    public void add(T newEntry) {
        int i = 0;
        while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
            i++;
        }
        makeRoom(i + 1);
        array[i] = newEntry;
        numberOfEntries++;
        // return true;
    }

    @Override
    public boolean remove(T anEntry) {
        if (isEmpty()) {
            return false;

        } else {
            int index = 0;

            while (index < numberOfEntries && array[index].compareTo(anEntry) < 0)
                index++;

            if (array[index].equals(anEntry)) {
                removeGap(index + 1);
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public int getPosition(T anEntry) {
        //
        return 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }
        return result;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) { // why givenPosition more than eq 1?
            array[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public boolean contains(T anEntry) {
        //
        return false;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public int getNumOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

}