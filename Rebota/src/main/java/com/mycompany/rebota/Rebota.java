/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.rebota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Rebota extends JComponent {

    private final static int ANCHO = 1000;
    private final static int ALTO = 600;
    private final static int DIAMETRO = 20;
    private Timer timer;
    private boolean arriba, abajo, w, s;
    Pelotas[] p = new Pelotas[3];
    Barra b1 = new Barra(ANCHO - 100);
    Barra b2 = new Barra(50);
    JLabel puntos1, puntos2;

    public void cicloPrincipalJuego() throws Exception {
        long tiempoViego = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViego) / 1000000000f;
            tiempoViego = tiempoNuevo;
            for (int i = 0; i < p.length; i++) {
                p[i].Fisica(dt, p, b1, b2);
                //b1.fisica(dt);
            }
            //b1.fisica(dt);
            dibuja();

        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ANCHO, ALTO);
        /* g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
   g.setColor(Color.RED); 
   g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
    g.setColor(Color.BLACK);
    g.drawString("hola",(int) x+20,(int) y +20);
         */

        Font fuente = new Font("URW Gothic", Font.PLAIN, 28);
        for (int i = 0; i < p.length; i++) {
            g.setColor(p[i].color);
            g.fillOval(Math.round(p[i].x), Math.round(p[i].y), DIAMETRO, DIAMETRO);
            //System.out.println("x="+xbarra+"y="+ybarra);

        }
        g.setColor(Color.WHITE);
        g.fillRect(b1.x, b1.y, b1.ANCHO, b1.ALTO);
        g.fillRect(b2.x, b2.y, b2.ANCHO, b2.ALTO);
        g.setFont(fuente);
        g.drawString(p[0].c2 + "", 250, 50);
        g.drawString(p[0].c1 + "", 750, 50);

      

    }

    public Rebota() {
        
        setPreferredSize(new Dimension(ANCHO, ALTO));
        for (int i = 0; i < p.length; i++) {
            p[i] = new Pelotas();
            //p[i].toString();
        }
            timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Actualiza la posición de las barras aquí
                if (arriba && b1.y > 0) {
                    b1.y -= 5;
                }
                if (abajo && b1.y + b1.ALTO < ALTO) {
                    b1.y += 5;
                }
                if (w && b2.y > 0) {
                    b2.y -= 5;
                }
                if (s && b2.y + b2.ALTO < ALTO) {
                    b2.y += 5;
                }
            }
        });
        timer.start();
        puntos1 = new JLabel("Hola");
        puntos1 = new JLabel("Hola");

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }

            public void keyReleased(KeyEvent e) {
                actualiza(e.getKeyCode(), false);
            }

            private void actualiza(int keyCode, boolean pressed) {
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        arriba = pressed;
                        break;
                    case KeyEvent.VK_DOWN:
                        abajo = pressed;
                        break;
                    case KeyEvent.VK_W:
                        w = pressed;
                        break;
                    case KeyEvent.VK_S:
                        s = pressed;
                        break;
                }
            }

        });

        setFocusable(true);

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

        jf.setResizable(false);
        Rebota demo1 = new Rebota();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
}
