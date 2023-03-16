/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cnumeros;

/**
 *
 * @author aaron
 */
public class CNumeros <T extends Number>{
    
    private T n1;
    private T n2 ;
    private T res;
    
    public CNumeros(){ n1 = null; n2 = null; }
    public CNumeros(T n1,T n2){this.n1=n1;this.n2=n2;}
    public T getN1(){ return this.n1; }
    public T getN2(){ return this.n2; }
    public T getRes(){return this.res; }
    public void setN1(T n1){ this.n1=n1; }
    public void setN2(T n2){ this.n2=n2; }
    public void setRes(T res){this.res=res; }
    
    
    
}
