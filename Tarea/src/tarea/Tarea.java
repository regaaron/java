/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea;
import java.awt.*;
import javax.swing.*;
public class Tarea extends JFrame{
    
    public Tarea(){
        super("Tarea");
        setSize(800,800);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.drawRect(5,60,40,40);
        
        g.setColor(Color.CYAN);
        g.drawOval(50, 60, 40,40);
        
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
        g.fillOval(100,60,40,40);
        
        g.setColor( new Color((int)(Math.random()*256)));
        g.drawPolygon(new int[] {150,175,200}, new int[] {100,30,100}, 3);
        
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
        g.fillArc(230, 60,50, 50, 30, 300);
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));

        g.setFont(new Font("Serif",Font.BOLD,12));
        g.drawString("Serif 12 point bold.",5 , 120);
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));

        
        g.setFont(new Font ("Monospaced",Font.ITALIC,24));
        g.drawString("Monospaced 24 pont italic.",5,160);
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));

        g.setFont(new Font("SansSerif",Font.PLAIN,14));
        g.drawString("SanSerif 14 point plain .",5 ,200);
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
        
        g.setFont(new Font("Purisa", Font.PLAIN, 18));
        g.drawString("Purisa 18 pont plain",5, 240 );
        
        g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
        g.setFont(new Font("Mandali",Font.ROMAN_BASELINE,18));
        g.drawString("Mandali 18 pont Romas ", 5, 280);
        g.setColor(Color.red);
        g.fillPolygon(new int [] {40,80,120}, new int[] {360,310,360}, 3);
        g.setColor(new Color(51,  234, 255));
        g.fill3DRect(46, 360, 70, 60, false);
      
        g.setColor(Color.YELLOW);
        g.fillOval(54, 365, 20, 20);
        g.fillOval(86, 365, 20, 20);
        
        g.setColor(new Color(87,61,6));
        g.fillRect(70, 390, 20,30);
        g.setColor(Color.YELLOW);
        g.fillRect(72, 405, 2, 2);
        
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Tarea app = new Tarea();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
