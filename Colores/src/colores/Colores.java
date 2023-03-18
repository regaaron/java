/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colores;

/**
 *
 * @author aaron
 */

import java.awt.*;
import javax.swing.*;
public class Colores extends JFrame{

   public Colores(){
    super("Using colors");
   
       setSize(450,165);
       setVisible(true);
    }
   
   public void paint (Graphics g){
       super.paint(g);
       
       g.setColor(new Color(255, 0, 0));
       g.fillRect(25, 50, 100,20);
       g.drawString("Current RGB: "+ g.getColor(),130,65);
       
       g.setColor(new Color(0.0f, 1.0f, 0.0f));
       g.fillRect(25, 75, 100, 20);
       g.drawString("Current RGB: "+ g.getColor(),130,90);
       
       //set new drawing color using static color objects
       g.setColor(Color.BLUE);
       g.fillRect(25, 100, 100, 20);
       g.drawString("Current RGB: "+ g.getColor(),130,115);
       
       
       //display individual RGB values
       Color color = Color.MAGENTA;
       g.setColor(color);
       g.fillRect(25,125,100,20);
       g.drawString("RGB values" + color.getRed() + ',' +color.getGreen()+","+color.getBlue()
                , 130,140 );
   
   }
    public static void main(String[] args) {
        // TODO code application logic here
        Colores application = new Colores();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        //application.Paint(g);
    }
    
}
