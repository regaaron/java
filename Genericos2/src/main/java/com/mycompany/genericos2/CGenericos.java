/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.genericos2;

/**
 *
 * @author aaron
 */
public class CGenericos  {
    
  
    
    public <Tipo, Segundo> Segundo  mostrar(Tipo tipoObjeto, Segundo tipoObj){
        System.out.println("Esta es la clase del generico: " + tipoObjeto.getClass().getName());
        return tipoObj;
        
    }
}
