package com.camunda.bpm.servicesdemo.services;

public interface ProcessService<T, ID> {

    void start(T object);
    void cancel(ID processId);
}
