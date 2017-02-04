package testScrap;

import java.util.ArrayList;

public class database {

	public ArrayList<reference> allRef;
	
	database() {
		allRef = new ArrayList<reference>();
	}

	/*
	public void addToDatabase(reference input,int generation) {
		allRef.get(generation).add(input);
	}
	*/

	public void addListToDatabase(ArrayList<reference> inputList) {
		allRef.addAll(inputList);
	}

	public int size() {
		return allRef.size();
	}
	
	public reference getRef(int index) {
		return allRef.get(index);
	}

	/*
	public ArrayList<String> getAllUrlFromGeneration(int generation)
	{
		ArrayList<String> allUrl = new ArrayList<String>();
		for(reference r:allRef.get(generation))
		{
			allUrl.add(r.url);
		}
		return allUrl;
	}
	*/
	
	/*
	public ArrayList<String> getAllTitlesFromGeneration(int generation)
	{
		ArrayList<String> allTitle = new ArrayList<String>();
		for(reference r:allRef.get(generation))
		{
			allTitle.add(r.title);
		}
		return allTitle;
	}
	*/
	/*
	public void displayAll() {
		
		for (ArrayList<reference> g : allRef) {
			for (reference r : g) {
				System.out.println(" new entry");
				System.out.println(" Duration is : " + r.duration);
				System.out.println(" views is : " + r.views);
				System.out.println(" adress is : " + r.url);
			}
		}

	}
	*/
	
	

}
