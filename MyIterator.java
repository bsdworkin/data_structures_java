/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa2;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author bsdwork
 */
public class MyIterator {
    public static void main(String [] args){
        LinkedList<String> myList = new LinkedList <>();
        ListIterator<String> iter = null; 
        myList.add("Alex");
        myList.add("Bob");
        myList.add("Cindy");
        myList.add("Dave");
        myList.add("Ellen");
        
        iter = myList.listIterator();
        
        System.out.println("Traversing the list with the get() method");
        for (int i=0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
        
        System.out.println("Traversing the list with list iterator in the positive direction");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("Traversing the list with list iterator  in the negative direction");
        while(iter.hasPrevious()){
            System.out.println(iter.previous());
        }
    }
    
}
