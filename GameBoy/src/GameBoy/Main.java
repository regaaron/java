package GameBoy;


import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class Main {
    
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adeventure");
        GamePanel gampanel = new GamePanel();
        window.add(gampanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gampanel.startGameThread();
    }
}
