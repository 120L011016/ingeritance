package1 package1.java;

import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTest {
    /*
       java.util.Date类
                java.sql.Date类：
        1.两个构造器的使用
        2.两个方法的使用
            ->toString():显示当前的年月日
            ->getTime():获取当前对象对应的毫秒数。（时间戳）
        3.java.sql.Date类：对应着数据库中的日期和对象
            >如何实例化
            >sql.Date  转化为   util.Date 对象
            >util.Date 对象 转化为  sql.Date 对象
     */
    @Test
    public void test2(){
        //构造器一：Data（）：创建了一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1650597463305L);
        System.out.println(date2.toString());
        //创建了一个java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1650597463305L);
        System.out.println(date3);

        //>util.Date 对象 转化为  sql.Date 对象
        Date date4 = new java.sql.Date(1650597463305L);
        java.sql.Date date5 = (java.sql.Date) date4;

        //情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date) date6;    父类与子类的问题
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
    // 1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
    //创建SimpleDateFormat对象，1：调用对象的格式化format（）方法，该方法参数为日期类，返回值为string类
    //                        2:
    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
        Date parse = sdf.parse(format);
        System.out.println(parse);
        //*****************************************************************************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = new Date();
        String format1 = sdf1.format(date1);
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则，抛异常
        System.out.println(format1);
    }
//  Calendar 是一个抽象类
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：调用其静态方法
        Calendar calendar = Calendar.getInstance();
        //反方式二：创建其子类（GregorianCalendar）的对象
        GregorianCalendar calendar1 = new GregorianCalendar();
        System.out.println(calendar1.getClass());
        System.out.println(calendar.getClass());

        //常用方法
        //get()方法
        int i = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(i);
        //set（）
        calendar.set(Calendar.DAY_OF_MONTH,22);
        calendar.add(Calendar.DAY_OF_MONTH,22);
        //getTime（）：日历类-》Date
        //setTime():Date->日历类
        calendar.setTime(new Date());


    }

}

