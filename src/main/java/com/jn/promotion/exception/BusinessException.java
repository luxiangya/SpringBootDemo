package com.jn.promotion.exception;


import com.jn.promotion.common.result.ResultResponse;
import com.jn.promotion.common.result.ResultResponseEnum;

import java.util.List;

public class BusinessException extends RuntimeException {

    private ResultResponse resultResponse;

    public ResultResponse getResultResponse() {
        return resultResponse;
    }

    /**
     * 返回自定义异常
     *
     * @param resultResponseEnum
     */
    public BusinessException(ResultResponseEnum resultResponseEnum) {
        super(resultResponseEnum.getDesc());
        this.resultResponse = new ResultResponse(resultResponseEnum);
    }

    /**
     * 返回自定义异常
     *
     * @param resultResponseEnum
     */
    public BusinessException(ResultResponseEnum resultResponseEnum, String param) {
        super(resultResponseEnum.getDesc());
        String message = "|param: " + param + "|message: " + resultResponseEnum.getDesc() + "|";
        this.resultResponse = new ResultResponse(resultResponseEnum);
        this.resultResponse.setMessage(message);
    }


    /**
     * 判断Object是否为null,如果为null返回数据异常
     *
     * @param object
     * @param param
     */
    public static void isNullThrow(Object object, String param) {
        if (null == object) {
            throw new BusinessException(ResultResponseEnum.NO_DATA, param);
        } else if (object instanceof List) {
            List list = (List) object;
            if (list.isEmpty()) {
                throw new BusinessException(ResultResponseEnum.NO_DATA, param);
            }
        }

    }

    /**
     * 判断Object是否为null,如果为null返回数据异常
     *
     * @param object
     */
    public static void isNullThrow(Object object) {
        if (null == object) {
            throw new BusinessException(ResultResponseEnum.NO_DATA);
        }
    }

}
