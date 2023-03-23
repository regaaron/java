/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textfield;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.*;
public class Textfield extends JFrame implements ActionListener{
    private JTextField caja;
    private JButton boton1;
    private JLabel etiqueta1;
    private Font fuente= new Font("URW Gothic",Font.PLAIN,18);
    public Textfield(){
         Color color= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

        setLayout(null);
        etiqueta1 = new JLabel("Usiario");
        etiqueta1.setBounds(10,10,200,50);
        etiqueta1.setFont(fuente);
        etiqueta1.setForeground(Color.red);
        add(etiqueta1);
        
        caja = new JTextField();
        caja.setBounds(95,27,140,25);
        caja.setFont(fuente);
        add(caja);
        
        boton1 = new JButton("Aceptar");
        boton1.setBounds(10,80,150,30);
        boton1.setFont(fuente);
        boton1.setForeground(color);
        add(boton1);
        boton1.addActionListener(this);
        
        
        setBounds(0,0,300,150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Textfield formulario = new Textfield();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            String texto = caja.getText();
            setTitle(texto);
        }
    }
}
