/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laberinto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author aaron
 */
public class Laberinto extends JComponent {

    int[][] matriz;
    /*
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 2, 0, 0, 1, 1, 0, 0, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
        {0, 0, 1, 1, 0, 1, 0, 1, 1, 0},
        {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 0, 1, 0, 1, 0, 1, 1, 0, 1},
        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0}};
     */
    int[] pos;
    boolean arriba, abajo, izq, der;
    Timer timer;

    public Laberinto() {
        setPreferredSize(new Dimension(500, 500));
        matriz = ObtenerMatriz(1);
        pos = ObtenerPosicion();

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("pos[0] = " + pos[0]); //y
                System.out.println("pos[1] = " + pos[1]);//x
                //System.out.println(izq);
                if ((izq) && (pos[1] != 0)) {
                    System.out.println("dentro");
                    if (matriz[pos[0]][pos[1] - 1] != 1) {
                        matriz[pos[0]][pos[1] - 1] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[1] -= 1;
                        // imprimeMatriz();
                        repaint();
                    }
                }
                System.out.println("tamanio de matriz[0]=" + matriz[pos[0]].length);
                if ((der) && (pos[1] < matriz[pos[0]].length)) {
                    System.out.println("der");
                    if (matriz[pos[0]][pos[1] + 1] != 1) {
                        matriz[pos[0]][pos[1] + 1] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[1] += 1;
                        repaint();

                    }
                }

                if ((arriba) && (pos[0] != 0)) {
                    System.out.println("ariba");
                    if (matriz[pos[0] - 1][pos[1]] != 1) {
                        matriz[pos[0] - 1][pos[1]] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[0] -= 1;
                        repaint();

                    }
                }

                if ((abajo) && (pos[0] < matriz[pos[0]].length)) {
                    System.out.println("abajo");
                    if (matriz[pos[0] + 1][pos[1]] != 1) {
                        matriz[pos[0] + 1][pos[1]] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[0] += 1;
                        repaint();
                    }
                }

            }
        });
        timer.start();
        addKeyListener(new KeyAdapter() {

            //si se preciona una tecla envia verdadero y el codigo de la 
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }

            //Si se preciona una tecla envia falso asi dejara de hacer el movimiento
            public void keyReleased(KeyEvent e) {
                actualiza(e.getKeyCode(), false);
            }

            //en caso de que la tecla se este precionando pasa true y el codigo de teclado 
            private void actualiza(int keyCode, boolean pressed) {

                switch (keyCode) {
                    case KeyEvent.VK_UP: //caso aariba
                        arriba = pressed;
                        break;
                    case KeyEvent.VK_DOWN: //caso abajo
                        abajo = pressed;
                        break;
                    case KeyEvent.VK_LEFT: //caso W
                        izq = pressed;
                        System.out.println("izq");
                        break;
                    case KeyEvent.VK_RIGHT: //caso S
                        der = pressed;
                        break;
                }
            }

        });

        setFocusable(true);

    }

    public void imprimeMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[j][i] + ",");
            }
            System.out.println("");
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == 1) {
                    g.setColor(new Color(255, 0, 255));
                    g.fillRect(50 * j, 50 * i, 50, 50);
                    g.setColor(Color.BLACK);
                    g.drawRect(50 * j, 50 * i, 50, 50);
                }
                if (matriz[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(50 * j, 50 * i, 50, 50);
                    g.setColor(Color.black);
                    g.drawRect(50 * j, 50 * i, 50, 50);

                }

                if (matriz[i][j] == 2) {
                    g.setColor(Color.red);
                    g.fillOval(j * 50, i * 50, 50, 50);
                    g.setColor(Color.black);
                    g.drawOval(j * 50, i * 50, 50, 50);

                    g.setColor(Color.white);
                    g.fillOval(j * 50 + 7, i * 50 + 8, 13, 13);
                    g.fillOval(j * 50 + 21, i * 50 + 8, 13, 13);
                    g.setColor(Color.black);
                    g.fillOval(j * 50 + 11, i * 50 + 12, 5, 5);
                    g.fillOval(j * 50 + 25, i * 50 + 12, 5, 5);

                    g.setColor(Color.black);
                    g.fillOval(j * 50 + 7, i * 50 + 24, 24, 7);

                }
            }
        }

    }

    public void cicloPrincipalJuego() throws Exception {
        while (true) {

            repaint();

        }
    }

    public void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                paintImmediately(0, 0, 500, 500);
            }
        });
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "BIenvenido/nEmpezemos");
        JFrame jf = new JFrame("Laberinto");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jf.setResizable(false);
        //Rebota demo1 = new Rebota();
        Laberinto laberinto1 = new Laberinto();
        jf.getContentPane().add(laberinto1);
        jf.pack();
        jf.setVisible(true);

    }

    private int[] ObtenerPosicion() {
        int[] posicionObjeto = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 2) {
                    posicionObjeto[0] = i;//0=y
                    posicionObjeto[1] = j;//1=x
                    break;
                }
            }
        }
        return posicionObjeto;
    }

    private int[][] ObtenerMatriz(int i) {

        if (i == 1) {
            int[][] lab
                    = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 0, 2, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                    {1, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
 matriz=lab;
        }

        if (i == 2) {
            int[][] lab = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 2, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
             matriz=lab;
        }
            if (i == 3) {
                int[][] lab = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                    {1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                    {1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                    {1, 0, 2, 0, 0, 0, 0, 0, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
                        matriz=lab;
            }
       
        return matriz;
    }

}
