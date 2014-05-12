package tetris;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
 
public class Son {
	
    public URL url;
    public AudioClip ac ;
    public String name_song;
    
	
	public Son(String name) {
		name_song = name;
		url = Son.class.getResource(name_song+".wav");
		ac = Applet.newAudioClip(url);
		
	}
	
	public boolean lecture(){		
		ac.play();
		return true;
	}
	
	public void boucle(){		
		ac.loop();
	}
		
	public boolean stop(){		
		ac.stop();
		return true;
	}
 
}