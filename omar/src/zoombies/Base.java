package zoombies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Base {
    Plantas p;//creamos un objeto planta para pasarle mucha informacion de referencia

    Base(Plantas p) {
        this.p = p; //igualamos para tener una copia de la informacion pasada
                    //y poder referenciarla en los otros metodos
    }
    //dibujar 
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK); //color negro
        g.drawRect(0, 0, p.screenX, p.screenY); //colocamos un rectangulo negro 
                                                    //para estar repintando
        g.setColor(Color.red); 
        //imagen de fondo
        g.drawImage(p.back, 0, 0, p.screenX, p.screenY, p);
        //imagen del sol de puntos
        g.drawImage(p.score, p.extraxIzq + 10, 0, p.pixel - 10, p.pixel - 10, p);
        Font fuente = new Font("URW Gothic", Font.PLAIN, 28);
        g.setFont(fuente);//fuente para los puntos con tamanio de 28 y tipo de letra al gusto
        g.setColor(new Color(0xD9BD89)); //color para el rectangulo de puntos
        g.fillRect(p.extraxIzq+70, 25, p.pixel-30, p.pixel/3);//rectangulo de puntos
        g.setColor(Color.BLACK);//color negro
        //rectangulo negro esto le da contraste (se ve mejor)
        g.drawRect(p.extraxIzq+70, 25, p.pixel-30, p.pixel/3);
        //dibujamos los puntos
        g.drawString(p.puntos + "", p.extraxIzq + 80, 50);
        //dibujamos la pala
        g.drawImage(p.pala1,p.extraxIzq+150 , 15,p.pixel-20,p.pixel-40,p);
        //lo contratio a tag1 si esta desacticado solo lo dibujamos y si no
        //lo dibujamos mas a la derecha y vamos a dibijar la planta girazol
        //en donde este el mouse
        if (!p.tag1) {
            g.drawImage(p.mazo[0].imagen, 40, 15, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[0].imagen, 40 + 30, 15, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[0].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);
        }

        //lo mismo pero con la planta 2
        if (!p.tag2) {
            g.drawImage(p.mazo[1].imagen, 40, 15 + p.pixel, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[1].imagen, 40 + 30, 15 + p.pixel, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[1].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        //lo mismo pero con la planta 3
        if (!p.tag3) {
            g.drawImage(p.mazo[2].imagen, 40, 15 + p.pixel * 2, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[2].imagen, 40 + 30, 15 + p.pixel * 2, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[2].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        //lo mismo pero con la planta 4
        if (!p.tag4) {
            g.drawImage(p.mazo[3].imagen, 40, 15 + p.pixel * 3, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[3].imagen, 40 + 30, 15 + p.pixel * 3, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[3].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        //lo mismo pero con la planta 5
        if (!p.tag5) {
            g.drawImage(p.mazo[4].imagen, 40, 15 + p.pixel * 4, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[4].imagen, 40 + 30, 15 + p.pixel * 4, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[4].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        //lo mismo pero con la planta 6
        if (!p.tag6) {
            g.drawImage(p.mazo[5].imagen, 40, 15 + p.pixel * 5, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.mazo[5].imagen, 40 + 30, 15 + p.pixel * 5, p.pixel + 30, p.pixel, p);
            g.drawImage(p.plantas[(p.mazo[5].posicion)], p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }
       
        //si la pala esta activa dibuja la pala donde este el mouse 
      
        
        //dibuja los recuadros para dar una regerencia no es importante
        for (int i = 0; i <= p.row; i++) {
            g.setColor(Color.red);
            g.drawLine(p.extraxIzq, (i * p.pixel) + p.extraArriba, p.screenX - p.extraDer,(i * p.pixel) + p.extraArriba);

            for (int j = 0; j <= p.col; j++) {
                g.drawLine((j * p.pixel) + p.extraxIzq, p.extraArriba, (j * p.pixel) + p.extraxIzq, p.screenY - 30);
            }

        }
    }
}
