package constants;


import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class SoundHolder {
	private static final SoundHolder instance = new SoundHolder();
	public Media bgm = new Media(ClassLoader.getSystemResource("sound/give_me_smile.mp3").toString());

	public static SoundHolder getInstance() {
		return instance;
	}

	public AudioClip loadSound(String name, String fileType) {
		return new AudioClip(ClassLoader.getSystemResource("sound/" + name + '.' + fileType).toString());
	}
}
