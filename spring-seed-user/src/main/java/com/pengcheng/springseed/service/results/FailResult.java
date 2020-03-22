package com.pengcheng.springseed.service.results;

import com.pengcheng.springseed.enums.ServiceEnums;

public class FailResult<T> extends BaseResult<T> {

    public FailResult() {
        setSuccess(false);
        setCode(ServiceEnums.FAILED.getCode());
        setMsg(ServiceEnums.FAILED.getMessage());
    }

    public FailResult(ServiceEnums serviceEnums) {
        setSuccess(false);
        setCode(serviceEnums.getCode());
        setMsg(serviceEnums.getMessage());
    }
    public FailResult(ServiceEnums serviceEnums, T data) {
        setSuccess(false);
        setCode(serviceEnums.getCode());
        setMsg(serviceEnums.getMessage());
        setData(data);
    }
}
