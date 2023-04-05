/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprite;

/**
 *
 * @author aaron
 */
public class Posicion {
    public int x;
    public  int y;
    
    Posicion(){
        
    }
    
        public Posicion(int x,int y){
            Set(x,y);
        }
        
        public Posicion(Posicion p){
            Set(p);
        }
        
        public void Set(int _x,int _y){
            x = _x;
            y = _y;
        }
        
        public void Set(Posicion p){
            if(p != null){
                x = p.x;
                y = p.y;
            }else{
                x = 0;
                y = 0;
            }
        }
        
          @Override
        public String toString(){
            return getClass().getSimpleName() + "(" + x + "," + y + ")";
        }
}
