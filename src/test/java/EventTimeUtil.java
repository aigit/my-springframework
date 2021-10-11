

import java.util.Date;

public class EventTimeUtil {

    public static final String EVENT_TIME_FORMAT = "yyyy-MM-dd HH:mm:00";
    // 获取事件上报统计窗口启止时间
    public static TimeInterval getTimeInterval(){
        TimeInterval timeInterval = new TimeInterval();
        Date currentTime = new Date();
        Date lastMinuteTime = new Date(currentTime.getTime() - 1000 * 60);
        String startTime = DateUtils.format(lastMinuteTime, EventTimeUtil.EVENT_TIME_FORMAT);
        String endTime = DateUtils.format(currentTime, EventTimeUtil.EVENT_TIME_FORMAT);
        timeInterval.setStartTime(startTime);
        timeInterval.setEndTime(endTime);
        return timeInterval;
    }

    public static void main(String[] args) {
        TimeInterval timeInterval = EventTimeUtil.getTimeInterval();
        System.out.println(timeInterval.getStartTime());
        System.out.println(timeInterval.getEndTime());
    }
}
