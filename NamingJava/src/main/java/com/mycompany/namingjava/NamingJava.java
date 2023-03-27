/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.namingjava;

/**
 *
 * @author aaron
 *///upper camel class
public class NamingJava {

   
    /**
     * Descripcion:Convierte a dolares
     * @param monto Cantidad de dinero
     * @param  moneda String tipo de moneda solo acepta MXM o COP
     * 
     * @return devuelve la cantidad en dolares 
     */
    public static double dollar(double monto, String moneda){
        
        switch(moneda){
            case "MXM":
                monto*=18.88;
            break;
            case "COP":
                monto*=4751.62 ;
            break;
            default: System.out.println("Valor no valido.");
        }
        
        return monto;
    }
    
    public static void main(String[] args) {
        String moneda;
        System.out.println(dollar(10,"MXM"));
        
    }
}
