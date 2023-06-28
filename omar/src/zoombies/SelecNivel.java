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

public class SelecNivel extends JComponent {
    JFrame jf;

    int screnx = 1334;
    int screny = 750;
    int x;
    int y;
    int ecenario = 0;
    int nivel = 0;
    BufferedImage dia, noche, niebla;
    BufferedImage img = null;
    BackgroundSound menusound;

    private boolean lvl1() {
        return ((x >= 735 && x <= 834) && (y >= 330 && y <= 360));
    }

    private boolean lvl2() {
        return ((x >= 510 && x <= 612) && (y >= 330 && y <= 360));
    }

    SelecNivel(JFrame jf) {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(screnx, screny));
        this.jf = jf;
        cagarImagenes();
        menusound = new BackgroundSound("/Java/resources/start_menu.wav");
        menusound.clip.loop(Clip.LOOP_CONTINUOUSLY);
        img = dia;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Dia()) {
                    img = dia;
                    ecenario = 1;
                }

                if (Noche()) {
                    img = noche;
                    ecenario = 2;
                }

                if (Niebla()) {
                    img = niebla;
                    ecenario = 3;
                }

                if (lvl1()) {
                    nivel = 1;
                    try {
                        salir();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

                if (lvl2()) {
                    nivel = 2;
                    try {
                        salir();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                if(e.getX()>2 && e.getX()<81 && e.getY()>580 && e.getY()<730){
                    try {
                        regresar();
                    } catch (Exception ex) {
                        Logger.getLogger(Minijuegos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                repaint();

            }

        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("x: " + e.getX());
                System.out.println("y: " + e.getY());
                x = e.getX();
                y = e.getY();

                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }
        });
        setFocusable(true);
    }

    public boolean Dia() {
        return ((x >= 376 && x <= 474) && (y >= 544 && y <= 610));
    }

    public boolean Noche() {
        return ((x >= 492 && x <= 590) && (y >= 494 && y <= 591));
    }

    public boolean Niebla() {
        return ((x >= 710 && x <= 806) && (y >= 512 && y <= 591));
    }

    public void cagarImagenes() {
        try {
            dia = ImageIO.read(getClass().getResourceAsStream("/Java/resources/dia.jpeg"));
            noche = ImageIO.read(getClass().getResourceAsStream("/Java/resources/noche.jpeg"));
            niebla = ImageIO.read(getClass().getResourceAsStream("/Java/resources/niebla.jpeg"));

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void salir() throws Exception {
        JFrame jf2 = new JFrame("Juego");
        jf2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // jf.setLocationRelativeTo(null);
        // jf.setResizable(false);

        Cartas demo1 = new Cartas(jf2,nivel,ecenario,false);
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
        g.fillRect(0, 0, screnx, screny);
        g.drawImage(img, 0, 0, screnx, screny, this);

    }

}
