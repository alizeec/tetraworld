package tetris;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
 
public class Son {
	
    public URL url;
    public AudioClip ac ;
    public String name_song;
    
	/*public Son() {
		url = Son.class.getResource("musique_tetris1.wav");
		ac = Applet.newAudioClip(url);
	}*/
	
	public Son(String name) {
		name_song = name;
		url = Son.class.getResource(name_song+".wav");
		ac = Applet.newAudioClip(url);
		
	}
	
	public void lecture(){		
		ac.play();
	}
	
	public void stop(){		
		ac.stop();
	}
 
}