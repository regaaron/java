/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sprite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Sprite extends JComponent{
    sprite uno ;
    Sprite(){
        setPreferredSize(new Dimension(500,500));
         this.setFocusable(true);
        this.setBackground(Color.black);
        uno = new sprite("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngwing.com%2Fen%2Ffree-png-plgdq&psig=AOvVaw1wur3Zx4SdoKdTr-trmqtV&ust=1680710493537000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCNCy6NHMkP4CFQAAAAAdAAAAABAJ",50,50,30,30);
        
        
    }
    
    public void paint(Graphics g){
                super.paintComponent(g);
                 setBackground(Color.red);
                 g.setColor(Color.BLACK);
                 //g.fillRect(0,0,500,500);
                 g.fillOval(40,40,30,30);
                 uno.pintar(g);
    }
    
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("Sprites");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        Sprite demo1 = new Sprite();
        jf.add(demo1);
        jf.setResizable(false);
        jf.pack();
        jf.setVisible(true);
    }
}
