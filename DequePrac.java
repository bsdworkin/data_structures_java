/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa3;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author bsdwork
 */
public class DequePrac {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("[+-]?(\\d+(\\.\\d*)?([eE][+-]?\\d+)?)|" + "(\\.\\d+([eE][+-]?\\d+)?)"); 
        Deque<String> deque = new ArrayDeque(); 
        int numNumeric = 0; 
        int numOther = 0; 
        Scanner kb = new Scanner(System.in); 
        String str;
        while (kb.hasNext()){ 
            str = kb.next(); 
            if(str.equals("exit")){
                break;
            }
            Matcher m = pat.matcher(str); 
            if (m.matches()) { 
                deque.addLast(str); 
                numNumeric++; 
                
            } 
            else {
                deque.addFirst(str); 
                numOther++;    
            } 
            
        }
        System.out.println(numOther);
        System.out.println(numNumeric);
    }
    
}
