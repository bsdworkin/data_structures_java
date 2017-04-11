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
public class RecursiveLinearSearch {
    public static void main(String[] args) {
       Integer[] nums = {1,2,3,4,5,2,6,7,1};
       int result = linearSearch(nums, 4);
       System.out.println(result);
    }
    
    /**
     *
     * @param stuff
     * @param tar
     * @param pos
     * @return
     */
    public static int linearSearch(Object[] stuff, Object tar, int pos){
 
        if(pos == -1){
            return -1;
        }
        else if (tar.equals(stuff[pos])){
            return pos;
        } else{
            return linearSearch (stuff, tar, pos - 1);
        } 
    }
    
    public static int linearSearch(Object[] stuff, Object tar){
        return linearSearch(stuff, tar, stuff.length -1);
    }
}
