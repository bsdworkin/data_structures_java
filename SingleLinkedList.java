/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa2;
import java.util.*;

/**
 *
 * @author bsdwork
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        SLList<String> myList = new SLList<String>();
        
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        
        System.out.println(myList.toString());
        myList.swap(2,3);
        System.out.println(myList.toString());
        myList.removeRange(1,3);
        System.out.println(myList.toString());
       
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
    private int size;
    
    public boolean add(E item){
        add(size, item);
        return true;
    }
    
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new
                IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0){
            addFirst(item);
        }else {
            Node<E> node = getNode(index -1);
            addAfter(node, item);
        }
    }
    
    private void addFirst(E item){
        head = new Node<E>(item, head);
        size++;
    }
    
    private void addAfter(Node<E> nd, E item){
        nd.next = new Node<E>(item, nd.next);
        size ++;
    }
       
    private Node<E> getNode (int index){
        Node<E> node = head;
        for(int i =0; i< index && node!= null; i++){
            node = node.next;
        }
        return node;
    }
    
     public E get (int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    
    public E set (int index, E newValue){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
    
    
    @Override
     public String toString() {
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();

        while (nodeRef != null) {
            result.append(nodeRef.data);
            if (nodeRef.next != null) {
                result.append(" ==> ");
            }
            nodeRef = nodeRef.next;
        }
        return result.toString();

    }
    
    public Node remove (int index){
        if(index< 0 || index >= this.size){
            throw new IndexOutOfBoundsException("You can't remove the index with Linked List size being" + this.size);
        }
        Node <E> temp = this.head;
        
        for (int i= 0; i < index -1; i++){
            temp = temp.next;
        }
        
        Node<E>  removedNode = temp.next;
        temp.next = temp.next.next;
        
        size--;
        return removedNode;
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
    
    public int getSize(){
        int counter = 0;
        for (Node node = head; node != null; node = node.next)
            ++ counter;
        return counter;
    }
    
    public void swap(int i, int j){
        if(i < 0 || i > size){
            throw new
                IndexOutOfBoundsException(Integer.toString(i));
        }
        if(j < 0 || j > size){
            throw new
                IndexOutOfBoundsException(Integer.toString(j));
        }
        E temp = get(i);
        E temp2 = get(j);
        set(i, temp2);
        set(j, temp);
    }
    
    public void removeRange(int index, int numItems){
        int deletedItems = numItems - index +1;
        try{
            Node<E> node1 = this.head; 
            for(int i =0; i< index-1; i++){
                node1= node1.next;
            }
            
            Node<E> node2 = this.head;
            for(int i=0; i <= numItems; i++){
                node2 = node2.next; 
            }
            
            node1.next = node2;
            this.size -= (numItems - index +1);
            System.out.println("Number of deleted items:" + deletedItems);
        }catch (NullPointerException e){
            System.out.println("Cant remove range");
        }
    }
}
    
    
    

