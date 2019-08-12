package com.application.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "校验约束不通过",value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    public  ValidationException(String msg){super(msg);}
}
