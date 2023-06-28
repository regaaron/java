package zoombies;

import java.io.IOException;
import javax.imageio.ImageIO;

public class DobleGizantes extends Gizantes{
   DobleGizantes(Plantas p,int x,int y){
        super(p, x, y);
        
    }

    @Override
    public void generarBala(){
        for(zombies zombie:p.vectorZombies){
            if(zombie.y>=this.y&&zombie.y<=this.y+p.pixel/2&&zombie.x<p.extraxIzq+(p.pixel*8)&&zombie.x>this.x+p.pixel/2){
             //   contador2++;
            if(contador2>=p.FPS*3){//30 frames y 10 son los segundos 
                vectorBalas.add(new Balas(p,this.x,this.y));
                vectorBalas.add(new Balas(p, this.x - 70, this.y));
                System.out.println(vectorBalas.size());
                contador2=0;
            }
            }
            
        }
        
    }

    @Override
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
            e.printStackTrace();
        }
       
    }


  
    
  

  
}
