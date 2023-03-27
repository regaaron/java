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

    final static int ANCHO = 1000;
    final static int ALTO = 600;
    final static int DIAMETRO = 20;
    float x, y;
    float vx, vy;
    static int c1;
    static int c2;
    Color color;

    Pelotas() {
        x = ANCHO / 2;//(int)(Math.random()*500+1);
        y = (int) (Math.random() * 350 + 1);
        vx = (int) (Math.random() * (300 - 150 + 1) + 150);
        vy = (int) (Math.random() * (400 - 150 + 1) + 150);
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        c1 = c2 = 0;

    }

   

    public void Fisica(float dt, Pelotas[] p, Barra b1, Barra b2) {

        this.x += this.vx * dt;
        y += vy * dt;

        if (vx < 0 && x <= 0) {
            x = ANCHO / 2;//(int)(Math.random()*500+1);
            y = (int) (Math.random() * ALTO + 1);
            vx = -vx;
            c1++;
            System.out.println("c1=" + c1);
        }

        if (vx > 0 && x + DIAMETRO >= ANCHO) {
            x = ANCHO / 2;//(int)(Math.random()*500+1);
            y = (int) (Math.random() * ALTO + 1);
            vx = -vx;
            c2++;
            System.out.println("c2=" + c2);

        }

        if (x + DIAMETRO > b1.x && x + DIAMETRO < b1.x + b1.ANCHO && y + DIAMETRO > b1.y && y < b1.y + b1.ALTO) {
            vx = -vx;
            vy = -vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }

        if (x > b2.x && x < b2.x + b2.ANCHO && y > b2.y && y < b2.y + b2.ALTO) {
            vx = -vx;
            vy = -vy;
            //System.out.println(x+", "+y+","+xbarra+","+ybarra);
        }

        if (vy < 0 && y <= 0 || vy > 0 && y + DIAMETRO >= ALTO) {
            vy = -vy;
        }
        for (int i = 0; i < p.length; i++) {

            if (this != p[i]) {
                float dx = x - p[i].x;
                float dy = y - p[i].y;
                float distance = (float) Math.sqrt(dx * dx + dy * dy);

                if (distance <= DIAMETRO) {
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
