/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estadistica;



import java.util.Scanner;

/**
 *
 * @author aaron
 */
public class Arreglo {
    int[] array;
    int n;
    Scanner sc=new Scanner(System.in);
    Arreglo(){
        this.n=1;
        this.array=new int[1];
    }
    
    Arreglo(int n){
        this.n=n;
        this.array=new int[n];
    }
    /**
     * Descripcion:Muestra  el vector
     */
    public void Mostrar(){
        for(int i=0;i<this.n;i++){
            System.out.println("array["+i+"]="+this.array[i]);
        }
    }
    
    /**
     * Descripcion:Metodo para llenar Manualmente el Vector y luego lo muestra
     */
    public void Manual(){
        for(int i=0;i<this.n;i++){
            System.out.println("Ingresa el elemento #"+i);
            this.array[i]=Integer.valueOf(sc.nextLine());
        }
        
        this.Mostrar();
    }
    /**
     * Descripcion: Llena el vector de forma automatica y luego lo muestra
     */
    public void Automatico(){
        for(int i=0;i<this.n;i++){
            this.array[i]= (int)(Math. random()*10+1); 
        }
        this.Mostrar();
    }
    /**
     * Descripcion:Obtener la media se suman todos los elementos y se divide por el numero de elementos
     * @return Regresa la media en flotante
     */
    public float Media(){
        float media=0;
        for(int i=0;i<this.n;i++){
            media+=this.array[i];
        }
        media/=this.n;
        return  media;
    }
    /**
     * Descripcion:Ordena primero el array y luego obtiene el valor de en medio del arreglo ordenado
     * @return Regresa el valor en la posicion de en medio del arreglo ordenado
     */
    public int Mediana(){
        int[] ordenado =new int[this.n];
        int mediana=1;
        ordenado=this.array;
        int aux=0;
        for(int i=0;i<this.n-1;i++){
            for(int j=0;j<this.n-1;j++){
                if(ordenado[j]>ordenado[j+1]){
                   aux=ordenado[j];
                   ordenado[j]=ordenado[j+1];
                   ordenado[j+1]=aux;
                }
            
            }
        }
        mediana=ordenado[this.n/2];
        return mediana;
        
    }
    
    public int Moda(){
        int Maxrepeticiones=0;
        int moda=0;
        for(int i=0;i<this.n;i++){
            int repeticiones=0;
            for(int j=0;j<this.n;j++){
                if(this.array[i]==this.array[j]){
                    repeticiones++;
                }
                
                if(Maxrepeticiones<repeticiones){
                    moda=this.array[i];
                    Maxrepeticiones=repeticiones;
                }
                
            }
        }
        return moda;  
    }
    
    public float Desviacion(){
        float desviacion=0;
        float desviacionaux=0;
        for(int i=0;i<this.n;i++){
            desviacionaux=(this.array[i]-this.Media());
            desviacion+=desviacionaux;
            System.out.println("Desviacion[i]:"+desviacion);
        }
        //pow(desviacion,2);
        Math.pow(desviacion, 2);
        System.out.println("desviacion despues de pow: "+desviacion);
        Math.sqrt(desviacion);
        return desviacion;
    }
          
}
