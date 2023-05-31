package zoombies;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Cactus {
    int x,y;
    BufferedImage [] imagenes = new BufferedImage[11];
    BufferedImage cactus=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;
    int vida=100;
    int contador3=0;
    CopyOnWriteArrayList<Balas> vectorBalas=new CopyOnWriteArrayList<>();
    Cactus(Plantas p,int x,int y){
        this.p=p;
        this.x=p.extraxIzq+(x*p.pixel);
        this.y=p.extraArriba+(y*p.pixel);
        this.vectorBalas=p.vectorBalas;
        cargarImagenes();
    }

    public void generarBala(){
        for(zombies zombie:p.vectorZombies){
            if(zombie.y>=this.y&&zombie.y<=this.y+p.pixel/2&&zombie.x<p.extraxIzq+(p.pixel*8)&&zombie.x>this.x+p.pixel/2){
             //   contador2++;
            if(contador2>=p.FPS*1.5){//30 frames y 10 son los segundos 
                vectorBalas.add(new Balas(p, this.x, this.y,1));
                System.out.println("bala");
                System.out.println(vectorBalas.size());
                contador2=0;
            }
            }
            
        }
        
    }

    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_10.png"));
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public void draw(Graphics2D g2){
        cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(cactus, x,y,p.pixel,p.pixel,p);
        g2.drawString(vida+"", x-20, y-20);
        contador2++;
    }

    public void colision(){

        for(zombies zombie:p.vectorZombies){
            if((this.x)+p.pixel>=zombie.x&&(this.x)+p.pixel<=zombie.x+p.pixel&&this.y>=zombie.y&&this.y<=zombie.y+p.pixel/2){
                contador3++;
                if(contador3>=30*2){//30 frames y 10 son los segundos 
                    vida-=25;
                    contador3=0;
                }
                
            }
            
        }
    }

    

    public void cambiarFrame(){
        switch(frame){
            case 0: cactus=imagenes[0]; break;
            case 1: cactus=imagenes[1]; break;
            case 2: cactus=imagenes[2]; break;
            case 3: cactus=imagenes[3]; break;
            case 4: cactus=imagenes[4]; break;
            case 5: cactus=imagenes[5]; break;
            case 6: cactus=imagenes[6]; break;
            case 7: cactus=imagenes[7]; break;
            case 8: cactus=imagenes[8]; break;
            case 9: cactus=imagenes[9]; break;
            case 10: cactus=imagenes[10]; break;

            default: frame=0;
        }

        contador++;
        if(contador==3){
            frame++;
            contador=0;
        }
        
    }

    public boolean eliminar(MouseEvent e){

        if(e.getX()>=this.x&&e.getX()<=this.x+p.pixel&&e.getY()>=this.y&&e.getY()<=this.y+p.pixel){
            return true;
          }
      
      return false;
    }
}
