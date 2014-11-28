package com.dcj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @类说明：
 * @version 1.0
 */
public class DateUtil {

	/**
	 * 日期格式，年份，例如：2004，2008
	 */
	public static final String DATE_FORMAT_YYYY = "yyyy";

	/**
	 * 日期格式，年份和月份，例如：200707，200808
	 */
	public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

	/**
	 * 日期格式，年月日，例如：20050630，20080808
	 */
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

	/**
	 * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
	 */
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * 日期格式，年月日，用斜杠分开，例如：2006/12/25，2008/08/08
	 */
	public static final String DATE_FORMAT_YYYY_MM_DD2 = "yyyy/MM/dd";

	/**
	 * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
	 */
	public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

	/**
	 * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
	 */
	public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String _DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 日期格式，年月日时分，年月日用横杠分开，时分用冒号分开 例如：2005-05-10 23：20，2008-08-08 20:08
	 */
	public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";

	public static final String DATE_TIME_FORMAT_TRANS = "yyMMddHHmm";

	/**
	 * 时间格式，时分秒，冒号分开
	 */
	public static final String TIME_FORMAT_HH_MI_SS = "HH:mm:ss";

	/**
	 * 时间格式，时分，冒号分开
	 */
	public static final String TIME_FORMAT_HH_MI = "HH:mm";

	/**
	 * 返回指定n天的截至时间日期的int形式：格式为Ymd 20120810
	 * 
	 * @param days
	 * @return
	 */
	public static int deadDate(int days) {
		return Integer.parseInt(deadline(days));
	}

	/**
	 * 返回指定n天的截至时间日期的字符串：格式为Ymd 20120810
	 * 
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String deadline(int days) {
		Date date = getCurDate();
		long l = date.getTime();
		l += 1000l * 60 * 60 * 24 * days;
		return getDate2String(new Date(l));
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getCurDate() {
		return new Date();
	}

	/**
	 * 获取当前时间字符串格式（yyyyMMdd）
	 * 
	 * @return
	 */
	public static String getCurDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
		return sdf.format(getCurDate());
	}

	/**
	 * 获取当前时间指定字符串格式（format）
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getCurDate());
	}

	/**
	 * 获取给定时间(yyyyMMdd)格式时间串
	 * 
	 * @return
	 */
	public static String getDate2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
		return sdf.format(date);
	}

	/**
	 * 获取给定时间指定字符串格式
	 * 
	 * @return
	 */
	public static String getDate2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * @throws ParseException
	 *             字符串转换为日期
	 * 
	 * @param String
	 *            strDate：日期的字符串形式
	 * @param String
	 *            format：转换格式
	 * @return String
	 * @throws
	 */
	public static Date strToDate(String strDate, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;

		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期时间
	 * 
	 * @param String
	 *            strDateTime：日期时间的字符串形式
	 * @param String
	 *            format：转换格式
	 * @return String
	 * @throws
	 */
	public static Date strToDateTime(String strDateTime, String fromat) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(fromat);
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(strDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param Date
	 *            date：需要转换的日期
	 * @param String
	 *            format：转换格式
	 * @return String
	 * @throws
	 */
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 日期时间转换为字符串
	 * 
	 * @param Date
	 *            date：需要转换的日期
	 * @param String
	 *            format：转换格式
	 * @return String
	 * @throws
	 */
	public static String dateTimeToStr(Date date, String format) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format);
		return dateTimeFormat.format(date);
	}

	/**
	 * 得到当天的最开始时间,today是字符串类型"yyyy-mm-dd", 返回是日期类型"yyyy-mm-dd 00:00:00"
	 * 
	 * @param String
	 *            today
	 * @return Date
	 * @throws
	 */
	public static Date getTodayFirstTime(String today) {
		String todayfirstTime = today + " 00:00:00";
		return strToDateTime(todayfirstTime,
				DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
	}

	/**
	 * 得到当天的最后时间,today是字符串类型"yyyy-mm-dd", 返回是日期类型"yyyy-mm-dd 23:59:59"
	 * 
	 * @param String
	 *            today
	 * @return Date
	 * @throws
	 */
	public static Date getTodayLastTime(String today) {
		String todayLastTime = today + " 23:59:59";
		return strToDateTime(todayLastTime,
				DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
	}

	/**
	 * 获得今天是星期几
	 * 
	 * @return int 的 1-7
	 */
	public static int getTodayWeek() {
		Calendar cal = Calendar.getInstance();
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w == 0) {
			return 7;
		}
		// System.out.println(w);
		return w;
	}

	/**
	 * 获得指定日期是星期几
	 * 
	 * @return int 的 1-7
	 */
	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w == 0) {
			return 7;
		}
		return w;
	}

	/**
	 * 判断传入的日期是不是今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		String time = dateTimeToStr(date, DATE_FORMAT_YYYYMMDD);
		String today = dateTimeToStr(new Date(), DATE_FORMAT_YYYYMMDD);
		return time.equals(today);
	}

	public static int getNowNextHour() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour + 1;
	}

	/**
	 * 比较2个时间是否相等
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean compareDateEquals(Date date1, Date date2) {
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		return d1 == d2;
	}

	/**
	 * 字符串格式的日期转化为毫秒值
	 * 
	 * @param strDateTime
	 * @return
	 */
	public static long strToLong(String strDateTime, String format) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format);
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(strDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		return dateTime.getTime();
	}

	/**
	 * long型(20131127112323)日期转化为毫秒值
	 * 
	 * @param strDateTime
	 * @return long类型的时间
	 */
	public static long longToLong(long strDateTime, String format) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format);
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(strDateTime + "");
		} catch (ParseException e) {
			return 0;
		}
		return dateTime.getTime();
	}

}
