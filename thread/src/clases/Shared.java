/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class Shared {
        void doWork(String string){
            System.out.println("Iniciando: "+string);
            try {
                Thread.sleep((long)(Math.random()*5000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Shared.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Terminado. "+string);
        }
}
