package zoombies;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NuezGrande extends Gizantes{

    BufferedImage [] imagenes2= new BufferedImage[13];
    BufferedImage [] imagenes3= new BufferedImage[12];

   

    NuezGrande(Plantas p,int x,int y){
        super(p,x,y);
        vida=400;
        cargarImagenes2();
    }


    public void cargarImagenes2() {
        try{
         
            imagenes2[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_00.png"));
            imagenes2[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_01.png"));
            imagenes2[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_02.png"));
            imagenes2[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_03.png"));
            imagenes2[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_04.png"));
            imagenes2[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_05.png"));
            imagenes2[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_06.png"));
            imagenes2[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_07.png"));
            imagenes2[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_08.png"));
            imagenes2[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_09.png"));
            imagenes2[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_10.png"));
            imagenes2[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_11.png"));
            imagenes2[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked1/frame_12.png"));

            imagenes3[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_00.png"));
            imagenes3[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_01.png"));
            imagenes3[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_02.png"));
            imagenes3[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_03.png"));
            imagenes3[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_04.png"));
            imagenes3[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_05.png"));
            imagenes3[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_06.png"));
            imagenes3[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_07.png"));
            imagenes3[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_08.png"));
            imagenes3[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_09.png"));
            imagenes3[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_10.png"));
            imagenes3[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallnutCracked2/frame_11.png"));
           

        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez Grande/n"+e.getMessage());
        }
    }
    @Override
    public void cargarImagenes(){
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/TallNut/frame_13.png"));
   
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez Grande/n"+e.getMessage());
        }
    }

  
    @Override
    public void cambiarFrame(){
        
        if(vida>300){
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
                case 13: gisantes=imagenes[13]; break;

                default: frame=0;
           
            }
        }else{
            if(vida>100){
                switch(frame){
                    case 0: gisantes=imagenes2[0]; break;
                    case 1: gisantes=imagenes2[1]; break;
                    case 2: gisantes=imagenes2[2]; break;
                    case 3: gisantes=imagenes2[3]; break;
                    case 4: gisantes=imagenes2[4]; break;
                    case 5: gisantes=imagenes2[5]; break;
                    case 6: gisantes=imagenes2[6]; break;
                    case 7: gisantes=imagenes2[7]; break;
                    case 8: gisantes=imagenes2[8]; break;
                    case 9: gisantes=imagenes2[9]; break;
                    case 10: gisantes=imagenes2[10]; break;
                    case 11: gisantes=imagenes2[11]; break;
                    case 12: gisantes=imagenes2[12]; break;
                 
                default: frame=0;

                }
            }else{
                switch(frame){
                    case 0: gisantes=imagenes3[0]; break;
                    case 1: gisantes=imagenes3[1]; break;
                    case 2: gisantes=imagenes3[2]; break;
                    case 3: gisantes=imagenes3[3]; break;
                    case 4: gisantes=imagenes3[4]; break;
                    case 5: gisantes=imagenes3[5]; break;
                    case 6: gisantes=imagenes3[6]; break;
                    case 7: gisantes=imagenes3[7]; break;
                    case 8: gisantes=imagenes3[8]; break;
                    case 9: gisantes=imagenes3[9]; break;
                    case 10: gisantes=imagenes3[10]; break;
                    case 11: gisantes=imagenes3[11]; break;
                  
                default: frame=0;

                }
            }
        }

        contador++;
        if(contador==3){
            frame++;
            contador=0;
        }
    }

  @Override
  public void addBala() {
      
  }
}
