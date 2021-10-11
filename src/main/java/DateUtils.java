

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liujianqing
 * @date 2018/11/12
 */
public class DateUtils {
    /**
     * 精确到日期.
     */
    public static final String DATE_FORMAT = "yyyy-M-d";
    /**
     * 精确到日期.
     */
    public static final String DATE_FORMAT_STD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_STD2 = "yyyyMMdd";
    /**
     * 精确到日期.
     */
    public static final String DATE_FORMAT_ZH = "yyyy年M月d日";
    public static final SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 只有小时和分钟.
     */
    public static final String HOUR_MINUTE_FORMAT_ZH = "H时mm分";

    /**
     * 精确到分钟.
     */
    public static final String MINUTE_FORMAT = "yyyy-M-d H:mm";


    /**
     * 精确到日.
     */
    public static final String DAY_FORMAT = "yyyy-MM-dd";

    /**
     * 精确到秒钟.
     */
    public static final String SECOND_FORMAT = "yyyy-M-d H:mm:ss";

    /**
     * 精确到秒钟.
     */
    public static final String SECOND_FORMAT_WITH = "yyyy-MM-dd HH:mm:ss";

    public static final String MTTIME = "yyyyMMddHHmmss";

    /**
     * 将日期类型转换为精确到天的字符串
     * <p>
     * 字符串格式为yyyy-MM-dd
     *
     * @param date 日期类型
     * @return String 日期
     */
    public static String date2String(Date date) {
        SimpleDateFormat clsFormat = new SimpleDateFormat("yyyy-MM-dd");
        return clsFormat.format(date);
    }

    /**
     * 将日期类型转换为指定格式的字符串
     *
     * @param date 日期类型
     * @param frm  需要转换的格式,具体格式参加java说明
     * @return String 日期
     */
    public static String date2String(Date date, String frm) {
        SimpleDateFormat clsFormat = new SimpleDateFormat(frm);
        return clsFormat.format(date);
    }

    public static Date addSeconds(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }


