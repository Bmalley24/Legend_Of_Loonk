package object;

import main.GamingPanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends SuperObject{

    //this File is for adding the key object to the game

    GamingPanel gp;
    public OBJ_Key (GamingPanel gp) {

        this.gp = gp;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
