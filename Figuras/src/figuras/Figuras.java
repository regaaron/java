/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras;

import java.awt.*;
import javax.swing.*;
public class Figuras extends JFrame{

   public Figuras(){
       super("Draw Lines, rectangles and ovals");
       
       setSize(400,400);
       setVisible(true);
   }
   
   public void paint(Graphics g){
       super.paint(g);
       
       g.setColor(Color.BLACK);
       g.drawLine(30,30,350,60);
       g.drawRect(5, 30, 50, 70);
       g.fillRect(100,40, 90, 55);
       
       g.setColor(Color.CYAN);
       g.fillRoundRect(195,40 ,90 ,55 ,50 ,50 );
       g.drawRoundRect(290,40,90,55,20,20);
       
       g.setColor(new Color(0, 255, 0));
       g.draw3DRect(5,100 ,90 ,55 ,true);
       g.fill3DRect(100,100,90,55,true);
   
       
       g.setColor(Color.MAGENTA);
       g.drawOval(195,100 ,90 ,55 );
       g.fillOval(290,100 ,90 , 55);
   
   }   
    public static void main(String[] args) {
        Figuras app = new Figuras();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
