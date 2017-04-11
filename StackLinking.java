/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa3;

/**
 *
 * @author bsdwork
 */
public class StackLinking {
    public static void main(String[] args) {
        LinkedStack<String> stack2 = new LinkedStack<String>();
        stack2.push("Alex");
        stack2.push("Bob");
        stack2.push("Cindy");
        stack2.push("Dave");
        
        System.out.print(stack2.size());
    }
}

interface StackInt<E> {
    E push (E item);
    E peek ();
    E pop ();
    boolean isEmpty();
}

class LinkedStack<E> implements StackInt<E>{
    private static class Node<E> {
        private E data; 
        private Node<E> next;
        private Node(E newItem){
            data = newItem;
            next = null;
        }
        private Node(E newItem, Node<E> nodeRef){
            data = newItem;
            next = nodeRef;
        }
    }
    
    private Node<E> topOfStackRef = null;
    
    
    public E push(E item){
       topOfStackRef = new Node<E>(item, topOfStackRef);
       return item;
    }
    
    
    public E pop(){
        E result = topOfStackRef.data;
        topOfStackRef = topOfStackRef.next;
        return result;
    }
    
    
    public E peek(){
        return topOfStackRef.data;
    }
    
    
    public boolean isEmpty(){
        return topOfStackRef == null;
    }
    
    public int size(){
        int count = 0; 
        Node<E> current = topOfStackRef;
        while(current != null){
            count ++;
            current = current.next;
        }
        return count;
    }
}