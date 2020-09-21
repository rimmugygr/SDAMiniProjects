package com.project.employeesservice.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidData extends RuntimeException{
    public InvalidData() {
    }

    public InvalidData(String message) {
        super(message);
    }
}
