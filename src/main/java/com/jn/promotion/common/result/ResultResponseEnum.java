package com.jn.promotion.common.result;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum ResultResponseEnum implements Serializable {

    SUCCESS(200, "ok"),
    // 1000-1999 表示系统层面异常
    SYSTEM_ERROR(1000, "系统异常"),
    NO_DATA(1001, "暂无数据"),
    OPERATION_FAILED(1002, "操作失败"),
    ILLEGAL_PARA_METE(1003, "参数非法"),
    REQUIRED_PARAMETERS_ARE_MISSING(1004, "必要参数缺失"),
    REQUEST_BODY_EXCEPTION(1005, "请求体异常,非JSON"),
    MYCAT_ERROR(1006, "MyCat错误"),
    //2000-2100 表示用户相关
    USER_PASSWORD_IS_WRONG(2000, "用户密码错误"),
    ;


    private Integer code;

    private String desc;

}
