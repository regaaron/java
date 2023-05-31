package zoombies;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cactus extends Gizantes{
    Cactus(Plantas p,int x,int y){
       super(p, x, y);
    }

    
    @Override
    public void addBala() {
        // TODO Auto-generated method stub
        vectorBalas.add(new Balas(p, x, y, 1));
    }

    @Override
    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_04.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_05.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_06.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_07.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_08.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_09.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_10.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/Cactus/frame_10.png"));

        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
   
}
