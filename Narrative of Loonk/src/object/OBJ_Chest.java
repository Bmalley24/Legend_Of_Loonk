package object;

import main.GamingPanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{

    GamingPanel gp;

    //This File Is for ADding the Chest Object to the Game

    public OBJ_Chest (GamingPanel gp) {

        this.gp = gp;
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/TreasureChest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
