/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poligonos;

import java.awt.*;
import javax.swing.*;
public class Poligonos extends JFrame{

    public Poligonos(){
        super("Drawing Poligons");
        setSize(275,230);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        
        int xValues[]={20,40,50,30,20,15};
        int yValues []={50,50,60,80,80,60};
        Polygon poligon1 = new Polygon(xValues,yValues,6);
        g.setColor(Color.red);
        g.drawPolygon(poligon1);
        
        
        int xValues2[] = { 70, 90, 100, 80, 70, 65, 60 };
        int yValues2[] = { 100, 100, 110, 110, 130, 110, 90 };
        g.setColor(Color.GREEN);
        g.drawPolygon(xValues2, yValues2, 7);
        
        int xValues3[] = { 120, 140, 150, 190 };
        int yValues3[] = { 40, 70, 80, 60 }; 
        
        g.setColor(Color.PINK);
        g.fillPolygon(xValues3, yValues3, 4);
        
        Polygon poligon2 = new Polygon();
        poligon2.addPoint(165, 135);
        poligon2.addPoint( 175, 150 );
 poligon2.addPoint( 270, 200 );
 poligon2.addPoint( 200, 220 );
 poligon2.addPoint( 130, 180 );
    g.setColor(Color.BLUE);
 g.fillPolygon(poligon2);
        
    }
    public static void main(String[] args) {
        Poligonos app = new Poligonos();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
