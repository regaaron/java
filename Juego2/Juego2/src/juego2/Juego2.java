/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juego2;

/**
 *
 * @author Chuy
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Juego2 extends JComponent {

    private final static int ANCHO = 512;
    private final static int ALTO = 384;
    private final static int DIAMETRO = 20;
    private float x, y;
    private float vx, vy;
    
    private boolean arriba, abajo, izquierda, derecha;
    
    private BufferedImage image;
    
   
    
    
    public Juego2() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 10;
        y = 20;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("\src\imagenes\changuito.jpg"));
        } catch (IOException ex) {
            System.out.println("Error: Imagen no encontrada");
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
        /*g.setColor(Color.WHITE);
        g.fillRect(0, 0, ANCHO, ALTO);*/
        g.drawImage(image, 10, 10, null);
        
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
    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Demo2");
        jf.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        jf.setResizable(false);
        Juego2 demo2 = new Juego2();
        jf.getContentPane().add(demo2);
        jf.pack();
        jf.setVisible(true);
        demo2.cicloPrincipalJuego();
    }
}
