package com.camunda.bpm.servicesdemo.services;

import java.util.List;

public interface NotificationService<T> {

    void sendBatch(List<T> object);
    void send(T object);
}
