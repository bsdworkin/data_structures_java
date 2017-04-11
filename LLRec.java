/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa4;
import java.util.*;
/**
 *
 * @author bsdwork
 */
public class LLRec {
    public static void main(String[] args) {
        LinkedListRec<String> myList = new LinkedListRec<String>();
        myList.add("Ben");
        myList.add("Carl");
        myList.add("Jack");
        myList.add("Pat");
        myList.add("Austin");
        LinkedListRec<String> myList2 = new LinkedListRec<String>();
        myList2 = myList;
        myList.equals(myList2);
        myList.search(myList, "Ben");
        
        
    }
      
    
}
class LinkedListRec<E>{

    private Object pred;

    private static class Node<E>{
        private E data;
        private Node<E> next= null;
        
        public Node (E dataItem){
            data = dataItem;
            next = null;
        }
        
        public Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    }
    private Node<E> head= null;
    private int size=0;
        
    @Override
    
    public boolean equals(Object obj){
        if (this == obj){
            return true; 
        }
        if (obj == null){
            return false; 
        }
        if (this.getClass()!= obj.getClass()){
            return false;
        }
        LinkedListRec<E> other = (LinkedListRec<E>) obj;
        return equals(head, other.head);
    }
    
    public boolean equals(Node<E> node1, Node<E> node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null){
            return false; 
        }
        if (node2 == null){
            return false;
        }
        if (node1.data.equals(node2.data)){
            return equals(node1.next, node2.next);
        }
        return false;
    }

    
   
    
    private String toString (Node<E> head){
        if (head == null){
            return "";
        }else {
            return head.data + "\n" + toString(head.next);
        }
    }
    
    @Override
    public String toString(){
        return toString(head);
    }
    
    private void replace(Node<E> head, E oldObj, E newObj){
        if (head != null){
            if (oldObj.equals(head.data)){
                head.data = newObj;
            }
            replace(head.next, oldObj, newObj);
        }
    }
    
    public void replace(E oldObj, E newObj){
        replace(head, oldObj, newObj);
    }
    
    private void add(Node<E> head, E data){
        if(head.next == null){
            head.next = new Node<E>(data);
        } else {
            add(head.next, data);
        }
    }
    
    public void add (E data){
        if(head == null){
            head = new Node<E>(data);
        } else {
            add(head, data);
        }
    }
    
    private boolean remove(Node<E> head, Node<E> pred, E outData){
        if (head == null){
            return false;
        }
        else if (head.data.equals(outData)){
            pred.next = head.next;
            return true;
        } else { 
            return remove(head.next, head, outData);
        }
    }
    
    public boolean remove(E outData){
        if(head == null){
            return false;
        }
       else if (head.data.equals(outData)){
            head = head.next;
            return true;
        } else {
            return remove(head.next, head,outData);
       }
    }
    
    
    
    public ListNode reverse(ListNode list){
        if(list == null){
            return null;
        }
        if (list.next == null){
            return list;
        }
        ListNode secEle = list.next;
        list.next = null;
        
        ListNode reverseRest = reverse(secEle);
        secEle.next = list;
        return reverseRest;
    }
    
    public class ListNode{
        public String data;
        public ListNode next;
    }
    
    private boolean search(Node<E> head, LinkedListRec list, E tar){
        if (list== null){
            return false;
        }
        else if (tar.equals(head.data)){
            return true;
        } else {
            return search(head.next, list, tar);
        }
    }
    
    public boolean search(LinkedListRec list, E tar){
        return search(head, list, tar);
    }
    
    public void insertBefore(E target, E inData){
        if(head == null){
            head = new Node<E>(target, null);
            return;
        }
        if (head.data.equals(target)){
            head = new Node<E>(inData, head);
            return;
        }
        insertBefore(target, inData, head);
    }
    
    private void insertBefore(E target, E inData, Node<E> node){
        if (node.next == null){
            node.next = new Node<E>(inData, node.next);
            return;
        }
        insertBefore(target, inData, node.next);
    }
    
    public void insert(E obj, int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            head = new Node<E>(obj, head);
        }else {
            insert(obj, head, index -1);
        }
    }
    
    private void insert (E obj, Node<E> prev, int index){
        if (prev == null){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            prev.next = new Node<E>(obj, prev.next);
        } else {
            insert(obj, prev.next, index -1);
        }
    }
    
}

