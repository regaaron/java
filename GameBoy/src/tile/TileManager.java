/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import GameBoy.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import javax.imageio.ImageIO;

/**
 *
 * @author aaron
 */
//clase azulejos
public class TileManager {

    GamePanel gp; //panel
    public Tile[] tile; //azulejos
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp; //igualamos el panel  al del juego principal
        tile = new Tile[10]; //creamos un vector de azulejos
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];  //vector del mapa
        this.loadMap("/maps/world01.txt");
        this.getTileImage();
    }

    //metodo para cargar el archivo del mapa a la matriz
    public void loadMap(String filePath) {

        try {

            // leer el archivo 
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            //recorrer el archivo hasta llegar al final del tamanio del mapa
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine(); //leer una linea completa del archivo
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" "); //separa los datos por espacion
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //cargamos las imagenes de los azulejos
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision=true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2].collision=true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision=true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //pintamos el mapa
    public void draw(Graphics2D g2) {
        int worldcol = 0;
        int worldrow = 0;
       

        //recorremos todo el mapa
        while (worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldcol][worldrow]; //obtenemos el numero  del azulejo dependiendo de la matriz
           
            int worldX=worldcol*gp.tileSize;
            int worldY=worldrow*gp.tileSize;
            int ScreenX=worldX -gp.player.worldX+gp.player.screenX;
            int screenY=worldY-gp.player.worldY+gp.player.screenY;
            
            if(worldX +gp.tileSize>gp.player.worldX-gp.player.screenX&&
               worldX-gp.tileSize<gp.player.worldX+gp.player.screenX&&
                worldY+gp.tileSize>gp.player.worldY-gp.player.screenY&&
                worldY-gp.tileSize<gp.player.worldY+gp.player.screenY){
               
                g2.drawImage(tile[tileNum].image, ScreenX, screenY, gp.tileSize, gp.tileSize, null); //imprimimos
            }
            
            worldcol++;
         
            //treminado la col pasamos al renglon
            if (worldcol == gp.maxWorldCol) {
                worldcol = 0;
            
                worldrow++;
          
            }

        }

    }
}
