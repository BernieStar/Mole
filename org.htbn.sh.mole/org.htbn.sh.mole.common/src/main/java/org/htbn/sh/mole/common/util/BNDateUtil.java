package org.htbn.sh.mole.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @desc 日期处理工具类
 * 
 * */
public class BNDateUtil {
	public static final String dashFormat = new String("yyyy-MM-dd");
	public static final String slashForamt = new String("yyyy/MM/dd");
	public static final String ymdFormat = new String("yyyyMMdd");
	public static final String timeFormat = new String("HH:mm:ss");
	public static final String dateTimeFormat = new String("yyyy-MM-dd HH:mm:ss");
	public static final String ignoreSecondFormat = new String("yyyy-MM-dd HH:mm");
	public static final long M_PER_DAY = 1000 * 60 * 60 * 24;
	private static SimpleDateFormat _ins = new SimpleDateFormat ("yyyyMMddHHmmssSSS");
	private static SimpleDateFormat _insa = new SimpleDateFormat ("yyMMddHHmmssSSS");
	public static SimpleDateFormat getDateStyleFromDB(){
		return new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	}
	public static SimpleDateFormat getDateStyleFromUI(){
		return new SimpleDateFormat ("yyyy-MM-dd");
	}
	public static SimpleDateFormat getDateStyleFromUIForMoon(){
		return new SimpleDateFormat ("yyyy-MM");
	}
	public static SimpleDateFormat getDateStyleFromID(){
		return _ins;
	}
	public static SimpleDateFormat getDateStyle1FromID(){
		return _insa;
	}
	public static String getCurrentDateTime(SimpleDateFormat simpleDateFormat){

	    return simpleDateFormat.format(new Date());
	}
	/**
	 * 根据给定的格式对时间类型格式化
	 * 
	 * @param date 日期
	 * @param formatString 日期表达式
	 * @return description: Modification History:
	 */
	public static String getDateString(Date date, String formatString) {
		try {
			return (date != null) ? new SimpleDateFormat(formatString).format(date) : "";
		} catch (Throwable e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * get the default dateString with style "yyyy-MM-dd"
	 * 将日期格式化成"yyyy-MM-dd"样式
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date) {
		return (date != null) ? DateFormatUtils.format(date, dashFormat) : "";
	}

	/**
	 * get the default dateString with style "HH:mm:ss"
	 * 将日期格式化成"HH:mm:ss"样式
	 * 
	 * @param date date
	 * @return
	 */
	public static String getTimeString(Timestamp time) {
		return (time != null) ? DateFormatUtils.format(time, timeFormat) : "";
	}

	/**
	 * 
	 * get the default dateString with style "yyyyMMdd-HH:mm:ss"
	 * 将日期格式化成"yyyyMMdd-HH:mm:ss"样式
	 * 
	 * @param time
	 * @return
	 */
	public static String getTimeString2(Timestamp time) {
		return (time != null) ? DateFormatUtils.format(time, ymdFormat + "-" + timeFormat) : "";
	}

	/**
	 * get the default dateString with style "yyyy-MM-dd HH:mm:ss"
	 * 将日期格式化成"yyyy-MM-dd HH:mm:ss"样式
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeString(Date date) {
		return (date != null) ? DateFormatUtils.format(date, dateTimeFormat) : "";
	}

	/**
	 * use the default date format "yyyy-MM-dd"
	 * 将"yyyy-MM-dd"格式的字符串转换为日期格式
	 * 
	 * @param dStr
	 * @return
	 */
	public static Date getDate(String dStr) {
		return (StringUtils.isEmpty(dStr)) ? null : getDate(dStr, dashFormat);
	}

	/**
	 * use the default date format "yyyy-MM-dd HH:mm:ss"
	 * 将"yyyy-MM-dd HH:mm:ss"格式的字符串转换为日期格式
	 * 
	 * @param dStr
	 * @return
	 */
	public static Date getDateTime(String dStr) {
		return (StringUtils.isEmpty(dStr)) ? null : getDate(dStr, dateTimeFormat);
	}

	/**
	 * 根据字符串、字符串格式转换为日期
	 * 
	 * @param dStr 字符串
	 * @param formatString 日期表达式
	 * @return description: Modification History:
	 */
	public static Date getDate(String dStr, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		format.setLenient(false);
		Date date = null;
		try {
			date = format.parse(dStr);
		} catch (ParseException ex) {
			ex.getStackTrace();
		}
		return date;
	}

	/**
	 * 获取给定日期当日的00:00:00时间戳，即去除日期中含有的时间数据
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateIgnoreTime(Date date) {
		GregorianCalendar gday = new GregorianCalendar();
		gday.setTime(date);
		gday.set(Calendar.HOUR, 0);
		gday.set(Calendar.HOUR_OF_DAY, 0);
		gday.set(Calendar.MINUTE, 0);
		gday.set(Calendar.SECOND, 0);
		gday.set(Calendar.MILLISECOND, 0);
		return gday.getTime();
	}

	/**
	 * convent method to get days after or before
	 * 根据天数偏移量计算日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateAfter(Date date, int days) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * convent method to get days after or before
	 * 根据年、月、日偏移量计算最终日期
	 * 
	 * @param date
	 * @param year
	 * @param month
	 * @param days
	 * @return
	 */
	public static Date getDateAfter(Date date, int year, int month, int days) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.YEAR, year);
		calendar.add(GregorianCalendar.MONTH, month);
		calendar.add(GregorianCalendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 计算两个日期间间隔的天数
	 * 
	 * @param startDate 第一个日期
	 * @param endDate 相比较日期
	 * @return
	 */
	public static Long computeDateInterval(Date startDate, Date endDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long startTime = calendar.getTimeInMillis();

		calendar.setTime(endDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long endTime = calendar.getTimeInMillis();

		return (endTime - startTime) / M_PER_DAY;
	}

	/**
	 * 获取日期中的年份数值
	 * 
	 * @param date
	 * @return
	 */
	public static int getYearForDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.YEAR);
	}

