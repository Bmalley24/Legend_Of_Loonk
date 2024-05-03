package object;

import main.GamingPanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject{

    //This File is for Adding The Door Object To the game

    GamingPanel gp;
    public OBJ_Door (GamingPanel gp) {

        this.gp = gp;
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
