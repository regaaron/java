/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rebota;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

/**
 *
 * @author aaron
 */
public class Barra extends JComponent{
    public int x;
    public int y;
    public final static int ANCHO=30;
    public final static int ALTO=60;
    public int velocidad=10;
    public boolean arriba,abajo;
    Barra(int x){
        this.x=x;
        this.y=(int)(Math.random()*(600-60+1)+60);
    }
    
     public void fisica(float dt){
            // y +=velocidad*dt;
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
                            arriba = pressed; if(y>0) y-=velocidad*dt;
                            break;
                        case KeyEvent.VK_DOWN:
                            abajo = pressed; if(y+ALTO < 600) y +=velocidad*dt;
                            break;
                      
                    }
                }
            });
        
           setFocusable(true);
     }
}
