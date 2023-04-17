/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos5;

/**
 *
 * @author aaron
 */
public class Hilos5 implements Runnable {

    Thread thread;
    int counter = 0;
    volatile boolean goflag;

    public Hilos5(int p) {
        thread = new Thread(this);
        thread.setPriority(p);
    }

    public void start() {
        goflag = true;
        thread.start();
    }

    public static void main(String[] args) {
        System.out.println("max: " + Thread.MAX_PRIORITY);
        System.out.println("norm: " + Thread.NORM_PRIORITY);
        System.out.println("min: " + Thread.MIN_PRIORITY);

        Hilos5 thread1 = new Hilos5(Thread.MIN_PRIORITY);
        Hilos5 thread2 = new Hilos5(Thread.MIN_PRIORITY);
        Hilos5 thread3 = new Hilos5(Thread.MIN_PRIORITY);
        Hilos5 thread4 = new Hilos5(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        } finally {
            thread1.end();
            thread2.end();
            thread3.end();
            thread4.end();

        }

        System.out.println("Hilo1 contando: " + thread1.counter);
        System.out.println("Hilo2 contando: " + thread2.counter);

        System.out.println("Hilo3 contando: " + thread3.counter);
        System.out.println("Hilo4 contando: " + thread4.counter);

    }

    @Override
    public void run() {
        while (goflag) {
            counter++;
        }
    }

    public void end() {
        goflag = false;
    }
}
