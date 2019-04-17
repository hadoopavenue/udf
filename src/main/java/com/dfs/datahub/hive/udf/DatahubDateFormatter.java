package com.dfs.datahub.hive.udf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.hadoop.hive.ql.exec.UDF;

public class DatahubDateFormatter extends UDF {

	public String evaluate(String sDate, String inputFormat, String outputFormat) {
		Date _date = null;
		DateFormat dateFormat;
		if (outputFormat.equalsIgnoreCase("reverse")) {
			dateFormat = new SimpleDateFormat("yyyyMMdd");
			dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
			try {
				_date = (new SimpleDateFormat(inputFormat)).parse(sDate);
			} catch (Exception e) {
				_date = new Date();
			}
			return String.valueOf(2147483647 - Integer.parseInt(dateFormat.format(_date)));
		}
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		try {
			_date = (new SimpleDateFormat(inputFormat)).parse(sDate);
		} catch (Exception e) {
			_date = new Date();
		}
		return dateFormat.format(_date);
	}
}