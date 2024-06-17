package Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SFX {

    private Clip currentClip;

    public void playSoundEffect(String soundFileName) {
        try {
            // Get the sound file as a resource
            URL soundFileUrl = this.getClass().getResource("/" + soundFileName);

            // Create an AudioInputStream from the sound file
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFileUrl);

            // Get a sound clip resource
            currentClip = AudioSystem.getClip();

            // Open the sound file for playing
            currentClip.open(audioIn);

            // Start playing the sound clip
            currentClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopSoundEffect() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
        }
    }
}