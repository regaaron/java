/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberinto2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aaron
 */
public class Laberinto {
    int [][] lab=new int [10][10];
    int fila=0;
    int columna=0;
    int numColumnas=10;
    int numFilas=10;
    final int ANCHO =500;
    final int ALTO= 500;
    
    public void paint(Graphics g){
        int [][] laberinto=obtenerLaberinto();
        
        for (int filas = 0; filas <numFilas; filas++) {
            for (int columnas = 0; columnas < numColumnas; columnas++) {
                if(laberinto[filas][columnas]==1){
                    
                
                if(Laberinto2.obtieneNivel()==1)g.setColor(Color.BLACK.pink);
                if(Laberinto2.obtieneNivel()==2)g.setColor(Color.darkGray);
                if(Laberinto2.obtieneNivel()==3)g.setColor(Color.magenta);
                    
                g.fillRect(columnas*50,filas*50 ,50,50);
                g.setColor(Color.black);
                g.drawRect(columnas*50,filas*50 ,50,50);
                }
                
                if(laberinto[filas][columnas]==2){
                    g.drawLine(columnas*50, filas*50, columnas*51, filas*51);
                    g.drawLine(columnas*50, filas*51,columnas*51 , filas*50);
                }
                }
        }
        
    }
    
    public int [][] obtenerLaberinto(){

        if(Laberinto2.obtieneNivel()==1){
            int [][] laberinto ={{2,1,1,1,1,1,1,1,1,1},
                               {1,0,0,1,0,1,0,1,0,1},
                               {0,0,0,0,0,1,1,0,0,1},
                               {0,0,1,0,1,0,0,1,1,0},
                               {0,0,1,1,0,1,0,1,1,0},
                               {1,1,0,0,1,0,1,0,0,1},
                               {1,0,0,1,0,1,0,1,0,1},
                               {1,0,1,0,1,0,1,0,1,0},
                               {2,0,1,0,1,0,1,1,0,1},
                               {0,0,1,0,1,0,1,0,1,0}};
            lab=laberinto;
        }
         if(Laberinto2.obtieneNivel()==2){
           // lab=laberinto;
        }
          if(Laberinto2.obtieneNivel()==3){
            //lab=laberinto;
        }
        return lab;
    }
}


