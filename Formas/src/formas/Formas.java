/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formas;

import java.awt.*;
import java.awt.geom.AffineTransform.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.*;
import javax.swing.*;

public class Formas extends JFrame{
    public Formas(){
        super("Drawing 2d Fromas");
        setSize(425,160);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; //cast
        g2d.setPaint(new GradientPaint(5,30,Color.BLUE,35,100,Color.YELLOW,true));
        g2d.fill(new Ellipse2D.Double(5,30,65,100));
        
        
        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(10.0f));
        g2d.draw(new Rectangle2D.Double(80,30 ,65,100 ));
        
        BufferedImage buffimage = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        
        Graphics2D gg = buffimage.createGraphics();
        gg.setColor(Color.YELLOW);
        gg.fillRect(0,0,10,10);
        gg.setColor(Color.BLACK);
        gg.drawRect(1,1,6,6);
        gg.setColor(Color.BLUE);
        gg.fillRect(1,1,3,3);
        gg.setColor(Color.RED);
        gg.fillRect(4,4,3,3);
        
        
        g2d.setPaint(new TexturePaint(buffimage , new Rectangle(10,10)));
        
        g2d.fill(new RoundRectangle2D.Double(155,30,75,100,50,50));
        
        
        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(240,30,75,100,0,270,Arc2D.PIE));
        
        g2d.setPaint(Color.GREEN);
        g2d.draw(new Line2D.Double(395,30,320,150));
        
        float dashes[]={10};
        
        
        g2d.setPaint(Color.YELLOW);
        g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,0));
        g2d.draw(new Line2D.Double(320,30,395,150));
        
        
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        Formas app = new Formas();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
