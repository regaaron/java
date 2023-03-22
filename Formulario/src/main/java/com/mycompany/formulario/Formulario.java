/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.formulario;
import java.awt.Font;
import javax.swing.*;
public class Formulario extends JFrame{
    private JLabel label1;
    private JLabel label2;
    public Formulario(){
        super("Hola Mundo");
        setLayout(null);
        Font fuente = new Font("Z003",Font.PLAIN,18) ;
        
        label1 = new JLabel("Interfaz grafica.");
        label1.setBounds(10,20,300,30);
        add(label1);
        
        label2 = new JLabel("Verion 1.0");
        label2.setBounds(10,100,100,30);
        add(label2);
        label1.setFont(new Font("Z003",Font.PLAIN,18));
        label2.setFont(fuente);
        setBounds(0, 0,500,250);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
    }
    
    public static void main(String[] args) {
        Formulario formulario1 = new Formulario();
      
       
    }
}
