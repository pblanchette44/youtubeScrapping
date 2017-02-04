package testScrap;

import java.util.ArrayList;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class launchscrap {

	public UserAgent userAgent;
	public ArrayList<reference> allRef;

	public launchscrap(String inputUrl) throws NotFound, ResponseException {

		allRef = new ArrayList<reference>();
		userAgent = new UserAgent();
		
		try{
		userAgent.visit(inputUrl);
		findAllRelatedVideoList(userAgent);
		} catch (ResponseException e) {
			System.out.print("Couldn't connect to page the content of the inputUrl is : " + inputUrl);
		}
		
	}

	private void findAllRelatedVideoList(UserAgent theAgent) {
			
			try {
				for (Element e : theAgent.doc.findFirst("<ul id=watch-related class = video-list>").findEach("<li>")) {
					allRef.add(scrapRelatedInfo(e)); 
				}
			} catch (NotFound e) {
				System.out.println("Couldn't find the element in the video list");
			}
			
	}

	private reference scrapRelatedInfo(Element input) throws NotFound {
		
		return new reference(findRelatedViews(input),findRelatedDurations(input),findRelatedUrl(input),findRelatedTitle(input));
	}

	private Integer findRelatedViews(Element input) {
		
		
		 return htmlParser.filterViews(input.findEach("<a>").findEvery("<span>views").innerHTML());
	}

	private Integer findRelatedDurations(Element input)  {
		try{
		return htmlParser.filterDuration(input.findEach("<a>").findFirst("<span class=accessible-description>").innerHTML());
		} catch (NotFound e)
		{
			return 0;
		}
	}

	private String findRelatedUrl(Element input) {
		 try{
		 return input.findFirst("<a>").getAt("href");
		 } catch(NotFound e)
		 {
			 return null;
		 }
	}

	private String findRelatedTitle(Element input) throws NotFound {
		try{
		return input.findEach("<a>").findFirst("<span dir=ltr class=title>").innerHTML();
		} catch(NotFound e) {
			return null;
		}
	}

	public void formatReference() {
	     
		ArrayList<reference> temp = new ArrayList<reference>();
		for(reference r: allRef)
	     {
	    	 if(r.url == null)
	    	 {
	    		 temp.add(r);
	    	 }
	     }
		allRef.removeAll(temp);
	}

	public ArrayList<reference> outputReferences() {
		return allRef;
	}
	
	public ArrayList<String> outputReferencesTitles() {
		ArrayList<String> temp = new ArrayList<String>();
		for(reference r: allRef) {
			temp.add(r.title);
		}
		return temp;
	}

}
