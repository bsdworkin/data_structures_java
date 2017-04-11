/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa2;

import java.util.Arrays;

/**
 *
 * @author bsdwork
 */
interface MyList<E>{
    public void swap(MyArrayList1 list, int i, int j);
    public boolean add(E e);
    public void add(int index, E newItem);
}

public class MyArrayList {

    public static void main(String[] args) {
        MyArrayList1<String> myArrayList = new MyArrayList1<>();
        myArrayList.add("Alex");
        myArrayList.add("Bob");
        myArrayList.add("Cindy");
        myArrayList.add("Dave");
        myArrayList.add("Ellen");
        
        System.out.println("The original list is: " + myArrayList.toString());
        myArrayList.swap(myArrayList, 0, 2);
        System.out.println("After calling the swap: " + myArrayList.toString());
        
        System.out.println("\nThe original list is: " + myArrayList.toString());
        System.out.print("The current size is:" + myArrayList.size());
        System.out.println("\tThe current capacity is:" + myArrayList.capacity());
        myArrayList.removeAt(1);
        System.out.println("After calling remove method: " +myArrayList.toString());
        System.out.print("The current size is:" + myArrayList.size());
        System.out.print("\tThe current capacity is:" + myArrayList.capacity());
    }
}
class MyArrayList1<E> implements MyList<E>{
    public static final int INIT_CAP = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = 0;
    
    public MyArrayList1(){
        this.capacity = INIT_CAP;
        theData = (E[]) new Object[capacity];
    }
    
    @Override
    public void swap (MyArrayList1 list, int i, int j){
        if (i< 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException(i);
        
        if (size== capacity){
            reallocate();
        }
        
        Object temp = list.get(i);  
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    @Override
        public boolean add(E newItem){
        if(size == capacity){
            reallocate();
        }
        theData[size] = newItem;
        size++;
        return true;
    }
    
    
    @Override
    public void add(int index, E newItem){
        if (index< 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        
        if (size== capacity){
            reallocate();
        }
        
        for (int i =size; i > index; i--)
            theData[i] = theData[i-1];
        
        theData[index] = newItem;
        size++;
    }
    
    
    public E get(int index) {
        if (index< 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return theData[index];
    }
    
    
    public E set(int index, E newItem) {
        if (index< 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        E oldItem = theData[index];
        theData[index] = newItem;
        return oldItem;
    }
    
    
    public E removeAt (int index) {
        if (index< 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        E removedItem = theData[index];
        for (int i = index + 1; i < size; i++){
            theData[i-1] = theData[i];
        }
        size--;
        if (size <= capacity/4)
            reallocate();
        return removedItem;
    }
      
   public int size(){
        return this.size;
    }
   
   public void reallocate(){
        if(size <= capacity/ 4){
            capacity = capacity/ 2;
            theData = Arrays.copyOf(theData, capacity);
        }
        else{
            capacity = 2 * capacity;
            theData = Arrays.copyOf(theData, capacity);
        }
    }
   
    @Override
   public String toString(){
       StringBuilder sb = new StringBuilder();   
        for (int i =0; i < size; i++){
            if (i == size-1){
                sb.append( theData[i] + " ");
            }
            else sb.append(theData[i] + " ==> ");    
        }
       return sb.toString();
   }
   
   public int capacity(){
        return this.capacity;
    }
    
}   
    



