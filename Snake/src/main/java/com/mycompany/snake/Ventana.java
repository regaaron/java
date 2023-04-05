/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Ventana extends JFrame{
    final static int ANCHO=600;
    final static int ALTO=600;
    Ventana(){
        super("Snake Game");
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Game());
        this.pack();
          this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
