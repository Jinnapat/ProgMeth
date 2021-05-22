package constants;


import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundHolder {
	private static final SoundHolder instance = new SoundHolder();
//	public Media bgm = new Media(ClassLoader.getSystemResource("sound/give_me_smile.wav").toString());
//	public Media gunShot = new Media(ClassLoader.getSystemResource("sound/gunShot.wav").toString());
	public String source = ClassLoader.getSystemResource("sound/gunShot.wav").toString();
	public AudioClip bgm = this.loadSound("give_me_smile", "wav");
	public AudioClip gunshot = this.loadSound("gunShot", "wav");
//	
	public static SoundHolder getInstance() {
		return instance;
	}

	public SoundHolder() {
		super();
		System.out.println("SoundHolder");
	}

	public AudioClip loadSound(String name, String fileType) {
		return new AudioClip(ClassLoader.getSystemResource("sound/" + name + '.' + fileType).toString());
	}
}
