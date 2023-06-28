package zoombies;

import java.io.IOException;

import javax.imageio.ImageIO;

public class cereza extends Gizantes{
     int explosion=0;
    cereza(Plantas p,int x,int y){
        super(p,x,y);
    }

    public void cargarImagenes(){
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/imagenes/Cerezas.png"));
           imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/resources/explosion3.png"));
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

   

    @Override
    public void cambiarFrame(){
      gisantes=imagenes[0];
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
                gisantes=imagenes[1];
                contador3++; 
            }
            
        }
    

       if(explosion>p.FPS){
            vida=0;
            for (zombies zombie : p.vectorZombies) {
                int zombieX = (int)zombie.x;
                int zombieY = (int)zombie.y;

                if (zombieX >= this.x - p.pixel-30 && zombieX <= this.x + p.pixel &&
                    zombieY >= this.y - p.pixel && zombieY <= this.y + p.pixel &&
                    !(zombieX == this.x && zombieY == this.y)) {
                    zombie.vida=0;
                }
            }
        }
       }
}
