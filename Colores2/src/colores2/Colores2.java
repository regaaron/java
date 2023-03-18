/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colores2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Colores2 extends JFrame{
private JButton changeColorButton;
private Color color = Color.LIGHT_GRAY;
private Container container;
    

public Colores2(){
    super("Using JColorChooser");
    
    container = getContentPane();
    container.setLayout(new  FlowLayout());
    
    //set up changeColorButton and register its event handler
    changeColorButton = new JButton("Change Color");
    changeColorButton.addActionListener(
    new ActionListener() {//anonymous inner class
        
        //display JColorChooser when user clicks button
        @Override
        public void actionPerformed(ActionEvent e) {
           color =JColorChooser.showDialog(
                   Colores2.this,"Chose a color", color);
           
           if(color == null )
               color = Color.lightGray;
           
           container.setBackground(color);
        }
    }   //end anonymous inner class
    );//end call to addActionListener
    
    container.add(changeColorButton);
    setSize(400,130);
    setVisible(true);

}
    public static void main(String[] args) {
        Colores2 application = new Colores2();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
