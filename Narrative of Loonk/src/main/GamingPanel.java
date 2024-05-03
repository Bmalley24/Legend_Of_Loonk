package main;
import Tile.TileManager;
import entity.Player;
import object.SuperObject;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

//This is Where the My Game Functions Are set Up to Run (IE Running the Screen PLaying Sounds all that Jazz

public class GamingPanel extends JPanel implements Runnable{

    //Screen Settings
    final int orignalTileSize = 16; //16x16 tile
    final int scale = 3;
    public final int tileSize  = orignalTileSize * scale; //48x 48 pixel
    public final int screenCol = 16;
    public final int screenRow = 12;
    public final int screenWidth = tileSize * screenCol;
    public final int screenHight = tileSize * screenRow;

    //World Map
    public final int maxWoldCol = 50;
    public final int maxWoldRow = 50;

    //Frames Per Second
    int FPS = 60;

    //Managers
    TileManager tileM = new TileManager(this);
    KeyInputer keyH = new KeyInputer();
    public UI ui = new UI(this);

    //Music/Sound Effects
    Sound sound = new Sound(); // music
    Sound SE = new Sound(); // sound effects

    Thread gameThread;

    //interactables
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyH);
    public AssetSetter aSetter = new AssetSetter(this);
    public SuperObject obj[] = new SuperObject[10]; // can display up to 10 objects at a time in game (subject to change if needed)

    public GamingPanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {

        aSetter.setObject();

        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; //0.016666
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            //long currrntTime = System.nanoTime();   Check current time
            //System.out.println("current Time"+currrntTime);

            //Update information such as player position
            update();

            //repaint the screen with the most recent information
            repaint();


            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {

                e.printStackTrace();

            }


        }
    }

    public void update(){ // new classes without player being in them

        player.update();
    }

    public void paint(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Debug
        long drawStart = 0;
        if (keyH.checkDrawTime == true) {

            drawStart = System.nanoTime();

        }

        //draw backrond tiles first so it wont cover up the player character
        tileM.draw(g2);

        //Objects
        for (int i = 0; i < obj.length; i++) {

            if (obj[i] != null) {

                obj[i].draw(g2, this);

            }
        }

        //Player
        player.draw(g2);

        //UI
        ui.draw(g2);

        //Debug
        if (keyH.checkDrawTime == true) {

            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10 , 400);
            System.out.println("Draw Time: " + passed);

        }

        //Stops drawing
        g2.dispose();
    }

    public void playMusic(int i){

        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {

        sound.stop();
    }

    public void playSE(int i){ //Plays Sound Effect

        SE.setFile(i);
        SE.play();
    }
}
