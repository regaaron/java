/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author aaron
 */
public class CustomThread extends Thread{
    
    Shared shared;
    
    public CustomThread(Shared shared,String string){
        super(string);
        this.shared = shared;
        start();
    }

    @Override
    public void run() {
        shared.doWork(Thread,currentThread().getName());
    }
    
    public static void main(String[] args) {
        Shared shared = new Shared();
        CustomThread thread1 = new CustomThread(shared, "uno");
        CustomThread thread2 = new CustomThread(shared, "dos");
        CustomThread thread3 = new CustomThread(shared, "tres");
        CustomThread thread4 = new CustomThread(shared, "cuatro");
        
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

        }catch(InterruptedException e){
            
        }

    }
    
}
