/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rebota;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class Rebota extends JComponent{
private final static int ANCHO =1000;
private final static int ALTO = 600;
private final static int DIAMETRO= 20;
private final static int BALTO=70;
private final static int BANCHO=30;
private int xbarra=ANCHO-BANCHO;
private int ybarra=ALTO-BALTO;
private boolean arriba,abajo,izquierda,derecha;
Pelotas [] p = new Pelotas[10]; 

public void cicloPrincipalJuego() throws Exception{
    long tiempoViego = System.nanoTime();
    while(true){
        long tiempoNuevo = System.nanoTime();
        float dt = (tiempoNuevo - tiempoViego)/1000000000f;
        tiempoViego=tiempoNuevo;
        for(int i=0; i<p.length;i++){
            p[i].Fisica(dt,p,ybarra,xbarra);
            
        }
        dibuja();
        
    }
}

public void paint(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect(0, 0,ANCHO,ALTO);
   /* g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
   g.setColor(Color.RED); 
   g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
    g.setColor(Color.BLACK);
    g.drawString("hola",(int) x+20,(int) y +20);
    */
    for(int i=0; i<p.length;i++){
        g.setColor(p[i].color);
        g.fillOval(Math.round(p[i].x), Math.round(p[i].y), DIAMETRO, DIAMETRO);
        //System.out.println("x="+xbarra+"y="+ybarra);
        g.setColor(Color.BLACK);
        g.fillRect(xbarra,ybarra,BANCHO, BALTO);
    }
 
}
public Rebota(){
    setPreferredSize(new Dimension(ANCHO,ALTO));
    for(int i=0; i<p.length; i++ ){
        p[i]=new Pelotas();
        //p[i].toString();
    }
    addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    actualiza(e.getKeyCode(), true);
                }
                public void keyReleased(KeyEvent e) {
                    actualiza(e.getKeyCode(), false);
                }
                private void actualiza(int keyCode,
                        boolean pressed) {
                    switch (keyCode) {
                        case KeyEvent.VK_UP:
                            arriba = pressed; if(ybarra>0) ybarra-=10;
                            break;
                        case KeyEvent.VK_DOWN:
                            abajo = pressed; if(ybarra+BALTO < ALTO) ybarra +=10;
                            break;
                        case KeyEvent.VK_LEFT:
                            izquierda = pressed;
                            break;
                        case KeyEvent.VK_RIGHT:
                            derecha = pressed;
                            break;
                    }
                }
            });
        
        setFocusable(true);
}
/*
public void fisica(float dt){
    for(int i=0; i<p.length;i++){
        p[i].x += p[i].vx*dt;
        p[i].y += p[i].vy*dt;
    
        if(p[i].vx<0 && p[i].x<=0 || p[i].vx>0 && p[i].x+ DIAMETRO >=ANCHO)
            p[i].vx=-p[i].vx;
    
         if(p[i].vy<0 && p[i].y<=0 || p[i].vy>0 && p[i].y+DIAMETRO >= ALTO)
            p[i].vy=-p[i].vy;
    }


    
    
}
*/
public void dibuja() throws Exception{
    SwingUtilities.invokeAndWait(new Runnable(){
        public void run(){
            paintImmediately(0,0,ANCHO,ALTO);
        }
    });
}
    public static void main(String[] args) throws Exception{
        JFrame jf = new JFrame("Juego");
        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        jf.setResizable(false);
        Rebota demo1 = new Rebota();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
}
