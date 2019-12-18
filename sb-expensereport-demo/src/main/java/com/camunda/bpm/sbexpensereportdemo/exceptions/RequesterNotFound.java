package com.camunda.bpm.sbexpensereportdemo.exceptions;

public class RequesterNotFound extends RuntimeException {

    public RequesterNotFound(String message){
        super(message);
    }
}
