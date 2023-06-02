package zoombies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

public class zombies {
    Plantas p;// objeto principal para la referencia
    double x, y; // posicion en x y y
    BufferedImage[] imagenes = new BufferedImage[31]; // vector de imagenes sprites
    BufferedImage[] eat = new BufferedImage[31];// vector de imagenes sprites comiendo
    BackgroundSound sonidoeat; // sonido de comer
    BackgroundSound soundnew;
    BufferedImage zoombie = null; // imagen que se va a mostrar dependiendo el sprite
    double velocidad;// velocidad del zombie
    int frame = 0;// frame o imagen
    int cambio = 1;
    int vida = 100;
    int tiempoCongelado = 0;
    boolean realentiza = false;
    BufferedImage buffer; 

    // zombie recibe plantas para la referencia y una posicion en y ya que en x
    // siempre sera hasta el final
    zombies(Plantas p, int y) {
        this.p = p;// igualamos la referencia
        cargarImagenes(); // cargamos las imagenes
        this.x = p.screenX - 200; // x es el final - 200
        this.y = p.pixel * y + p.extraArriba;// colocamos en y en base al pixel y el valor y
                                             // que es la fila

        velocidad = .5; // velocidad de .25 ya que se actualiza 30 veces por segundo
        // creamos el objeto de sonido pasandole la direccion
        sonidoeat = new BackgroundSound("/Java/resources/zombie_eat.wav");
        soundnew = new BackgroundSound("/Java/resources/plain_zombie.wav");
        soundnew.clip.start();
    }

    // dibujamos al zombie en base a su frame y posicion
    /*
     * public void draw(Graphics2D g2){
     * g2.drawImage(zoombie,(int)x,(int)y,p.pixel,p.pixel,p);
     * g2.drawString(vida+"", (int) x-20, (int) y-20);
     * }
     */

    public void EfectoLento(){
        try{

            buffer=new BufferedImage(zoombie.getWidth(), zoombie.getHeight(), BufferedImage.TYPE_INT_ARGB);
                tiempoCongelado++;
                if(tiempoCongelado>=p.FPS*3){
                    descongelar();
                }

            
            // Obtener las dimensiones de la imagen
            int width = zoombie.getWidth();
            int height = zoombie.getHeight();

            // Iterar sobre cada píxel de la imagen
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Obtener el color original del píxel
                    Color color = new Color(zoombie.getRGB(x, y), true);

                    // Obtener el nivel de opacidad original
                    int alpha = color.getAlpha();

                    // Aplicar el efecto de congelación: reducir la opacidad y agregar un tinte azul
                    int red = (int) (color.getRed() / 1.8);
                    int green = (int) (color.getGreen() / 1.8);
                    int blue = color.getBlue();
                    Color nuevoColor = new Color(red, green, blue, (int) (alpha));

                    // Establecer el nuevo color en el píxel del buffer
                    buffer.setRGB(x, y, nuevoColor.getRGB());
                }
            }

          //  g2.drawImage(buffer, (int) x, (int) y, p.pixel, p.pixel, p);
        
      }catch(Exception e){
            System.out.println("Error shader");
        }

       
    }
    public void draw(Graphics2D g2) {

            if(realentiza){
                EfectoLento();
                g2.drawImage(buffer, (int) x, (int) y, p.pixel, p.pixel, p);

            }else{
                g2.drawImage(zoombie, (int) x, (int) y, p.pixel, p.pixel, p);

            }
        // Dibujar la barra de vida del zombie
        BarraVida(g2);

    }
    public void descongelar(){
            realentiza = false;
            velocidad = .5;
    }

    public void BarraVida(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect((int) x, (int) y - 10, p.pixel, 5);
        g2.setColor(Color.GREEN);
        g2.fillRect((int) x, (int) y - 10, (int) (p.pixel * (vida / 100.0)), 5);
    }

    // fisica del movimiento y aqui hice tambien lo de seleccionar el frame
    public void fisica() {
        // siempre y cuando no colisione avanza si no avanza y se detiene el sonido de
        // comer
        if (!colision()) {
            x -= velocidad;
            sonidoeat.stop();
            if (x < p.extraxIzq - 100) {
                p.over = true;
                if (p.tiempo < 240)
                    p.tiempo++;
            }
        }
        // siempre y cuando no este colisionando osea no este comiendo escoje un frame
        // del zombie moviendoze y lo pone en zombie que es el que se muestra
        cambiarFrame();
    }

    public void cambiarFrame() {
        
            if (!colision()) {
                if (frame >= 0 && frame <= 30) {
                    zoombie = imagenes[frame];
                } else {
                    frame = 0;
                    zoombie = imagenes[frame];
                }
            } else {
                if (frame >= 0 && frame <= 20) {
                    zoombie = eat[frame];
                } else {
                    frame = 0;
                    zoombie = eat[frame];
                }
            }
            
            cambio++;
            if (cambio == 3) {
                frame++;
                cambio = 1;
            }
    }
    

    // colision
    public boolean colision() {
        // recirremos la matriz
        for (int i = 0; i < p.matriz.length; i++) {
            for (int j = 0; j < p.matriz[i].length; j++) {
                // siempre y que en la matriz sea diferente de 0 o que hay una planta checamos
                if (p.matriz[i][j] != 0) {
                    // si al restar la velocidad osea la posicion que va tener el zombie al moverse
                    // si es igual ala de una planta y menor osae que esta dentro como cuando
                    // seleccionamos algo en un menu > y < que el tamanio
                    if ((x - velocidad >= p.extraxIzq + (j * p.pixel))
                            && (x - velocidad <= p.extraxIzq + (j * p.pixel) + p.pixel / 2)) {
                        if (y == p.extraArriba + (i * p.pixel)) {// esto es en y
                            sonidoeat.clip.loop(Clip.LOOP_CONTINUOUSLY);// repoduce en loop
                            return true; // devuelve verdadero para saber que colisiono
                        }
                    }

                }
            }
        }
        return false;
    }

    // cargar las imagenes
  
public void cargarImagenes() {
    try {
        String path = "/Java/imagenes/plain_zombie/frame_";
        String eatPath = "/Java/imagenes/plain_zombie_eat/frame_";

        for (int i = 0; i <= 30; i++) {
            imagenes[i] = ImageIO.read(getClass().getResourceAsStream(path + String.format("%02d", i) + ".png"));
        }

        for (int i = 0; i <= 20; i++) {
            eat[i] = ImageIO.read(getClass().getResourceAsStream(eatPath + String.format("%02d", i) + ".png"));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
