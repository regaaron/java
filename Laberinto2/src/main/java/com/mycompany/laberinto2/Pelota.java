/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberinto2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author aaron
 */
public class Pelota {

    Laberinto lab = new Laberinto();
    int x = 50;
    int y = 50;
    final int ANCHO = 50;
    final int ALTO = 50;
    final int MOVIMIENTO = 50;

    Pelota() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, ANCHO, ALTO);
        g.setColor(Color.black);
        g.drawOval(x, y, ANCHO, ALTO);

        g.setColor(Color.white);
        g.fillOval(x + 7, y + 8, 13, 13);
        g.fillOval(x + 21, y + 8, 13, 13);
        g.setColor(Color.black);
        g.fillOval(x + 11, y + 12, 5, 5);
        g.fillOval(x + 25, y + 12, 5, 5);

        g.setColor(Color.black);
        g.fillOval(x + 7, y + 24, 24, 7);

    }

    public void teclaPrecionada(KeyEvent e) {
        int[][] laberinto = lab.obtenerLaberinto();

        if (e. getKeyCode()==37) {//izq
                        System.out.println("izq");

            if(laberinto[y/50][(x/50)-1]!=1){
                x-=MOVIMIENTO;
            }
        }
        if (e. getKeyCode()==39) {//der
                        System.out.println("der");

            if(laberinto[y/50][(x/50+1)]!=1){
                x+=MOVIMIENTO;
            }
        }
        if (e. getKeyCode()==40) {//abajo
            System.out.println("abajo");
            if(laberinto[(y/50)+1][x/50]!=1){
                y+=MOVIMIENTO;
            }
        }
        if (e.getKeyCode()==38) {//arriba
                        System.out.println("arriba");

            if(laberinto[(y/50)-1][x/50]!=1){
                y-=MOVIMIENTO;
            }
        }
        
        if(laberinto[x][y]==2){
            Laberinto2.CabiaLevel();
            x=50;
            y=50;
        }
    }

}
