/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fonts;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author aaron
 */
public class Fonts extends JFrame{
    public Fonts(){
        super("Using Fonts");
        setSize(420,125);
        setVisible(true);
        
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        
        g.setFont(new Font("Serif",Font.BOLD,12));
        g.drawString("Serif 12 point bold.", 20, 50);
        
        
        g.setFont(new Font ("Monospaced",Font.ITALIC,24));
        g.drawString("Monospaced 24 pont italic.", WIDTH, WIDTH);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
