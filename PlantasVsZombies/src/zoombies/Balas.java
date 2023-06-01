package zoombies;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import java.io.IOException;


import javax.imageio.ImageIO;

public class Balas {
    int x,y;
    int xfinal;
    BufferedImage bala=null,bala2 = null, bala3 = null;
    Plantas p;
    int n;
    BackgroundSound danio=new BackgroundSound("/Java/resources/splat2.wav");
    BackgroundSound disparo=new BackgroundSound("/Java/resources/peashooter_attack2.wav");
    Balas(Plantas p,int x,int y){
        this.p=p;
        this.x=x+p.pixel;
        this.y=y+p.pixel/4;
        this.xfinal=p.screenX-300;
        try{
            bala=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bullet/peabullet.png"));
            bala2=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bullet/bala2.png"));
        }catch(IOException e){
            System.out.println("Error al cargar bala\n"+e.getMessage());
        }

        disparo.clip.start();

    }
    Balas(Plantas p,int x,int y,int n){
        this.p=p;
        this.x=x+p.pixel;
        this.y=y+p.pixel/4;
        this.xfinal=p.screenX-300;
        try{
            bala=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bullet/snowpeabullet.png"));
            bala2=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bullet/bala2.png"));
        }catch(IOException e){
            System.out.println("Error al cargar bala\n"+e.getMessage());
        }
        this.n=n;
        disparo.clip.start();
    }

    public void draw(Graphics2D g2){
        if(n==1){
            g2.drawImage(bala2, x, y, p.pixel/3,p.pixel/3,null);
        }else{
            g2.drawImage(bala, x, y, p.pixel/3,p.pixel/3,null);
        }
            
            if(x<xfinal){
                x+=4.5;
            }
        
    }

    public boolean colision(){
        for(zombies zombie:p.vectorZombies){
            if((this.x+4.5)+p.pixel/4>=zombie.x&&(this.x+4.5)+p.pixel/4<=zombie.x+p.pixel&&this.y>=zombie.y&&this.y<=zombie.y+p.pixel){
                danio.clip.start();
                zombie.vida-=10;
                if(n==2){
                    zombie.realentiza=true;
                    zombie.tiempoCongelado=0;
                    zombie.velocidad=.375;
                    
                }
                return true;
            }
            
        }
        return false;
    }
    
}
