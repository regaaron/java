/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laberinto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Laberinto extends JComponent{
    int [][] matriz = {{1,1,1,1,1,1,1,1,1,1},
                               {1,0,0,1,0,1,0,1,0,1},
                               {0,0,0,0,0,1,1,0,0,1},
                               {0,0,1,0,1,0,0,1,1,0},
                               {0,0,1,1,0,1,0,1,1,0},
                               {1,1,0,0,1,0,1,0,0,1},
                               {1,0,0,1,0,1,0,1,0,1},
                               {1,0,1,0,1,0,1,0,1,0},
                               {2,0,1,0,1,0,1,1,0,1},
                               {0,0,1,0,1,0,1,0,1,0}};

    public Laberinto() {
        setPreferredSize(new Dimension(500, 500));
    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        for(int i=0; i<matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++) {
                
                if(matriz[i][j]==1){
                    g.setColor(Color.RED);
                    g.fillRect(50*j,50*i, 50, 50);
                }
                if(matriz[i][j]==0){
                     g.setColor(Color.WHITE);
                    g.fillRect(50*j,50*i, 50, 50);
                }
                
                if(matriz[i][j]==2){
                    g.setColor(new Color(255,0,255));
                    g.fillOval(50*j, 50*i, 50, 50);
                }
            }
        }
    }
    
     public void cicloPrincipalJuego() throws Exception {
        long tiempoViego = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViego) / 1000000000f;
            tiempoViego = tiempoNuevo;
            //llamamos a fisica y despues redibujamos
           Fisica(dt){
            
          }
      
            

        }
    }
     
     public void Fisica(float df){
         
     }
    public void Mostrar(){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length;j++){
                
            }
        }
    }
    
    
    public static void main(String[] args) {
         JFrame jf = new JFrame("Laberinto");
          jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jf.setResizable(false);
        //Rebota demo1 = new Rebota();
        Laberinto laberinto1 = new Laberinto();
        jf.getContentPane().add(laberinto1);
        jf.pack();
        jf.setVisible(true);

    }
}
