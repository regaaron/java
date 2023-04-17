/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author aaron
 */
public class Examen extends JPanel implements ActionListener {

    final int ANCHO = 960;
    final int ALTO = 600;
    BufferedImage fondo, wudy, jessie, caja;
    Toy Tjessie;
    Toy Tdino;
    Toy futbol ;
    Toy americano ;
    Toy basquet ;
    Toy pijama;
    Toy tenis ;
    Toy mate;
    Toy policia;
    Toy nintendo ;
    Toy Tswitch;
    BackgroundSound soundFondo;
    Timer timer;
    int contador ;
    int mousex, mousey;
    int puntos ;
    boolean fin;
    
    int numero;
       int orden;
             Color color2;

           public void   iniciar(){
               numero=1;
                    Tjessie = new Toy(this, 80, 140, "/resources/Jessie.png", "juguete");
     Tdino = new Toy(this, 80, 140, "/resources/dino.png", "juguete");
     futbol = new Toy(this, 90, 90, "/resources/pelota.png", "pelota");
     americano = new Toy(this, 80, 60, "/resources/americano.png", "pelota");
     basquet = new Toy(this, 80, 80, "/resources/basquet.png", "pelota");
     pijama = new Toy(this, 80, 110, "/resources/pijama.png", "Ropa");
     tenis = new Toy(this, 80, 110, "/resources/tenis.png", "Ropa");
     mate = new Toy(this, 80, 110, "/resources/mate.png", "Carro");
     policia = new Toy(this, 80, 110, "/resources/policia.png", "Carro");
     nintendo = new Toy(this, 80, 110, "/resources/nintendo.png", "videojuego");
     Tswitch = new Toy(this, 80, 110, "/resources/switch.png", "videojuego");
     contador=60;
     puntos=0;
     fin=false;
     orden=1;
     
     soundFondo = new BackgroundSound("/resources/fondo.wav");
        soundFondo.clip.loop(Clip.LOOP_CONTINUOUSLY);
           cargarImagenes();
             }
           
           
    Examen() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
       
        this.setVisible(true);
        iniciar();
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                repaint();
                if(!fin){
                    contador--;
                }
                
                if (Tjessie.dentro && Tdino.dentro && futbol.dentro && americano.dentro && basquet.dentro
                        && pijama.dentro && tenis.dentro && mate.dentro && policia.dentro && nintendo.dentro && Tswitch.dentro) {
                    
                    fin = true;
                 
                   
                    

                }
                
                if(fin){
                        
                        soundFondo.stop();
                    }
                
