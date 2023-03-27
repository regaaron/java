/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cstring;

/**
 *
 * @author aaron
 */
public class CString1 {
       public String frase;
         CString1(){
           this.frase=null;
       }
        CString1(String frase){
           this.frase=frase;
       }
       /**
        *Descripcion:Rescribe la  frase del objeto
        * @param frase Nueva frase a rescribir
        */
       public void Cadena(String frase){
           this.frase=frase;
       }
       /**
        *Descripcion:Imprime el caracter dada una posicion. 
        * @param posicion Posicion del caracter a imprimir
        * @return caracter de la frase en base a la posicion
        */
       public char caracter(int posicion){
           return this.frase.charAt(posicion);
       }
       /**
        * Descripcion:Muestra el contenido del objeto
        */
       public void Mostrar(){
           System.out.println(this.frase);
       }
       
       /**
        * Descripcion:Imprime la subcadena
        * @param inicio Inicio de la  subcadena
        * @param fin Final de la  subcadena
        * @return Regresa la subcadena en String
        */
       public String SubCadena(int inicio,int fin){
        String subCadena="";
        if(inicio<=fin){
            for(int i=inicio;i<=fin;i++){
            subCadena+=this.frase.charAt(i);
            }
        }else{
            System.out.println("El inicio es mas  grande que el  final "+inicio+":"+fin);
        }
        
            return subCadena;
    }
    
    /**
     * Descripcion:Regresa la frase en mayusculas
     * @return Regresa la frase en mayusculas
     */
    public String ToMayus(){
        String Mayus;
        Mayus=this.frase.toUpperCase();
        return Mayus;
    }
    /**
     * Descripcion:Invierte la cadena
     * @return Regresa la cadena invertida en un string
     */
    public String Invierte(){
        String Invertida="";
        
        for(int i=this.frase.length()-1;i>=0;i--){
            Invertida+=this.frase.charAt(i);
        }
        return Invertida;
    }
}
