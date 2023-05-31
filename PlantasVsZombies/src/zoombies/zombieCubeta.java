package zoombies;

import java.io.IOException;

import javax.imageio.ImageIO;

public class zombieCubeta extends zombies{

    zombieCubeta(Plantas p,int y){
        super(p, y);
        this.vida=200;
    }

    @Override
    public void cargarImagenes() {
        // TODO Auto-generated method stub
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_13.png"));
            imagenes[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie/frame_14.png"));
      
            eat[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_00.png"));
            eat[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_01.png"));
            eat[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_02.png"));
            eat[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_03.png"));
            eat[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_04.png"));
            eat[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_05.png"));
            eat[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_06.png"));
            eat[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_07.png"));
            eat[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_08.png"));
            eat[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_09.png"));
            eat[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bucket_head_zombie_eat/frame_10.png"));
       
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    
    @Override
    public void cambiarFrame() {
        // TODO Auto-generated method stub
        
        if(!colision()){
            switch(frame){
                case 0: zoombie=imagenes[0]; break;
                case 1: zoombie=imagenes[1]; break;
                case 2: zoombie=imagenes[2]; break;
                case 3: zoombie=imagenes[3]; break;
                case 4: zoombie=imagenes[4]; break;
                case 5: zoombie=imagenes[5]; break;
                case 6: zoombie=imagenes[6]; break;
                case 7: zoombie=imagenes[7]; break;
                case 8: zoombie=imagenes[8]; break;
                case 9: zoombie=imagenes[9]; break;
                case 10: zoombie=imagenes[10]; break;
                case 11: zoombie=imagenes[11]; break;
                case 12: zoombie=imagenes[12]; break;
                case 13: zoombie=imagenes[13]; break;
                case 14: zoombie=imagenes[14]; break;
               
                default: frame=0; //si el frame llega al final se reinicia para
         //no salir del limite y no perder la referencia de las imagenes
            }
        }else{ //en caso de colision esta comiendo y selecciona una de comiendo
            switch(frame){
                case 0: zoombie=eat[0]; break;
                case 1: zoombie=eat[1]; break;
                case 2: zoombie=eat[2]; break;
                case 3: zoombie=eat[3]; break;
                case 4: zoombie=eat[4]; break;
                case 5: zoombie=eat[5]; break;
                case 6: zoombie=eat[6]; break;
                case 7: zoombie=eat[7]; break;
                case 8: zoombie=eat[8]; break;
                case 9: zoombie=eat[9]; break;
                case 10: zoombie=eat[10]; break;
             
                default: frame=0;
            }
        }
            //aunmentamos el frame para cambiar de imagen
            cambio++;
            if(cambio==5){
                frame++;
                cambio=1;
            }
    }

    
    
}
