package com.daicy.military.core;

import com.daicy.military.exception.base.ForbiddenException;
import com.daicy.military.exception.base.InternalException;
import com.daicy.military.exception.base.ParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity forbiddenHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = InternalException.class)
    public ResponseEntity internalHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = ParamException.class)
    public ResponseEntity paramHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptHanler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        return new ResponseEntity<>("daicy.unknown", HttpStatus.BAD_REQUEST);
    }
}