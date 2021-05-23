package constants;


import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundHolder {
	private static final SoundHolder instance = new SoundHolder();
	public Media bgm = new Media(ClassLoader.getSystemResource("sound/yoitrax-warrior.wav").toString());
	public MediaPlayer bgmPlayer = new MediaPlayer(bgm);
	public String gunShot = ClassLoader.getSystemResource("sound/gunShot.wav").toString();
	public String grunt = ClassLoader.getSystemResource("sound/grunt-male_NWM.wav").toString();
	
	public static SoundHolder getInstance() {
		return instance;
	}

	public SoundHolder() {
		super();
		bgmPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   bgmPlayer.seek(Duration.ZERO);
		       }
		   });
		System.out.println("SoundHolder");
	}

	public AudioClip loadSound(String name, String fileType) {
		return new AudioClip(ClassLoader.getSystemResource("sound/" + name + '.' + fileType).toString());
	}
}
