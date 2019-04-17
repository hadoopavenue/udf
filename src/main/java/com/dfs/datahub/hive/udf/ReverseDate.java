package com.dfs.datahub.hive.udf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.hadoop.hive.ql.exec.UDF;

public class ReverseDate extends UDF {

	public Integer evaluate(String sDate) {
		Date _date = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		try {
			_date = (new SimpleDateFormat("yyyy-MM-dd")).parse(sDate);
		} catch (Exception e) {
			_date = new Date();
		}
		return Integer.valueOf(2147483647 - Integer.parseInt(dateFormat.format(_date)));
	}
}