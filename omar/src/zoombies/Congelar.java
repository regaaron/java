package zoombies;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Congelar extends Gizantes{
    int contparalizar;
    Congelar(Plantas p,int x,int y){
        super(p, x, y);

    }

    @Override
    public void cargarImagenes() {
         try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/resources/Congela.png"));
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

    @Override
    public void cambiarFrame() {
        gisantes=imagenes[0];
        paralizar();
    }

    public void paralizar(){
        contparalizar++;
        for(zombies zombi:p.vectorZombies){
                zombi.velocidad=0;
                zombi.paralizar=true;
                zombi.realentiza=true;
            }
        if(contparalizar>p.FPS*5){
            vida=0;
            for(zombies zombi:p.vectorZombies){
                zombi.descongelar();;
                zombi.paralizar=false;
                zombi.realentiza=false;
            }
            
        }
    }

    @Override
    public void addBala() {
        
    }



}
