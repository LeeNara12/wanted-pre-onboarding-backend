package com.exam.api.advice;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String>  handleInvalidArgument(MethodArgumentNotValidException ex, RedirectAttributes redirectAttributes){
        Map<String, String> errorMap = new HashMap<String, String>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        redirectAttributes.addFlashAttribute("errorMap",errorMap);

        return errorMap;
    }
}
