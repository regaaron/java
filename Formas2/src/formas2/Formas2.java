/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formas2;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class Formas2 extends JFrame{
    
    public Formas2(){
       super("Drawing 2d Formas");
       setSize(400,400);  
       setVisible(true);
    } 
   
    public void paint(Graphics g){
        super.paint(g);
         int xPoints[] = {55,67,10,73,83,55,27,37,1,43};
         int yPoints[]={0,36,36,54,96,72,96,54,36,36};
         
         Graphics2D g2d = (Graphics2D) g;
         GeneralPath star= new GeneralPath();
         
         star.moveTo(xPoints[0],yPoints[0]);
         
         
         for(int count=1;count<xPoints.length;count++)
             star.lineTo(xPoints[count], yPoints[count]);
             
             
             star.closePath();
             
             g2d.translate(200, 200);
             
        for(int count=1;count<=20;count++){
            
            g2d.rotate(Math.PI/10.0);
            
            g2d.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
            
            
            g2d.fill(star);
        }
         
    
    }
    public static void main(String[] args) {
        Formas2 app = new Formas2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
