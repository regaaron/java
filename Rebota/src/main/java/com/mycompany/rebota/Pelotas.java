/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rebota;

import java.awt.Color;
/***
 * 
 * @author aaron
 */
public class Pelotas {

    final static int ANCHO = 1000; //ancho de la pantalla
    final static int ALTO = 600; //altura de la pantalla
    final static int DIAMETRO = 20; //diametro de la pelota
    float x, y; //posicion de la pelota
    float vx, vy; //velocidad de la pelota y direccion
    //contador de puntos
    static int c1; 
    static int c2;
    Color color;
    /***
    * Constructor de las pelotas posicion en x a la mitad de la pantalla 
    * Posicion en y aletoria 
    * Velocidades y color aletorio
    */
    Pelotas() {
        x = ANCHO / 2;//Colocamos la pantalla justo a la mitad
        //damos un valor aleatorio para y y sus velocidades y color
        y = (int) (Math.random() * 350 + 1);
        vx = (int) (Math.random() * (300 - 150 + 1) + 150);
        vy = (int) (Math.random() * (400 - 150 + 1) + 150);
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        c1 = c2 = 0;

    }

   
    //Fisica del comportamiento de las pelotas
    /***
     * Fisica Para el movimiento de las pelotas en base un tiempo y que rebote entre las barras y la pantalla
     * @param dt tiempo trascurrido para el movimiento de la pelota 
     * @param p vector de pelotas
     * @param b1 Barra derecha
     * @param b2 Barra Izquierda
     */
    public void Fisica(float dt, Pelotas[] p, Barra b1, Barra b2) {
        

        //movimiento de las pelotas
            x += vx * dt;
            y += vy * dt;

            
            //reajuste de la pelota al chocar con izquierda 
        if (vx < 0 && x <= 0) {
            x = ANCHO / 2;//(int)(Math.random()*500+1);
            y = (int) (Math.random() * ALTO + 1);
            vx = -vx;
            c1++;
            System.out.println("c1=" + c1);
        }

        
            //reajuste al chocar con derecha
        if (vx > 0 && x + DIAMETRO >= ANCHO) {
            x = ANCHO / 2;//(int)(Math.random()*500+1);
            y = (int) (Math.random() * ALTO + 1);
            vx = -vx;
            c2++;
            System.out.println("c2=" + c2);

        }

           //Rebote con la barra derecha
        if (x + DIAMETRO > b1.x && x + DIAMETRO < b1.x + b1.ANCHO && y + DIAMETRO > b1.y && y < b1.y + b1.ALTO) {
            vx = -vx;
            vy = -vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }

         //Rebote con la barra 
        if (x > b2.x && x < b2.x + b2.ANCHO && y > b2.y && y < b2.y + b2.ALTO) {
            vx = -vx;
            vy = -vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }
        //Rebote con limite superior o inferior 
        if (vy < 0 && y <= 0 || vy > 0 && y + DIAMETRO >= ALTO) {
            vy = -vy;
        }
        
        //Rebote entre pelotas
        for (int i = 0; i < p.length; i++) {

            if (this != p[i]) {
                //Calculamos distancia para saber si chocan
                float dx = x - p[i].x;
                float dy = y - p[i].y;
                float distance = (float) Math.sqrt(dx * dx + dy * dy);
                //si la distancia es menor al diametro chocan
                if (distance <= DIAMETRO) {
                    //si chocan cambian de direccion o color
                   vx=-vx;
                   vy=-vy;
                   p[i].vx=-vx;
                   p[i].vy=-vy;
                    color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
                    p[i].color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

                }
            }
        }
    }

}
