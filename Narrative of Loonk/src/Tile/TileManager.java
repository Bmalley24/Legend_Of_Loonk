package Tile;

import main.GamingPanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager { //This File is where all my Tiles Are put Into The Code
    //It Also is Where the Map is Loaded and Drawn in

    GamingPanel gp;
    public Tile[] tile;
    public int mapTileNum [][];

    public TileManager (GamingPanel gp) {
        this.gp = gp;
        tile = new Tile[50];
        mapTileNum = new int [gp.maxWoldCol] [gp.maxWoldRow];

        getTileImage();
        loadMap ();
    }

    public void getTileImage() {

        setup(0, "Earth", false);
        setup(1, "Earth", false);
        setup(2, "Earth", false);
        setup(3, "Earth", false);
        setup(4, "Earth", false);
        setup(5, "Earth", false);
        setup(6, "Earth", false);
        setup(7, "Earth", false);
        setup(8, "Earth", false);
        setup(9, "Earth", false); //0-9 Are PLace Holders

        setup(10, "Grass00", false);
        setup(11, "Grass01", false);
        setup(12, "Water00", true);
        setup(13, "Water01", true);
        setup(14, "Water02", true);
        setup(15, "Water03", true);
        setup(16, "Water04", true);
        setup(17, "Water05", true);
        setup(18, "Water06", true);
        setup(19, "Water07", true);
        setup(20, "Water08", true);
        setup(21, "Water09", true);
        setup(22, "Water10", true);
        setup(23, "Water11", true);
        setup(24, "Water12", true);
        setup(25, "Water13", true);
        setup(26, "Sand00", false);
        setup(27, "Sand01", false);
        setup(28, "Sand02", false);
        setup(29, "Sand03", false);
        setup(30, "Sand04", false);
        setup(31, "Sand05", false);
        setup(32, "Sand06", false);
        setup(33, "Sand07", false);
        setup(34, "Sand08", false);
        setup(35, "Sand09", false);
        setup(36, "Sand10", false);
        setup(37, "Sand11", false);
        setup(38, "Sand12", false);
        setup(39, "Earth", false);
        setup(40, "Brick", true);
        setup(41, "Tree", true);


    }

    public void setup (int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch(IOException e) {

            e.printStackTrace();

        }

    }

    public void loadMap () {

        try {
            InputStream is = getClass().getResourceAsStream("/Maps/world_map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWoldCol && row < gp.maxWoldRow) {

                String line = br.readLine();

                while (col < gp.maxWoldCol) {
                    //.split splits the line at the space to read map
                    String numbers [] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gp.maxWoldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWoldCol && worldRow < gp.maxWoldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenX;

            if (    worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize * 3 > gp.player.worldY - gp.player.screenY &&
                    worldY < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWoldCol) {

                worldCol = 0;
                worldRow++;


            }
        }

    }

}
