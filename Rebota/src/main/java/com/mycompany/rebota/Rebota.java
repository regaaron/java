/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rebota;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class Rebota extends JComponent{
private final static int ANCHO =512;
private final static int ALTO = 384;
private final static int DIAMETRO= 20;
private float x,y;
private float vx,vy;

public void cicloPrincipalJuego() throws Exception{
    long tiempoViego = System.nanoTime();
    while(true){
        long tiempoNuevo = System.nanoTime();
        float dt = (tiempoNuevo - tiempoViego)/1000000000f;
        tiempoViego=tiempoNuevo;
        fisica(dt);
        dibuja();
    }
}

public void paint(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect(0, 0,ANCHO,ALTO);
   // g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
   g.setColor(Color.RED); 
   g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
    g.setColor(Color.BLACK);
    g.drawString("hola",(int) x+20,(int) y +20);

}
public Rebota(){
    setPreferredSize(new Dimension(ANCHO,ALTO));
    x=10;
    y=20;
    vx=300;
    vy=400;
}
public void fisica(float dt){
    x += vx*dt;
    y += vy*dt;
    
    if(vx<0 && x<=0 || vx>0 && x+ DIAMETRO >=ANCHO)
        vx=-vx;
    
    if(vy<0 && y<=0 || vy>0 && y+DIAMETRO >= ALTO)
        vy=-vy;
}

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
