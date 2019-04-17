package com.dfs.datahub.pig.udf;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

public class IsDateValid extends FilterFunc {

	private static final String EXPECTED_DATE_FORMAT = "yyyyMMdd";
	
	public Boolean exec(Tuple input)
        throws IOException
    {
        if(input == null || input.size() == 0)
            return Boolean.valueOf(false);
        return Boolean.valueOf(isDateValid((String)input.get(0), EXPECTED_DATE_FORMAT));
       
    }

	public boolean isDateValid(String dateFromFile, String expectedDateFormat) {
		if (dateFromFile == null)
			return false;
		SimpleDateFormat sdf = new SimpleDateFormat(expectedDateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(dateFromFile);
			//System.out.println(date);
		} catch (ParseException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}

}