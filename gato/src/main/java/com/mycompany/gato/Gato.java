/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gato;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author aaron
 */
public class Gato extends JComponent {
    //definimos ancho alto y tamnio del cuadro
    final static int ANCHO = 500;
    final static int ALTO = 500;
    int CUADRO = ANCHO / 3;
    //matriz del gato
    int[][] matriz = 
    {{0, 0, 0},
    {0, 0, 0},
    {0, 0, 0}};
    //turno del jugador
    int turno = 1;
    int x, y; //posicion del mouse
    int c1,c2; //contador de puntos
    /***
     * Coloca en 0 todas las posiciones de la matriz para asi poder reiniciar y luego repinta
     */
    public void Reinicio() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
        repaint(); 
    }

    Gato() {
        //colocamos la pantalla
        setPreferredSize(new Dimension(ANCHO, ALTO));
        //eventos del teclado
        addMouseListener(new MouseAdapter() {

            @Override//si es click derecho 
            public void mouseClicked(MouseEvent evetno) {
                if (evetno.isMetaDown()) {

                } else { //si es click izq
                    //obtenemos y y x del mouse
                    x = evetno.getX();
                    y = evetno.getY();

                    //1er cuadrante 00
                    if (x > 0 && x < CUADRO && y > 0 && y < CUADRO) {
                        if (matriz[0][0] == 0) {
                            if (turno == 1) {
                                matriz[0][0] = 1;
                                turno = 2;
                            } else {
                                matriz[0][0] = 2;
                                turno = 1;
                            }
                        }
                    }
                    //cuadrante 2 01
                    if (x > CUADRO && x < CUADRO * 2 && y > 0 && y < CUADRO) {
                        if (matriz[0][1] == 0) {
                            if (turno == 1) {
                                matriz[0][1] = 1;
                                turno = 2;
                            } else {
                                matriz[0][1] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 3 02
                    if (x > CUADRO * 2 && x < CUADRO * 3 && y > 0 && y < CUADRO) {
                        if (matriz[0][2] == 0) {
                            if (turno == 1) {
                                matriz[0][2] = 1;
                                turno = 2;
                            } else {
                                matriz[0][2] = 2;
                                turno = 1;
                            }
                        }
                    }
                    //cuadrante 4 10
                    if (x > 0 && x < CUADRO && y > CUADRO && y < CUADRO * 2) {
                        if (matriz[1][0] == 0) {
                            if (turno == 1) {
                                matriz[1][0] = 1;
                                turno = 2;
                            } else {
                                matriz[1][0] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 5 11
                    if (x > CUADRO && x < CUADRO * 2 && y > CUADRO && y < CUADRO * 2) {
                        if (matriz[1][1] == 0) {
                            if (turno == 1) {
                                matriz[1][1] = 1;
                                turno = 2;
                            } else {
                                matriz[1][1] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 6 12
                    if (x > CUADRO * 2 && x < CUADRO * 3 && y > CUADRO && y < CUADRO * 2) {
                        if (matriz[1][2] == 0) {
                            if (turno == 1) {
                                matriz[1][2] = 1;
                                turno = 2;
                            } else {
                                matriz[1][2] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 7 20
                    if (x > 0 && x < CUADRO && y > CUADRO * 2 && y < CUADRO * 3) {
                        if (matriz[2][0] == 0) {
                            if (turno == 1) {
                                matriz[2][0] = 1;
                                turno = 2;
                            } else {
                                matriz[2][0] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 8 21
                    if (x > CUADRO && x < CUADRO * 2 && y > CUADRO * 2 && y < CUADRO * 3) {
                        if (matriz[2][1] == 0) {
                            if (turno == 1) {
                                matriz[2][1] = 1;
                                turno = 2;
                            } else {
                                matriz[2][1] = 2;
                                turno = 1;
                            }
                        }
                    }

                    //cuadrante 9 22
                    if (x > CUADRO * 2 && x < CUADRO * 3 && y > CUADRO * 2 && y < CUADRO * 3) {
                        if (matriz[2][2] == 0) {
                            if (turno == 1) {
                                matriz[2][2] = 1;
                                turno = 2;
                            } else {
                                matriz[2][2] = 2;
                                turno = 1;
                            }
                        }
                    }

                }
                //repintamos y llamamos a logica para saber si ya se gano 
                //se repinta cada que se hace un movimiento no tiene caso repintar cada cierto tiempo en segundos
                repaint();
                logica();
            }

        });

    }

    public void logica() {
           //coloco funtes para los mensajes 
            Font font = new Font("URW Gothic", Font.BOLD, 24);
            UIManager.put("OptionPane.messageFont", font);

            
            //logica para saber si gano o hay empate imprime quien gana y llama a la funcion reinicio para reinciar el juego 
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != 0) {
            System.out.println(matriz[0][0] + " ganó!");
            if (matriz[0][0] == 2) {
                c1++;
                JOptionPane.showMessageDialog(null, "Felicidades Gano X\n"+c1+"-"+c2);
            } else {
                c2++;
                JOptionPane.showMessageDialog(null, "Felicidades Gano O\n"+c1+"-"+c2);

            }
            Reinicio();
        } else if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] != 0) {
            System.out.println(matriz[0][2] + " ganó!");
            if (matriz[0][2] == 2) {
                c1++;
                JOptionPane.showMessageDialog(null, "Felicidades Gano X\n"+c1+"-"+c2);
            } else {
                c2++;
                JOptionPane.showMessageDialog(null, "Felicidades Gano O\n"+c1+"-"+c2);

            }
            Reinicio();

        } else {
            for (int i = 0; i < 3; i++) {
                if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != 0) {
                    System.out.println(matriz[i][0] + " ganó!");
                    if (matriz[i][0] == 2) {
                        c1++;
                        JOptionPane.showMessageDialog(null, "Felicidades Gano X\n"+c1+"-"+c2);
                    } else {
                        c2++;
                        JOptionPane.showMessageDialog(null, "Felicidades Gano O\n"+c1+"-"+c2);

                    }
                    Reinicio();

                    return;
                }

                if (matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] != 0) {
                    System.out.println(matriz[0][i] + " ganó!");

                    if (matriz[0][i] == 2) {
                        c1++;
                        JOptionPane.showMessageDialog(null, "Felicidades Gano X\n"+c1+"-"+c2);
                    } else {
                        c2++;
                        JOptionPane.showMessageDialog(null, "Felicidades Gano O\n"+c1+"-"+c2);

                    }
                    Reinicio();

                    return;
                }
            }
            //si recorre la matriz y hay un 0 el juego puede segir si todas estan ocupadas osea que no hay 0 es empate y se reinicia
                   boolean bandera = false;
       for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    bandera = true;
                }
            }
        }
        if (!bandera) {
          
            JOptionPane.showMessageDialog(null, "Nadie Gana");
           
            Reinicio();

        }
        }
      
    }

    public void paint(Graphics g) {
        //coloca la pantalla con fondo 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0x81D8D0));
        g2d.fillRect(0, 0, ANCHO, ALTO);
        g2d.setStroke(new BasicStroke(5));

        //codigo que dibuja las 4 lineas que dividen los cuadrantes con lineas redondas y un grosor de linea
       g2d.setColor(Color.WHITE);
       g2d.setColor(new Color(0xD8FFDB));

    g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2d.drawLine(30, CUADRO, ANCHO-30, CUADRO);
    g2d.drawLine(30, CUADRO*2, ANCHO-30, CUADRO*2);
    g2d.drawLine(CUADRO, 30, CUADRO, ALTO-30);
    g2d.drawLine(CUADRO*2, 30, CUADRO*2, ALTO-30);

// Dibujar los bordes del gato
/*
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                g2d.drawRect(j * CUADRO, i * CUADRO, CUADRO, CUADRO);
            }
        }
*/

// Recorremos la matriz para dibujar las figuras del juego
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    //Colocamos un color un grosor y dibujamos un ovalo
                 
                    g2d.setColor(new Color(0x568C82));   
                    g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawOval(j * CUADRO + 30, i * CUADRO + 30, CUADRO - 60, CUADRO - 60);
                    
                } else if (matriz[i][j] == 2) {
                    
                    g2d.setColor(new Color(0xD8FFDB));
                    g2d.setStroke(new BasicStroke(15, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(j * CUADRO + 40, i * CUADRO + 40, (j + 1) * CUADRO - 40, (i + 1) * CUADRO - 40);
                    g2d.drawLine(j * CUADRO + 40, (i + 1) * CUADRO - 40, (j + 1) * CUADRO - 40, i * CUADRO + 40);
                    
                }
            }
        }

       
    }

    public void imprimematriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("GATO");
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Gato demo1 = new Gato();
        jf.add(demo1);
        jf.setResizable(false);
        jf.pack();
        jf.setVisible(true);

    }
}
