package main;

import object.OBJ_Key;
import sun.plugin2.message.Message;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class UI {

    //This File IS for Drawing On the UI or In Game Messages Like Picked up Key

    GamingPanel gp;
    Font fontLucida40, Lucida80;
    BufferedImage keyImage;
    public Boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public Boolean gameFinished = false;

    public UI(GamingPanel gp) {
        this.gp = gp;

        fontLucida40 = new Font("Lucida Bright", Font.PLAIN, 40);
        Lucida80 = new Font("Lucida Bright", Font.BOLD, 55);
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }
    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished == true) {

            g2.setFont(fontLucida40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found Loonks Treasure";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHight/2 - gp.tileSize/2;
            g2.drawString(text, x, y);

            g2.setFont(Lucida80);
            g2.setColor(Color.yellow);

            text = "Congradulations You Win!!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHight/2 + gp.tileSize ;
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {

            g2.setFont(fontLucida40);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            //Message
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(25F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

                messageCounter++;

                if (messageCounter > 90) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }
}
