package com.liyeam.seckill.utils;

import java.util.regex.Pattern;

/**
 * 校验数据是否合法
 * @author liyeam
 */
public class ValidatorUtil {

    private static final Pattern MOBILE_PATTERN = Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile) {
        if (mobile == null) {
            return false;
        }
        return MOBILE_PATTERN.matcher(mobile).matches();
    }

}
