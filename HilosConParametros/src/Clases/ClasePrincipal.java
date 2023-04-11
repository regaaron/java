/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aaron
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        Proceso hilo1 = new Proceso(5, "Hilo1");
        Proceso hilo2 =new Proceso(50,"Hilo2");
        Proceso hilo3 = new Proceso(10,"hilo3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
