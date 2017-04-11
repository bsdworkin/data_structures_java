/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa3;

import java.util.*;

/**
 *
 * @author bsdwork
 */
public class StackPrac {
    public static void main(String[] args) {
        Stack <Integer> stack1 = new Stack<Integer>();
        Stack <Integer> stack2 = new Stack<Integer>();
        Queue <Integer> queue = new ArrayDeque<Integer>();
        
        int [] numbers = {-1, 15, 23, 44, 4, 99};
        
        for (int i = 0; i< numbers.length; i++){
            stack1.push(numbers[i]);
        }
        
        while(!stack1.isEmpty()){
            stack2.push(stack1.peek());
            queue.add(stack1.pop());
        }
        
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop()+ "\t"+ queue.poll());
        }
    
    }
}