                if(contador<=0){
                     fin = true;
             
               
                }
            }
        });
        timer.start();

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {

                    Tjessie.pressed = false;
                    Tdino.pressed = false;
                    futbol.pressed = false;
                    americano.pressed = false;
                    basquet.pressed = false;
                    pijama.pressed = false;
                    tenis.pressed = false;
                    mate.pressed = false;
                    policia.pressed = false;
                    nintendo.pressed = false;
                    Tswitch.pressed = false;
                    //---------------------------------------
                    Tjessie.dentro();
                    Tdino.dentro();
                    futbol.dentro();
                    americano.dentro();
                    basquet.dentro();
                    pijama.dentro();
                    tenis.dentro();
                    mate.dentro();
                    policia.dentro();
                    nintendo.dentro();
                    Tswitch.dentro();
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousex = e.getX();
                mousey = e.getY();
                if (solo1()) {
                    Tjessie.press(e);
                }
                if (solo1()) {
                    pijama.press(e);
                }
                if (solo1()) {
                    basquet.press(e);
                }
                if (solo1()) {
                    americano.press(e);
                }
                if (solo1()) {

                    futbol.press(e);
                }
                if (solo1()) {
                    Tdino.press(e);
                }

                if (solo1()) {
                    tenis.press(e);
                }

                if (solo1()) {
                    mate.press(e);
                }
                if (solo1()) {
                    policia.press(e);
                }

                if (solo1()) {
                    nintendo.press(e);
                }
                if (solo1()) {
                    Tswitch.press(e);
                }

                repaint();
            }

            public boolean solo1() {
                if (!Tjessie.pressed && !Tdino.pressed && !futbol.pressed && !americano.pressed && !basquet.pressed && !pijama.pressed
                        && !tenis.pressed && !mate.pressed && !policia.pressed && !nintendo.pressed && !Tswitch.pressed) {
                    return true;
                } else {
                    return false;
                }

            }

            @Override
            public void mouseClicked(MouseEvent evento) {
                if(fin){
                   iniciar();
                      
                repaint();
                }
            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                Tjessie.mover(e);
                Tdino.mover(e);
                futbol.mover(e);
                americano.mover(e);
                basquet.mover(e);
                pijama.mover(e);
                tenis.mover(e);
                mate.mover(e);
                policia.mover(e);
                nintendo.mover(e);
                Tswitch.mover(e);
                //------------------------------------------------------ 

                repaint();
            }

            public void mouseMoved(MouseEvent evento) {
                System.out.println("x=" + evento.getX());
                System.out.println("y=" + evento.getY());
                if(fin){
                      if(evento.getX()>417&&evento.getX()<573&&evento.getY()>356&&evento.getY()<395){
                    color2=new Color(0x4D1F61);
                    
                }else{
                    color2=Color.white;
                }
                      
                repaint();
                }
              
            }
        });

        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        if (!fin) {

            g.setColor(Color.black);
            g.fillRect(0, 0, ANCHO, ALTO);
            g.drawImage(fondo, 0, 0, ANCHO, ALTO, this);
            g.drawImage(caja, 85, ALTO - 200, 150, 150, this);
            Font fuente = new Font("URW Gothic", Font.ROMAN_BASELINE, 20);
            g.setFont(fuente);
            g.setColor(Color.black);
            g.drawString("ROPA", 140, ALTO - 100);
            g.drawImage(caja, 250, ALTO - 200, 150, 150, this);
            g.drawString("PELOTAS", 280, ALTO - 100);

            g.drawImage(caja, 400, ALTO - 200, 150, 150, this);
            g.drawString("CARROS", 430, ALTO - 100);

            g.drawImage(caja, 550, ALTO - 200, 150, 150, this);
            g.drawString("MONOS", 580, ALTO - 100);
            g.drawImage(caja, 700, ALTO - 200, 150, 150, this);
            g.drawString("VIDEOJUEGOS", 710, ALTO - 100);

            Graphics2D g2;
            g2 = (Graphics2D) g;
            Tjessie.draw(g2);
            Tdino.draw(g2);
            futbol.draw(g2);
            americano.draw(g2);
            basquet.draw(g2);
            pijama.draw(g2);
            tenis.draw(g2);
            mate.draw(g2);
            policia.draw(g2);
            nintendo.draw(g2);
            Tswitch.draw(g2);

            g.setColor(Color.black);
            fuente = new Font("URW Gothic", Font.ROMAN_BASELINE, 28);
            g.setFont(fuente);
            g.drawString("Tiempo: " + contador, ANCHO - 200, 45);
            g.drawString("Puntos: " + puntos, ANCHO - 200, 75);
        } else {
            g.setColor(Color.black);
            g.fillRect(0, 0, ANCHO, ALTO);
            g.setColor(Color.white);
            String texto = "Game  Over  \n"
                    + "Score = " + this.puntos;
            Font fuente = new Font("Arial", Font.PLAIN, 28);

            g.setFont(fuente);

// Obtener el ancho del String
            FontMetrics fm = g.getFontMetrics(fuente);
            int anchoTexto = fm.stringWidth(texto);

// Calcular la posición x del centro
            int centroX = (getWidth() - anchoTexto) / 2;
            int centoY = (getHeight() / 2);
// Dibujar el String centrado
            g.drawString(texto, centroX, centoY);
           g.setColor(color2);
            RoundRectangle2D rectanguloRedondeado = new RoundRectangle2D.Float(centroX+80,centoY+50, 160, 50, 20, 20);
        Graphics2D g2d =(Graphics2D) g;
        g2d.fill(rectanguloRedondeado);
       
         g.setColor(Color.black);
         g.drawString("Reintentar", centroX+90, centoY+90);
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("Juego");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // jf.setLocationRelativeTo(null);
        // jf.setResizable(false);

        Examen demo1 = new Examen();
        jf.getContentPane().add(demo1);

        jf.pack();
        jf.setVisible(true);

    }

    private void cargarImagenes() {
        try {
            fondo = ImageIO.read(getClass().getResourceAsStream("/resources/fondo.jpg"));
            caja = ImageIO.read(getClass().getResourceAsStream("/resources/caja.png"));
        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
