package zoombies;

import java.awt.image.BufferedImage;

public class Carta {
    BufferedImage imagen;
    boolean activa;
    public int posicion;

    public Carta(BufferedImage imagen, boolean activa,int posicion) {
        this.imagen = imagen;
        this.activa = activa;
        this.posicion = posicion;
    }
    
    
}
