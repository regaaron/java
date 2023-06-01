package zoombies;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Girazol extends Gizantes{

    Girazol(Plantas p,int x,int y){
       super(p, x, y);
       
    }
    
    public void cargarImagenes(){
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/sunflower/frame_12.png"));
            
        }catch(IOException e){
            System.out.println("Error al cargar girazoles\n "+ e.getMessage());
        }
    }

    @Override
    public void draw(Graphics2D g2){
        super.draw(g2);
        generarSol();
    }

    @Override
    public void addBala() {
        
    }

    public void generarSol(){
        if(contador2==30*10){//30 frames y 20 son los segundos 
            p.vectorSoles2.add(new Soles(p, x, y,0));
            contador2=0;
        }
    }
    
}