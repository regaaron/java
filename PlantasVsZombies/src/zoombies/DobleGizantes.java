package zoombies;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.imageio.ImageIO;

public class DobleGizantes {
    int x,y;
    BufferedImage [] imagenes = new BufferedImage[15];
    BufferedImage gisantesDoble=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;
    int vida=100;
    int contador3=0;
    CopyOnWriteArrayList<Balas> vectorBalas=new CopyOnWriteArrayList<>();
    DobleGizantes(Plantas p,int x,int y){
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
            if(contador2>=p.FPS*3){//30 frames y 10 son los segundos 
                vectorBalas.add(new Balas(p,this.x,this.y));
                vectorBalas.add(new Balas(p, this.x - 70, this.y));
                System.out.println("bala");
                System.out.println(vectorBalas.size());
                contador2=0;
            }
            }
            
        }
        
    }

    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_13.png"));
            imagenes[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Repeater/frame_14.png"));
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public void draw(Graphics2D g2){
        cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(gisantesDoble, x,y,p.pixel,p.pixel,p);
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
            case 0: gisantesDoble=imagenes[0]; break;
            case 1: gisantesDoble=imagenes[1]; break;
            case 2: gisantesDoble=imagenes[2]; break;
            case 3: gisantesDoble=imagenes[3]; break;
            case 4: gisantesDoble=imagenes[4]; break;
            case 5: gisantesDoble=imagenes[5]; break;
            case 6: gisantesDoble=imagenes[6]; break;
            case 7: gisantesDoble=imagenes[7]; break;
            case 8: gisantesDoble=imagenes[8]; break;
            case 9: gisantesDoble=imagenes[9]; break;
            case 10: gisantesDoble=imagenes[10]; break;
            case 11: gisantesDoble=imagenes[11]; break;
            case 12: gisantesDoble=imagenes[12]; break;
            case 13: gisantesDoble=imagenes[13]; break;
            case 14: gisantesDoble=imagenes[14]; break;

            default: frame=0;
        }

        contador++;
        if(contador==3){
            frame++;
            contador=0;
        }
        
    }

    public boolean eliminar(MouseEvent e){

        if (e.getX() >= this.x && e.getX() <= this.x+p.pixel &&
            e.getY() >= this.y && e.getY() <= this.y+p.pixel ){

            return true;
          
        }
      
      return false;
    }
}
