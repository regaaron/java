/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cstring;

import java.util.Scanner;

/**
 *
 * @author aaron
 */
public class CString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CString1 obj = new CString1("Hola mundo");
        int opc;
        do {
            //System.out.print("\f");
            System.out.println("Binvenido");
            System.out.println("Cambiar Frase 1.");
            System.out.println("Mostrar Frase 2.");

            System.out.println("Obtener Caracter 3.");
            System.out.println("Obtener Subcadena 4.");
            System.out.println("Mostrar Cadena en Mayusculas 5.");
            System.out.println("Mostrar cadena al Reves 6.");
            System.out.println("Salir 7");
            System.out.println("Ingrese tu opcion deseada.");

                       // response = Integer.valueOf(sc.nextLine());
                        opc = Integer.valueOf(sc.nextLine());
            switch(opc){
                case 1: System.out.println("Ingrese la frase: ");
                        obj.Cadena(sc.nextLine());
                        break;
                case 2: obj.Mostrar();
  
                        break;
                case 3: System.out.println("Ingrese la posicion del caracter: ");
                        System.out.println(obj.caracter(sc.nextInt()));
                        break;
                case 4: System.out.println("Ingrese el inicio de la Subcadena y despues ingrese el final de la subcadena");
                        System.out.println(obj.SubCadena(sc.nextInt(), sc.nextInt()));
                        break;
                case 5: System.out.println(obj.ToMayus());
                        break;
                case 6: obj.Mostrar();
                        System.out.println(obj.Invierte());
                        break;
                case 7: System.out.println("Adios.");
                default: System.out.println("Opcion no valida.");
            }
                        System.out.println("Precione una tecla para continuar");
                        sc.nextLine();
        } while (opc !=7);
    }

}
