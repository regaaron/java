/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game;

/**
 *
 * @author aaron
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chuy
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.Graphics;

import java.awt.Graphics;

import java.io.IOException;

import java.awt.Graphics;

import java.awt.Graphics;

public class Sprite {
    //private 
    private Posicion posicion = new Posicion();
    private BufferedImage image;
    private int frame = 0;
    private int width;
    private int height;
    int tw=1;
    int th=1;
    int pX, pY;

    public Sprite(String spriteName, int spriteWidth, 
            int spriteHeight, int x, int y) {
        try {
            //image = ImageIO.read(ClassLoader.getSystemResourceAsStream(spriteName));
            image = ImageIO.read(
                  getClass().getResourceAsStream(
                    spriteName));
            width = spriteWidth;
            height = spriteHeight;
            tw = image.getWidth() / width;
            th = image.getHeight() / height;
            pX = x;
            pY = y;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void setFrame(int index) {
        frame = index;
    }
    
    public void pintar(Graphics g) {
        int x = posicion.x;
        int y = posicion.y;
        
        x += pX;
        y += pY;

        int i = frame % tw;
        int j = frame / tw;
        g.drawImage(image, x, y, x + width, 
                y + height, i * width, 
                j * height, (i + 1) * width, 
                (j + 1) * height, 
                null);
    }
    public void setPosicion(Posicion p) {
        posicion.Set(p);
    }
    public void setPosicion(int x, int y) {
        posicion.Set(x, y);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

