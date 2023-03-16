/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.genericos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author aaron
 */
public class Genericos {

    public static void main(String[] args) {
        // TODO code application logic here
        //creando un objeto y utilizando la clase T y el tipo de dato generico le decimos que es un entero
        //y convertir todo lo que tenia T con el tipo de dato a trabajar
        
       //llamar al constructor y le enviamos los parametros 
       //Pair<String> mm = new Pair<String> ("uno","dos");
       // Pair<Integer> mm = new Pair<Integer> (15,20);
        //Pair<Float> mm = new Pair<Float> (15.4f,20.3f);
        /*
        String[] words={"mary","algo","a","pequeño","lampara","z"};
        Integer[] num={1,1,2,3,4,};
        Pair <String> mm =ArrayAlg.minmax(words);
        //mostramos el valor ,ayor o menor
        System.out.println("min = " +mm.getFirst());
        System.out.println("max = " +mm.getSecond());
        
        //para el metodo generico
        String middle =ArrayAlg.<String>getMiddle(words);
        System.out.println("middle: "+middle);
        
        Integer enmedio =ArrayAlg.<Integer>getMiddle(num);
        System.out.println("middle: "+enmedio);
*/
        Integer [] entero={1,67,34,77};
        Pair<Integer> mm = ArrayAlg.minmax(entero);
        System.out.println("min =" + mm.getFirst());
        System.out.println("max ="+mm.getSecond());
        
        GregorianCalendar[] birhdays=
        {
            new GregorianCalendar(1906,Calendar.DECEMBER,9),
            new GregorianCalendar(1815, Calendar.DECEMBER, 10),
            new GregorianCalendar(1903,Calendar.DECEMBER,3),
            new GregorianCalendar(1910, Calendar.JUNE, 22),
            
        };
        
        Pair<GregorianCalendar> mm2 = ArrayAlg.minmax(birhdays);
        System.out.println("min = "+ mm2.getFirst().getTime());
        System.out.println("max = "+ mm2.getSecond().getTime());

                
    }
    
}
