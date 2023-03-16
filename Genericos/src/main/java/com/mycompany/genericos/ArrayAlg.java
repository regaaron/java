/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.genericos;

/**
 *
 * @author aaron
 */
public class ArrayAlg {
    /*
        //obtener el mayor y el menor haciendo comparaciones y regresar el mayor o menor del String
    public static Pair <String> minmax (String [] a){
        if (a==null || a.length == 0){
            return null;
        }
        
        String min = a[0];
        String max = a[0];
        for(int i=1; i<a.length; i++){
            if(min.compareTo(a[i]) > 0){
                min=a[i];
            }
            if(max.compareTo(a[i]) < 0){
                max=a[i];
            }
        }
        //regresamos como un objeto T
        return new Pair<String>(min,max);
    }
    //se creo static para no crear un objeto
    //regresa un objeto T, recibe un vector 
    public static <T> T getMiddle (T[] a){
        return (a[a.length/2]);
    }
    //regresa el elemtno que esta a la mitad del vector
    */
    
    public static <T extends Comparable> Pair<T> minmax(T[] a)
                {
                    if(a == null || a.length==0) return null;
                    T min=a[0];
                    T max = a[0];
                    
                    for (int i = 1; i < a.length; i++) {
                        if(min.compareTo(a[i])>0) min = a[i];
                        if(max.compareTo(a[i])<0) max = a[i];
                    }
                    
                    return new Pair<T>(min,max);
                }                  
  
}
