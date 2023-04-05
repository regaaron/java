/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.imagenes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Imagenes extends JFrame implements Runnable{
int ANCHO =500;
int ALTO=400;
Image img;
Thread hilo;
int incremento=0;
    BufferedImage bi;

    public Imagenes(){
        setBounds(0,0,ANCHO,ALTO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        hilo = new Thread(this);
        img=herramienta.getImage("/home/aaron/img.png");
                bi=new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);

        hilo.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d;

        g.drawImage(img,0,0,this);
        
        g2d=bi.createGraphics();
        g2d.fillRect(0,0,ANCHO,ALTO);
        int mx=(incremento%5)*20;
        int my= (incremento/5)*20;
        g2d.drawImage(img, 50,50,50+20,50+20,mx,my, mx+20,my+20,this);
        repaint();
    }
    
    
    public static void main(String[] args) {
        new Imagenes().setVisible(true);
        
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
            incremento++;
            
            if(incremento>8){
                incremento=0;
            }
        }
    }
}
