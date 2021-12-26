import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class playsound{
    public static void playSound(String location) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(location).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
            
		} catch(Exception ex) {
			System.out.println("Can't play file.");
		}
	}
    public static void main(String[] args){
        System.out.println("This file needs to be runned with Samex.");
    }
}