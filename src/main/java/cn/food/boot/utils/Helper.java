package cn.food.boot.utils;

import java.util.Date;

public class Helper {
    private static String key = "wow!@#$%";

    public static int getTimeOfSecond() {
        Date date = new Date();
        String time = String.valueOf(date.getTime() / 1000);
        return Integer.parseInt(time);
    }

    public static boolean isStringInArray(String str, String[] array){
        for (String val:array){
            if(str.equals(val)){
                return true;
            }
        }
        return false;
    }

    public static String encode(String str){
        String enStr = "";
        try {
            enStr = DesUtil.encrypt(str, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return enStr;
    }

    public static String decode(String str) {
        String deStr = "";
        try {
            deStr = DesUtil.decrypt(str, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deStr;
    }
}