    /**
     * 加几天时间.
     *
     * @param daynum 要加天数
     * @return 天数累加后时间
     */
    public static String addDate(final int daynum) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daynum);
        return getDate(cal.getTimeInMillis());
    }




    /**
     * minute分钟之后.
     *
     * @param minute 分钟数
     * @return 累加分钟数后的时间
     */
    public static String addTime(final int minute) {
        long millis = System.currentTimeMillis();
        millis = millis + (minute * 60L * 1000L);
        return getTime(millis);
    }

    public static String format(Date optime, String secondFormatWith) {
        SimpleDateFormat getTimeFormat = new SimpleDateFormat(secondFormatWith);
        return getTimeFormat.format(optime);
    }

    /**
     * 将日期类型转换为字符串类型.
     *
     * @param date    待转换的日期
     * @param pattern 转换为字符串的格式规定
     * @return 转换后的日期字符串
     */
    public static String formatByPattern(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 获取该时间中的小时（24小时）.
     *
     * @param date 待获取小时值的时间
     * @return 小时值
     */
    public static int get24Hour(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取给定时间的一个月以后的时间.
     *
     * @param time 给定的时间
     * @return Date
     */
    public static Date getAMonthAfter(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time.getTime() + 3600000 * 24 * 30);
        return cal.getTime();
    }

    /**
     * 获取系统当前时间戳精确到秒 <br />
     * 格式：yyyy-M-d H:mm:ss.
     *
     * @return 系统当前时间戳
     */
    public static String getCurrentTimestamp() {
        return format(new Date(), DateUtils.SECOND_FORMAT);
    }

    /**
     * 以制定格式获取系统当前时间戳 <br />
     * .
     */
    public static String getCurrentTimestamp(String format) {
        return format(new Date(), format);
    }

    /**
     * 获取该时间中的日期.
     *
     * @param date 给定时间
     * @return 时间内的日期
     */
    public static Date getDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 同步获取时间.
     *
     * @param millis 给定时间戳
     * @return 日期字符串
     */
    public static synchronized String getDate(final long millis) {
        Date date = new Date();
        if (millis > 0) {
            date.setTime(millis);
        }
        return GET_DATE_FORMAT.format(date);
    }

    /**
     * 获取该时间中的日期.
     *
     * @param date 给定时间
     * @return 日期字符串
     */
    public static String getDateString(Date date) {
        return format(getDate(date), SECOND_FORMAT_WITH);
    }

    /**
     * 以给定格式获取该时间中的日期.
     */
    public static String getDateString(Date date, String pattern) {
        return format(getDate(date), pattern);
    }

    /**
     * 获取几天之后的时间.
     *
     * @param today 当前时间
     * @param num   天数规定
     * @return 几天之后的时间值
     */
    public static Date getDayAfter(Date today, int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }

    /**
     * 获取xx秒后的时间
     *
     * @param from 时间点
     * @param xx   秒数
     * @return
     */
    public static Date getBeforeXSecondTime(Date from, int xx) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(from);
        ca.set(Calendar.SECOND, ca.get(Calendar.SECOND) - xx);
        return ca.getTime();
    }


    /**
     * 判断当前日期是星期几<br>
     * . <br>
     *
     * @return dayForWeek 判断结果<br>
     * 解析出错的情况下返回-1<br>
     */
    public static int getDayForWeek(Long millis) {
        try {
            Calendar cc = Calendar.getInstance();
            cc.setTimeInMillis(millis);
            int dayForWeek = 0;
            if (cc.get(Calendar.DAY_OF_WEEK) == 1) {
                dayForWeek = 7;
            } else {
                dayForWeek = cc.get(Calendar.DAY_OF_WEEK) - 1;
            }
            return dayForWeek;
        } catch (Exception ex) {
            return -1;
        }
    }

    /**
     * 判断当前日期是星期几<br>
     * . <br>
     *
     * @param pTime 修要判断的时间<br>
     * @return dayForWeek 判断结果<br>
     * 解析出错的情况下返回-1<br>
     */
    public static int getDayForWeek(String pTime) {
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT_STD);
            Calendar cc = Calendar.getInstance();
            cc.setTime(format.parse(pTime));
            int dayForWeek = 0;
            if (cc.get(Calendar.DAY_OF_WEEK) == 1) {
                dayForWeek = 7;
            } else {
                dayForWeek = cc.get(Calendar.DAY_OF_WEEK) - 1;
            }
            return dayForWeek;
        } catch (Exception ex) {
            return -1;
        }
    }

    /**
     * currentDate所在的月的1号.
     *
     * @param currentDate 当前日期字符串
     * @return 下个月1号日期
     */
    public static Date getFirstDateOfCurrentMonth(String currentDate) {
        return getFirstDateOfMonth(currentDate, 0);
    }

    /**
     * currentDate所在的月的 后面x个月的1号.
     *
     * @param xx 0表示当前月，负数表示之前的月
     */
    public static Date getFirstDateOfMonth(String currentDate, int xx) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(parse(currentDate, DATE_FORMAT_STD));
        ca.set(Calendar.DAY_OF_MONTH, 1);
        ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + xx);

        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    public static int getHour() {
        Calendar cld = Calendar.getInstance();
        return cld.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取该时间中的小时.
     */
    public static int getHourOfDay(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        return ca.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取该时间中的分钟（24小时）.
     */
    public static int getMinute(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MINUTE);
    }

    /**
     * currentDate所在的星期的 周一的日期.
     */
    public static Date getMondayOfCurrentWeek(String currentDate) {
        return getMondayOfCurrentWeekFromDate(parse(currentDate, DATE_FORMAT_STD));
    }

    /**
     * currentDate所在的星期的 周一的日期.
     */
    public static Date getMondayOfCurrentWeekFromDate(Date currentDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(currentDate);
        ca.set(Calendar.DAY_OF_WEEK, 2);

        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 根据时间from，获取from的前x天的时间.
     */
    public static String getPastXDate(Date from, int xx) {
        return format(getPastXDateTime(from, xx), SECOND_FORMAT_WITH);
    }


    /**
     * 获取前x天的时间.
     */
    public static String getPastXDate(int xx) {
        return format(getPastXDateTime(xx), SECOND_FORMAT_WITH);
    }

    /**
     * 根据时间from，获取from的前x天的时间.
     */
    public static Date getPastXDateTime(Date from, int xx) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(from);

        ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR) - xx);

        return ca.getTime();
    }

    /**
     * 获取前x天的时间.
     */
    public static Date getPastXDateTime(int xx) {
        Calendar ca = Calendar.getInstance();

        ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR) - xx);

        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 获取前x小时的时间（小时）.
     */
    public static String getPastXHour(int xx) {
        return format(getPastXHourTime(xx), SECOND_FORMAT_WITH);
    }

    /**
     * 获取前x小时的时间（小时）.
     */
    public static Date getPastXHourTime(int xx) {
        Calendar ca = Calendar.getInstance();

        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - xx);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 获取前x小时的时间（小时）.
     */
    public static Date getPastXMinuteTime(int xx) {
        Calendar ca = Calendar.getInstance();

        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) - xx);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 获取给定日期的后一天.
     */
    public static Date getSpecifiedDayAfter(Date specifiedDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(specifiedDay);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * 获取系统当前时间戳 格式：yyyy-MM-dd HH:mm:ss.
     */
    public static String getStdCurrentTimestamp() {
        return format(new Date(), DateUtils.SECOND_FORMAT_WITH);
    }

    /**
     * currentDate所在的月的1号.
     */
    public static String getStringFirstDateOfCurrentMonth(String currentDate) {
        return getStringFirstDateOfMonth(currentDate, 0);
    }

    /**
     * currentDate所在的月的 下个月的1号.
     */
    public static String getStringFirstDateOfMonth(String currentDate, int xx) {
        return format(getFirstDateOfMonth(currentDate, xx), DATE_FORMAT_STD);
    }


    /**
     * currentDate所在的星期的 周一的日期.
     */
    public static String getStringMondayOfCurrentWeek(String currentDate) {
        return format(getMondayOfCurrentWeek(currentDate), DATE_FORMAT_STD);
    }

    public static String getTime() {
        return getTime(0);
    }

    /**
     * 通过时间戳获取时间.
     */
    public static String getTime(final long millis) {
        Date date = new Date();
        if (millis > 0) {
            date.setTime(millis);
        }
        SimpleDateFormat getTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getTimeFormat.format(date);
    }

    /**
     * 获取精确到小时的时间.
     */
    public static Date getTimeByPrecisionOfHour(Date currentDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(currentDate);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }



    /**
     * 精确到秒的时间戳
     */
    public static Long getTimeStemp(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 获取今天的日期，例如：2011-07-20.
     */
    public static Date getToday() {
        Calendar ca = Calendar.getInstance();

        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return ca.getTime();
    }


    /**
     * 判断日期是否在现在之前.
     */
    public static boolean isDateBeforeNow(String date, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date destDate = format.parse(date);
        return destDate.before(new Date());
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    /**
     * 是否是今天.
     */
    public static boolean isToday(Date time) {
        boolean isToday = false;
        if (toFullDayStr(time).equals(toFullDayStr(new Date()))) {
            isToday = true;
        }
        return isToday;
    }

    /**
     * 将日期字符串转化为日期对象.
     */
    public static Date parse(String date, String pattern) {
        return parse(date, pattern, null);
    }

    /**
     * 将日期字符串转化为日期对象.
     */
    public static Date parse(String date, String pattern, Date defaultVal) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date xx = defaultVal;
        try {
            xx = format.parse(date);
        } catch (Exception e) {
            return xx;
        }
        return xx;
    }

    /**
     * 分割时间.
     *
     * @param interval 单位：天
     */
    public static List<Date> splitDate(Date start, Date end, int interval) {
        return splitDate(start, end, Calendar.DAY_OF_YEAR, interval);
    }

    /**
     * 分割时间.
     *
     * @param type 时间类型，天，小时等
     */
    private static List<Date> splitDate(Date start, Date end, int type, int interval) {

        Calendar ca = Calendar.getInstance();
        ca.setTime(start);

        List<Date> list = new ArrayList<Date>();
        list.add(start);

        do {
            ca.set(type, ca.get(type) + interval);
            list.add(ca.getTime());
        } while (ca.getTime().before(end));

        if (list.size() > 1) {
            list.remove(list.size() - 1);
        }

        list.add(end);

        return list;
    }

    /**
     * 分割时间.
     */
    public static List<Date> splitHour(Date start, Date end, int interval) {
        return splitDate(start, end, Calendar.HOUR_OF_DAY, interval);
    }

    /**
     * 把时间戳time转换成date.
     *
     * @param time 待转换的时间戳
     * @return 转换后的时间
     */
    public static Date toDate(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.getTime();
    }

    /**
     * 把时间戳time转换成秒数
     *
     * @param time 待转换的时间戳
     * @return　转换后的秒数
     */
    public static long toSecond(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.get(cal.SECOND);
    }

    /**
     * 获取当前时间秒数
     *
     * @return　得到系统统当前时间秒数
     */
    public static long getSecondTimeStamp(long time) {
        return time / 1000;
    }

    /**
     * 把字符串日期转成date.
     */
    public static Date toDate(String dateStr) {
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = ff.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String toDateStr(final Date date) {
        SimpleDateFormat ff = new SimpleDateFormat("MM-dd HH:mm");
        return ff.format(date);
    }

    public static String toFullDateStr(final Date date) {
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ff.format(date);
    }

    public static String toFullDayStr(final Date date) {
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        return ff.format(date);
    }

    public static String toMonthDay(final Date date) {
        SimpleDateFormat ff = new SimpleDateFormat("MM-dd");
        return ff.format(date);
    }

    public static String toShortTimeStr(final Date date) {
        SimpleDateFormat ff = new SimpleDateFormat("HH:mm");
        return ff.format(date);
    }

    /**
     * 测试dateStr是否是 dddd-dd-dd 的格式.
     */
    public static boolean validate(String dateString) {
        // 使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)
        Pattern pp = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");
        Matcher mm = pp.matcher(dateString);
        if (!mm.matches()) {
            return false;
        }

        // 得到年月日
        String[] array = dateString.split("-");
        int year = Integer.valueOf(array[0]);
        int month = Integer.valueOf(array[1]);
        int day = Integer.valueOf(array[2]);

        if (month < 1 || month > 12) {
            return false;
        }
        int[] monthLengths = new int[]{0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            monthLengths[2] = 29;
        } else {
            monthLengths[2] = 28;
        }
        int monthLength = monthLengths[month];
        if (day < 1 || day > monthLength) {
            return false;
        }
        return true;
    }

    private DateUtils() {

    }

    public static Date getNextDay(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);

        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取2个date之间间隔的天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static int getIntervalDayNum(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 获取xx分钟前的时间
     *
     * @param from 时间点
     * @param xx   分钟数
     * @return
     */
    public static Date getPastXMinuteTime(Date from, int xx) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(from);

        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) - xx);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 获取xx分钟后的时间
     *
     * @param from 时间点
     * @param xx   分钟数
     * @return
     */
    public static Date getAfterXMinuteTime(Date from, int xx) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(from);

        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) + xx);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 获取给定日期字符串前xx天的日期字符串.
     *
     * @param date
     * @param xx
     * @param dateFormat
     * @return
     */
    public static String getPastXDayDateString(String date, int xx, String dateFormat) {
        return getDateString(getPastXDateTime(DateUtils.parse(date, dateFormat), xx),
                dateFormat);
    }

    /**
     * 将当前时间转换成字符串
     *
     * @return 转换后的日期字符串
     */
    public static String formatByNowDate() {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STD2);
        return format.format(new Date());
    }

    /**
     * 时分秒格式00:00:00转换秒数
     *
     * @param time //时分秒格式00:00:00
     * @return 秒数
     */
    public static String getSecond(String time) {
        Integer s = 0;
        if (time.length() == 8) { //时分秒格式00:00:00
            int index1 = time.indexOf(":");
            int index2 = time.indexOf(":", index1 + 1);
            s = Integer.parseInt(time.substring(0, index1)) * 3600;//小时
            s += Integer.parseInt(time.substring(index1 + 1, index2)) * 60;//分钟
            s += Integer.parseInt(time.substring(index2 + 1));//秒
        }
        if (time.length() == 5) {//分秒格式00:00
            s = Integer.parseInt(time.substring(time.length() - 2)); //秒  后两位肯定是秒
            s += Integer.parseInt(time.substring(0, 2)) * 60;    //分钟
        }
        if (time.length() < 5) {//直接是秒数
            s = Integer.parseInt(time);
        }
        return String.valueOf(s);
    }

    /**
     * 将当前时间转换成字符串
     *
     * @return 转换后的日期字符串
     */
    public static String formatByCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STD);
        return format.format(new Date());
    }




    /**
     * 根据时间from，获取from的前x天的时间（yyyy-MM-dd）.
     */
    public static String getPastXDateOfStr(Date from, int xx) {
        return format(getPastXDateTime(from, xx), DATE_FORMAT_STD);
    }

    /**
     * 获取当前时间年份
     *
     * @return 年份字符串
     */
    public static String getYearString() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        return String.valueOf(year);
    }



    /**
     * 将日期类型转换为精确到天的字符串
     * <p>
     * 字符串格式为yyyy-MM-dd
     *
     * @param date 日期类型
     * @return String 日期
     */
    public static String dateToString(Date date) {
        SimpleDateFormat clsFormat = new SimpleDateFormat("yyyy/MM/dd");
        return clsFormat.format(date);
    }

    /**
     * 时间差
     *
     * @param endDate
     * @param nowDate
     * @return
     */
    public static Long getDatePoor(Date endDate, Date nowDate) {
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少分钟
        long min = diff / nm;
        return min;
    }

    /**
     * @param endDate
     * @param nowDate
     * @return
     */
    public static Long getDateSecondPoor(Date endDate, Date nowDate) {
        long nm = 1000;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少秒
        long min = diff / nm;
        return min;
    }

    /**
     * 秒转化为天小时分秒字符串
     *
     * @param seconds
     * @return String
     */
    public static String formatSeconds(int seconds) {
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        temp = seconds / 3600;
        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");   //时

        temp = seconds % 3600 / 60;
        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");  //分

        temp = seconds % 3600 % 60;
        sb.append((temp < 10) ? "0" + temp : "" + temp);  //秒

        return sb.toString();
    }


}
