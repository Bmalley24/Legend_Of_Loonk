package entity;

import java.awt.*;
import java.awt.image.BufferedImage;


//This stores Varibaibles that will be used in Player, Monster, and NPC classes
public class Entity {

    public int worldX, worldY;
    public int speed;

    //BufferedImage describes an image with a accessable buffer of image data
    public BufferedImage up1, up2, down1, down2,left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum =1;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public Boolean collisionOn = true;


}
