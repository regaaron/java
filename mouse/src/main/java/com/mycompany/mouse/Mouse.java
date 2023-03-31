/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author aaron
 */
public class Mouse extends JComponent {

    private final static int ANCHO = 512;
    private final static int ALTO = 384;
    private final static int DIAMETRO = 20;
    private int x, y;
    private int mx, my;
    private String titulo;

    Mouse() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 10;
        y = 20;
        titulo = "";

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evento) {

                //obtinene x y y
                mx = evento.getX();
                my = evento.getY();
                if (evento.isMetaDown()) { //boton derecho del raton
                    titulo = "(" + mx + "," + my + ")" + "Derecho";
                } else {
                    if (evento.isAltDown()) {//boton de enmerdio del boton
                        titulo = "(" + mx + "," + my + ")" + "Centrall";
                    } else {
                        titulo = "(" + mx + "," + my + ")" + "izq";
                    }
                }
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent evento){
                titulo="Dragged";
                x=evento.getX();
                y=evento.getY();

            }
            public void mouseMoved(MouseEvent evento){
               // x=evento.getX()-DIAMETRO/2;
                //y=evento.getY()-DIAMETRO/2;

                titulo="Moved";
            }
        });
        
        setFocusable(true);
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETRO, DIAMETRO);
        g.setColor(Color.BLACK);
        g.drawOval(x, y,DIAMETRO ,DIAMETRO);
        g.drawString(titulo, x-20, y-20);
    }
    
    
    public void Principal() throws Exception{
         long tiempoViego = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViego) / 1000000000f;
            tiempoViego = tiempoNuevo;
            //llamamos a fisica y despues redibujamos
            
      
            dibuja();

        }
    }
public void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                paintImmediately(0, 0, ANCHO, ALTO);
            }
        });
    }
    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Juego"); 
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Mouse demo1 = new Mouse();
        jf.setResizable(false);
        
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.Principal();
    }
}
