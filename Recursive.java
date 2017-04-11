/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa4;
import java.util.Scanner;
/**
 *
 * @author bsdwork
 */
public class Recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        System.out.print(toNumber("3ac4"));
    }
    
    public static int toNumber(String str){
        if (str == null || str.length()==0){
            return 0;
        }
        char nxt = str.charAt(0);
        if (Character.isDigit(nxt)){
            return Character.digit(nxt, 10) + toNumber(str.substring(1));
        } else{
            return toNumber(str.substring(1));
        }
    }
    
}
