package com.pengcheng.springseed.service.results;

import com.pengcheng.springseed.enums.ServiceEnums;

public class SuccessResult<T> extends BaseResult<T> {
    public SuccessResult() {
        setSuccess(true);
        setCode(ServiceEnums.SUCCESS.getCode());
        setMsg(ServiceEnums.SUCCESS.getMessage());
    }

    public SuccessResult(T data) {
        setSuccess(true);
        setCode(ServiceEnums.SUCCESS.getCode());
        setMsg(ServiceEnums.SUCCESS.getMessage());
        setData(data);
    }
}
