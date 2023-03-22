/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.botones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Botones extends JFrame implements ActionListener {
    private JButton boton1;
    private JButton boton2; //botones
    private JButton boton3;
    private JLabel etiqueta1; //etiqueta 
    public Botones(){
        setLayout(null);
        boton1 = new JButton("1");
        Font  fuente = new Font("URW Gothic",Font.PLAIN,18);
        boton1.setFont(fuente);
        boton1.setBounds(10,100,90,30); //posicion y tamanio boton1 
        add(boton1); //agregamos ala interfaz
        boton1.addActionListener(this); //a la espera de un evento
        
        boton2= new JButton("2");
        boton2.setFont(fuente);
        boton2.setBounds(110, 100,90,30); //pisicion y tmanio
        add(boton2); //agregar ala iterfaz
        boton2.addActionListener(this); //espera de evento
        
        
        boton3 = new JButton("Salir");
        boton3.setFont(fuente);
        boton3.setBounds(210, 100, 90, 30);
        add(boton3);
        boton3.addActionListener(this);
        
        etiqueta1 = new JLabel("En espera");
        etiqueta1.setBounds(10,10,300,30);
        add(etiqueta1);
        
        setBounds(0,0,350,200); //tamanio de la interfaz
        setVisible(true);//que sea visible
        setResizable(false); //no poder ajustar el tamanio
        setLocationRelativeTo(null); //centrar la interfaz
        
    }
    
    public static void main(String[] args) {
        Botones b = new Botones();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {//funcion para los eventos
        if(e.getSource()==boton1){
                etiqueta1.setText("has precionado el boton 1");
        }
        
         if(e.getSource()==boton2){
                etiqueta1.setText("has precionado el boton 2");
        }
          if(e.getSource()==boton3){
                System.exit(0);
        }
    }

    
}
