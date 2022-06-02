package com.liyeam.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liyeam
 */

@AllArgsConstructor
@ToString
@Getter
public enum RespBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务器异常");

    private final Integer code;
    private final String message;
}
