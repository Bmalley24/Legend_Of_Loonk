package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool {

    //This File is for helpimng Scale Every Image That needs to be drawn to Reduce Lag

    public BufferedImage scaleImage(BufferedImage original, int width, int height) {

        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();

        return scaledImage;
    }
}
