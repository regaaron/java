/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameBoy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author aaron
 */
public class KeyHandler implements KeyListener{
    public boolean upPressed,downPressed,leftPressed,rigthPressed;
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int code =e.getKeyCode();
      
      if(code == KeyEvent.VK_W|| code ==KeyEvent.VK_UP){
          upPressed=true;
      }
      if(code == KeyEvent.VK_S||code ==KeyEvent.VK_DOWN){
          downPressed=true;
      }
      if(code == KeyEvent.VK_A||code ==KeyEvent.VK_LEFT){
          leftPressed=true;
      }
      if(code == KeyEvent.VK_D||code ==KeyEvent.VK_RIGHT){
          rigthPressed=true;
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =e.getKeyCode();
      
      if(code == KeyEvent.VK_W|| code ==KeyEvent.VK_UP){
          upPressed=false;
      }
      if(code == KeyEvent.VK_S||code ==KeyEvent.VK_DOWN){
          downPressed=false;
      }
      if(code == KeyEvent.VK_A||code ==KeyEvent.VK_LEFT){
          leftPressed=false;
      }
      if(code == KeyEvent.VK_D||code ==KeyEvent.VK_RIGHT){
          rigthPressed=false;
      }
    }
    
}
