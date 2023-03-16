/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author aaron
 */
public class GVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>();
        v.add("Puerta");
        v.add("Ventana");
        v.add("Silla");
        v.add("Mesa");
        
        imprimeV(v);
        
        if(v.contains("Silla")){
            System.out.println("Contiene silla");
        }
        
        List vl = v.subList(0, 2);
        imprimeL(vl);
        Stack<String> pila = new Stack<String>();
        pila.push(v.firstElement());
        System.out.println(pila.peek());
        pila.push(v.lastElement());
        System.out.println(pila.peek());
        System.out.println( pila.toString());
    }
    
    public static void imprimeL(List<String> vl){
        String txt;
        Iterator<String> iterator=vl.iterator();
        while(iterator.hasNext()){
            txt= iterator.next();
            System.out.println(txt.toString());
        }
        System.out.println("............");
    }
    
    public static void imprimeV(Vector<String> v){
        String txt;
        Enumeration<String> en=v.elements();
        while(en.hasMoreElements()){
            txt=en.nextElement();
            System.out.println(txt.toString());
        }
        System.out.println("............");
    }
    
}
