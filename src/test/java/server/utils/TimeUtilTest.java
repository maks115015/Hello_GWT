package server.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

/**
 * Created by maks(avto12@i.ua) on 22.02.2016.
 */
public class TimeUtilTest {

    TimeUtil service=TimeUtilImpl.getInstance();

    @Test
    public void testGetPartOfDayShouldReturnMorningBegin(){
        Assert.assertEquals("morning", getPartOfDayInString(6, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnMorningEnd(){
        Assert.assertEquals("morning", getPartOfDayInString(8, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnDayBegin(){
        Assert.assertEquals("day", getPartOfDayInString(9, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnDayEnd(){
        Assert.assertEquals("day", getPartOfDayInString(18, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningBegin(){
        Assert.assertEquals("evening", getPartOfDayInString(19, 0,0));
    }

    @Test
    public void testGetPartOfDayShouldReturnEveningEnd(){
        Assert.assertEquals("evening", getPartOfDayInString(22, 59, 59));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightMiddle(){
        Assert.assertEquals("night", getPartOfDayInString(0, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightBegin(){
        Assert.assertEquals("night", getPartOfDayInString(23, 0, 0));
    }

    @Test
    public void testGetPartOfDayShouldReturnNightEnd(){
        Assert.assertEquals("night", getPartOfDayInString(5, 59, 59));
    }


    private String getPartOfDayInString(int hour, int minute, int second){
        return service.getPartOfDay(LocalTime.of(hour, minute, second));
    }
}