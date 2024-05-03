package entity;

import main.GamingPanel;
import main.KeyInputer;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    // This File Handles Anythign Related to the PLayer (How they are drawn each Frame, How they Interact with Objects)

    GamingPanel gp;
    KeyInputer keyI;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;


    public Player(GamingPanel gp, KeyInputer keyI){
        this.gp = gp;
        this.keyI = keyI;
        setDefaultValues();
        getPlayerImage();

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16 - gp.tileSize * 2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues () {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage () {

        up1 = setup("Loonk_up_1");
        up2 = setup("Loonk_up_2");
        down1 = setup("Loonk_down_1");
        down2 = setup("Loonk_down_2");
        left1 = setup("Loonk_left_1");
        left2 = setup("Loonk_left_2");
        right1 = setup("Loonk_right_1");
        right2 = setup("Loonk_right_2");

    }

    public BufferedImage setup(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;

    }

    public void update() {

        if (keyI.upPressed == true || keyI.downPressed == true || keyI.leftPressed == true || keyI.rightPressed == true) {
            if (keyI.upPressed == true){
                direction = "up";
            } else if (keyI.downPressed == true) {
                direction = "down";
            } else if (keyI.leftPressed == true) {
                direction = "left";
            } else if (keyI.rightPressed == true) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {

                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
        }
        }
    }

    public void pickUpObject(int i){

        if(i != 999) {

             String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("+1 key");
                    break;
                case "Door":
                    if(hasKey> 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("door opened");
                    } else {
                        gp.ui.showMessage("key missing");
                    }
                    break;
                case "Chest":
                    if(hasKey> 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("chest opened");

                        //game ends (temp)
                        gp.ui.gameFinished = true;
                        gp.stopMusic();
                        gp.playSE(4);
                        break;
                    } else {
                        gp.ui.showMessage("key missing");
                    }
                    break;
            }

        }

    }

    public void draw(Graphics2D g2) {

//        g2.setColor(Color.green);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
            }
                if (spriteNum ==2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum ==2) {
                image = down2;
            }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum ==2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum ==2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null);


    }
}
