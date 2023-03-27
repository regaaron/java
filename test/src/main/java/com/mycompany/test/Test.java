/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.test;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class Test {

    public static void main(String[] args) {
        int salary = 1000;
        //bono $200
        int bono=200;
        salary+=bono;
        
        System.out.println("Salary= " +salary);
        //pension %50 descuento
        
        salary-=50;
        System.out.println(salary);
        
        //2 horas extra $30 c/u
        //comida $45
        salary  = salary + (30*2)-45;
        System.out.println(salary);
        
        String employeName="Aaron Lopez ";
        employeName = employeName + "es una verga";
        System.out.println(employeName);
        
        employeName = "hola "+employeName;
        System.out.println(employeName);
    }
}
