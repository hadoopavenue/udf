package com.dfs.datahub.pig.udf;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

public class IsTimeValid extends FilterFunc {

	private static final String EXPECTED_TIME_FORMAT = "HHmmss";

	public Boolean exec(Tuple input) throws IOException {
		if (input == null || input.size() == 0)
			return Boolean.valueOf(false);
		return Boolean.valueOf(isTimeValid((String) input.get(0), EXPECTED_TIME_FORMAT));
	}

	public boolean isTimeValid(String timeFromFile, String expectedTimeFormat) {
		if (timeFromFile != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(expectedTimeFormat);
			sdf.setLenient(false);
			try {
				sdf.parse(timeFromFile);
				// System.out.println(date);
			} catch (ParseException e) {
				// e.printStackTrace();
				return false;
			}
			return true;
		} else
			return false;
	}
}