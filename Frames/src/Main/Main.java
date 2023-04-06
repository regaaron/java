/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Main extends JFrame{
    
  
    Main(){
    Sprite sp= new Sprite(0,0);
    Sprite sp2= new Sprite(0,0);
    add(sp);
    add(sp2);
    this.setBackground(Color.white);
    this.setTitle("Cargando sprites");
    this.setSize(600,600);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setResizable(false);
   
    }
    public static void main(String[] args){
        Main demo1= new Main();
    }
}
