package zoombies;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Cartas extends JComponent implements Runnable{
    JFrame jf;
    public int ANCHO = 1200,
               ALTO  = 600;
    public int pixeles_costados = 15,
               pixeles_x = 0;
    public int mousex,
               mousey;
    public int aux;
    public int contadorplantas = 0,
               contadorzombies = 0;
    public int []posicionplantas = new int[6];
    public int []posicionzombies = new int[6];
    boolean activoszombies,activosplantas;
    final int FPS = 30;
    
    BufferedImage back,continuar,mazo,marco;
    BufferedImage []plantas = new BufferedImage[15];
    BufferedImage []zombies = new BufferedImage[15];
    BufferedImage []mazopla = new BufferedImage[6];
    BufferedImage []mazozom = new BufferedImage[6];
    
    Carta []cartaplanta = new Carta[15];
    Carta []cartazombie = new Carta[15];
    Carta []mazoplantas = new Carta[6];
    Carta []mazozombies = new Carta[6];
    
    public boolean []activaplantas = new boolean[15];
    public boolean []activazombies = new boolean[15];
    public boolean []activamazopla = new boolean[6];
    public boolean []activamazozom = new boolean[6];
    
    public boolean multijugador = false;
    
    //Constructor por defecto; asignamos todos los valores inciales de las cartas de los dos jugadores
    public Cartas(JFrame jf) throws Exception{
        //Ventana desplegable para mostrar el apartado de cartas y poder seleccionar las 6 cartas
        this.setVisible(true);
        this.setPreferredSize(new Dimension(ANCHO,ALTO));
        this.jf = jf;
        activoszombies = false;
        activosplantas = false;
        for(int i = 0; i < 15; i++){
            activaplantas[i] = true;
            activazombies[i] = true;
        }
        for(int i = 0; i < 6; i++){
            activamazopla[i] = false;
            activamazozom[i] = false;
            posicionplantas[i] = 0;
            posicionzombies[i] = 0;
        }
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evento){
                mousex = evento.getX();
                mousey = evento.getY();
                //si se da click en alguno de las cartas de las plantas
                for(int i=0;i<3;i++){
                    for(int o=0;o<5;o++){
                        if(pixeles_costados + o*110 + 15 < mousex && (pixeles_costados + o*110 + 15)+100 > mousex && pixeles_costados +  i*140 + 155 < mousey && (pixeles_costados +  i*140 + 155)+120 > mousey && contadorplantas < 6 && activaplantas[(i*5)+o]){
                            activaplantas[(i*5)+o] = false;
                            if(activamazopla[contadorplantas]){
                                aux = contadorplantas;
                                while(aux != 0){
                                    aux--;
                                    if(!activamazopla[aux]){
                                        posicionplantas[aux] = cartaplanta[(i*5)+o].posicion;
                                        activamazopla[aux] = true;
                                        mazopla[aux] = plantas[(i*5)+o];
                                        contadorplantas++;
                                        break;
                                    }
                                }
                            }else{
                                posicionplantas[contadorplantas] = cartaplanta[(i*5)+o].posicion;
                                activamazopla[contadorplantas] = true;
                                mazopla[contadorplantas] = plantas[(i*5)+o];
                                contadorplantas++;
                            }
                        }
                    }
                }
                //si se da click en alguna de las cartas de los zombies
                for(int i=0;i<3;i++){
                    for(int o=0;o<5;o++){
                        if((ANCHO/2) + pixeles_costados + o*110 + 15 < mousex && ((ANCHO/2) + pixeles_costados + o*110 + 15)+100 > mousex && pixeles_costados +  i*140 + 155 < mousey && (pixeles_costados +  i*140 + 155)+120 > mousey && contadorzombies < 6 && activazombies[(i*5)+o] && multijugador){
                            activazombies[(i*5)+o] =false;
                            if(activamazozom[contadorzombies]){
                                aux = contadorzombies;
                                while(aux != 0){
                                    aux--;
                                    if(!activamazozom[aux]){
                                        posicionzombies[aux] = cartazombie[(i*5)+o].posicion;
                                        activamazozom[aux] = true;
                                        mazozom[aux] = plantas[(i*5)+o];
                                        contadorzombies++;
                                        break;
                                    }
                                }
                            }else{
                                posicionzombies[contadorzombies] = cartazombie[(i*5)+o].posicion;
                                activamazozom[contadorzombies] = true;
                                mazozom[contadorzombies] = plantas[(i*5)+o];
                                contadorzombies++;
                            }
                        }
                    }
                }
                //si se da click en alguna carta de el mazo de plantas
                for(int i=0;i<6;i++){
                    if(pixeles_costados + i*90 + 15 < mousex && (pixeles_costados + i*90 + 15)+80 > mousex && pixeles_costados + 15 < mousey && (pixeles_costados + 15)+100 > mousey && activamazopla[i]){
                        activamazopla[i] = false;
                        activaplantas[mazoplantas[i].posicion] = true;
                        contadorplantas--;
                    }
                }
                //si se da click en alguna carta de el mazo de zombies
                for(int i=0;i<6;i++){
                    if((ANCHO/2)+pixeles_costados + i*90 + 15 < mousex && ((ANCHO/2)+pixeles_costados + i*90 + 15)+80 > mousex && pixeles_costados + 15 < mousey && (pixeles_costados + 15)+100 > mousey && activamazozom[i]){
                        activamazozom[i] = false;
                        activazombies[mazozombies[i].posicion] = true;
                        contadorzombies--;
                    }
                }
                //cuando tu mazo esta listo y das click en el boton de continuar
                if(multijugador){
                    if(!activosplantas  && (pixeles_costados + (ANCHO/2) - 190)/2 < mousex && (pixeles_costados + (ANCHO/2) -190)/2 + 200 > mousex && pixeles_costados + 140 + 350 < mousey && pixeles_costados + 140 + 350 + 60 > mousey){
                        nivel();
                    } 
                }else{
                    if(!activosplantas  && (ANCHO/2) < mousex && (ANCHO/2) + 200 > mousex && 20 < mousey && 80 > mousey){
                        nivel();
                    }
                }
            }
        });
        
        cargarimagenes();
        setFocusable(true);
    }
    
    //funcion para dibujar todas las cartas en sus respectivas posiciones
    @Override
    public void paint(Graphics g){        
        repaint();
        g.setColor(Color.white);
        g.drawRect(0, 0, ANCHO, ALTO);
        g.drawImage(back, 0, 0,ANCHO,ALTO, this);
        activoszombies = false;
        activosplantas = false;
        Graphics2D g2d = (Graphics2D) g;
        //Se crean los cuadros donde van las plantas y los zombies
        g.setColor(Color.black);
        g.drawImage(marco,pixeles_costados, pixeles_costados, (ANCHO/2)-30, 130, this);
        g.drawImage(mazo, pixeles_costados, pixeles_costados + 140, (ANCHO/2)-30, (ALTO)-170, this);
        
        if(multijugador){
            g.drawImage(marco, (ANCHO/2)+pixeles_costados, pixeles_costados, (ANCHO/2)-30, 130, this);
            g.drawImage(mazo, (ANCHO/2)+pixeles_costados, pixeles_costados + 140, (ANCHO/2)-30, (ALTO)-170, this);
        }
        for(int i=0;i<15;i++){
            cartaplanta[i] = new Carta(plantas[i],activaplantas[i],i);
        }
        
        if(multijugador){
            for(int i=0;i<15;i++){
                cartazombie[i] = new Carta(plantas[i],activazombies[i],i);
            }
        }
        for(int i=0;i<6;i++){
            mazoplantas[i] = new Carta(mazopla[i],activamazopla[i],posicionplantas[i]);
            mazozombies[i] = new Carta(mazozom[i],activamazozom[i],posicionzombies[i]);
        }
        
        //Cartas Plantas
        for(int i = 0;i < 3; i++){
            for(int o = 0; o < 5; o++){
                if(cartaplanta[((i*5)+o)].activa){
                    g.drawImage(cartaplanta[((i*5)+o)].imagen,pixeles_costados + o*109 + 22, pixeles_costados +  i*125 + 185, 95, 80,this);
                }
            }  
        }
        
        //mazo de cartas de las pantas
        
        for(int i = 0;i < 6; i++){
                if(mazoplantas[i].activa){
                    g.drawImage(mazoplantas[i].imagen,pixeles_costados + i*90 + 15, pixeles_costados + 45, 95, 80,this);
                }
        }
        
        for(int i=0;i<6;i++){
            if(!mazoplantas[i].activa){
                activosplantas = true;
            }
            if(multijugador){
                if(!mazozombies[i].activa){
                    activoszombies = true;
                }
            }
        }
       //activoplantas
        if(!activosplantas){
            if(multijugador){
                g.drawImage(continuar, (pixeles_costados + (ANCHO/2) -190)/2, pixeles_costados + 140 + 350,200,60, this);
            }else{
                g.drawImage(continuar, (ANCHO/2), 20,200,60, this);
            }
        }
        
        if(multijugador){
            //Cartas Zombies
            for(int i = 0;i < 3; i++){
                for(int o = 0; o < 5; o++){
                    if(cartazombie[((i*5)+o)].activa){
                        g.drawImage(cartazombie[((i*5)+o)].imagen,(ANCHO/2) + pixeles_costados + o*109 + 22, pixeles_costados +  i*125 + 185, 95, 80,this);
                    }
                }  
            }

            //mazo de cartas de zombies
            for(int i = 0;i < 6; i++){
                    if(mazozombies[i].activa){
                        g.drawImage(mazozombies[i].imagen,(ANCHO/2) + pixeles_costados + i*90 + 15, pixeles_costados + 45, 95, 80,this);
                    } 
            }

            //activozombies
            if(!activoszombies){
                g.drawImage(continuar, (pixeles_costados + (ANCHO/2) -190)/2 +(ANCHO/2), pixeles_costados + 140 + 350,200,60, this);
            }
        }
    }
    
    
    //funcion para cargar todas las imagenes que se necesitan
    private void cargarimagenes(){
        try{
           back = ImageIO.read(getClass().getResourceAsStream("/imagenes/background.png")); 
           plantas[0] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaCactus.png")); 
           plantas[1] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaCerezas.png"));
           plantas[2] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaChile.png"));
           plantas[3] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaCongela.png"));
           plantas[4] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaGirasol.png"));
           plantas[5] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaGuisante.png"));
           plantas[6] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaGuisante2.png"));
           plantas[7] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaGuisante3.png"));
           plantas[8] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaHielo.png"));
           plantas[9] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaHongo0.png"));
           plantas[10] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaHongoLargo.png"));
           plantas[11] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaHongoNoche.png"));
           plantas[12] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaMina.png"));
           plantas[13] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaNuez.png"));
           plantas[14] = ImageIO.read(getClass().getResourceAsStream("/imagenes/CartaNuezGrande.png"));
           continuar = ImageIO.read(getClass().getResourceAsStream("/imagenes/continuar.png")); 
           mazo = ImageIO.read(getClass().getResourceAsStream("/imagenes/mazo.jpg"));
           marco = ImageIO.read(getClass().getResourceAsStream("/imagenes/MarcoArriba.png"));
        
        }catch(IOException e){}
    }
    
    public void nivel(){
        JFrame jf2 = new JFrame("Juego");
                jf2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                // jf.setLocationRelativeTo(null);
                // jf.setResizable(false);
               
                Plantas demo2 = new Plantas(mazoplantas);
                jf2.getContentPane().add(demo2);

                // jf.getContentPane().add(demo1);
                jf2.pack();
                jf2.setVisible(true);
                demo2.cicloPrincipalJuego();
        jf.dispose();
    }
    
    @Override
    public void run() {
        double drawIterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawIterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            repaint();
        }
    }
    
}
