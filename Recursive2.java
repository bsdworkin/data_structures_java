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
public class Recursive2 {
    public static void main(String[] args) {
        int [] numArray = {1,2,3,4,5};
        int sum = sum(numArray, 0);
        System.out.print("The sum of the values stored in the array from the specified index is: " + sum);
    }
    
    
    private static int sum(int [] array, int i){
        if (i == array.length){
            return 0;
        } else{
            return array[i] + sum(array, i +1);
        }
    }
    
    
    public static int sum(int [] array){
        return sum(array, 0);
    }
}
