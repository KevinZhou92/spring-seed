package com.pengcheng.springseed.service.results;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult<T> implements Serializable {

    /**
     * Successfully executed or not
     */
    private Boolean success;

    /**
     * Status Code from service execution
     */
    private String code;

    /**
     * Message returned from execution of service
     */
    private String msg;

    /**
     * Result Data
     */
    private T data;

    @Override
    public String toString() {
        String jsonData = null;
        try {
            jsonData = new ObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Results: {" + "success=" + success + ", code='" + code + "\'" + ", message=" + msg + ", jsonData=" + jsonData;
    }
}
