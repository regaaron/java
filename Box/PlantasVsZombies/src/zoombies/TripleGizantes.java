package zoombies;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.imageio.ImageIO;

public class TripleGizantes {
    int x,y,y2,y3,coordx,coordy;
    BufferedImage [] imagenes = new BufferedImage[13];
    BufferedImage gisantes=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;
    int vida=100;
    int contador3=0;
    CopyOnWriteArrayList<Balas> vectorBalas=new CopyOnWriteArrayList<>();
    TripleGizantes(Plantas p,int x,int y){
        this.coordx = x;
        this.coordy = y;
        this.p=p;
        this.x=p.extraxIzq+(x*p.pixel);
        this.y=p.extraArriba+(y*p.pixel);
        this.y2= p.extraArriba + (y*p.pixel + p.pixel);
        this.y3= p.extraArriba + (y*p.pixel - p.pixel);
        this.vectorBalas=p.vectorBalas;
        cargarImagenes();
    }

    public void generarBala(){
        for(zombies zombie:p.vectorZombies){
            if((zombie.y>=this.y&&zombie.y<=this.y+p.pixel/2&&zombie.x<p.extraxIzq+(p.pixel*8)&&zombie.x>this.x+p.pixel/2) || (zombie.y>=this.y2&&zombie.y<=this.y2+p.pixel/2&&zombie.x<p.extraxIzq+(p.pixel*8)&&zombie.x>this.x+p.pixel/2) || (zombie.y>=this.y3&&zombie.y<=this.y3+p.pixel/2&&zombie.x<p.extraxIzq+(p.pixel*8)&&zombie.x>this.x+p.pixel/2)){
             //   contador2++;
            if(contador2>=p.FPS*3){//30 frames y 10 son los segundos
                System.out.println(coordy);
                if(coordy != 4){
                   vectorBalas.add(new Balas(p, this.x, this.y2)); 
                }
                vectorBalas.add(new Balas(p, this.x, this.y));
                if(coordy != 0){
                    vectorBalas.add(new Balas(p, this.x, this.y3));
                }
                System.out.println("bala");
                System.out.println(vectorBalas.size());
                contador2=0;
            }
            }
            
        }
        
    }

    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_12.png"));
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public void draw(Graphics2D g2){
        //cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(p.plantas[7], x,y,p.pixel,p.pixel,p);
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
            case 0: gisantes=imagenes[0]; break;
            case 1: gisantes=imagenes[1]; break;
            case 2: gisantes=imagenes[2]; break;
            case 3: gisantes=imagenes[3]; break;
            case 4: gisantes=imagenes[4]; break;
            case 5: gisantes=imagenes[5]; break;
            case 6: gisantes=imagenes[6]; break;
            case 7: gisantes=imagenes[7]; break;
            case 8: gisantes=imagenes[8]; break;
            case 9: gisantes=imagenes[9]; break;
            case 10: gisantes=imagenes[10]; break;
            case 11: gisantes=imagenes[11]; break;
            case 12: gisantes=imagenes[12]; break;
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

