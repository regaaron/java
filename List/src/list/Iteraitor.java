/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list;

import java.util.ArrayList;
import java.util.ListIterator;



/**
 *
 * @author aaron
 */
public class Iteraitor {
    
    public class Bebida{
        int precio;
        String nombre;
        Bebida(String nom,int p){
            this.precio=p;
            this.nombre=nom;
        }
        
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayI = new ArrayList<Integer>();
        arrayI.add(1);
        arrayI.add(2);
                arrayI.add(3);
                
        ArrayList<Float> arrayF = new ArrayList<Float>();
        arrayF.add(1.1f);
        arrayF.add(2.2f);
        arrayF.add(3.3f);
        
        Integer i;
        
        ListIterator<Integer> iterator = arrayI.listIterator();
        while(iterator.hasNext()){
            i = iterator.next();
            System.out.println(i.toString());
        }
        
        ArrayList<Bebida> arr = new ArrayList<Bebida>();
        arr.add(new Bebida("Coca cola",9));
        arr.add(new Bebida("Pepsi",9));


    }
    
    
}
