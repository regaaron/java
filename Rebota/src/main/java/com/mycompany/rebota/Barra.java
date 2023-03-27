/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rebota;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

/**
 *
 * @author aaron
 */
public class Barra extends JComponent{
    //posiciones
    public int x;
    public int y;
    //tamanio
    public final static int ANCHO=30;
    public final static int ALTO=60;

    /***
     * Constructor de la barra con una posicion en x y y aletoria
     * @param x Posicion en x 
     */
    Barra(int x){
        this.x=x;
        this.y=(int)(Math.random()*(600-60+1)+60);
    }
    
}
