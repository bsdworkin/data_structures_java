/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.ch2.linkedlist;

/**
 *
 * @author bsdwork
 */
public class It179Ch2LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class SLList<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next = null;
        
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
        
        public Node(E data){ 
            this(data, null);
        }
    }
    
    private Node<E> head = null;
    private int size = 0;
    
    private void addFirst(E item){
        head = new Node<E>(item, head);
        size++;
    }
    
    private void addAfter(Node<E> nd, E item){
        nd.next = new Node<E>(item, nd.next);
    }
    
    private E removeFirst(){
        Node<E> temp = head;
        if (head != null){
            head = head.next;
        }
        if(temp != null){
            size--;
            return temp.data;
        }
        else{
            return null;
        }
    }
    
    private E removeAfter(Node<E> nd){
        Node<E> temp = nd.next;
        if(temp != null){
            nd.next = temp.next;
            size--;
            return temp.data;
        }
        else {
            return null;
        }
    }
    
