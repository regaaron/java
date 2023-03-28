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
Color  color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    int[][] matriz; //matriz con la que se va atrabajar
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
    int[] pos; //vector de posiciones de la pelota 0 para y .... 1 para x
    boolean arriba, abajo, izq, der; //para comprobar las teclas precionadas
    Timer timer; //timer para delay 
int ANCHO,ALTO;
int pixel=25;
    public Laberinto() {
        int m = (int) (Math.random() * (3 - 1) + 1);
        
        

        matriz = ObtenerMatriz(0);//regresa una matriz
        
        pos = ObtenerPosicion(); //obtenemos posicion 0 para y y 1 para x
        ANCHO=pixel*matriz[1].length;
         ALTO=pixel*matriz.length;
                setPreferredSize(new Dimension(ANCHO, ALTO)); //tamanio de la pantalla
        //logica para teclado y un delay
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //logica para ir ala izq si pos[1] que es x es 0 no debe intentar ir ala izq ya que checaria con -1 y daria error de overflow 
                if ((izq) && (pos[1] != 0)) {
                    System.out.println("dentro");
                    //tambien checamos que la posicion ala izq sea un movimiento valido de ser asi cambiamos posicion y liberamos espacio libre
                    if (matriz[pos[0]][pos[1] - 1] != 1) {
                        matriz[pos[0]][pos[1] - 1] = 2;
                        
                        matriz[pos[0]][pos[1]] = 0;
                        pos[1] -= 1;
                        repaint(); //repintamos
                    }
                }
                //checamos der prendido y que no nos pasemos del limite en x de la matriz para no causar desboramiento
                if ((der) && (pos[1] != matriz[pos[0]].length-1)) {
                    //revisamos que no haya bloque a la derecha cambiamos posicion ,liberamos espacio libre y repintamos
                    if (matriz[pos[0]][pos[1] + 1] != 1) {
                        matriz[pos[0]][pos[1] + 1] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[1] += 1;
                        repaint();

                    }
                }
                //checamos que arriba este prendido y que pos[0]=y no sea 0 para que no de -1 y cause overflow
                if ((arriba) && (pos[0] != 0)) {
                    //checamos espacion libre de ser asi cambiamos posicion, libereamos espacio y repintamos
                    if (matriz[pos[0] - 1][pos[1]] != 1) {
                        matriz[pos[0] - 1][pos[1]] = 2;
                        matriz[pos[0]][pos[1]] = 0;
                        pos[0] -= 1;
                        repaint();

                    }
                }

                //checamos abajo prendido y que no nos pasemos del limite en y de la matriz para no causar desboramiento
                if ((abajo) && (pos[0]!=matriz[pos[0]].length-1)) {
                    
                    
                    //checamos espacion libre de ser asi cambiamos posicion, libereamos espacio y repintamos
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
        
        //logica para precionar teclas y poner el true las teclas
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

        setFocusable(true); //ala escucha de eventos

                        
    }
    //metodo para imprimir patriz
    public void imprimeMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[j][i] + ",");
            }
            System.out.println("");
        }
    }

    public void paint(Graphics g) {
        //color de fondo y ponemos el fondo
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, ANCHO, ALTO);
        
        //recorremos la matriz para ir poniendo lo que corresponda
       
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                //si es 1 pone un cloque 
                if (matriz[i][j] == 1) {
                   
           //         color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
                    g.setColor(color); 
                    g.fillRect(pixel * j, pixel * i, pixel, pixel);
                    g.setColor(Color.BLACK);
                    g.drawRect(pixel * j, pixel * i, pixel, pixel);
                }
                
                //si es 0 pone espacio en blanco
                if (matriz[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(pixel *j, pixel * i, pixel,pixel);
                    g.setColor(Color.black);
                    g.drawRect(pixel * j, pixel * i, pixel, pixel);

                }
                //si es 2 dibuja al personaje
                if (matriz[i][j] == 2) {
                    g.setColor(Color.red);
                    g.fillOval(j * pixel, i * pixel, pixel, pixel);
                    g.setColor(Color.black);
                    g.drawOval(j * pixel, i * pixel, pixel, pixel);

                    g.setColor(Color.white);
                    g.fillOval(j * pixel + 7, i * pixel + 8, 13, 13);
                    g.fillOval(j * pixel + 21, i * pixel + 8, 13, 13);
                    g.setColor(Color.black);
                    g.fillOval(j * pixel + 11, i * pixel + 12, 5, 5);
                    g.fillOval(j * pixel + 25, i * pixel + 12, 5, 5);

                    g.setColor(Color.black);
                    g.fillOval(j * pixel + 7, i * pixel + 24, 24, 7);

                }
                
                if(matriz[i][j] == 3){
                    g.setColor(Color.red);
                    g.drawLine(j*50, i*50,(j+1)*50,(i+1)*50);
                    g.drawLine((j)*50, (i+1)*50,(j+1)*50,i*50);
                      g.setColor(Color.black);
                    g.drawRect(50 * j, 50 * i, 50, 50);
                    System.out.println("j= "+j+"i= "+i);
                                        System.out.println("pos[0]= "+pos[0]+"pos(1)= "+pos[1]);

                    
                    
                    
                }
            }
        }

    }
    //corre todo el tiempo
    public void cicloPrincipalJuego() throws Exception {
        while (true) {

            repaint();

        }
    }
    //para redibujar
    public void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                paintImmediately(0, 0, 500, 500);
            }
        });
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "BIenvenido"
                + "\nEmpezemos"); //mensaje
        JFrame jf = new JFrame("Laberinto");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jf.setResizable(false);//no dejamos que cambie el tamanio
        Laberinto laberinto1 = new Laberinto();
        jf.getContentPane().add(laberinto1);
        jf.pack();
        jf.setVisible(true); //se hace visible 

    }
    //recorre la matriz en busca del 2 que es nuestro personaje para obtener la posicion en x y y
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
    // devuelve una matriz que sera el mapa
    private int[][] ObtenerMatriz(int i) {
        if(i==0){
            int [][] lab=
         {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 2, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0},
        {1,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1},
        {1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1,1,0,0,1}
        };
            matriz=lab;
        }
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
                    {1, 0, 3, 0, 0, 0, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
            matriz = lab;
        }

        if (i == 2) {
            int[][] lab = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 2, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 3, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1}
            };
            matriz = lab;
        }
        if (i == 3) {
            int[][] lab = {
                {1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
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
            matriz = lab;
        }

        return matriz;
    }

}
