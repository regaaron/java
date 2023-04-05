package GameBoy;

import entity.BackgroundSound;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aaron
 */
public class GamePanel extends JPanel implements Runnable {

    final int originTileSize = 16; //tamanio promedio de las cosas en pixeles
    final int scale = 3;

    public final int tileSize = originTileSize * scale; //nuevo tamanio escalado
    final int maxScreenCol = 16;
    final int maxScrennRow = 12;

    final int screenWidth = tileSize * maxScreenCol; //786
    final int screenHeigth = tileSize * maxScrennRow;//576
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    int FPS = 60;
    Player player = new Player(this, keyH);
    BackgroundSound sound1 ;
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        sound1= new BackgroundSound();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
/*
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            update();
            repaint();

            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000000;
                if(remainingTime < 0 ){
                    remainingTime=0;
                }
                
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval; 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
*/
    
    public void run(){
        double drawIterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount =0;
        while(gameThread!=null){
            currentTime = System.nanoTime();
            delta+=(currentTime-lastTime)/drawIterval;
            timer+=(currentTime-lastTime);
            lastTime= currentTime;
            if(delta>=1){
                update();
            repaint();
            delta--;
            drawCount++;
            }
            if(timer>=1000000000){
                //System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }

}
