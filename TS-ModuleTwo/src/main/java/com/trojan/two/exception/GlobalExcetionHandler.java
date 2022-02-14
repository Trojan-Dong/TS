package com.trojan.two.exception;

import com.trojan.one.entity.RespBean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcetionHandler {
    @ExceptionHandler(Exception.class)
    public RespBean exceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof MethodArgumentNotValidException) {
            return validationExceptionHandler((MethodArgumentNotValidException) e);
        } else {
            return RespBean.error(e.getMessage());
        }
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespBean validationExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        String message = result.getFieldError().getDefaultMessage();
        return RespBean.error(message);
    }
}
