/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author aaron
 */
public class Game extends JPanel implements ActionListener{
    //pantalla 
    static final int PANTALLA=600;
    final static int CUADRITO_SIZE=25;
    final static int CUADRITOS_EN_PARALELO=(int)PANTALLA/CUADRITO_SIZE;
    //serpiente
    static final int CUADROS=(PANTALLA*PANTALLA)/CUADRITO_SIZE;
    int [] serpienteX = new int [CUADROS];
    int [] serpienteY = new int[CUADROS];
    int cuerpo=3;
    char direccion='d'; //wasd
    
    //comida
    int comidax;
    int comiday;
    //timer
    static final int DELAY=70;;
    Timer timer;
    boolean running=true;
    //otros
    Random random = new Random();
    
    Game(){
        this.setPreferredSize(new Dimension(PANTALLA,PANTALLA));
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.addKeyListener(new Controles());
        this.iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(running){
            moverSerpiente();
            checarComida();
            checarColisiones();
        }
        
        repaint();
        
    }
    @Override
     public void paint(Graphics g){
         super.paintComponent(g);
         g.setColor(Color.gray);
        /*
         for(int i=0;i<CUADRITOS_EN_PARALELO;i++){
             g.drawLine(0,CUADRITO_SIZE*i, PANTALLA, CUADRITO_SIZE*i);
             g.drawLine(CUADRITO_SIZE*i,0, CUADRITO_SIZE*i, PANTALLA);

         }
*/
         g.setColor(Color.red);
         g.fillOval(comidax, comiday, CUADRITO_SIZE,CUADRITO_SIZE);
         g.setColor(Color.GREEN);
         for(int i=0;i<cuerpo;i++){
             g.fillRect(serpienteX[i], serpienteY[i], CUADRITO_SIZE,CUADRITO_SIZE);
         }
         
     }
    public void iniciar(){
        comida();
        timer=new Timer(DELAY,this);
        timer.start();
    }
    
    public void comida(){
        comidax=random.nextInt(CUADRITOS_EN_PARALELO)*CUADRITO_SIZE;
        comiday=random.nextInt(CUADRITOS_EN_PARALELO)*CUADRITO_SIZE;
        
    }
    public void moverSerpiente(){
        for(int i=cuerpo; i>0;i--){
            serpienteX[i]=serpienteX[i-1];
            serpienteY[i]=serpienteY[i-1];
        }
        switch(direccion){
            case 'd':    serpienteX[0]=serpienteX[0]+CUADRITO_SIZE;
                            break;
            case 'a': serpienteX[0]=serpienteX[0]-CUADRITO_SIZE;
                        break;
            case 'w': serpienteY[0]=serpienteY[0]-CUADRITO_SIZE;
                break;
                case 's': serpienteY[0]=serpienteY[0]+CUADRITO_SIZE;
                break;
        }
    }
    
    public void checarComida(){
        if(serpienteX[0]==comidax&&serpienteY[0]==comiday){
            cuerpo++;
            comida();
        }
    }
    
    public void checarColisiones(){
        if(serpienteX[0]<0){
            running=false;
        }
        
        if(serpienteY[0]<0){
            running=false;
        }
        
        if(serpienteX[0]>PANTALLA-CUADRITO_SIZE){
            running=false;
        }
        if(serpienteY[0]>PANTALLA-CUADRITO_SIZE){
            running=false;
        }
        
        for(int i=0;i<cuerpo;i++){
            
                if(serpienteX[0]==serpienteX[i]){
                    System.out.println("pierdes");
                }
                if(serpienteY[0]==serpienteY[i]){
                                        System.out.println("pierdes");

                
            }
        }
    }
    
    
    
    
    public class Controles extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyChar()){
                case 'w': direccion='w';
                    break;
                         case 's': direccion='s';
                    break;
                         case 'a': direccion='a';
                    break;
                         case 'd': direccion='d';
                    break;
                    
            }
        }
    }
    
}
