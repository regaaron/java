/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fraccion;

/**
 *
 * @author aaron
 */
public class CFraccion {
    public int numerador;
    public int denominador;
    /**
     * Constructor por defecto
     */
    CFraccion(){
        this.numerador=0;
        this.denominador=1;
    }
    
    /**
     * Constructor con numerador
     * @param numerador valor del numerador y el denominador sera 1 por  defecto
     */
    CFraccion(int numerador){
        this.numerador=numerador;
        this.denominador=1;
        
    }
    /**
     * Constructor con numerador y denominador
     * @param numerador Numerador
     * @param denominador Denominador
     */
    CFraccion(int numerador,int denominador){
        this.numerador=numerador;
        this.denominador=denominador;
    }
    /**
     * Constructor de Objeto crea una copia del objeto
     * @param obj obj  de tipo CFraccion
     */
    CFraccion(CFraccion obj){
        this.numerador=obj.numerador;
        this.denominador=obj.denominador;
    }
    
    /**
     * Muestra el contenido del objeto
     */
    public void Mostrar(){
        System.out.println(this.numerador+"/"+this.denominador);
    }
    
    /**
     * Suma un valor entero al objeto
     * @param n Entero a ser sumado al objeto
     * @return Regresa un objeto con la del objeto con el argumento enviado
     */
    public CFraccion Suma(int n){
        CFraccion obj = new CFraccion(this);
        
        obj.numerador=(n*this.denominador)+obj.numerador;
        
        return obj;
    } 
    /**
     * Suma un obj de tipo CFraccion al objeto en si
     * @param obj Objeto de tipo Fraccion a ser sumado
     * @return Regresa el objeto sumado con el Objeto recibido
     */
    public CFraccion Suma(CFraccion obj){
        CFraccion r = new CFraccion(this);
        r.denominador*=obj.denominador;
        r.numerador=(r.numerador*obj.denominador)+(obj.numerador*obj.numerador);
        
        return r;
    }
    /**
     * Suma el objeto en base a un numerador  y un denominador recibidos respectivamente
     * @param numerador numerador 
     * @param denominador denominador
     * @return Regresa un objeto que es el objeto en si mas los argumentos recibidos
     */
    public CFraccion Suma(int numerador,int denominador){
        CFraccion r = new CFraccion(this);
            r.denominador*=denominador;
            r.numerador=(r.numerador*denominador)+(numerador*r.denominador);
        return r;
    }
    
    /**
     * Resta el objeto y un numero entero
     * @param n entero a ser restado
     * @return Regresa un objeto CFraccion restado con el entero enviado
     */
    public CFraccion Resta(int n){
        CFraccion obj = new CFraccion(this);
        
        obj.numerador=(n*this.denominador)-obj.numerador;
        
        return obj;
    } 
    /**
     * Resta un obj de tipo CFraccion al objeto en si
     * @param obj Objeto de tipo Fraccion a ser sumado
     * @return Regresa el objeto Resta con el Objeto recibido
     */
    public CFraccion Resta(CFraccion obj){
        CFraccion r = new CFraccion(this);
        r.denominador*=obj.denominador;
        r.numerador=(r.numerador*obj.denominador)-(obj.numerador*obj.numerador);
        
        return r;
    }
    /**
     * Resta el objeto en base a un numerador  y un denominador recibidos respectivamente
     * @param numerador numerador 
     * @param denominador denominador
     * @return Regresa un objeto que es el objeto en si menos los argumentos recibidos
     */
    public CFraccion Resta(int numerador,int denominador){
        CFraccion r = new CFraccion(this);
            r.denominador*=denominador;
            r.numerador=(r.numerador*denominador)-(numerador*r.denominador);
        return r;
    }
    
    public CFraccion Multiplicacion(int n){
        CFraccion r = new CFraccion(this);
        this.numerador*=n;
        
        return r;
        
    }
    
    public CFraccion Multiplicacion(int numerador,int denominador){
        CFraccion r =new CFraccion(this);
        r.numerador*=numerador;
        r.denominador*=denominador;     
        return r;
        
    }
    
    public CFraccion Multiplicacion(CFraccion obj){
        CFraccion r = new CFraccion(this);
        r.denominador*=obj.denominador;
        r.numerador*=obj.denominador;
        return r;
    }
    
    
    public CFraccion Division(int n){
        CFraccion r = new CFraccion(this);
        r.denominador*=n;
        return r;
    }
    
    public CFraccion Division(int numerador,int denominador){
        CFraccion r = new CFraccion(this);
        r.numerador*=denominador;
        r.denominador*=numerador;
        
        return r;
    }
    
    public CFraccion Division(CFraccion obj){
        CFraccion r = new CFraccion(this);
        
        r.denominador*=obj.numerador;
        r.numerador*=obj.denominador;
        
        return r;
    }
    
    
}
