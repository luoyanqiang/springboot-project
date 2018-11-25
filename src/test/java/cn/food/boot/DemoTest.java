package cn.food.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.ThreadUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DemoTest {

    @Test
    public void pringStar() {
        for(int a=1;a<4;a++){
            for(int b=1;b<=4-a;b++){
                System.out.print(" ");
            }
            for(int c=1;c<=2*a-1;c++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i<=4;i++){
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*(4-i)+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    @Test
    public void testStar1() {
        int n = 3;
        for(int a = 1; a <= n; a++) {
            int spaceNum = ((n * 2 - 1) - (a * 2 - 1)) / 2;
            String spaceStr = String.join("", Collections.nCopies(spaceNum, " "));
            System.out.print(spaceStr);
            String str = String.join("", Collections.nCopies(a * 2 - 1, "*"));
            System.out.print(str);
            System.out.println();
        }
        for(int j = n - 1; j > 0; j--) {
            int spaceNum = ((n * 2 - 1) - (j * 2 - 1)) / 2;
            String spaceStr = String.join("", Collections.nCopies(spaceNum, " "));
            String str = String.join("", Collections.nCopies(j * 2 - 1, "*"));
            System.out.print(spaceStr);
            System.out.print(str);
            System.out.println();
        }

    }

    @Test
    public void testTime() {
        Integer[] arr = {1, 3, 8, 7, 5};
        List<Integer> list = Arrays.asList(arr);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(Object i : list) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void testJson() {

    }

    @Test
    public void testDays() {
        int year, month, day;
        final int DAYS_28 = 28, DAYS_29 = 29, DAYS_30 = 30, DAYS_31 = 31;
        year = 2018;
        month = 2;
        day = 16;
        int totalDays = day;
        switch(month) {
            case 12:
                totalDays += DAYS_30;
            case 11:
                totalDays += DAYS_31;
            case 10:
                totalDays += DAYS_30;
            case 9:
                totalDays += DAYS_31;
            case 8:
                totalDays += DAYS_31;
            case 7:
                totalDays += DAYS_30;
            case 6:
                totalDays += DAYS_31;
            case 5:
                totalDays += DAYS_30;
            case 4:
                totalDays += DAYS_31;
            case 3:
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    totalDays += DAYS_29;
                } else {
                    totalDays += DAYS_28;
                }
            case 2:
                totalDays += DAYS_31;
        }

        System.out.println(totalDays);
    }

    @Test
    public void testNum() {
        int day = 20180716;
        String dayStr = String.valueOf(day);
        if(dayStr.length() < 8) {
            System.out.println("格式不对");
        }

        String month = dayStr.substring(4, 6);
        System.out.println(month);

    }

    @Test
    public void testDays2() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 7, 12);
        calendar.add(Calendar.DATE, 2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(weekDay);

        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(monthDay);
    }

    @Test
    public void testArray() {
        IntRange intRange = new IntRange(1, 5);
    }
    
    
}
