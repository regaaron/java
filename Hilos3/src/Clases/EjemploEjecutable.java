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
public class EjemploEjecutable implements Runnable {

    @Override
    public void run() {

        try {
            System.out.println("Hola  Soy un ejecutable");

            Thread.sleep(3000);
            System.out.println("Adios un ejecutable");

        } catch (InterruptedException ex) {
            Logger.getLogger(HiloEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
