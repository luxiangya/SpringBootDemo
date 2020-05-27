package com.jn.promotion.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultResponse implements Serializable {

    private Integer code;

    private String desc;

    private String message;

    private Object data;


    public ResultResponse(ResultResponseEnum resultEnum, String message, Object data) {
        this.code = resultEnum.getCode();
        this.desc = resultEnum.getDesc();
        this.message = message;
        this.data = data;
    }

    public ResultResponse(ResultResponseEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.desc = resultEnum.getDesc();
    }


}
