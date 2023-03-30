/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;


public class lab extends JComponent{
    
    private int pixeles = 25;
    private final static int DIAMETRO = 25;
    private float x, y;
    private float vx, vy;
    Timer timer;
    
    int [][] matriz = {
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1},
            {1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,1,1,0,0,1,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1},
            {1,0,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
    
    private final  int ANCHO = 500;
    private final  int ALTO = 500;
    
    private boolean arriba, abajo, izquierda, derecha;
    
    public lab(){
        setPreferredSize(new Dimension(ALTO, ANCHO));
        
        addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    actualiza(e.getKeyCode(), true);
                }
                public void keyReleased(KeyEvent e) {
                    actualiza(e.getKeyCode(), false);
                }
                private void actualiza(int keyCode,boolean pressed) {
                    switch (keyCode){
                        case KeyEvent.VK_UP:
                            arriba = pressed;
                            break;
                        case KeyEvent.VK_DOWN:
                            abajo = pressed;
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
    
    private float satura(float valor, float min, float max) {
        if (valor > max)
            return max;
        if (valor < min)
            return min;
        return valor;
    }
    
    private void fisica(float dt) {
        vx = 0;
        vy = 0;
        if (arriba)   vy = -300;
        if (abajo)    vy = 300;
        if (izquierda) vx = -300;
        if (derecha)   vx = 300;
        x = satura(x + vx * dt, 0, ANCHO - DIAMETRO);
        y = satura(y + vy * dt, 0, ALTO - DIAMETRO);
    }
    
    public void paint(Graphics g) {
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<20; j++){
                if(matriz[i][j] == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*pixeles, i*pixeles, pixeles, pixeles);
                }
            }
        }
        
        g.setColor(Color.RED);
        g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
        
    }
    
    private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO, ALTO);
                }
            });
    }
    
    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            fisica(dt);
            dibuja();
        }
    }

    public static void main(String[] args)throws Exception {
        JFrame jf = new JFrame("Laberinto");
        jf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        
        jf.setResizable(false);
        lab demo2 = new lab();
        jf.getContentPane().add(demo2);
        jf.pack();
        jf.setVisible(true);
        demo2.cicloPrincipalJuego();
    }
}
