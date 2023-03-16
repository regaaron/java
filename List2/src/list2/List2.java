/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package list2;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author aaron
 */
public class List2 {

    /**
     * @param args the command line arguments
     */
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
        
        ListIterator<Float> iteratorF = arrayF.listIterator();
        Float f;
        while(iteratorF.hasNext()){
             f= (float)iterator.next();
            System.out.println(f.toString());
        }
        
        ArrayList<Bebida> arr = new ArrayList<Bebida>();
        arr.add(new Bebida("Coca cola",9));
        arr.add(new Bebida("Pepsi",9));
        
        ListIterator<Bebida> iterator3 = arr.listIterator();
        while(iterator3.hasNext()){
            
           // System.out.println(arr.);
        }
    }
    
}
