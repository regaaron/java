/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author aaron
 */
public class Sprite extends JPanel implements Runnable{
Image image;
Thread thread;
boolean go=true;
int img=0;
    ImageIcon ii;
    int cnt=0;
    int posX,posY;

    
    public Sprite(int x,int y){
        posX=x;
        posY=y;
        
        ii=new ImageIcon(new javax.swing.ImageIcon("/home/aaron/2d/boy_down_1.png").getImage());
        image=ii.getImage();
        thread= new Thread(this);
        thread.start();
        
        
    }
    
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 600,600);
        g2d.drawImage(image, cnt+posX,0+posY ,40,40,this);
        System.out.println("pintando: " +img);
    }
    @Override
    public void run() {
       while(go){
           try{
               thread.sleep(10);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
           if(img==0){
               ii= new ImageIcon(new javax.swing.ImageIcon("/home/aaron/2d/boy_right_1.png").getImage());
               img=1;
           }else{
               ii= new ImageIcon(new javax.swing.ImageIcon("/home/aaron/2d/boy_right_2.png").getImage());
               img=0;
           }
           image=ii.getImage();
           System.out.println("pintando: "+img);
           repaint();
           cnt++;
       }
    }
    
}
