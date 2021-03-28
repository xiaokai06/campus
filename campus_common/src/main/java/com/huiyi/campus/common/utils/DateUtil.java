package com.huiyi.campus.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 */
public class DateUtil {
	private static Log logger = LogFactory.getLog(DateUtil.class);

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String SHORT_FORMAT = "yyyy-MM-dd HH:mm";

	public static final String HOUR_FORMAT = "yyyy-MM-dd HH";

	public static final String HOUR_FORMAT_MM = "yyyy-MM-dd HH:00";

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String MONTH_FORMAT = "yyyy-MM";

	public static final String DATE_FORMAT_MMDDHHMM = "MM-dd HH:mm";

	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String DATE_FOMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String DATE_FOMATE_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	public static final String REPORT_NAME_FORMAT = "yyyyMMddHH";
	public static final String DAY_FORMAT = "yyyyMMdd";

	public static final String START_FORMAT = "yyyy-MM-dd 00:00:00";

	public static final String END_FORMAT = "yyyy-MM-dd 23:59:59";

	public static final String MM_START_FORMAT = "yyyy-MM-dd 00:00";

	public static final String MM_END_FORMAT = "yyyy-MM-dd 23:59";


	/**
	 * 获取当前应用系统时间
	 */
	public static String currentTime() {
		return getDateStr(new Date(), DEFAULT_FORMAT);
	}

	/**
	 * 日期转换为yyyyMMdd 的字符串
	 */
	public static String getDateStr(Date date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.format(date);
	}

	/**
	 * 将字串转成日期和时间
	 *
	 * @return Date
	 */
	public static Date convertStrToDate(String date, String format) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(date);
	}

	public static Date convertStrToDate(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(DEFAULT_FORMAT);
		return formatter.parse(date);
	}

	/**
	 * 获取当前时间，并返回指定格式的时间字符串。
	 *
	 * @param format 格式
	 * @return String
	 */
//  public static String getCurrentDate(String format) {
//    return new DateTime().toString();
//  }

	/**
	 * 格式化时间
	 *
	 * @param format 格式
	 * @return String
	 */
//  public static String format(Timestamp date, String format) {
//    return new DateTime(date).toString(format);
//  }

	/**
	 * 格式化时间
	 */
//  public static String format(Date date, String format) {
//    return new DateTime(date).toString(format);
//  }

	/**
	 * 格式化时间
	 */
//  public static String format(Date date) {
//    return new DateTime(date).toString(DEFAULT_FORMAT);
//  }

	/**
	 * 计算几天前的时间
	 */
//  public static Date getDateBefore(Date d, int day) {
//    return new DateTime(d).minusDays(day).toDate();
//  }

 /* public static List<Date> getDateListBefore(Date d, int day) {
    List<Date> dateList = new ArrayList<Date>();
    for (int i = 0; i < day; i++) {
      dateList.add(new DateTime(d).minusDays(i).toDate());
    }
    return dateList;
  }*/

	/**
	 * 计算几天前的时间
	 */
 /* public static String getDateBefore(Date d, int day, String format) {
    return new DateTime(d).minusDays(day).toString(format);
  }*/

	/**
	 * 计算几小时前的时间
	 */
//  public static Date getHourBefore(Date d, int hour) {
//    return new DateTime(d).minusHours(hour).toDate();
//  }

	/**
	 * 计算几个月的时间
	 */
//  public static Date getMonthBefore(Date d, int month) {
//    return new DateTime(d).minusMonths(month).toDate();
//  }

	/**
	 * 计算时间间隔
	 */
