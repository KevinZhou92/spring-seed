package com.pengcheng.springseed.handler;

import com.pengcheng.springseed.enums.ServiceEnums;
import com.pengcheng.springseed.exception.ServiceException;
import com.pengcheng.springseed.service.results.BaseResult;
import com.pengcheng.springseed.service.results.FailResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult handleServiceException(ServiceException e) {
        return new FailResult(e.getServiceEnums());
    }

    /**
     * Handle exception being thrown out while bind request body to bean instance.
     * @param e, exception being thrown out
     * @return FailResult
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResult<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        if (e.getBindingResult().hasErrors()) {
            List<Map<String, String>> errors = getFieldAndMessage(e.getBindingResult().getAllErrors());
            return new FailResult<>(ServiceEnums.PARAMETER_BIND_FAIL, errors);
        }

        return new FailResult<>();
    }

    /**
     * Get field and message for bean bind exception
     * @param errorList, List of ObjectError
     * @return List of Map<String, String>
     */
    private List<Map<String, String>> getFieldAndMessage(List<ObjectError> errorList) {
        List<Map<String, String>> list = errorList.stream().map(objectError -> {
            Map<String, String> map = new HashMap<>(2);
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                map.put("field", fieldError.getField());
                map.put("message", fieldError.getDefaultMessage());
            } else {
                map.put("field", objectError.getObjectName());
                map.put("message", objectError.getDefaultMessage());
            }
            return map;
        }).collect(Collectors.toList());

        return list;
    }

    /**
     * Handle exception being thrown out while binding ordinary parameters.
     * @param e, exception being thrown out
     * @return FailResult
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResult<?> handleConstraintViolationException(ConstraintViolationException e) {
        List<Map<String, String>> errorList = getFieldAndMessage(e.getMessage().split(","));
        return new FailResult<>(ServiceEnums.PARAMETER_BIND_FAIL, errorList);
    }

    /**
     * Get field and message for constraint violation
     * @param errorMessages, array of string message.
     * @return List of Map<String, String>
     */
    private List<Map<String, String>> getFieldAndMessage(String[] errorMessages) {
        return Arrays.stream(errorMessages).map(message -> {
            return new HashMap<String, String>() {{
                String[] fieldAndMsg = message.split(": ");
                String field = fieldAndMsg[0].split("\\.")[1];
                String message = fieldAndMsg[1];

                put("field", field);
                put("message", message);
            }};
        }).collect(Collectors.toList());
    }
}
