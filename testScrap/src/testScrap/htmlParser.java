package testScrap;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class htmlParser {

	htmlParser() {
		
	}
	
	public static int filterDuration(String input) {
		String temp = input.replaceAll("\\D"," ");
	    temp = temp.trim();
		return convertString(temp.split("\\D+"));
	}
	
	private static int convertString(String[] temp) {
		
		if (temp.length == 3) {
			return (Integer.parseInt(temp[0]) * 3600) + (Integer.parseInt(temp[1]) * 60) + (Integer.parseInt(temp[2]));
		} else if (temp.length == 2) {
			return (Integer.parseInt(temp[0]) * 60) + (Integer.parseInt(temp[1]));
		} else {
			try{
			return (Integer.parseInt(temp[0]));
			} catch(NumberFormatException n){
				System.out.println("couldn't get the length");
				return 0;
			}
		}
		
		
	}

	public static Integer filterViews(String input) {
		try{
		return Integer.parseInt(input.replaceAll("\\D", ""));
		} catch (NumberFormatException e) {
		return 0;	
		}
	}
	
	public String filterTitle(String input){
		
		
		return null;
	}
	
	
}
