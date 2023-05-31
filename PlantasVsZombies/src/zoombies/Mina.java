package zoombies;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mina {
    int x,y;
    BufferedImage [] imagenes= new BufferedImage[8];
 
    BufferedImage nuez=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;
    int contador3=0;
    int vida=400;

    Mina(Plantas p,int x,int y){
        this.p=p;
        this.x=p.extraxIzq+(x*p.pixel);
        this.y=p.extraArriba+(y*p.pixel);
        cargarImagenes();
    }

    public void cargarImagenes(){
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/PotatoMine/frame_07.png"));
          
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

    public void draw(Graphics2D g2){
        cambiarFrame();
        colision();
        g2.drawImage(nuez,x,y,(int)(p.pixel/1.5),p.pixel,p);
        g2.drawString(vida+"", x-20, y-20);

    }

    public void colision(){

        for(zombies zombie:p.vectorZombies){
            if((this.x)+p.pixel>=zombie.x&&(this.x)+p.pixel<=zombie.x+p.pixel&&this.y>=zombie.y&&this.y<=zombie.y+p.pixel/2){
                contador3++;
                if(contador3==30*2.5){//30 frames y 10 son los segundos 
                    vida-=25;
                    contador3=0;
                }
                
            }
            
        }
    }

    public void cambiarFrame(){
       
        
        switch(frame){
            case 0: nuez=imagenes[0]; break;
            case 1: nuez=imagenes[1]; break;
            case 2: nuez=imagenes[2]; break;
            case 3: nuez=imagenes[3]; break;
            case 4: nuez=imagenes[4]; break;
            case 5: nuez=imagenes[5]; break;
            case 6: nuez=imagenes[6]; break;
            case 7: nuez=imagenes[7]; break;
            
            default: frame=0;
        }
    

        contador++;
        if(contador==5){
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
