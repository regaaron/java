/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cnumeros;

/**
 *
 * @author aaron
 */
public class Operaciones {
    public static CNumeros suma(CNumeros nums){
        /*
        if(nums.getN1() instanceof Integer){
            nums.setRes(nums.getN1().intValue()+nums.getN2().intValue());
        }
        
        if(nums.getN1() instanceof Double){
        nums.setRes(nums.getN1().doubleValue()+nums.getN2().doubleValue());
        }
        
        if(nums.getN1() instanceof Float){
        nums.setRes(nums.getN1().floatValue()+nums.getN2().floatValue());
        }
        */
        //nums.setRes(nums.getN1()+nums.getN2());
        return nums;
    }
    
    public static CNumeros<Integer> sumaInt(CNumeros <Integer> nums){
        nums.setRes(Integer.parseInt(nums.getN1().toString())+Integer.parseInt(nums.getN2().toString()));
        return nums;
    }
    
    public static CNumeros<Float> sumaFloat(CNumeros <Float> nums){
       // nums.setRes(Integer.parseInt(nums.getN1().toString())+Integer.parseInt(nums.getN2().toString()));
        nums.setRes(nums.getN1()+nums.getN2());
       return nums;
    }
    
    public static CNumeros<Double> sumaDouble(CNumeros <Double> nums){
        nums.setRes(nums.getN1()+nums.getN2());
        return nums;
    }
}
