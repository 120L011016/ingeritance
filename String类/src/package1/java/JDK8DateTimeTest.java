package1 package1.java;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;

public class JDK8DateTimeTest {
    @Test
    public void test1(){
        //用静态方法创建对象
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.of(2020, 12, 11);
        System.out.println(localDate1);

        //获取相关的属性
        System.out.println(localDate1.getMonth());//DECEMBER
        System.out.println(localDate1.getMonthValue());//12

        //体现不可变性，不改变原来对象，返回新的对象，跟string类一样
        //设置相关属性

        LocalDate localDate2 = localDate1.withDayOfMonth(12);
        System.out.println(localDate2);
    }
    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //
        long milli = instant.toEpochMilli();//当前时间是本地的时间，不是z时区时间
        System.out.println(milli);

        Date date2 = new Date(milli);//Date类也是用时间戳来创建对象的
        System.out.println(date2);

        Instant instant1 = Instant.ofEpochMilli(milli);//方法同上，替代了Date类
        System.out.println(instant1);
    }
    //日期时间格式化类：DataTimeFormatter,类似于SimpleDateFormat
    //预定义的标准格式实例化    本地化相关格式，自定义相关格式
    //
    @Test
    public void test3(){
        //方式一：预定义的标准格式
//        DateTimeFormatter formatter = DateTimeFormatter:ISO_LOCAL_DATE_TIME;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        //格式化：日期-》字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String strl = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(strl);
        //解析：字符串-》日期
        System.out.println("**********************************************");
        TemporalAccessor parse = formatter.parse("2022-04-22T22:56:07.418");
        System.out.println(parse);//{},ISO resolved to 2022-04-22T22:56:07.418


        //method2:format based on localized   such as : ofLocalizedDateTime()
        //paramenter: FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        //formating:
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2022年4月22日 下午11时09分44秒

        DateTimeFormatter formatter2 = ofLocalizedDateTime(FormatStyle.MEDIUM);
        String str3 = formatter2.format(localDateTime);
        System.out.println(str3);//2022-4-22 23:11:51

        DateTimeFormatter formatter3 = ofLocalizedDateTime(FormatStyle.SHORT);
        String str4 = formatter3.format(localDateTime);
        System.out.println(str4);//22-4-22 下午11:14


        //Point3: selfDefinedFormat:  like : ofPattern()
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy年----MM月--dd日 hh:mm:ss");
        String str5 = formatter4.format(localDateTime);
        System.out.println(str5);
        //selfdefine method is the most efficieny method ,it can implement any method above all
        System.out.println("********************************************************************");
        //parsing:
        TemporalAccessor parse1 = formatter4.parse("2020年----12月--22日 11:22:22");
        System.out.println(parse1);//but why hh can't above 12 ???

    }
    @Test
    public void test4(){
        //another API'use

        //1.Data and Time with Zone   getAvailableZoneIds():get all of the ZoneId   It's a parameter to LocalDateTime.now();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();//The generic Type set
        int i=0;
        for(String s : zoneIds){
//            System.out.println(s);
            i++;
        }
        System.out.println(i);
        System.out.println();
        //There are 601 in all.
        //2:get the time correspond to the place that you want.
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);


        //方法二:get the Date and Time of the place derectly by create a object
        //now(); get the Date and Time of current time zone.
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //now(ZoneId id):get the Date and Time for the specified time zone.
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime1);





    }

    @Test
    public void test5(){
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime = LocalTime.of(15, 22, 3);
        //between(),static method that can creat an object of duration.
        Duration duration = Duration.between(localTime, localTime1);
        System.out.println(duration);

        System.out.println(duration.getSeconds());
        System.out.println(duration.toHours());
        //it can also apply in the LocalDateTime type

        //period:to count period between two date.   for LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.of(2021, 12, 11);
        System.out.println(localDate1);
        Period period = Period.between(localDate1, localDate);
        int days = period.getDays();
        System.out.println(days);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());

        Period period1 = period.withYears(2);
        System.out.println(period1);
        System.out.println(period1.getMonths());
        System.out.println(period1.getDays());
        System.out.println(period1.getYears());



    }

    @Test
    public void test6(){
        //TemporalAdjuster
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
//        System.out.println(temporalAdjuster);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(LocalDateTime.now());
        System.out.println(localDateTime);//return the next sunday'date.

        //get the next workday

        TemporalAdjuster temporalAdjuster1 = new TemporalAdjuster() {

            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate localDate = (LocalDate) temporal;
                if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return localDate.plusDays(2);
                } else if (localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return localDate.plusDays(3);
                } else {
                    return localDate.plusDays(1);
                }
            }
        };
        //if we new TemporalAdjuster(),we mush override the method of public Temporal AdjustInto(Temporal temporal)
        //then when we call the adjustInto method that we implement.
        LocalDate localDate = LocalDate.now().with(temporalAdjuster1);
        System.out.println("the next workingday is :"+localDate);


    }


}
