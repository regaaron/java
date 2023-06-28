package zoombies;

import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class ZombieFlag extends zombies{
    ZombieFlag(Plantas p,int y,boolean bandera){
        super(p,y,bandera);
        this.vida=200;
        this.bandera = bandera;
    }


    @Override
    public void cargarImagenes() {
        String basePath = "/Java/imagenes/FlagZombie/frame_";
        String eatBasePath = "/Java/imagenes/FlagZombie_eat/frame_";
 
        try {
            for (int i = 0; i <= 11; i++) {
                String imagePath = basePath + String.format("%02d.png", i);
                imagenes[i] = ImageIO.read(getClass().getResourceAsStream(imagePath));
            }

            for (int i = 0; i <= 10; i++) {
                String eatImagePath = eatBasePath + String.format("%02d.png", i);
                eat[i] = ImageIO.read(getClass().getResourceAsStream(eatImagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Override
    public void BarraVida(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect((int) x, (int) y - 10, p.pixel, 5);
        g2.setColor(Color.GREEN);
        g2.fillRect((int) x, (int) y - 10, (int) (p.pixel * (vida / 200.0)), 5);
    }

    @Override
    public void draw(Graphics2D g2) {        
        if(realentiza){
            EfectoLento();
            g2.drawImage(buffer, (int) x-20, (int) y-10, (int)(p.pixel*1.4), (int)(p.pixel*1.2), p);
         
        }else{
            g2.drawImage(zoombie, (int) x-20, (int) y-10, (int)(p.pixel*1.4), (int)(p.pixel*1.2), p);     
        }
    // Dibujar la barra de vida del zombie
        BarraVida(g2);
    }

    @Override
    public void cambiarFrame() {
        if (!colision()) {
            if (frame >= 0 && frame <= 11) {
                zoombie = imagenes[frame];
            } else {
                frame = 0;
                zoombie = imagenes[frame];
            }
        } else {
            if (frame >= 0 && frame <= 10) {
                zoombie = eat[frame];
            } else {
                frame = 0;
                zoombie = eat[frame];
            }
        }
        
        cambio++;
        if (cambio == 3) {
            frame++;
            cambio = 0;
        }
    }
}
