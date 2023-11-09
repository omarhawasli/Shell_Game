package MyApp.Utlis;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class AudioManager {
    public static void playAudio(String name, String extension){

        String resource = AudioManager.class.getResource("/audio/" + name + "." + extension).toExternalForm();
        AudioClip audioClip = new AudioClip(resource);
        audioClip.play(0.25);
    }

}
