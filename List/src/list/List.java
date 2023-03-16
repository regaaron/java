/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package list;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();

        array.add("Triangulo");
        array.add("Cuadrado");
        array.add("Rectangulo");
        array.add("Pentagono");
        array.add("Hexagono");

        System.out.println("Array: " + array);

        System.out.println("array.size() = " + array.size());
        System.out.println("array.empty() = " + array.isEmpty());
        System.out.println("array.indexOf(Rectangulo)= "+ array.indexOf("Rectangulo"));
        System.out.println("array.subList(0,3)= "+array.subList(0, 3));
        array.clear();

        System.out.println("array.clear()...");
        System.out.println("array.size() = " + array.size());
        System.out.println("array.empty() = " + array.isEmpty());

    }

}
