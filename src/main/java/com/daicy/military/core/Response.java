package com.daicy.military.core;

import com.daicy.military.model.BaseModel;
import com.github.pagehelper.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Response<T extends BaseModel> extends ResponseEntity {
    public Response(HttpStatus status) {
        super(status);
    }

    public Response(Page<T> body, HttpStatus status) {
        super(new RecordSet<T>(body), status);
    }

    public Response(T body, HttpStatus status) {
        super(body, status);
    }

    public Response(List<T> body, HttpStatus status) {
        super(body, status);
    }
}
