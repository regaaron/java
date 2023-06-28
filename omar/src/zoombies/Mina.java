package zoombies;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mina extends Gizantes{

   
    int explosion=0;
    Mina(Plantas p,int x,int y){
        super(p,x,y);
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
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/resources/explosion3.png"));
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

   

    @Override
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
            
            default: frame=0;
        }
    

        contador++;
        if(contador==5){
            frame++;
            contador=0;
        }
    }

   @Override
   public void addBala() {
       
   }

   @Override
   
   public void colision() {
       // TODO Auto-generated method stub
      
    
        for(zombies zombie:p.vectorZombies){
            if((this.x)+p.pixel>=zombie.x+30&&(this.x)+p.pixel<=zombie.x+p.pixel&&this.y>=zombie.y&&this.y<=zombie.y+p.pixel/2){
                explosion++;
                gisantes=imagenes[8];
                contador3++; 
            }
            
        }
    

       if(explosion>p.FPS){
            vida=0;
            for(zombies zombie:p.vectorZombies){
                if((this.x)+p.pixel>=zombie.x&&(this.x)+p.pixel<=zombie.x+p.pixel*2&&this.y>=zombie.y&&this.y<=zombie.y+p.pixel/2){
                    zombie.vida=0;
                }
            }
        }
       }
}


