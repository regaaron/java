/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author aaron
 */
public class ClasePrincipal {
    
    
    public static void main(String[] args) {
        Proceso1 hilo1 = new Proceso1();
        Proceso1 hilo3 = new Proceso1();
        Thread hilo2 = new Thread(new Proceso2());
       
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
