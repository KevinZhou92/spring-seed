package com.pengcheng.springseed.exception;

import com.pengcheng.springseed.enums.ServiceEnums;


public class ServiceException extends RuntimeException {

    private ServiceEnums serviceEnums;

    public ServiceEnums getServiceEnums() {
        return serviceEnums;
    }
    public ServiceException(ServiceEnums serviceEnums) {
        super(serviceEnums.getMessage());
        this.serviceEnums = serviceEnums;
    }
}
