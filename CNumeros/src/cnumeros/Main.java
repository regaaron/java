/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cnumeros;

/**
 *
 * @author aaron
 */
public class Main {
    public static void main(String[] args) {
       String n1="dos", n2 ="hola";
       CNumeros nums = new CNumeros();
        try{
            nums= new CNumeros(Integer.parseInt(n1),Integer.parseInt(n2));
        }catch(NumberFormatException e1){
            System.out.println("Error.- No es entero");
            try{
                nums = new CNumeros(Float.parseFloat(n1),Float.parseFloat(n2));
            }catch(NumberFormatException e2){
                System.out.println("Error.- No es Flotante");
            }
            
        }
        
        nums=Operaciones.suma(nums);
        System.out.println(nums.getRes());
        

    }
}
