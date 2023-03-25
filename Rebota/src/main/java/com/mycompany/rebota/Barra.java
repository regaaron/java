/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rebota;

/**
 *
 * @author aaron
 */
public class Barra {
    public int x;
    public int y;
    public final static int ANCHO=30;
    public final static int ALTO=60;
    Barra(int x){
        this.x=x;
        this.y=(int)Math.random()*(600-60+1)+60;
    }
}
