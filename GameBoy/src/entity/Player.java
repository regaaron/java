/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import GameBoy.GamePanel;
import GameBoy.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aaron
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaulValues();
        getPlayerImage();
    }

    public void setDefaulValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction="down";
    }
    public void getPlayerImage(){
        try{
                up1=ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
                up2=ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
                down1=ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
                down2=ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
                left1=ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
                left2=ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
                rigth1=ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
                rigth2=ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
               
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        
        if(keyH.upPressed||keyH.leftPressed||keyH.rigthPressed||keyH.downPressed){
            
        
        if (keyH.upPressed) {
            direction="up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction="down";
            y += speed;
        } else if (keyH.rigthPressed) {
            direction="rigth";
            x += speed;
        } else if (keyH.leftPressed) {
            direction="left";
            x -= speed;
        }
        
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image =null;
        switch(direction){
            case "up": 
                if(spriteNum==1){
                    image=up1;
                }
                if(spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                     image=down1;
                }
               if(spriteNum==2){
                   image=down2;
               }
                break;
            case "left": 
                if(spriteNum==1){
                      image=left1;
                }
              if(spriteNum==2){
                  image=left2;
              }
                break;
            case "rigth":
                if(spriteNum==1){
                    image=rigth1;
                }
                if(spriteNum==2){
                    image=rigth2;
                }
                break;
        }
         g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
         //g2.fillOval(x, y, gp.tileSize, gp.tileSize);
    }
}
