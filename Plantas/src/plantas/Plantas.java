/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plantas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Plantas extends JComponent implements Runnable{

    final int col =11;
    final int row = 5;
    final int pixel = 90;
    final int extraxIzq = 240;
    final int extraDer = 100;
    final int extraArriba = 65;
    final int screenX = col * pixel + extraDer + extraxIzq;
    final int screenY = row * pixel + 100;
    final int FPS=60;
      int solx=(int)(Math.random()*5);
      int soly=(int)(Math.random()*12);
       int sol=0;
    int movimiento=0;
    Thread gameThread;
    BufferedImage back, score, gisante, girasol, nuez, gisante1, zoombie, tagGirazol, tagNuez, tagGisante,tagBomba;
    int spriteCounter=0;   
    Plantas() {
        System.out.println("sceenx=" + screenX);
        System.out.println("sceeny=" + screenY);

        setPreferredSize(new Dimension(screenX, screenY));
        cargarImagenes();
        
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
              
                        break;
                    case KeyEvent.VK_DOWN: //caso abajo
                 
                        break;
                    case KeyEvent.VK_LEFT: //caso W
                        movimiento+=4;
                        break;
                    case KeyEvent.VK_RIGHT: //caso S
                            movimiento-=4;
                        break;
                }
            }

        });

        setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, screenX, screenY);
        g.setColor(Color.red);
        g.drawImage(back, 0, 0, screenX, screenY, this);
        g.drawImage(score, extraxIzq + 10, 0, pixel-10, pixel-10, this);
        g.setColor(new Color(0xE8B059));
        Graphics2D g2d = (Graphics2D) g;
       
        int puntos = 120;
            g.drawImage(zoombie, screenX-150-movimiento, extraArriba + (2* pixel), pixel, pixel, this);
                           g.drawImage(zoombie, screenX-150-movimiento, extraArriba + (3* pixel), pixel, pixel, this);
                           g.drawImage(zoombie, screenX-150-movimiento, extraArriba + (4* pixel), pixel, pixel, this);
                           g.drawImage(zoombie, screenX-150-movimiento, extraArriba + (1* pixel), pixel, pixel, this);
        Font fuente = new Font("URW Gothic", Font.PLAIN, 28);
        g2d.setFont(fuente);
        g2d.setColor(Color.BLACK);
        g2d.drawString(puntos + "", extraxIzq + 80, 50);

        g2d.drawImage(tagGirazol, 40, 15, pixel + 30, pixel, this);
        g2d.drawImage(tagNuez, 40, 15+pixel, pixel + 30, pixel, this);
        g2d.drawImage(tagGisante, 40, 15+pixel*2, pixel + 30, pixel, this);
        boolean tag1=false;
        
        if(tag1){
                g2d.drawImage(tagBomba, 60, 15+pixel*3, pixel + 30, pixel, this);
                
        }else{
                g2d.drawImage(tagBomba, 40, 15+pixel*3, pixel + 30, pixel, this);

        }
    
        g2d.drawImage(tagGisante, 40, 15+pixel*4, pixel + 30, pixel, this);
        g2d.drawImage(tagBomba, 40, 15+pixel*5, pixel + 30, pixel, this);

        
        int matriz[][]={{1,2,2,3,2,2,0,0,0,4,4},
                               {1,2,2,3,2,2,0,2,0,4,4},
                               {1,2,2,3,2,2,0,2,0,4,4},
                               {1,2,2,3,2,2,0,2,0,4,4},
                               {1,2,2,3,2,2,0,0,0,4,4}};
        /*
        System.out.println("------------------------------------------");
         for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+",");
                }
             System.out.println();
            }
                 System.out.println("------------------------------------------");
*/
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
               // g.drawImage(girasol, extraxIzq + (i * pixel), extraArriba + (j * pixel), pixel, pixel, this);
               if(matriz[i][j]==1){
                   g.drawImage(girasol, extraxIzq + (j * pixel), extraArriba + (i * pixel), pixel, pixel, this);
               }
                  if(matriz[i][j]==2){
                   g.drawImage(gisante1, extraxIzq + (j * pixel), extraArriba + (i * pixel), pixel, pixel, this);
               }
                     if(matriz[i][j]==3){
                   g.drawImage(nuez, extraxIzq + (j * pixel), extraArriba + (i * pixel), pixel, pixel, this);
               }
                     /*
                    if(matriz[i][j]==4){
                   g.drawImage(zoombie, extraxIzq + (j * pixel), extraArriba + (i * pixel), pixel, pixel, this);
               }
                     */
               
            }
        }
           spriteCounter++;
        if(spriteCounter>4){
            movimiento+=2;
            spriteCounter=0;
            
        }
        
     
        
        sol++;
                  
                if(sol>300){
                    solx=(int)(Math.random()*12);
                     soly=(int)(Math.random()*4);
                    System.out.println("solx="+solx);
                    System.out.println("soly="+soly);
                    
               


                    try {
                        Thread.sleep(100);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Plantas.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                                  
                    sol=0;
                }
                        g.drawImage(score, extraxIzq + (solx * pixel), extraArriba + (soly * pixel), pixel, pixel, this);

                       
                          

        for (int i = 0; i <= row; i++) {
            g.setColor(Color.red);
            g.drawLine(extraxIzq, (i * pixel) + extraArriba, screenX - extraDer, (i * pixel) + extraArriba);

            for (int j = 0; j <= col; j++) {
                g.drawLine((j * pixel) + extraxIzq, extraArriba, (j * pixel) + extraxIzq, screenY - 30);
            }

        }

    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        JFrame jf = new JFrame("Juego");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // jf.setLocationRelativeTo(null);
        // jf.setResizable(false);

        Plantas demo1 = new Plantas();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    
    }

    public void cicloPrincipalJuego()  {
       
        gameThread = new Thread(this);
        gameThread.start();
 
    }

    private void cargarImagenes() {
        try {
            back = ImageIO.read(getClass().getResourceAsStream("/resources/background.png"));
            score = ImageIO.read(getClass().getResourceAsStream("/resources/score.png"));
            gisante = ImageIO.read(getClass().getResourceAsStream("/resources/gisante.png"));
            girasol = ImageIO.read(getClass().getResourceAsStream("/resources/girasol.png"));
            nuez = ImageIO.read(getClass().getResourceAsStream("/resources/nuez1.png"));
            gisante1 = ImageIO.read(getClass().getResourceAsStream("/resources/gisante1.png"));
            zoombie = ImageIO.read(getClass().getResourceAsStream("/resources/clasic_zoombie.png"));
            tagGirazol = ImageIO.read(getClass().getResourceAsStream("/resources/tagGirazol.png"));
            tagGisante = ImageIO.read(getClass().getResourceAsStream("/resources/tagGisante.png"));
            tagNuez = ImageIO.read(getClass().getResourceAsStream("/resources/tagNuez.png"));
            tagBomba=ImageIO.read(getClass().getResourceAsStream("/resources/tagBomba.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plantas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
     double drawIterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount =0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta+=(currentTime-lastTime)/drawIterval;
            timer+=(currentTime-lastTime);
            lastTime= currentTime;
            if(delta>=1){
               
            repaint();
            delta--;
            drawCount++;
            }
            if(timer>=1000000000){
                //System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }

}
