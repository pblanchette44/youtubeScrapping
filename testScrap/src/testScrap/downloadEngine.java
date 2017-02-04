package testScrap;
import java.util.ArrayList;

import cmdLine.*;

public class downloadEngine {

	private String audioFormat = "mp3";
	
	downloadEngine() {

	}

	public void downloadVideoFromUrl(String url,Integer index) {
		
		String temp = index.toString();
		
		ExecCommand ec = new ExecCommand(
				"/usr/local/bin/youtube-dl -o "+ temp+".mp4 "+ url);
		extractAudioFromFile(index);
	}
	
	public void extractAudioFromFile( Integer index) {
		
		ExecCommand ec = new ExecCommand(
				"/usr/local/bin/ffmpeg -i " +index.toString()+".mp4 "+ index.toString()+".mp3");
	}
}
