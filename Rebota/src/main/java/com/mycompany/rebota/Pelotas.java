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
      final static int ANCHO =1000;
    final static int ALTO = 600;
    final static int DIAMETRO= 20;
    float x,y;
    float vx,vy;
    int c1;
    int c2;
    Color color ;
    Pelotas(){
        x=ANCHO/2;//(int)(Math.random()*500+1);
        y=(int)(Math.random()*350+1);
        vx=(int)(Math.random()*(300-150+1)+150);
        vy=(int)(Math.random()*(400-150+1)+150);
        color= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
        c1=c2=0;

    }
    private float[] rotate(float vx, float vy, float sin, float cos) {
    float[] result = new float[2];
    result[0] = cos * vx - sin * vy;
    result[1] = sin * vx + cos * vy;
    return result;
}

private float[] elasticCollision(float[] v1, float[] v2) {
    float[] result = new float[4];
    result[0] = v2[0];
    result[1] = v1[1];
    result[2] = v1[0];
    result[3] = v2[1];
    return result;
}
    
    public void Fisica(float dt, Pelotas []p,Barra b1,Barra b2){
        
        this.x += this.vx*dt;
          y +=vy*dt;
    
        if(vx<0 && x<=0 ){
            x=ANCHO/2;//(int)(Math.random()*500+1);
            y=(int)(Math.random()*ALTO+1);
            vx=-vx;
            c1++;
            System.out.println("c1="+c1);
        }
           
        
        if(vx>0 && x+ DIAMETRO >=ANCHO){
             x=ANCHO/2;//(int)(Math.random()*500+1);
            y=(int)(Math.random()*ALTO+1);
            vx=-vx;
            c2++;
            System.out.println("c2="+c2);

        }
        
        
        if(x+DIAMETRO>b1.x&&x+DIAMETRO<b1.x+b1.ANCHO && y+DIAMETRO>b1.y&&y<b1.y+b1.ALTO){
            vx=-vx;
            vy=-vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }
        
         if(x>b2.x&&x<b2.x+b2.ANCHO && y>b2.y&&y<b2.y+b2.ALTO){
            vx=-vx;
            vy=-vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }
            
        
        
         if(vy<0 && y<=0 || vy>0 && y+DIAMETRO >= ALTO)
            vy=-vy;
          for (int i = 0; i < p.length; i++) {
              
        if (this != p[i]) {
            float dx = x - p[i].x;
            float dy = y - p[i].y;
            float distance = (float) Math.sqrt(dx * dx + dy * dy);
            
            if (distance <=DIAMETRO) {
                
                vx=-vx;
                vy=-vy;
                p[i].vx=-vx;
                p[i].vy=-vy;
                color= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
                p[i].color= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

                 /*
                // Las pelotas chocan, cambiamos su dirección
                float angle = (float) Math.atan2(dy, dx);
                float sin = (float) Math.sin(angle);
                float cos = (float) Math.cos(angle);
                
                // Rotamos la velocidad de ambas pelotas
                float[] v1 = rotate(vx, vy, sin, cos);
                float[] v2 = rotate(p[i].vx, p[i].vy, sin, cos);
                
                // Calculamos las nuevas velocidades
                float[] finalVelocities = elasticCollision(v1, v2);
                
                // Rotamos las velocidades de vuelta
                float[] v1F = rotate(finalVelocities[0], finalVelocities[1], cos, -sin);
                float[] v2F = rotate(finalVelocities[2], finalVelocities[3], cos, -sin);
                
                // Asignamos las nuevas velocidades a las pelotas
                vx = v1F[0];
                vy = v1F[1];
                p[i].vx = v2F[0];
                p[i].vy = v2F[1];
                */
            }
        }
    }
    }
    
}
