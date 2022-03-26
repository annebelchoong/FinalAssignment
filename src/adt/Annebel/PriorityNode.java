/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt.Annebel;

/**
 *
 * @author annebelchoong
 */
public class PriorityNode<T>{
    
    int priority;
    T data;
    PriorityNode<T> next;

    public PriorityNode() {
    }

    public PriorityNode(T data) {
        this.data = data;
    }
    
    public PriorityNode(int priority, T data) {
        this.priority = priority;
        this.data = data;
    }
    
    
    public PriorityNode(int priority, T data, PriorityNode<T> next) {
        this.priority = priority;
        this.data = data;
        this.next = next;
    }




    
    
}
