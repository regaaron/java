/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game;

/**
 *
 * @author aaron
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game extends JComponent {

    private final static int ANCHO = 512;
    private final static int ALTO = 384;
    private final static int DIAMETRO = 20;
    private float x,y;
    private float vx,vy;
    //public Sprite image2 = new Sprite("/imagenes/explosprite.png",64,64,100,100);
    public Sprite image = new Sprite("/imagenes/pikachu.png",256/4,256/4,ANCHO/2,ALTO/2);
    public int i = 0;
    
    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Juego...");
        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        jf.setResizable(false);
        Game demo1 = new Game();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, ANCHO, ALTO);
        g.setColor(Color.red);
        g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
        
        image.pintar(g);
        
   
    }
    
    public Game(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        x = 10;
        y = 20;
        vx = 300;
        vy = 400;
    }
    
    private void dibuja() throws Exception{
        SwingUtilities.invokeAndWait(new Runnable(){
            public void run(){
                paintImmediately(0,0, ANCHO, ALTO);
            }
        });
        
    }

    private void fisica(float dt){
        x += vx * dt;
        y += vy * dt;
        if(vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO){
            vx = -vx;
        }
        if(vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO){
            vy = -vy;
        }
    }
    
    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while(true){
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo)/1000000000f;
            tiempoViejo = tiempoNuevo;
            fisica(dt);
            dibuja();
            
            if (tiempoNuevo - tiempoViejo > 2000000000) {
            // Cambiar la imagen del sprite
            image.setFrame((i++)/1000);
        }
        }
    }
}
