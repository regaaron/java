/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author aaron
 */
public class Proceso extends Thread{
int num_int;

    Proceso(int num_int,String NombreHilo){
        super(NombreHilo);
        this.num_int= num_int;
        
    }
    
    Proceso(){
        this.num_int =5;
      
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i <=num_int; i++) {
            System.out.println(getName()+": "+i);
        }
        System.out.println();
    }
    
    
}
