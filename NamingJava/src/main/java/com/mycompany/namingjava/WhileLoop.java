/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.namingjava;

/**
 *
 * @author aaron
 */
public class WhileLoop {
    static boolean isTurnOnLigth= false;
    public static void main(String[] args) {
        turnOnOffLigth();
        int i=1;
        while(isTurnOnLigth && i<=10){
            printSos();
        }
    }
    
    public static void printSos(){
        System.out.println(". . . _ _ _ . . .");
    }
    
    public static boolean turnOnOffLigth(){
       return isTurnOnLigth=(isTurnOnLigth) ? false : true; 
    }
}
