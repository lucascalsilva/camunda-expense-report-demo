package com.camunda.bpm.sbexpensereportdemo.exceptions;

public class NotificationBuilderException extends RuntimeException {

    public NotificationBuilderException(String message){
        super(message);
    }

    public NotificationBuilderException(Exception e){
        super(e);
    }
}
