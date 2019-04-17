package com.dfs.datahub.pig.udf;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class ToTimeFormat extends EvalFunc<String> {

	@Override
	public String exec(Tuple arg) throws IOException {
	       try
	        {
	            String input = (String)arg.get(0);
	            return StringUtils.leftPad(input.trim(), 6, "0");   //left padding no of 0 for fixed length of 6 
	        }
	        catch(Exception e)
	        {
	            //throw new IOException("Caught exception while processing the input row ", e);        	
	        	return (String)arg.get(0);
	        	
	        }
	    }
}
