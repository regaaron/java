/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.namingjava;

/**
 *
 * @author aaron
 */
public class Arrays {
    public static void main(String[] args) {
        String[] androidVersions = new String[17];
        String days[] = new String [7];
        
        String [][] cityes = new String [4][2];
        
        int [][][] numbers = new int [2][2][2];
        int [][][][] numbers4 = new int [2][2][2][2];
        
        androidVersions[0]="Apple Pie";
        androidVersions[1]="Banana bread";
        androidVersions[2]="Cupcake";
        androidVersions[3]="Donut";
        
        for (int i = 0; i < androidVersions.length; i++) {
            System.out.println(androidVersions[i]);
        }
        System.out.println("---------------");
        for(String androiVersion: androidVersions){
            System.out.println(androiVersion);
        }
        
        System.out.println();
        System.out.println();
        
        cityes[0][0]="Colombia";
        cityes[0][1]="Medellin";
        cityes[1][0]="Colombia";
        cityes[1][1]="Bogota";
        cityes[2][0]="Mexico";
        cityes[2][1]="Guadalajara";
        cityes[3][0]="Mexico";
        cityes[3][1]="CDMX";
        
        for (int i = 0; i <cityes.length; i++) {
            for (int j = 0; j < cityes[i].length; j++) {
                System.out.println(cityes[i][j]);
            }
        }
        
        for(String[] pair:cityes){
            for(String name: pair){
                System.out.println(name);
                int m;
            }
        }
        
        
       

        String [][][][] animals = new String [2][3][2][2];
        animals[1][0][0][1]="Monkey";
        System.out.println();
        System.out.println();
        System.out.println(animals[1][0][0][1]);


    }
}
