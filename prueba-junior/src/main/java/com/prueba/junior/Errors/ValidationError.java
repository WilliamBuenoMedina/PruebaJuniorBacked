package com.prueba.junior.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {

    private HttpStatus status ;
    private List<String> message ;

    public ValidationError(HttpStatus status, List<ObjectError> message) {
        this.status = status;
        this.message = new ArrayList<String>();
        for ( ObjectError error : message) {
            this.message.add(error.getDefaultMessage());
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
