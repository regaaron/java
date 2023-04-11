/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class HiloEjemplo extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("Hola soy un hilo");
            Thread.sleep(4000);
            System.out.println("Adios soy un hilo");

        } catch (InterruptedException ex) {
            Logger.getLogger(HiloEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
