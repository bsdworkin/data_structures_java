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
public class ReverseStack {
   
    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        Stack <String> stack = new Stack<String>();
        String input = kb.nextLine();
        String [] str = input.split("\\s+");
        
        for (int i=0; i<str.length; i++){
            stack.push(str[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }
    
}
