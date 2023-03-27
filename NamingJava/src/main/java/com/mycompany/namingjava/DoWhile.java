/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.namingjava;

import java.util.Scanner;

/**
 *
 * @author aaron
 */
public class DoWhile {
    public static void main(String[] args) {
        int response=0;
        
        do{
            System.out.println("Seleccione en numero de la opcion deseada");
            System.out.println("1. Movie");
            System.out.println("2. Series");
            System.out.println("0. Salir");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 0: System.out.println("Gracias por visitarnos");
                break;
                case 1: System.out.println("Movies");
                break;
                case 2: System.out.println("Series");
                break;
                default: System.out.println("Seleciona una opcion correcta");
                break;
            }
        }while(response !=0); 
        
        System.out.println("Se termino el programa");
    }
}
