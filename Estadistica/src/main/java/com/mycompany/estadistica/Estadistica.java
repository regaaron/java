/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estadistica;

/**
 *
 * @author aaron
 */
public class Estadistica {

    public static void main(String[] args) {
        Arreglo obj = new Arreglo(10);
        obj.Manual();
       // obj.Automatico();
        System.out.println("Media:"+obj.Media());
        System.out.println("Mediana:"+obj.Mediana());
        System.out.println("Moda:"+obj.Moda());
        System.out.println("Desviacion:"+obj.Desviacion());
    }
}
