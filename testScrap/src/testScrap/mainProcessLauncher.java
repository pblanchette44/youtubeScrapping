package testScrap;

import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import cmdLine.ExecCommand;
import javafx.*;

public class mainProcessLauncher {

	public static void main(String[] args) {
		
		
		
		GUI theGui = new GUI();
		database db = new database();
		theGui.guiDatabase = db;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                theGui.start();
            }
        });
		
		 
		
		
		/*
		database db = new database();
		try {
			launchscrap scrapper = new launchscrap("https://www.youtube.com/watch?v=GcOl7fuUjrc");
			db.addListToDatabase(scrapper.allRef);
			db.displayAll();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//temp = trimTemp(temp);
		//db.addListToDatabase(temp);
		
		
		
		/*
		downloadEngine theEngine = new downloadEngine();
		for(int i =0; i < db.size();i++)
		{
		theEngine.downloadVideoFromUrl(db.getRef(i).url,i);
		}
		*/
		
	}
	
	

	
}
