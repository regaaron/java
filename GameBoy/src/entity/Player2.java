/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import GameBoy.GamePanel;
import GameBoy.KeyHandler;

/**
 *
 * @author aaron
 */
public class Player2 extends Player{
    
    public Player2(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
    }
    
    @Override
    public void update(){
          
        if(keyH.wPressed||keyH.aPressed||keyH.dPressed||keyH.sPressed){
            
        
        if (keyH.wPressed) {
            direction="up";
            y -= speed;
        } else if (keyH.sPressed) {
            direction="down";
            y += speed;
        } else if (keyH.dPressed) {
            direction="rigth";
            x += speed;
        } else if (keyH.aPressed) {
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
    
    @Override
    public void setDefaulValues(){
        x = 150;
        y = 100;
        speed = 6;
        direction="down";
    }
    
}
