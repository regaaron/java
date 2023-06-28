package zoombies;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class mini extends Gizantes{
    mini(Plantas p,int x,int y){
        super(p,x,y);
    }

    @Override
    public void cargarImagenes() {
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/resources/HongoPequeño.png"));
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

     @Override
     public void cambiarFrame() {
        gisantes=imagenes[0];
     }

     @Override
     public void draw(Graphics2D g2) {
         cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(gisantes, x+p.pixel/4,y+p.pixel/4,p.pixel/2,p.pixel/2,p);
        //BarraVida(g2);
        contador2++;
     }

}
