/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.helloworld;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author aaron
 */
public class Helloworld {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int f, c;
        System.out.print("numero de filas ");
        f = s.nextInt();
        System.out.print("numero de columnas ");
        c = s.nextInt();
        s.close();
        Random rand = new Random();
        int m[][] = new int[f][c];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = rand.nextInt(f * c * 10);
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(" " + i + "," + j + "-> " + m[i][j]);
            }
            System.out.println();
        }
        System.exit(0);

    }
}
