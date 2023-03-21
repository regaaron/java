/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arcos;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author aaron
 */
public class Arcos extends JFrame{

    public Arcos(){
     super("Drawing arcs");
     
     setSize(300,170);
     setVisible(true);
    }
    
    
    public void paint(Graphics g){
        
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.drawRect(15,35,80,80 );
        g.setColor(Color.BLACK);
        g.drawArc(15,35,80,80,0,360);
        
        g.setColor(Color.YELLOW);
        g.drawRect(100,35,80,80);
        g.setColor(Color.BLACK);
        g.drawArc(100,35,80,80,0,110);
        
        g.setColor(Color.yellow);
        g.drawRect(185,35,80,80);
        g.setColor(Color.BLACK);
        g.drawArc(185,35,80,80,0,-270);
        
        
        
        g.fillArc(15,120,80 ,40,0,360 );
        
        
        g.fillArc(100,120,80,40,270,-90);
        
        g.fillArc(185,120,80,40,0,-270);
        
        
        
    }
    public static void main(String[] args) {
        Arcos app = new Arcos();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
