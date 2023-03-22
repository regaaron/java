/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rebota;

import java.awt.Color;

/**
 *
 * @author aaron
 */
public class Pelotas {
      final static int ANCHO =512;
    final static int ALTO = 384;
    final static int DIAMETRO= 20;
    float x,y;

    @Override
    public String toString() {
        return "Pelotas{" + "x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + ", color=" + color + '}';
    }
    float vx,vy;
    Color color ;
    Pelotas(){
        x=(int)(Math.random()*500+1);
        y=(int)(Math.random()*350+1);
        vx=(int)(Math.random()*(300-150+1)+150);
        vy=(int)(Math.random()*(400-150+1)+150);
        color= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

    }
    public void Fisica(float dt){
       
        this.x += this.vx*dt;
        y +=vy*dt;
    
        if(vx<0 && x<=0 || vx>0 && x+ DIAMETRO >=ANCHO)
           vx=-vx;
    
         if(vy<0 && y<=0 || vy>0 && y+DIAMETRO >= ALTO)
            vy=-vy;
    
    }
    
}
