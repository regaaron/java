/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.boton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Boton extends JFrame implements ActionListener{

    JButton boton1;
    public Boton(){
            super("Boton");
            setLayout(null); //poner componentes atravez de las cordenadas
            boton1= new JButton("Cerrar");
            boton1.setFont(new Font("URW Gothic",Font.PLAIN,18));
            boton1.setBounds(300, 230, 100,30); //colocamos el boton y definimos su tamanio
            add(boton1); //agregar el boton para que se vea
            boton1.addActionListener(this);//esperando acccion
    }
    
    
    public static void main(String[] args) {
            Boton b = new Boton();
            b.setBounds(0,0,450,350); //colocar la posicion y el tamanio de la interfaz
            b.setVisible(true); //hace que sea visible
            b.setResizable(false); //para no poder cambiar el tamanio de la pantalla
            b.setLocationRelativeTo(null); //indica que inicie al centro de la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource() == boton1){ //si el evento corresponde a nuestro boton cierra la interfaz
            System.exit(0); //cerrar la interfaz grafica
        }
    }

    
}
