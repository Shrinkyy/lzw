package com.iweb.DBUtil;

import java.util.Random;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 10:31
 */
public class StringUtil {
    private static String strPool =
            "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    public static String getRandomString(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}
