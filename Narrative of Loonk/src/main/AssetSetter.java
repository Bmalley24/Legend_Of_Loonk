package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamingPanel gp;

    //This File IS for adding In Every Sing Object in The Gmae and Where They Go

    public AssetSetter(GamingPanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Door(gp);
        gp.obj[2].worldX = 24 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        gp.obj[3] = new OBJ_Chest(gp);
        gp.obj[3].worldX = 22 * gp.tileSize;
        gp.obj[3].worldY = 7 * gp.tileSize;

        gp.obj[4] = new OBJ_Key(gp);
        gp.obj[4].worldX = 38 * gp.tileSize;
        gp.obj[4].worldY = 8 * gp.tileSize;

        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 11 * gp.tileSize;

        gp.obj[6] = new OBJ_Door(gp);
        gp.obj[6].worldX = 8 * gp.tileSize;
        gp.obj[6].worldY = 28 * gp.tileSize;

        gp.obj[7] = new OBJ_Door(gp);
        gp.obj[7].worldX = 12 * gp.tileSize;
        gp.obj[7].worldY = 22 * gp.tileSize;

        gp.obj[8] = new OBJ_Chest(gp);
        gp.obj[8].worldX = 10 * gp.tileSize;
        gp.obj[8].worldY = 7 * gp.tileSize;



    }
}
