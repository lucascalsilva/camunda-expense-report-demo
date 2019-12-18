package com.camunda.bpm.sbexpensereportdemo.services;

import java.util.List;

public interface CrudService<T> {

    void merge(T object);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);

}
