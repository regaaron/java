package zoombies;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Minijuegos extends JComponent {
    JFrame jf;
   
    int x=1334;
    int y=750;
    BufferedImage fondo,play,moregames;
    BufferedImage img=null;
    BackgroundSound menusound;
    Minijuegos(JFrame jf) {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(x, y));
        this.jf=jf;
        cagarImagenes();
        menusound=new BackgroundSound("/Java/resources/start_menu.wav");
        menusound.clip.loop(Clip.LOOP_CONTINUOUSLY);
        img=fondo;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getX()>347 && e.getX()<492 && e.getY()>359 && e.getY()<461){
                    try {
                        juego1();
                    } catch (Exception ex) {
                        Logger.getLogger(Minijuegos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(e.getX()>599 && e.getX()<745 && e.getY()>304 && e.getY()<473){
                    try {
                        juego2();
                    } catch (Exception ex) {
                        Logger.getLogger(Minijuegos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(e.getX()>2 && e.getX()<81 && e.getY()>642 && e.getY()<730){
                    try {
                        regresar();
                    } catch (Exception ex) {
                        Logger.getLogger(Minijuegos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            
        });

        setFocusable(true);
    }

    public void cagarImagenes(){
        try {
            fondo=ImageIO.read(getClass().getResourceAsStream("/imagenes/minijuegos.jpg"));          
        } catch (Exception e) {
          e.getMessage();
        }
    }
    
    public void juego1() throws Exception{
        JFrame jf2 = new JFrame("Juego");
                jf2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                // jf.setLocationRelativeTo(null);
                // jf.setResizable(false);
               
                SelecNivel demo1 = new SelecNivel(jf2);
                jf2.getContentPane().add(demo1);
                menusound.stop();
                // jf.getContentPane().add(demo1);
                jf2.pack();
                jf2.setVisible(true);
            
                jf.dispose();
    }
    
    public void juego2() throws Exception {
        JFrame jf2 = new JFrame("Juego");
        jf2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // jf.setLocationRelativeTo(null);
        // jf.setResizable(false);

        Cartas demo1 = new Cartas(jf2,1,1,true);
        jf2.getContentPane().add(demo1);
        menusound.stop();
        // jf.getContentPane().add(demo1);
        jf2.pack();
        jf2.setVisible(true);
        demo1.cicloPrincipalJuego();
        jf.dispose();
    }
    
     public void regresar() throws Exception{
        JFrame jf2 = new JFrame("Juego");
                jf2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                // jf.setLocationRelativeTo(null);
                // jf.setResizable(false);
               
                Menu demo1 = new Menu(jf2);
                jf2.getContentPane().add(demo1);
                menusound.stop();
                // jf.getContentPane().add(demo1);
                jf2.pack();
                jf2.setVisible(true);
            
                jf.dispose();
    }

    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(0, 0, x, y);
        g.drawImage(img, 0, 0,x,y, this);
        
    }

}