//  public static int getDayBetween(Date d1, Date d2) {
//    DateTime dt1 = new DateTime(d1);
//    DateTime dt2 = new DateTime(d2);
//    Period p = new Period(dt1, dt2, PeriodType.days());
//    return p.getDays();
//  }

	/**
	 * 日期转string
	 *
	 * @param dateDate to str
	 */
	public static String dateToStrLong(Date dateDate, SimpleDateFormat formatter) {
		String dateString = formatter.format(dateDate);
		return dateString;
	}


 /* public static String getCurrentMonth(String format) {
    return new DateTime(new Date()).toString(format);

  }*/

	/**
	 * 获取YYYY格式
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 获取YYYY格式
	 */
	public static String getYear(Date date) {
		return formatDate(date, "yyyy");
	}

	/**
	 * 获取YYYY-MM-DD格式
	 */
	public static String getDay() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取YYYY-MM-DD格式
	 */
	public static String getDay(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 获取YYYYMMDD格式
	 */
	public static String getDays() {
		return formatDate(new Date(), "yyyyMMdd");
	}

	/**
	 * 获取YYYYMMDD格式
	 */
	public static String getDays(Date date) {
		return formatDate(date, "yyyyMMdd");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 */
	public static String getTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss.SSS格式
	 */
	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * 获取YYYYMMDDHHmmss格式
	 */
	public static String getAllTime() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 */
	public static String getTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtils.isNotBlank(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * @return boolean
	 * @Title: compareDate
	 * @Description:(日期比较，如果s>=e 返回true 否则返回false)
	 * @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		Date sDate = parseDate(s);
		Date eDate = parseDate(e);
		if (eDate == null || sDate == null) {
			return false;
		} else {
			return sDate.getTime() >= eDate.getTime();
		}
	}

	/**
	 * 格式化日期
	 */
	public static Date parseDate(String date) {
		return parse(date, "yyyy-MM-dd");
	}

	/**
	 * 格式化日期
	 */
	public static Date parseTime(String date) {
		return parse(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化日期
	 */
	public static Date parse(String date, String pattern) {
		try {
			Date result = DateUtils.parseDate(date, pattern);
			return result;
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public static Date parse2(String date, String pattern) throws ParseException {
		return DateUtils.parseDate(date, pattern);
	}

	/**
	 * 校验日期是否合法
	 */
	public static boolean isValidDate(String s) {
		return parse(s, "yyyy-MM-dd HH:mm:ss") != null;
	}

	/**
	 * 获取前月的第一天 ÅÅ
	 */
  /*public static String getMonthFirstDay(Date date,String format) {
    //获取前月的第一天
    Calendar cal_1 = Calendar.getInstance();//获取当前日期
    cal_1.setTime(date);
    cal_1.add(Calendar.MONTH, 0);
    cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天

    return format(cal_1.getTime(),format);

  }*/
	/**
	 * 获取前月的最后一天
	 */
 /* public static String getMonthLastDay(Date date,String format) {
    Calendar cal_1 = Calendar.getInstance();//获取当前日期
    cal_1.setTime(date);
    cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
    //获取前月的最后一天
    return format(cal_1.getTime(),format);
  }*/

	/**
	 * 校验日期是否合法
	 */
	public static boolean isValidDate(String s, String pattern) {
		return parse(s, pattern) != null;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
					startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 *
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			if (endDate != null) {
				day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
			} else {
				logger.error("对象endDate为null，请调试程序");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return day;
		// System.out.println("相隔的天数="+day);
	}

	/**
	 * 得到n天之后的日期
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

/*  public static Date formatDateStart(Date date) {
    if (date == null) {
      return DateUtil.formatDateStart(new Date());
    }
    return DateUtil.parseTime(DateUtil.format(date,DateUtil.START_FORMAT));
  }*/

 /* public static Date formatDateEnd(Date date) {
    if (date == null) {
      return DateUtil.formatDateEnd(new Date());
    }
    return DateUtil.parseTime(DateUtil.format(date,DateUtil.END_FORMAT));
  }*/

	public static String getYearYY() {
		return new SimpleDateFormat("yy", Locale.CHINESE).format(Calendar.getInstance().getTime());
	}

	public static void main(String[] args) throws Exception {
//    System.out.println(DateUtil.getDateBefore(new Date(), 1));


	}

}
