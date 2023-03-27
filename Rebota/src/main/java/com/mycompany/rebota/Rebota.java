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
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Rebota extends JComponent {
    //Dimension de la pantalla
    private final static int ANCHO = 1000;
    private final static int ALTO = 600;
    
    //timer para refrescar pantalla
    private Timer timer;
    //booleanos para las teclas  
    private boolean arriba, abajo, w, s;
    
    //vector de pelotas
    Pelotas[] p = new Pelotas[5];
    
    //Barras b1 derecha y b2 izquierda
    Barra b1 = new Barra(ANCHO - 50);
    Barra b2 = new Barra(20);

    
    //logica del luego
    public void cicloPrincipalJuego() throws Exception {
        long tiempoViego = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViego) / 1000000000f;
            tiempoViego = tiempoNuevo;
            //llamamos a fisica y despues redibujamos
            for (int i = 0; i < p.length; i++) {
                p[i].Fisica(dt, p, b1, b2);
            }
      
            dibuja();

        }
    }

    public void paint(Graphics g) {
        //coloco color de fondo en negro
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ANCHO, ALTO); //pantalla 
        
        //codigo para la linea discontinua
        //BasicStroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{5.0f, 2.0f}, 0.0f); 

       //Fuente y tamanio para el contador de los puntos 
        Font fuente = new Font("URW Gothic", Font.PLAIN, 28);
        
        //imprime todas las pelotas
        for (int i = 0; i < p.length; i++) {
            //coloco el color y la pelota
            g.setColor(p[i].color);
            g.fillOval(Math.round(p[i].x), Math.round(p[i].y), p[i].DIAMETRO, p[i].DIAMETRO);
            

        }
        
        //coloco el color de las barras
        g.setColor(new Color(255, 0, 255));
        
        //colocamos barra1 y barra2 
        g.fillRect(b1.x, b1.y, b1.ANCHO, b1.ALTO);
        g.fillRect(b2.x, b2.y, b2.ANCHO, b2.ALTO);
        
        //colocamos fuente y color blanco para los contadores de puntos
        g.setColor(Color.WHITE);
        g.setFont(fuente);
        g.drawString(p[0].c2 + "", 250, 50);
        g.drawString(p[0].c1 + "", 750, 50);

        //codigo para la linea discontinua
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{9}, 0));
        g2d.drawLine(ANCHO / 2, 0, ANCHO / 2, ALTO);

    }

    public Rebota() {
        //colocamos pantalla
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        //Inicializamos el vector de pelotas
        for (int i = 0; i < p.length; i++) {
            p[i] = new Pelotas();
            //p[i].toString();
        }
        
        //Logica del tiempo y movimiento de las barras
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Actualiza la posición de las barras aquí
                
                //si ariiba es precionado y b1.y es mayor a cero para que no se pase de la pantalla
                if (arriba && b1.y > 0) {
                    b1.y -= 5; //reducimos para que la barra vaya hacia arriba 
                }
                //si abajo es precionado barra b1 baja pero debe ser menor a alto pero considerando el alto de la barra
                if (abajo && b1.y + b1.ALTO < ALTO) {
                    b1.y += 5; 
                }
                
                //si w  es precionado la barra sube siempre y cuando no llegue ala cima b2.y llegue a 0
                if (w && b2.y > 0) {
                    b2.y -= 5;
                }
                
                //Si s es precionado la barra baja pero considerando el alto de la pantalla y en alto de la barra
                if (s && b2.y + b2.ALTO < ALTO) {
                    b2.y += 5;
                }
            }
        });
        timer.start();
        
        
         //logica de teclado
        addKeyListener(new KeyAdapter() {
            
            //si se preciona una tecla envia verdadero y el codigo de la 
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }
            //Si se preciona una tecla envia falso asi dejara de hacer el movimiento
            public void keyReleased(KeyEvent e) {
                actualiza(e.getKeyCode(), false);
            }
            //en caso de que la tecla se este precionando pasa true y el codigo de teclado 
            private void actualiza(int keyCode, boolean pressed) {
                
                switch (keyCode) {
                    case KeyEvent.VK_UP: //caso aariba
                        arriba = pressed;
                        break;
                    case KeyEvent.VK_DOWN: //caso abajo
                        abajo = pressed;
                        break;
                    case KeyEvent.VK_W: //caso W
                        w = pressed;
                        break;
                    case KeyEvent.VK_S: //caso S
                        s = pressed;
                        break;
                }
            }

        });

        setFocusable(true);

}
//creo es para refrescar la pantalla
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
