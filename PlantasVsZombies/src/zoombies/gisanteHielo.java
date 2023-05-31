package zoombies;

import java.io.IOException;

import javax.imageio.ImageIO;

public class gisanteHielo extends Gizantes{
    
    gisanteHielo(Plantas p,int x,int y){
        super(p,x,y);
        
    }

    @Override
    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_13.png"));
            imagenes[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/snowpea/frame_14.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override 
    public void addBala(){
        vectorBalas.add(new Balas(p, this.x, this.y,2));
    }
}
