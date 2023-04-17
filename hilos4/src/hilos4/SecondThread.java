/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class SecondThread implements Runnable{
        Thread thread;
        String nombre;

    public SecondThread(String nombre) {
        this.nombre= nombre;
        thread = new Thread(this.nombre);
        System.out.println("Iniciando hilos: "+ nombre);
        thread.start();
    }
    
        
        
    @Override
    public void run() {
         try {
             for (int i = 0; i < 10; i++) {
            System.out.println("Ejecutando hilo: " + Thread.currentThread().getName());
          
                Thread.sleep(1000);
             }
            } catch (InterruptedException ex) {
                Logger.getLogger(SecondThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

