/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class Hilos4 extends Thread{

        Hilos4(String nombre){
            super(nombre);
            start();
        }
        
        @Override
        public void run (){
           
                System.out.println("Ejecutando hilo"+Thread.currentThread().getName());
                 try {
                
                System.out.println("Hola");
                sleep(1000);
                System.out.println("Desde");
                sleep(1000);
                System.out.println("Java");
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos4.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
                Thread thread1 = Thread.currentThread();
                System.out.println("El Hilo principal se llama: "+thread1.getName());
                
                thread1.setName("hilo Principal");
                System.out.println("El hilo principal se llama: "+thread1.getName());
                 
                try {
                System.out.println("Hola");
                sleep(1000);
                System.out.println("Desde");
                sleep(1000);
                System.out.println("Java");
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos4.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             Hilos4 th = new Hilos4("Custom");
             
             SecondThread th2 = new SecondThread("Seegundo");
             SecondThread th3 = new SecondThread("Seegundo");
             SecondThread th4 = new SecondThread("Seegundo");
             
             try {
                 for (int i = 0; i < 10; i++) {
                   
                        System.out.println("Ejecutando hilo: " + Thread.currentThread().getName());
                        
                        Thread.sleep(1000);
                 }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilos4.class.getName()).log(Level.SEVERE, null, ex);
                    }
             }
        
    }
    
