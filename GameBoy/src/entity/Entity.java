/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author aaron
 */
public class Entity {
    public int worldX,worldY;
    public int speed;
    
    public BufferedImage up1,up2,down1,down2,left1,left2,rigth1,rigth2;
    public String direction;
    
    public int spriteCounter=0;
    public int spriteNum=1;
    
    public Rectangle  solidArea;
    public boolean colisionOn =false;
}
