package com.dfs.datahub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

	public static void main(String args[]) {
		
		//final String EXPECTED_TIME_FORMAT = "HHmmss";
		
	}
	
	public static boolean isTimeValid(String timeFromFile, String expectedTimeFormat) {
		if (timeFromFile != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(expectedTimeFormat);
			sdf.setLenient(false);
			try {
				Date date = sdf.parse(timeFromFile);
				System.out.println(date);
			} catch (ParseException e) {
				// e.printStackTrace();
				return false;
			}
			return true;
		} else
			return false;
	}
}
