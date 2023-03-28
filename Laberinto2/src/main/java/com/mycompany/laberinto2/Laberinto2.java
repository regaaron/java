/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laberinto2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aaron
 */
public class Laberinto2 extends JPanel{
    Laberinto laberinto= new Laberinto();
    Pelota personaje = new Pelota();
     static int level =1;

    public Laberinto2() {
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPrecionada(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
    
    
        });
        
        
        setFocusable(true);
    }
     
    public void paint(Graphics g){
        laberinto.paint(g);
        personaje.paint(g);
    }
     
    public static int CabiaLevel(){
        return level++;
    }
    
    public static int obtieneNivel(){
        return level;
    }
public void CicloJuego(){
    while(true){
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            System.out.println(e.toString());
        }
        repaint();
        
        if(obtieneNivel()>3){
            JOptionPane.showMessageDialog(null,"Fin");
            System.exit(0);
        }
        
    }
}
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Emoezemos");
        JFrame Ventana = new JFrame("Laberinto");
        Laberinto2 game = new Laberinto2();
        Ventana.add(game);
        Ventana.setBounds(0,0,500,550);
        Ventana.setVisible(true);
        
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       game.CicloJuego();
       
    }
}
