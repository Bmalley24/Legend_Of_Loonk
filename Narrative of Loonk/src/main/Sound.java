package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    //This File IS for Adding the Sound Class Withc can play Music and Sound Effects. It ALSO INITIALISES ALL OF THE SOUNDS

    URL soundURL[] = new URL[25];
    Clip clip;
    public Sound() {

        soundURL[0] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[1] = getClass().getResource("/Sounds/coin.wav");
        soundURL[2] = getClass().getResource("/Sounds/powerup.wav");
        soundURL[3] = getClass().getResource("/Sounds/unlock.wav");
        soundURL[4] = getClass().getResource("/Sounds/fanfare.wav");
        soundURL[5] = getClass().getResource("/Sounds/BlueBoyAdventure.wav");
        soundURL[6] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[7] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[8] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[9] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[10] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[11] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[12] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[13] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[14] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[15] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[16] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[17] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[18] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[19] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[20] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[21] = getClass().getResource("/Sounds/titletheme.wav");
        soundURL[22] = getClass().getResource("/Sounds/titletheme.wav");
    }

    public void setFile (int i) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e){

        }
    }

    public void play () {
        clip.start();
    }

    public void loop () {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop () {
        clip.stop();
    }
}