	/**
	 * 获取日期中的月份数值 calendar从 0 计数，所以需加一，才为实际所称月
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthForDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * 获取日期中的天数值
	 * 
	 * @param date
	 * @return description: Modification History:
	 */
	public static int getDayForDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(GregorianCalendar.DATE);
	}

	/**
	 * 校验日期格式是否正确
	 * 
	 * @param str
	 * @param formatString
	 * @return description: Modification History:
	 */
	public static boolean checkDateValidity(String str, String formatString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		sdf.setLenient(false);
		try {
			sdf.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 判断给定的日期是否是该月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDayOfMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return (cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 将时间格式HH：mm：ss拼接在日期中，主要供imix方法使用
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static Date getDateTime(Date date, String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		sdf.setLenient(false);
		try {
			return sdf.parse(BNDateUtil.getDateString(date, BNDateUtil.ymdFormat) + " " + time);
		} catch (Exception e) {
			return date;
		}
	}

	/**
	 * 将时间格式HH：mm：ss拼接在日期中，返回时间类型
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static Timestamp getDateTimeRtnTime(Date date, String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timeStamp = null;
		sdf.setLenient(false);
		try {
			String dateStr = sdf.format(date);
			timeStamp = Timestamp.valueOf(dateStr + " " + time);
		} catch (Exception e) {
		}
		return timeStamp;
	}

	/**
	 * 校验某日是否在一段日期区间中
	 * 
	 * @param CompareDate 待比较日期
	 * @param date1 前置日期
	 * @param date2 后置日期
	 * @return
	 */
	public static boolean isBetween(Date CompareDate, Date date1, Date date2) {
		if (date2.before(date1)) {
			Date tmp = date1;
			date1 = date2;
			date2 = tmp;
		}
		return !(CompareDate.before(date1) || CompareDate.after(date2));
	}

	/**
	 * 获取当前日期
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取当前时间
	 */
	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 日期比较函数
	 * 
	 * @param date1
	 * @param date2
	 * @return 比较两个日期的先后, date1>date2返回1， date1==date2返回0, date1<date2返回-1,
	 *         date1,date2数据错误返回-2 Modification History:
	 */
	public static int compareDate(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return -2;
		long temp = java.util.TimeZone.getDefault().getRawOffset();
		long result = (date2.getTime() + temp) / M_PER_DAY - (date1.getTime() + temp) / M_PER_DAY;
		if (result > 0) {
			return -1;
		} else if (result < 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 校验时间字符是否符合逻辑 HH:mm格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkTimeHHmmPattern(String str) {
		Pattern p = Pattern.compile("^([0-1]\\d|2[0-3]):[0-5]\\d$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 校验时间字符是否符合逻辑 yyyy-MM-dd格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkDayYYYYmmDDPattern(String str) {
		String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]"
				+ "|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1]" + "[0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|"
				+ "[3579][26])00))-02-29)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * Function Name: getCurrentMonthFirstDate
	 * 
	 * @return
	 *         description:取得当前月份的第一天
	 */
	public static Date getCurrentMonthFirstDate() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.set(Calendar.DATE, 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * Function Name: getCurrentMonthLastDate
	 * 
	 * @return
	 *         description:取得当前月份的最后一天
	 */
	public static Date getCurrentMonthLastDate() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.add(Calendar.MONTH, 1);
		gregorianCalendar.set(Calendar.DATE, 1);
		gregorianCalendar.add(Calendar.DATE, -1);
		return gregorianCalendar.getTime();
	}

	/**
	 * Function Name: getCurrentMonthLastDate
	 * 
	 * @return
	 *         description:移除日期中非数字字符
	 */
	public static String replaceNotNum(String time) {
		return time.replaceAll("[- :/]", "");
	}
	
	
	
	
	public static Date getCurrentDateTime() {

		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public static String getDateString() {

		Date date = getCurrentDateTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	public static String getDayStartTime() {
		Date date = getCurrentDateTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);
		return dateStr + " 00:00:00";
	}

	public static String getDayEndTime() {
		Date date = getCurrentDateTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);
		return dateStr + " 23:59:59";
	}

	public static String fromDateTime() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(cal.getTime());
		String dateTimeStr = dateStr + " 00:00:00";
		return dateTimeStr;
	}

	public static String toDateTime() {

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);
		String dateTimeStr = dateStr + " 23:59:59";
		return dateTimeStr;
	}

	public static String getCurDateTimeString() {

		Date date = getCurrentDateTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	public static String timeMillis() {

		return String.valueOf(System.currentTimeMillis());
	}

	public static Date getDateTimeFromStr(String dateTimeStr) throws ParseException {
		if(dateTimeStr.isEmpty()){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.parse(dateTimeStr);
	}

	public static Date getDateFromStr(String dateStr) throws ParseException {
		if(dateStr.isEmpty()){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.parse(dateStr);
	}

	public static Date getDateDayAimToNow(int daynum) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, daynum);
		cal.set(Calendar.HOUR, 24);
		cal.set(Calendar.MINUTE, 22);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(String dateStr) throws ParseException {

		DateFormat orginalFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = orginalFormat.parse(dateStr);
		DateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd");
		return objFormat.format(date);
	}

	public static String formatDate(String template, String dateStr) throws ParseException {

		DateFormat orginalFormat = new SimpleDateFormat(template);
		Date date = orginalFormat.parse(dateStr);
		DateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd");
		return objFormat.format(date);
	}
	
	public static String format2Date(String dateStr) throws ParseException {
        DateFormat orginalFormat = new SimpleDateFormat("yyyyMMddhhmmss");//14位时间转成--
        Date date = orginalFormat.parse(dateStr);
        DateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return objFormat.format(date);
    }

	public static String getDateOneMonthAfter(String date) {

		Calendar calendar = Calendar.getInstance();

		String[] dateArr = date.split("-");

		calendar.set(Calendar.YEAR, Integer.parseInt(dateArr[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(dateArr[1]));
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		DateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(objFormat.format(calendar.getTime()));
		return objFormat.format(calendar.getTime());

	}

	public static String getDateStr(Date date) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);
		return dateStr;
	}

	/**
	 * 
	 * @param date
	 * @param count
	 * @return
	 */
	public static String getMonthesAfter(String date, int count) {

		String[] dateArr = date.split("-");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(dateArr[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(dateArr[1]) + count - 1);
		calendar.set(Calendar.DATE, Integer.parseInt(dateArr[2]));

		String dateStr = getDateStr(calendar.getTime());

		return dateStr;
	}

	public static Date geYearsAfter(String dateStr, int count){

		DateFormat orginalFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = orginalFormat.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR)+count;
			calendar.set(Calendar.YEAR, year);
			return calendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 字符串时间戳转换成时间
	 * @Description: TODO
	 * @param millisecond
	 * @param format
	 * @return String
	 * @author jerry.wang
	 * @date:2016年4月12日
	 */
	 public static String timeStamp2DateTime(String millisecond,String format) {  
	        
	     if(millisecond == null || millisecond.isEmpty() || millisecond.equals("null")){  
	     
	         return "";  
	     }  

	     if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
	     
	     SimpleDateFormat sdf = new SimpleDateFormat(format);  
	     
	     return sdf.format(new Date(Long.valueOf(millisecond)));  
	}
	 
	
	
	
	/**
	 * 返回当前日期加上指定的月份后的日期
	 * @param num
	 * @return Date
	 * @author madacheng  @date:2016年4月12日
	 */
	public static Date nowDatePlusMonth(int num){
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH,num);
	    return cal.getTime();
	}
	
	/**
	 * 返回指定的日期加上指定的年份后的日期
	 * @param date 指定的日期
	 * @param year 指定的年份
	 * @return Date
	 * @author madacheng  @date:2016年4月28日
	 */
	public static Date datePlusYear(Date date,int year){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,year);
        return cal.getTime();
    }
	
	public static void main(String[] args) throws ParseException {
	    System.out.println(format2Date("20090327091010"));
    }
	
}
