package server.utils;

import java.time.LocalTime;

/**
 * Created by maks(avto12@i.ua) on 11.02.2016.
 */
public class TimeUtilImpl implements TimeUtil {
    public String getPartOfDay(LocalTime currentTime){
        String partOfDay="";
        if (currentTime.getHour() >= 23 || currentTime.getHour() < 6)
            partOfDay= "night";
        else if (currentTime.getHour() >= 6 && currentTime.getHour() < 9) {
            partOfDay= "morning";
        } else if (currentTime.getHour() >= 9 && currentTime.getHour() < 19) {
            partOfDay= "day";
        } else if (currentTime.getHour() >= 19 && currentTime.getHour() < 23) {
            partOfDay= "evening";
        }
        /*logger.info("getPartOfDay return: {}",partOfDay);*/
        return partOfDay;
    }

    private LocalTime getCurrentTime(){
        LocalTime localTime=LocalTime.now();
        /*logger.info("Current time is: {}", localTime.toString());*/
        return localTime;
    }
}
