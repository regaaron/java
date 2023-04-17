/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author aaron
 */
public class Toy {

    BufferedImage img;

    int ancho;
    int alto;
    Examen pantalla;
    int x;
    int y;
    boolean pressed = false;
    String nombre;
    boolean mostrar = true;
    String tag;
    int prevx;
    int prevy;
    BackgroundSound sound1,sound2;
    boolean dentro=false;
    int numero;
    
 

    Toy(Examen pantalla, int ancho, int alto, String nombre, String tag) {
        this.pantalla = pantalla;
        Random rand = new Random();
        x = rand.nextInt((this.pantalla.ANCHO - 100 + 1) - 100) + 100;
        y = rand.nextInt((this.pantalla.ALTO - 250 + 1) - 100) + 100;
        prevx = x;
        prevy = y;
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
        this.tag = tag;
        numero=pantalla.numero++;
        sound1=new BackgroundSound("/resources/error.wav");
        sound2= new BackgroundSound("/resources/bien.wav");
        cargarImagen();
    }

    public boolean sobre(MouseEvent e) {

        if (e.getX() > this.x + 10 && e.getX() <= this.x + this.ancho - 10 && e.getY() > this.y + 10 && e.getY() < this.y + this.alto - 10) {
            return true;
        } else {
            return false;
        }

    }

    public void dentro() {
        if (this.x > 100 - ancho / 2 && this.x < 202 && this.y > 440 - alto / 2 & this.y < 500) {
            if (tag == "Ropa"&&numero==pantalla.orden) {
                
                this.mostrar = false;
                x = -100;
                y = -100;
                this.pantalla.puntos += 10;
                this.pantalla.orden++;
                sound2.clip.start();
                dentro=true;
                
            } else {
             sound1.clip.start();
             x = prevx;
                y = prevy;
                this.pantalla.puntos -= 10;
                
            }

        }
        if (this.x > 274 - ancho / 2 && this.x < 364 && this.y > 440 - alto / 2 & this.y < 500) {
            if (tag == "pelota"&&numero==pantalla.orden) {
                this.mostrar = false;
                x = -100;
                y = -100;
                this.pantalla.puntos += 10;
                this.pantalla.orden++;
                 sound2.clip.start();
                 dentro=true;
            } else {
                sound1.clip.start();
                x = prevx;
                y = prevy;
                this.pantalla.puntos -= 10;
                
            }
        }

        if (this.x > 422 - ancho / 2 && this.x < 522 && this.y > 440 - alto / 2 & this.y < 500) {
            if (tag == "Carro"&&numero==pantalla.orden) {
                this.mostrar = false;
                x = -100;
                y = -100;
                this.pantalla.puntos += 10;
                this.pantalla.orden++;
                 sound2.clip.start();
                 dentro=true;
            } else {
               sound1.clip.start();
               x = prevx;
                y = prevy;
                this.pantalla.puntos -= 10;
                
            }
        }
        if (this.x > 576 - ancho / 2 && this.x < 670 && this.y > 440 - alto / 2 & this.y < 500) {
            if (tag == "juguete"&&numero==pantalla.orden) {
                this.mostrar = false;
                x = -100;
                y = -100;
                this.pantalla.puntos += 10;
                this.pantalla.orden++;
                 sound2.clip.start();
                 dentro=true;
            } else {
              sound1.clip.start();
              x = prevx;
                y = prevy;
                this.pantalla.puntos -= 10;
                
            }
        }
        if (this.x > 729 - ancho / 2 && this.x < 821 && this.y > 440 - alto / 2 & this.y < 500) {
            if (tag == "videojuego"&&numero==pantalla.orden) {
                this.mostrar = false;
                x = -100;
                y = -100;
                this.pantalla.puntos += 10;
                this.pantalla.orden++;
                 sound2.clip.start();
                 dentro=true;
            } else {
                sound1.clip.start();
                x = prevx;
                y = prevy;
                this.pantalla.puntos -= 10;
                
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (mostrar) {
                        Font fuente = new Font("Arial", Font.PLAIN, 18);

            g2.setFont(fuente);
            g2.drawString(numero+"", x+ancho/2, y-10);
            g2.drawImage(img, x, y, ancho, alto, pantalla);
        }

    }

    public void cargarImagen() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream(nombre));
        } catch (IOException ex) {
            Logger.getLogger(Toy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mover(MouseEvent e) {
        if (this.sobre(e)) {
            if (this.pressed) {
                this.x = e.getX() - this.ancho / 2;
                this.y = e.getY() - this.alto / 2;
            }
        }
    }

    public void press(MouseEvent e) {
        if (this.sobre(e)) {
            this.pressed = true;
        }
    }

}
