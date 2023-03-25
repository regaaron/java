/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.random;

/**
 *
 * @author aaron
 */
public class Random {

    public static void main(String[] args) {
        for(int i =0; i<10; i++){
             System.out.println((int)(Math.random()*(350-25+1)+25));
                                        //   (int)(Math.random()*(75-25+1)+25);
        }
       
    }
}
