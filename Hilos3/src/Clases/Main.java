/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aaron
 */
public class Main {
    public static void main(String[] args) {
        HiloEjemplo hilo1 = new HiloEjemplo();
        Thread thread = new Thread(new EjemploEjecutable());
        
        hilo1.start();
        thread.start();
    }
}
