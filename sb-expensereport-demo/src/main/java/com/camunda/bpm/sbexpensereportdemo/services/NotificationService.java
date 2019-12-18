package com.camunda.bpm.sbexpensereportdemo.services;

public interface NotificationService<T> {

    void send(T message);
}
