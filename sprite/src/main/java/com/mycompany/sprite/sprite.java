/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aaron
 */
public class sprite {
        private Posicion posicion = new Posicion();
        private BufferedImage image;
        private int frame =0;
        private int width;
        private int heigth;
        int tw=1;
        int th=1;
        int pX,pY;
        
        public sprite(String spriteName ,int spriteWidth ,int spriteHeigth,int x,int y){
                try{
                    image=ImageIO.read(getClass().getResource(spriteName));
                    width=spriteWidth;
                    heigth=spriteHeigth;
                    tw=image.getWidth();
                    th=image.getHeight();
                    
                    pX=x;
                    pY=y;
                }catch(Exception e){
                    System.out.println("Error " + e.toString());
                }
        }
        
        public void  setFrame(int index){
            frame=index;
        }
        
        public void pintar(Graphics g){
            int x =posicion.x;
            int y= posicion.y;
            
            x+=pX;
            y+=pY;
            
            int i=frame%tw;
            int j=frame/tw;
            g.drawImage(image, x, y, x+width,
                                        y+heigth,i*width,
                                        j*heigth,(i*1)*width,
                                        (j+1)*heigth,null);
        }
        
        public void setPosicion(Posicion p){
            posicion.Set(p);
        }
        
        public void setPosicion(int x,int y){
            posicion.Set(x, y);
        }
        
        public int getWidth(){
            return width;
        }
        
        public int getHeigth(){
            return heigth;
        }
}
