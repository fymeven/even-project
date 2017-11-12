package com.even.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * author huangshiping
 * 
 * @date:Aug 28, 201511:51:28 AM
 * @version:1.0
 */
public class DateUtil {

	private static final Logger logger = Logger.getLogger(DateUtil.class
			.getName());
	private static final String DEFAULTFORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DEFAULTFORMAT_SS = "yyyy-MM-dd HH:mm:ss:SSS";
	private static final String SHORTDEFAULTFORMAT = "yyyy-MM-dd";

	/**
	 * 获取当前时间 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getLongCurrTimes() {
		SimpleDateFormat df = new SimpleDateFormat(DEFAULTFORMAT);
		String dateFormart = df.format(new Date());
		return dateFormart;
	}

	/**
	 * 获取当前时间 格式 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getLongCurrTimesSS() {
		SimpleDateFormat df = new SimpleDateFormat(DEFAULTFORMAT_SS);
		String dateFormart = df.format(new Date());
		return dateFormart;
	}

	/**
	 * 获取当前时间 格式 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getShortCurrTimes() {
		SimpleDateFormat df = new SimpleDateFormat(SHORTDEFAULTFORMAT);
		String dateFormart = df.format(new Date());
		return dateFormart;
	}

	public static Date getDateFormat(long millis) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(millis);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	public static String DateChangeStr(Date date) {
		String dateFormart = null;
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(SHORTDEFAULTFORMAT);
			dateFormart = df.format(date);
		}
		return dateFormart;
	}

	public static Date getDateShotFormat(long millis) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(millis);
			SimpleDateFormat df = new SimpleDateFormat(SHORTDEFAULTFORMAT);
			return df.parse(df.format(c.getTime()));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 系统当前时间
	 * 
	 * @return
	 */
	public static Long getSysTime() {
		return new Date().getTime();
	}

	public static void main(String[] args) throws ParseException {
		System.out.print(parse("2016-12-10 11:06:09"));
	}

	public static Long getFailureTime() {
		Long time = 0l;
		try {
			DateFormat nowTime = new SimpleDateFormat(DEFAULTFORMAT);
			DateFormat specifyTime = new SimpleDateFormat(SHORTDEFAULTFORMAT);
			Date d1 = nowTime.parse(specifyTime.format(new Date())
					+ " 23:59:59");
			Date d2 = nowTime.parse(nowTime.format(new Date()));
			Long diff = d1.getTime() - d2.getTime();
			time = diff / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 当前时间新增n天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getDiffDate(int day) {
		Date dt = new Date();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DAY_OF_YEAR, day);
		return rightNow.getTime();
	}

	/*
	 * 当天日期增加或减少几天
	 */
	public static Date DateAdd(Date date, int datediff) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, datediff);
		Date times = calendar.getTime();
		return times;
	}

	public static Date DateAddHours(Date date, int hoursDiff) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hoursDiff);
		Date times = calendar.getTime();
		return times;
	}

	public static Date parse(String strDate) {
		if (StringUtils.isBlank(strDate))
			return null;
		try {
			return parse(strDate, getDatePattern());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static String getDatePattern() {
		return DEFAULTFORMAT;
	}

	public static Date parse(String strDate, String pattern)
			throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
				pattern).parse(strDate);
	}

	/**
	 * @param date
	 * @param type
	 *            0 获取年 1 获取月 2 获取日
	 * @return
	 */
	public static Integer getFormartDate(Date date, int type) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int i = 0;
		switch (type) {
		case 0:
			i = Calendar.YEAR;
			break;
		case 1:
			i = Calendar.MONTH;
			break;
		default:
			i = Calendar.DATE;
		}
		return c.get(i);
	}

	public static long dateSub(Date date1, Date date2) {
		long seconds = date1.getTime() - date2.getTime();
		return seconds;
	}
	
	/**
	 * 商品详情开始时间运算
	 * com.jiabian.util 
	 * 方法名：operatingTime
	 * 创建人：张铁成
	 * 时间：2016年12月29日-下午3:45:17 
	 * @param dateStart
	 * @param dateEnd
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String operatingTime(Date dateStart,Date dateEnd){
		long currtime = dateSub(dateEnd, dateStart);
		Long hour = currtime/1000/60/60;
		Long min = (currtime - hour *1000 *60 *60)/1000/60;
		Long second = (currtime - hour *1000 *60 *60- min*1000*60)/1000;
		StringBuilder resTime = new StringBuilder();
		
		if (hour < 10) {
			resTime.append("0").append(hour);
		}else{
			resTime.append(hour);
		}
		resTime.append(":");
		if (min < 10 ) {
			resTime.append("0").append(min);
		}else {
			resTime.append(min);
		}
		resTime.append(":");
		if (second < 10 ) {
			resTime.append("0").append(second);
		}else {
			resTime.append(second);
		}
		resTime.append(":000");
		return resTime.toString();
		
	}
}
