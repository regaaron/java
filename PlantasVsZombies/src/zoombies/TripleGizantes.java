package zoombies;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TripleGizantes extends Gizantes{
    int y2,y3,coordx,coordy;
    TripleGizantes(Plantas p,int x,int y){
        super(p, x, y);
        this.coordx = x;
        this.coordy = y;
        this.y2= p.extraArriba + (y*p.pixel + p.pixel);
        this.y3= p.extraArriba + (y*p.pixel - p.pixel);
       
        cargarImagenes();
    }

    @Override
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
    
    @Override
    public void draw(Graphics2D g2) {
        cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(gisantes, x-40,y-30,(int)(p.pixel*1.8),(int)(p.pixel*1.8),p);
        //BarraVida(g2);
        contador2++;
    }
    @Override
    public void cargarImagenes(){
        try {
            
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_01.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_02.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_03.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_04.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_05.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_06.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_07.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_08.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_09.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_10.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_11.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_12.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Triple/frame_13.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

}

    