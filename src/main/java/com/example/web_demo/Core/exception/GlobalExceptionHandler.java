package com.example.web_demo.Core.exception;

import com.example.web_demo.Core.exception.detail.ExceptionDetails;
import com.example.web_demo.Core.exception.detail.ValidationExceptionDetails;
import com.example.web_demo.Core.exception.type.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionDetails handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        return new ValidationExceptionDetails("Validasyon hatası",
                                                ex.getBindingResult().getAllErrors());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails handleBusinessException(BusinessException e){
        return new ExceptionDetails(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRunTimeException(){
        return "Runtime Error";
    }


}
