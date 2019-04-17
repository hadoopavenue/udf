package com.dfs.datahub.hive.udf;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.hadoop.hive.ql.exec.UDF;

public class CurrentTimestamp extends UDF {

	public String evaluate(String sDate, String inputFormat, String outputFormat) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat.format(new Date());
	}
}