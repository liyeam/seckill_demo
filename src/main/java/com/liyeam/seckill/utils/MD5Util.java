package com.liyeam.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {

    private static final String SALT = "1A2B3C4D";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    public static String inputPassToFromPass(String inputPass){
        return md5(SALT.charAt(0) + SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(4));
    }

    public static String formPassToDBPass(String formPass, String salt) {
        return md5(salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4));
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        return formPassToDBPass(inputPassToFromPass(inputPass),salt);
    }

    public static void main(String[] args) {
        String str = inputPassToFromPass("123456");
        System.out.println(str);
        System.out.println(formPassToDBPass(str,"1122233"));
        System.out.println(inputPassToDBPass("123456","1122233"));
    }
}
