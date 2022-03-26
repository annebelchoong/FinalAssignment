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
public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public SortedLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        Node nodeBefore = null;
        Node currentNode = firstNode;
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }

        if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
            newNode.next = firstNode;
            firstNode = newNode;
        } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        if (firstNode == null) {                            //check firstNode null ---> linkedKist is empty
            return false;
        } else {
            Node nodeBefore = null;                          //set the nodeBefore
            Node currentNode = firstNode;                     //currentNode
            while (currentNode != null && currentNode.data.compareTo(anEntry) < 0) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode.data.equals(anEntry)) {     //check currentNode && anEntry is found
                if (currentNode == firstNode) {                                //if deleting in the front
                    firstNode = firstNode.next;                             //firstNode = ??
                } else {
                    nodeBefore.next = currentNode.next;                     //nodeBefore = ?? 
                }
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node tempNode = firstNode;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.next;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;

        while (currentNode != null) {
            outputStr += currentNode.data + "\n";;
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    public Iterator<T> getIterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<T> {

        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currentData = null;
            if (hasNext()) {
                currentData = currentNode.data;
                currentNode = currentNode.next;
            }
            return currentData;
        }
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
